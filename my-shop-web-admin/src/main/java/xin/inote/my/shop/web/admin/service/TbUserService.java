package xin.inote.my.shop.web.admin.service;

import xin.inote.my.shop.domain.TbUser;

public interface TbUserService {
    TbUser login(String email, String password);
}
