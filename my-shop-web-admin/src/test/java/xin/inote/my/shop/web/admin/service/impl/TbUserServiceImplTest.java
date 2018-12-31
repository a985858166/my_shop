package xin.inote.my.shop.web.admin.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;
import xin.inote.my.shop.domain.TbUser;
import xin.inote.my.shop.web.admin.dao.TbUserDao;
import xin.inote.my.shop.web.admin.service.TbUserService;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbUserServiceImplTest {
    @Autowired
    TbUserService tbUserService;
    @Autowired
    TbUserDao tbUserDao;
    @Test
    public void login() {
        System.out.println(tbUserService.login("",""));
    }
    @Test
    public void insert(){
        TbUser tbUser = new TbUser();
        tbUser.setUsername("qq");
        tbUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        tbUser.setUpdated(new Date());
        tbUser.setCreated(new Date());
        tbUser.setEmail("qq@qq.com");
        tbUser.setPhone("12323456534");
        tbUserDao.insert(tbUser);
    }
    @Test
    public void delete(){
        tbUserDao.delete(43L);
    }
    @Test
    public void getById(){
        tbUserDao.getById(7L);
    }
    @Test
    public void seleteAll(){
        tbUserDao.selectAll();
    }
    @Test
    public void login2(){
        tbUserDao.login("qq@qq.com",DigestUtils.md5DigestAsHex("123456".getBytes()));
    }
}