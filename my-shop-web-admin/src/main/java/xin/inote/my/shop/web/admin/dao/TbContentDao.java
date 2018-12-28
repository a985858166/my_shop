package xin.inote.my.shop.web.admin.dao;

import xin.inote.my.shop.domain.TbContent;

import java.util.List;
import java.util.Map;

public interface TbContentDao {
    void insert(TbContent tbContent);
    void delete(Long id);
    void update(TbContent tbContent);
    TbContent getById(Long id);
    void deleteMulti(String[] idArray);
    int count(TbContent tbContent);
    List<TbContent> page(Map<String,Object> map);

}
