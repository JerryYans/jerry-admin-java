package com.jerryYan.vue.service.admin.impl;

import com.jerryYan.vue.jpa.entity.vueadmin.SysAdmin;
import com.jerryYan.vue.jpa.entity.vueadmin.SysRole;
import com.jerryYan.vue.jpa.repository.vueadmin.SysAdminRepository;
import com.jerryYan.vue.jpa.repository.vueadmin.SysRoleRepository;
import com.jerryYan.vue.service.admin.SysAdminService;
import com.jerryYan.vue.service.admin.dto.SysAdminInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysAdminService")
public class SysAdminServiceImpl implements SysAdminService {

    @Autowired
    private SysAdminRepository sysAdminRepository;
    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Override
    public SysAdminInfoDTO getAdminInfo(int adminId) {
        SysAdmin sysAdmin = sysAdminRepository.findById(adminId).get();
        SysAdminInfoDTO adminInfoDTO = new SysAdminInfoDTO(sysAdmin);
        List<SysRole> roleList = sysRoleRepository.findBySysAdminId(adminId);
        if (null != roleList){
            for (SysRole sysRole : roleList){
                if (sysRole.getName().equals("系统管理员")){
                    adminInfoDTO.setIsSystenAdmin(true);
                }
            }
        }
        return adminInfoDTO;
    }
}
