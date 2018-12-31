package xin.inote.my.shop.web.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import xin.inote.my.shop.commons.dto.BaseResult;
import xin.inote.my.shop.commons.dto.PageInfo;
import xin.inote.my.shop.commons.validator.BeanValidator;
import xin.inote.my.shop.domain.TbUser;
import xin.inote.my.shop.web.admin.dao.TbUserDao;
import xin.inote.my.shop.web.admin.service.TbUserService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    public void deleteMulti(String[] idArray) {
        tbUserDao.deleteMulti(idArray);
    }

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
            tbUserDao.insert(tbUser);
        }

        // 编辑用户
        else {

            tbUserDao.update(tbUser);
        }
        return BaseResult.success("保存用户信息成功");
    }


    @Override
    public TbUser getById(Long id) {
        return tbUserDao.getById(id);
    }

    @Override
    public PageInfo<TbUser> page(int start, int length, int draw,TbUser tbUser) {
        Map<String,Object> map = new HashMap<>();
        int count = tbUserDao.count(tbUser);
        map.put("start",start);
        map.put("length",length);
        map.put("tbUser",tbUser);
        PageInfo<TbUser> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(tbUserDao.page(map));
        return pageInfo;
    }


    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = tbUserDao.login(email, DigestUtils.md5DigestAsHex(password.getBytes()));
        return tbUser;

    }
}
