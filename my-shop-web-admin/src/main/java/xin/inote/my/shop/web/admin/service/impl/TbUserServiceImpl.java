package xin.inote.my.shop.web.admin.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import xin.inote.my.shop.commons.dto.BaseResult;
import xin.inote.my.shop.commons.validator.BeanValidator;
import xin.inote.my.shop.domain.TbUser;
import xin.inote.my.shop.web.admin.abstracts.AbstractBaseServiceImpl;
import xin.inote.my.shop.web.admin.dao.TbUserDao;
import xin.inote.my.shop.web.admin.service.TbUserService;

import java.util.Date;

/**
 * @program: my_shop
 * @description: 用户逻辑类
 * @author: zhenying
 * @create: 2018-12-11 22:08
 **/
@Service
public class TbUserServiceImpl extends AbstractBaseServiceImpl<TbUser,TbUserDao> implements TbUserService {


    @Override
    public BaseResult save(TbUser tbUser) {
        String validator = BeanValidator.validator(tbUser);
        if (validator != null){
            return BaseResult.fail(validator);
        }
        //通过验证
        {

        }
        tbUser.setUpdated(new Date());
        // 新增用户
        if (tbUser.getId() == null) {
            // 密码需要加密处理
            tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
            tbUser.setCreated(new Date());
            dao.insert(tbUser);
        }

        // 编辑用户
        else {

            dao.update(tbUser);
        }
        return BaseResult.success("保存用户信息成功");
    }



    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = dao.login(email, DigestUtils.md5DigestAsHex(password.getBytes()));
        return tbUser;

    }
}
