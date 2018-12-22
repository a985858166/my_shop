package xin.inote.my.shop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xin.inote.my.shop.domain.TbUser;

/**
 * @program: my_shop
 * @description: 用户管理
 * @author: zhenying
 * @create: 2018-12-13 21:55
 **/
@Controller
@RequestMapping(value = "user")
public class UserController {
    @ModelAttribute
    public TbUser getTbUser() {
        TbUser tbUser = new TbUser();
        return tbUser;
    }
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "user_list";
    }
}
