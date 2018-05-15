package com.jerryYan.vue.jpa.repository.vueadmin;

import com.jerryYan.vue.jpa.entity.vueadmin.AdminMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMenuRepository extends JpaRepository<AdminMenu, Integer> {

    @Query(nativeQuery = true, value = "SELECT menu.* FROM admin_menu menu " +
            "    LEFT JOIN admin_role_menu role_menu ON role_menu.menu_id=menu.id " +
            "    LEFT JOIN admin_user_role user_role ON user_role.role_id=role_menu.role_id " +
            " WHERE user_role.admin_id=?1 ORDER BY menu.parent_id asc, sort asc,update_time desc")
    List<AdminMenu> findMenusByAdminId(Integer adminId);
}
