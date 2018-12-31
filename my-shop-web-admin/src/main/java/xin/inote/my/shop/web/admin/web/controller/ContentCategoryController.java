package xin.inote.my.shop.web.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import xin.inote.my.shop.commons.dto.BaseResult;
import xin.inote.my.shop.domain.TbContentCategory;
import xin.inote.my.shop.web.admin.service.TbContentCategoryService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "content/category")
public class ContentCategoryController {
    @Autowired
    private TbContentCategoryService tbContentCategoryService;
    @ModelAttribute
    public TbContentCategory getTbContentCategory(Long id) {
        TbContentCategory tbContentCategory = null;
        //如果用户id不为空则获取该id的信息
        if (id != null) {
            tbContentCategory = tbContentCategoryService.getById(id);
        } else {
            tbContentCategory = new TbContentCategory();
        }
        return tbContentCategory;
    }
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        List<TbContentCategory> targetList = new ArrayList<>();
        List<TbContentCategory> sourceList = tbContentCategoryService.selectAll();
        sortList(sourceList,targetList,0L);
        model.addAttribute("tbContentCategories",targetList);
        return "content_category_list";
    }

    /**
     * @param sourceList 数据源集合
     * @param targetList 排序后的集合
     * @param parentId 父节点的id
     */
    private void sortList(List<TbContentCategory> sourceList,List<TbContentCategory> targetList,Long parentId){
        for (TbContentCategory tbContentCategory:sourceList
             ) {
            if (tbContentCategory.getParentId().equals(parentId)){
                targetList.add(tbContentCategory);
                //判断有没有子节点，如果有则继续追加。
                if (tbContentCategory.getIsParent()){
                    for (TbContentCategory contentCategory : sourceList) {
                        if (contentCategory.getParentId().equals(tbContentCategory.getId())){
                            sortList(sourceList,targetList,tbContentCategory.getId());
                            break;
                        }
                    }
                }
            }

        }
    }

    /**
     * @return 树形结构
     */
    @ResponseBody
    @RequestMapping(value = "tree/data",method = RequestMethod.POST)
    public List<TbContentCategory> treeData(Long id){
        if (id == null){
            id = 0L;
        }
        return tbContentCategoryService.selectByPid(id);
    }
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(){
        return "content_category_form";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbContentCategory tbContentCategory, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = tbContentCategoryService.save(tbContentCategory);

        // 保存成功
        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:list";
        }

        // 保存失败
        else {
            model.addAttribute("baseResult", baseResult);
            return "content_category_form";
        }
    }

}
