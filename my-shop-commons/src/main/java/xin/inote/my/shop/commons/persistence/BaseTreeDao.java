package xin.inote.my.shop.commons.persistence;

import java.util.List;
import java.util.Map;

public interface BaseTreeDao<T extends BaseEntity> {
    T getById(Long id);
    void insert(T entity);
    void delete(Long id);
    List<T> selectAll();
    List<T> page(Map<String,Object> map);
    int count(T entity);
    void update(T entity);
    void deleteMulti(String[] idArray);
    List<T> selectByPid(Long parentId);
}
