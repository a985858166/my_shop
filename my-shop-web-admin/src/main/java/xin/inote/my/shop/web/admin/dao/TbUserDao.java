package xin.inote.my.shop.web.admin.dao;

import org.apache.ibatis.annotations.Param;
import xin.inote.my.shop.commons.persistence.BaseDao;
import xin.inote.my.shop.domain.TbUser;


public interface TbUserDao extends BaseDao<TbUser> {
    TbUser login(@Param("email") String email,@Param("password") String password);
}
