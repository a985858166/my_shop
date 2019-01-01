package xin.inote.my.shop.web.admin.abstracts;

import org.springframework.beans.factory.annotation.Autowired;
import xin.inote.my.shop.commons.persistence.BaseEntity;
import xin.inote.my.shop.commons.persistence.BaseTreeDao;
import xin.inote.my.shop.commons.persistence.BaseTreeService;

import java.util.List;

public abstract class AbstractBaseTreeServiceImpl<T extends BaseEntity,D extends BaseTreeDao<T>> implements BaseTreeService<T> {
    @Autowired
    protected D dao;

    @Override
    public List<T> selectAll() {
        return dao.selectAll();
    }


    @Override
    public void update(T entity) {
        dao.update(entity);
    }

    @Override
    public List<T> selectByPid(Long pid) {
        return dao.selectByPid(pid);
    }

    @Override
    public void delete(String[] idArray) {
        dao.delete(idArray);
    }



    @Override
    public T getById(Long id) {
        return dao.getById(id);
    }
}
