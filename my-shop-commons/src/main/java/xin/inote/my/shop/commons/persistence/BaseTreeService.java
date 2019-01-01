package xin.inote.my.shop.commons.persistence;

import xin.inote.my.shop.commons.dto.BaseResult;

import java.util.List;

public interface BaseTreeService<T extends BaseEntity> {

    List<T> selectAll();

    BaseResult save(T entity);

    void delete(String[] idArray);

    T getById(Long id);

    void update(T entity);

    List<T> selectByPid(Long pid);
}
