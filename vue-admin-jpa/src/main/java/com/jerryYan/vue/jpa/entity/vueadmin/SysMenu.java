package com.jerryYan.vue.jpa.entity.vueadmin;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "sys_menu")
public class SysMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public void initDefault(){
        this.parentId = null == this.parentId ? 0 : this.parentId;
        this.isDel = null == this.isDel ? 0 : this.isDel;
        this.updateTime = new Date();
        if (null == this.id){
            this.createTime = this.updateTime;
        }
    }

    public void vaildNotNull(){
        if (StringUtils.isBlank(name)){
            throw new RuntimeException();
        }
    }
}
