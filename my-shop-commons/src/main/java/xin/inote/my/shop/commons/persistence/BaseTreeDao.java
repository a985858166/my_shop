package xin.inote.my.shop.commons.persistence;

import java.util.List;

public interface BaseTreeDao<T extends BaseEntity> {
    T getById(Long id);
    void insert(T entity);
    void delete(String[] ids);
    List<T> selectAll();
    void update(T entity);
    List<T> selectByPid(Long parentId);
}
