package xin.inote.my.shop.web.admin.service.impl;

import org.springframework.stereotype.Service;
import xin.inote.my.shop.commons.dto.BaseResult;
import xin.inote.my.shop.commons.dto.PageInfo;
import xin.inote.my.shop.commons.validator.BeanValidator;
import xin.inote.my.shop.domain.TbContent;
import xin.inote.my.shop.web.admin.abstracts.AbstractBaseServiceImpl;
import xin.inote.my.shop.web.admin.dao.TbContentDao;
import xin.inote.my.shop.web.admin.service.TbContentService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TbContentServiceImpl extends AbstractBaseServiceImpl<TbContent,TbContentDao> implements TbContentService {



    @Override
    public BaseResult save(TbContent entity) {
        String validator = BeanValidator.validator(entity);
        //验证不通过
        if (validator != null){
            return BaseResult.fail(validator);
        }{
            entity.setUpdated(new Date());
            // 新增
            if (entity.getId() == null) {
                entity.setCreated(new Date());
                dao.insert(entity);
            }

            // 编辑内容
            else {
                dao.update(entity);
            }
            return BaseResult.success("保存内容信息成功");
        }
    }
}

