package com.jerryYan.vue.jpa.repository.vueadmin;

import com.jerryYan.vue.jpa.entity.vueadmin.SysAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysAdminRepository extends JpaRepository<SysAdmin, Integer> {
}
