package xin.inote.my.shop.web.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.inote.my.shop.domain.TbContentCategory;
import xin.inote.my.shop.web.admin.dao.TbContentCategoryDao;
import xin.inote.my.shop.web.admin.service.TbContentCategoryService;

import java.util.List;

@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {
    @Autowired
    TbContentCategoryDao tbContentCategoryDao;

    @Override
    public List<TbContentCategory> selectByPid(Long parentId) {
        return tbContentCategoryDao.selectByPid(parentId);
    }

    @Override
    public List<TbContentCategory> selectAll() {
        return tbContentCategoryDao.selectAll();
    }
}
