package xin.inote.my.shop.commons.persistence;

import xin.inote.my.shop.commons.dto.BaseResult;
import xin.inote.my.shop.commons.dto.PageInfo;

public interface BaseTreeService<T extends BaseEntity> {
    PageInfo<T> page(int start, int length, int draw, T entity);

    BaseResult save(T entity);

    void deleteMulti(String[] idArray);

    T getById(Long id);
}
