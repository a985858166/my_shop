package xin.inote.my.shop.web.admin.service.impl;

import org.springframework.stereotype.Service;
import xin.inote.my.shop.commons.dto.BaseResult;
import xin.inote.my.shop.commons.validator.BeanValidator;
import xin.inote.my.shop.domain.TbContentCategory;
import xin.inote.my.shop.web.admin.abstracts.AbstractBaseTreeServiceImpl;
import xin.inote.my.shop.web.admin.dao.TbContentCategoryDao;
import xin.inote.my.shop.web.admin.service.TbContentCategoryService;

import java.util.Date;

@Service
public class TbContentCategoryServiceImpl extends AbstractBaseTreeServiceImpl<TbContentCategory, TbContentCategoryDao> implements TbContentCategoryService {

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
                        dao.update(currentCategoryParent);
                    }
                }
                //根目录一定是父级目录
                else {
                    entity.setIsParent(true);
                }
                dao.insert(entity);
            }
            //修改
            else {
                dao.update(entity);
            }
            return BaseResult.success("保存分类信息成功");
        }
    }
}
