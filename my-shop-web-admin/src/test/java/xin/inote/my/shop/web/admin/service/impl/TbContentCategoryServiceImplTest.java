package xin.inote.my.shop.web.admin.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xin.inote.my.shop.domain.TbContentCategory;
import xin.inote.my.shop.web.admin.dao.TbContentCategoryDao;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbContentCategoryServiceImplTest {
    @Autowired
    TbContentCategoryDao tbContentCategoryDao;
    @Test
    public void selectAll(){
        List<TbContentCategory> list =  tbContentCategoryDao.selectAll();
        for (TbContentCategory t:list
             ) {
            System.out.println(t.getName());
        }
    }
}