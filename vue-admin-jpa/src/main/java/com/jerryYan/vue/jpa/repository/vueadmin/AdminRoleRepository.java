package com.jerryYan.vue.jpa.repository.vueadmin;

import com.jerryYan.vue.jpa.entity.vueadmin.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRoleRepository extends JpaRepository<AdminRole, Integer> {
}
