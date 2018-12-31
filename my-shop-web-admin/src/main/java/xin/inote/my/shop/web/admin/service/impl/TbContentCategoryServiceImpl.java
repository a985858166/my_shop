package xin.inote.my.shop.web.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.inote.my.shop.commons.dto.BaseResult;
import xin.inote.my.shop.commons.dto.PageInfo;
import xin.inote.my.shop.commons.validator.BeanValidator;
import xin.inote.my.shop.domain.TbContentCategory;
import xin.inote.my.shop.web.admin.dao.TbContentCategoryDao;
import xin.inote.my.shop.web.admin.service.TbContentCategoryService;

import java.util.Date;
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
    public PageInfo<TbContentCategory> page(int start, int length, int draw, TbContentCategory entity) {
        return null;
    }

    @Override
    public BaseResult save(TbContentCategory entity) {
        String validator = BeanValidator.validator(entity);
        if (validator != null){
            return BaseResult.fail(validator);
        }else {
            TbContentCategory parent = entity.getParent();
            if (parent == null || parent.getId() == null){
                parent.setId(0L);
            }
            entity.setUpdated(new Date());
            //新增
            if (entity.getId() == null){
                entity.setCreated(new Date());
                entity.setIsParent(false);
                if (parent.getId() != 0L){
                    TbContentCategory currentCategoryParent = getById(parent.getId());
                    if (currentCategoryParent != null){
                        currentCategoryParent.setIsParent(true);
                        tbContentCategoryDao.update(currentCategoryParent);
                    }
                }
                //根目录一定是父级目录
                else {
                    entity.setIsParent(true);
                }
                tbContentCategoryDao.insert(entity);
            }
            //修改
            else {
                tbContentCategoryDao.update(entity);
            }
            return BaseResult.success("保存分类信息成功");
        }

    }

    @Override
    public void deleteMulti(String[] idArray) {

    }

    @Override
    public TbContentCategory getById(Long id) {

        return tbContentCategoryDao.getById(id);
    }

    @Override
    public List<TbContentCategory> selectAll() {
        return tbContentCategoryDao.selectAll();
    }

}
