package xin.inote.my.shop.commons.persistence;

import xin.inote.my.shop.commons.dto.BaseResult;
import xin.inote.my.shop.commons.dto.PageInfo;

import java.util.List;

public interface BaseService<T extends BaseEntity> {
    public List<T> selectAll();

    void delete(Long id);

    PageInfo<T> page(int start, int length, int draw, T entity);

    BaseResult save(T entity);

    void deleteMulti(String[] idArray);

    T getById(Long id);
}
