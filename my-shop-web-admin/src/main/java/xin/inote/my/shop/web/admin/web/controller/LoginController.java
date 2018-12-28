package xin.inote.my.shop.web.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xin.inote.my.shop.commons.constant.ConstantUtils;
import xin.inote.my.shop.domain.TbUser;
import xin.inote.my.shop.web.admin.service.TbUserService;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: my_shop
 * @description: 登录处理控制器
 * @author: zhenying
 * @create: 2018-12-13 15:29
 **/
@Controller
public class LoginController {
    @Autowired
    private TbUserService tbUserService;
    @ModelAttribute
    public TbUser getTbUser(){
        TbUser tbUser = null;
        tbUser = new TbUser();
        return tbUser;
    }
    /**
     * @return 跳转到登录页面
     */
    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 登录逻辑处理
     * @param httpServletRequest
     * @param model
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(TbUser tbUser,HttpServletRequest httpServletRequest, Model model) {
        TbUser tbUserDB = tbUserService.login(tbUser.getEmail(), tbUser.getPassword());
//        登录失败时执行
        if (tbUserDB == null) {
            model.addAttribute("message", "用户名或密码错误，请重新输入");
            return login();
        }
//        登录成功时执行
        else {
            tbUserDB.setPassword("");
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER, tbUserDB);
            return "redirect:/main";
        }
    }

    /**
     * 注销
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().invalidate();
        return login();
    }


}
