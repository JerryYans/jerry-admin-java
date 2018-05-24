package com.jerryYan.vue.jpa.entity.vueadmin;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "sys_admin")
public class SysAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String avatar;
    private String nickname;
    private Integer isDel;
    private Date createTime;
    private Date updateTime;

}
