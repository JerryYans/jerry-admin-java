package com.jerryYan.vue.jpa.entity.vueadmin;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "admin_menu")
public class AdminMenu {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer parentId;
    private Integer sort;
    private String name;
    private String href;
    private String icon;
    private Integer isShow;
    private Integer isDel;
    private Date createTime;
    private Date updateTime;

}
