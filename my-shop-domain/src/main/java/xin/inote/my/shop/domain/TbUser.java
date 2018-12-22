package xin.inote.my.shop.domain;

import java.util.Date;

/**
 * @program: my_shop
 * @description: 用户实体类
 * @author: zhenying
 * @create: 2018-12-11 17:25
 **/
public class TbUser {
//  用户id
    public Long id;
//   用户名
    public String username;
//   用户密码
    public String password;
//    用户手机号码
    public String phone;
//    用户邮箱
    public String email;
//    注册时间
    public Date created;
//    更新时间
    public Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
