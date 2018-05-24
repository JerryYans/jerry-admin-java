package com.jerryYan.vue.jpa.entity.vueadmin;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "sys_role")
public class SysRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Integer isDel;
    private Date createTime;
    private Date updateTime;

}
