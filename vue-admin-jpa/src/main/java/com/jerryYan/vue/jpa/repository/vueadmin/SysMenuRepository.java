package com.jerryYan.vue.jpa.repository.vueadmin;

import com.jerryYan.vue.jpa.entity.vueadmin.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysMenuRepository extends JpaRepository<SysMenu, Integer> {

    @Query(nativeQuery = true, value = "SELECT menu.* FROM sys_menu menu " +
            "    LEFT JOIN sys_role_menu_map role_menu ON role_menu.menu_id=menu.id " +
            "    LEFT JOIN sys_admin_role_map admin_role ON admin_role.role_id=role_menu.role_id " +
            " WHERE admin_role.admin_id=?1 ORDER BY menu.parent_id asc, sort asc,update_time desc")
    List<SysMenu> findMenusByAdminId(Integer adminId);

    @Query(nativeQuery = true, value = "SELECT menu.* FROM sys_menu menu ORDER BY menu.parent_id asc, sort asc,update_time desc")
    List<SysMenu> findAllMenus();

    List<SysMenu> findByHref(String href);
}
