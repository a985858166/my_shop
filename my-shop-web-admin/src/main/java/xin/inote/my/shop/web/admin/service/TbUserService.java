package xin.inote.my.shop.web.admin.service;

import xin.inote.my.shop.commons.persistence.BaseService;
import xin.inote.my.shop.domain.TbUser;

public interface TbUserService extends BaseService<TbUser> {
    TbUser login(String email, String password);
}
