package com.jerryYan.vue.service.admin;

import com.jerryYan.vue.service.admin.dto.MenuTreeDTO;

public interface MenuService {

    MenuTreeDTO getMenuTreeForAdminUser(Integer adminId);

}
