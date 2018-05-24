package com.jerryYan.vue.service.admin.dto;

import com.jerryYan.vue.jpa.entity.vueadmin.SysAdmin;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
@NoArgsConstructor
public class SysAdminInfoDTO {

    private Integer id;
    private String username;
    private String avatar;
    private String nickname;
    private Date createTime;
    private Date updateTime;

    public SysAdminInfoDTO(SysAdmin sysAdmin){
        BeanUtils.copyProperties(sysAdmin, this);
    }
    private Boolean isSystenAdmin = false;//是否是系统管理员
}
