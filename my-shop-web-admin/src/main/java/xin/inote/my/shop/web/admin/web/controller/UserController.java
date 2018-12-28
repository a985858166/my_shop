package xin.inote.my.shop.web.admin.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import xin.inote.my.shop.commons.dto.BaseResult;
import xin.inote.my.shop.commons.dto.PageInfo;
import xin.inote.my.shop.domain.TbUser;
import xin.inote.my.shop.web.admin.service.TbUserService;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: my_shop
 * @description: 用户管理
 * @author: zhenying
 * @create: 2018-12-13 21:55
 **/
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    TbUserService tbUserService;

    /**
     * 访问该类的方法，此方法都会先执行。
     * @param id 用户id
     * @return
     */
    @ModelAttribute
    public TbUser getTbUser(Long id) {
        TbUser tbUser = null;
        //如果用户id不为空则获取该id的信息
        if (id != null) {
            tbUser = tbUserService.getById(id);
        } else {
            tbUser = new TbUser();
        }
        return tbUser;
    }

    /**
     * @return 返回用户列表页面
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "user_list";
    }

    /**
     * 获取用户列表数据
     * @param request
     * @param tbUser 搜索条件会传到这
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<TbUser> page(HttpServletRequest request,TbUser tbUser){
        String strdraw = request.getParameter("draw");
        String strstart = request.getParameter("start");
        String strlength = request.getParameter("length");
        int draw = strdraw == null?0:Integer.parseInt(strdraw);
        int start = strstart == null?0:Integer.parseInt(strstart);
        int length = strlength==null?10:Integer.parseInt(strlength);
        PageInfo<TbUser> pageInfo = tbUserService.page(start,length,draw,tbUser);
        return pageInfo;
    }
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "user_form";
    }
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbUser tbUser, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = tbUserService.save(tbUser);

        // 保存成功
        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/user/list";
        }

        // 保存失败
        else {
            model.addAttribute("baseResult", baseResult);
            return "user_form";
        }
    }
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(TbUser tbUser){
        return "user_detail";
    }

    /**
     * 删除用户列表
     * @param ids 删除用户数组
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            tbUserService.deleteMulti(idArray);
            baseResult = BaseResult.success("删除用户成功");
        } else {
            baseResult = BaseResult.fail("删除用户失败");
        }

        return baseResult;
    }



}
