package xin.inote.my.shop.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import xin.inote.my.shop.commons.persistence.BaseEntity;
import xin.inote.my.shop.commons.utils.RegexpUtils;

import javax.validation.constraints.Pattern;

/**
 * @program: my_shop
 * @description: 用户实体类
 * @author: zhenying
 * @create: 2018-12-11 17:25
 **/
@Data
public class TbUser extends BaseEntity {
//   用户名
    @Length(min = 6,max = 12,message = "姓名的长度必须介于6-20位之间")
    private String username;
//   用户密码
    @Length(min = 6,max = 30,message = "密码的长度必须介于6-30位之间")
    private String password;
//    用户手机号码
    @Pattern(regexp = RegexpUtils.PHONE,message = "手机号码格式不正确")
    private String phone;
//    用户邮箱
    @Pattern(regexp = RegexpUtils.EMAIL,message = "邮箱格式不正确")
    public String email;



}
