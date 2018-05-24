package com.jerryYan.vue.jpa.repository.vueadmin;

import com.jerryYan.vue.jpa.entity.vueadmin.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRoleRepository extends JpaRepository<SysRole, Integer> {

    @Query(nativeQuery = true, value = "select role.* from sys_role role left join sys_admin_role_map map on role.id=map.role_id where map.admin_id=?1")
    List<SysRole> findBySysAdminId(Integer adminId);
}
