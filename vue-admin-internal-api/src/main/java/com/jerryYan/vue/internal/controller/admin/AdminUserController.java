package com.jerryYan.vue.internal.controller.admin;

import com.jerryYan.vue.common.entity.JsonResponseEntity;
import com.jerryYan.vue.jpa.entity.vueadmin.SysAdmin;
import com.jerryYan.vue.jpa.repository.vueadmin.SysAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    private SysAdminRepository adminUserRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResponseEntity adminLogin(@RequestBody String parms){
        JsonResponseEntity entity = new JsonResponseEntity();
        SysAdmin adminUser = adminUserRepository.findById(1).get();
        Map<String, Object> info = new HashMap<>();
        info.put("user", adminUser);
        info.put("adminToken", "21232f297a57a5a743894a0e4a801fc3");
        entity.setData(info);
        return entity;
    }
}
