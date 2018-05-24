package com.jerryYan.vue.internal.controller.admin;

import com.jerryYan.vue.common.entity.JsonListResponseEntity;
import com.jerryYan.vue.common.entity.JsonResponseEntity;
import com.jerryYan.vue.jpa.entity.vueadmin.SysMenu;
import com.jerryYan.vue.jpa.repository.vueadmin.SysMenuRepository;
import com.jerryYan.vue.service.admin.MenuService;
import com.jerryYan.vue.service.admin.dto.MenuTreeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/sys/menu")
public class SysMenuController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private SysMenuRepository sysMenuRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public JsonListResponseEntity menus(@RequestParam(required = false) String adminId){
        JsonListResponseEntity entity = new JsonListResponseEntity();

        MenuTreeDTO menuTreeDTO = menuService.getMenuTreeForAdminUser(1);
        entity.setContent(menuTreeDTO.getChildren());
        return entity;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JsonResponseEntity addMenu(@RequestBody SysMenu sysMenu){
        JsonResponseEntity entity = new JsonResponseEntity();
        menuService.saveAndUpdateSysMenu(sysMenu);
        entity.setData(sysMenu);
        return entity;
    }
}
