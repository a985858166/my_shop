package xin.inote.my.shop.web.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import xin.inote.my.shop.domain.TbUser;
import xin.inote.my.shop.web.admin.dao.TbUserDao;
import xin.inote.my.shop.web.admin.service.TbUserService;

/**
 * @program: my_shop
 * @description: 用户逻辑类
 * @author: zhenying
 * @create: 2018-12-11 22:08
 **/
@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    TbUserDao tbUserDao;
    @Override
    public TbUser login(String email,String password) {
        TbUser tbUser = tbUserDao.login(email, DigestUtils.md5DigestAsHex(password.getBytes()));
        return tbUser;

    }
}
