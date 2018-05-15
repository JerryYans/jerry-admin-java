package com.jerryYan.vue.jpa.entity.vueadmin;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "admin_user")
public class AdminUser {

    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    private String avatar;
    private String nickname;
    private Integer isDel;
    private Date createTime;
    private Date updateTime;

}
