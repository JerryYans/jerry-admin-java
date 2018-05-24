package com.jerryYan.vue.service.admin.impl;

import com.jerryYan.vue.jpa.entity.vueadmin.SysMenu;
import com.jerryYan.vue.jpa.repository.vueadmin.SysMenuRepository;
import com.jerryYan.vue.service.admin.MenuService;
import com.jerryYan.vue.service.admin.SysAdminService;
import com.jerryYan.vue.service.admin.dto.MenuTreeDTO;
import com.jerryYan.vue.service.admin.dto.SysAdminInfoDTO;
import com.jerryYan.vue.service.admin.util.MenuTreeBuild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private SysMenuRepository menuRepository;
    @Autowired
    private SysAdminService sysAdminService;

    @Override
    public MenuTreeDTO getMenuTreeForAdminUser(Integer adminId) {
        MenuTreeDTO menuTree = MenuTreeBuild.initEntityTree();
        SysAdminInfoDTO adminInfoDTO = sysAdminService.getAdminInfo(adminId);
        List<SysMenu> menus;
        if (adminInfoDTO.getIsSystenAdmin()){
            menus = menuRepository.findAllMenus();
        }else {
            menus = menuRepository.findMenusByAdminId(adminId);
        }
        for (SysMenu menu : menus){
            MenuTreeBuild.addMenuItem(menuTree, menu);
        }
        return menuTree;
    }

    @Override
    public SysMenu saveAndUpdateSysMenu(SysMenu menu) {
        if (null == menu.getParentId()){
            menu.setParentId(0);
        }
        menu.initDefault();
        if (!isUniqueForMenuHref(menu.getHref(), menu.getId())){
            throw new RuntimeException("链接已存在");
        }
        if (menu.getParentId() > 0 && menuRepository.findById(menu.getParentId()).get() == null){
            throw new RuntimeException("父级菜单无效!");
        }
        menuRepository.save(menu);
        return menu;
    }

    private boolean isUniqueForMenuHref(String href, Integer excludeId){
        List<SysMenu> sysMenus = menuRepository.findByHref(href);
        if (null == sysMenus || sysMenus.isEmpty()){
            return true;
        }
        for (SysMenu sysMenu : sysMenus){
            if (excludeId != sysMenu.getId()){
                return false;
            }
        }
        return true;
    }
}
