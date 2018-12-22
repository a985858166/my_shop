package xin.inote.my.shop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: my_shop
 * @description: 管理员页面
 * @author: zhenying
 * @create: 2018-12-13 15:59
 **/
@Controller
public class MainController {
    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String main() {
        return "main";
    }
}
