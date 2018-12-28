package xin.inote.my.shop.web.admin.service;

import xin.inote.my.shop.commons.dto.BaseResult;
import xin.inote.my.shop.commons.dto.PageInfo;
import xin.inote.my.shop.domain.TbUser;

public interface TbUserService {
    TbUser login(String email, String password);
    PageInfo<TbUser> page(int start, int length,int draw,TbUser tbUser);

    TbUser getById(Long id);

    BaseResult save(TbUser tbUser);

    void deleteMulti(String[] idArray);
}
