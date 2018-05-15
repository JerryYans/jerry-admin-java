package com.jerryYan.vue.service.admin.util;

import com.jerryYan.vue.jpa.entity.vueadmin.AdminMenu;
import com.jerryYan.vue.service.admin.dto.MenuTreeDTO;

import java.util.ArrayList;

public class MenuTreeBuild {

    public static MenuTreeDTO initEntityTree(){
        MenuTreeDTO menuTree = new MenuTreeDTO();
        menuTree.setId(0);
        menuTree.setName("vue-admin");
        menuTree.setChildren(new ArrayList<>());
        return menuTree;
    }

    public static void addMenuItem(MenuTreeDTO rootTree, AdminMenu menu){
        if (menu.getParentId() == rootTree.getId()){
            rootTree.getChildren().add(new MenuTreeDTO(menu));
        }else {
            for (MenuTreeDTO menuTree : rootTree.getChildren()){
                addMenuItem(menuTree, menu);
            }
        }
    }

}
