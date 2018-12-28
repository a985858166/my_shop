package xin.inote.my.shop.domain;

import lombok.Data;
import xin.inote.my.shop.commons.persistence.BaseEntity;

/**
 * @program: my_shop
 * @description: 用户实体类
 * @author: zhenying
 * @create: 2018-12-11 17:25
 **/
@Data
public class TbUser extends BaseEntity {
//   用户名
    public String username;
//   用户密码
    public String password;
//    用户手机号码
    public String phone;
//    用户邮箱
    public String email;


}
