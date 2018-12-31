package xin.inote.my.shop.web.admin.service;

import xin.inote.my.shop.commons.persistence.BaseService;
import xin.inote.my.shop.domain.TbContentCategory;

import java.util.List;

public interface TbContentCategoryService extends BaseService<TbContentCategory> {
    List<TbContentCategory> selectAll();
    List<TbContentCategory> selectByPid(Long parentId);
}
