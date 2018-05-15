package com.jerryYan.vue.service.admin.impl;

import com.jerryYan.vue.jpa.entity.vueadmin.AdminMenu;
import com.jerryYan.vue.jpa.repository.vueadmin.AdminMenuRepository;
import com.jerryYan.vue.service.admin.MenuService;
import com.jerryYan.vue.service.admin.dto.MenuTreeDTO;
import com.jerryYan.vue.service.admin.util.MenuTreeBuild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private AdminMenuRepository menuRepository;

    @Override
    public MenuTreeDTO getMenuTreeForAdminUser(Integer adminId) {
        MenuTreeDTO menuTree = MenuTreeBuild.initEntityTree();
        List<AdminMenu> menus = menuRepository.findMenusByAdminId(adminId);
        for (AdminMenu menu : menus){
            MenuTreeBuild.addMenuItem(menuTree, menu);
        }
        return menuTree;
    }

}
