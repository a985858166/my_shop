package xin.inote.my.shop.web.admin.abstracts;

import org.springframework.beans.factory.annotation.Autowired;
import xin.inote.my.shop.commons.dto.BaseResult;
import xin.inote.my.shop.commons.dto.PageInfo;
import xin.inote.my.shop.commons.persistence.BaseEntity;
import xin.inote.my.shop.commons.persistence.BaseTreeDao;
import xin.inote.my.shop.commons.persistence.BaseTreeService;

public abstract class AbstractBaseTreeServiceImpl<T extends BaseEntity,D extends BaseTreeDao<T>> implements BaseTreeService<T> {
    @Autowired
    private D baseTreeDao;
    @Override
    public PageInfo page(int start, int length, int draw, T entity) {
        return null;
    }

    @Override
    public BaseResult save(T entity) {
        return null;
    }

    @Override
    public void deleteMulti(String[] idArray) {

    }

    @Override
    public T getById(Long id) {
        return null;
    }
}
