package com.jerryYan.vue.internal.controller.admin;

import com.jerryYan.vue.common.entity.JsonListResponseEntity;
import com.jerryYan.vue.common.entity.JsonResponseEntity;
import com.jerryYan.vue.jpa.entity.vueadmin.AdminUser;
import com.jerryYan.vue.jpa.repository.vueadmin.AdminUserRepository;
import com.jerryYan.vue.service.admin.MenuService;
import com.jerryYan.vue.service.admin.dto.MenuTreeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sys/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public JsonListResponseEntity menus(@RequestParam(required = false) String adminId){
        JsonListResponseEntity entity = new JsonListResponseEntity();
        MenuTreeDTO menuTreeDTO = menuService.getMenuTreeForAdminUser(1);
        entity.setContent(menuTreeDTO.getChildren());
        return entity;
    }
}
