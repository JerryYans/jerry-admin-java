package com.jerryYan.vue.service.admin.dto;

import com.jerryYan.vue.jpa.entity.vueadmin.AdminMenu;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MenuTreeDTO {
    private Integer id;
    private Integer parentId;
    private Integer sort;
    private String name;
    private String href;
    private String icon;
    private Integer isShow;
    private List<MenuTreeDTO> children;

    public MenuTreeDTO(){

    }

    public MenuTreeDTO(AdminMenu menu){
        this.id = menu.getId();
        this.parentId = menu.getParentId();
        this.sort = menu.getSort();
        this.name = menu.getName();
        this.href = menu.getHref();
        this.icon = menu.getIcon();
        this.isShow = menu.getIsShow();
        this.children = new ArrayList<>();
    }

}
