package xin.inote.my.shop.web.admin.dao;

import xin.inote.my.shop.domain.TbContentCategory;

import java.util.List;

public interface TbContentCategoryDao {
    List<TbContentCategory> selectAll();

    /**
     * @param parentId 查询所有子节点分类。
     * @return
     */
    List<TbContentCategory> selectByPid(Long parentId);
}

