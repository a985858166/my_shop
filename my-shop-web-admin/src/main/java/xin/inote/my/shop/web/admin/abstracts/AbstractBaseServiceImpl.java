package xin.inote.my.shop.web.admin.abstracts;
import org.springframework.beans.factory.annotation.Autowired;
import xin.inote.my.shop.commons.dto.PageInfo;
import xin.inote.my.shop.commons.persistence.BaseDao;
import xin.inote.my.shop.commons.persistence.BaseEntity;
import xin.inote.my.shop.commons.persistence.BaseService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractBaseServiceImpl<T extends BaseEntity,D extends BaseDao<T>> implements BaseService<T> {
    @Autowired
    protected D dao;
    @Override
    public List<T> selectAll() {
        return dao.selectAll();
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public void deleteMulti(String[] idArray) {
        dao.deleteMulti(idArray);
    }

    @Override
    public T getById(Long id) {
        return dao.getById(id);
    }
    @Override
    public PageInfo<T> page(int start, int length, int draw, T entity) {
        Map<String,Object> map = new HashMap<>();
        int count = dao.count(entity);
        map.put("start",start);
        map.put("length",length);
        map.put("pageParams",entity);
        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);

        pageInfo.setData(dao.page(map));
        return pageInfo;
    }
}
