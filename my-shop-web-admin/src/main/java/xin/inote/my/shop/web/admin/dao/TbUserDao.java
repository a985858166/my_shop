package xin.inote.my.shop.web.admin.dao;

import org.apache.ibatis.annotations.Param;
import xin.inote.my.shop.domain.TbUser;

import java.util.List;

public interface TbUserDao {
    TbUser getByEmail(String email);
    TbUser getById(Long id);
    void insert(TbUser tbUser);
    void delete(Long id);
    List<TbUser> selectAll();
    List<TbUser> selectByUsername(String username);
    TbUser login(@Param("email") String email,@Param("password") String password);
}
