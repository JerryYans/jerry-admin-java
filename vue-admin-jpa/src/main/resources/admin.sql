#DROP TABLE admin_user;
CREATE TABLE IF NOT EXISTS admin_user
(
    id INT NOT NULL AUTO_INCREMENT COMMENT '管理员id',
    username VARCHAR(32) NOT NULL COMMENT '管理员登录账户',
    password VARCHAR(32) NOT NULL COMMENT '管理员登录密码',
    nickname VARCHAR(10) DEFAULT '匿名' COMMENT '昵称',
    avatar VARCHAR(10) NULL COMMENT '头像',
    is_del TINYINT NOT NULL DEFAULT '0' COMMENT '0:正常，1:用户删除，9:系统删除(可以理解为硬删除)',
    create_time DATETIME NOT NULL COMMENT '创建时间',
    update_time DATETIME NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='管理后台用户表';

CREATE TABLE IF NOT EXISTS admin_menu
(
    id INT NOT NULL AUTO_INCREMENT COMMENT '菜单id',
    parent_id INT NOT NULL DEFAULT 0 NOT NULL COMMENT '上级菜单id,为0表示为一级菜单',
    sort TINYINT NOT NULL DEFAULT 0 NOT NULL COMMENT '排序',
    name VARCHAR(20) NOT NULL COMMENT '菜单',
    href VARCHAR(20) NOT NULL DEFAULT '' COMMENT '链接',
    icon VARCHAR(20) NULL COMMENT '图标',
    is_show TINYINT NOT NULL DEFAULT 0  COMMENT '是否显示(1:显示,0:不显示)',
    is_del TINYINT NOT NULL DEFAULT 0 COMMENT '0:正常，1:用户删除，9:系统删除(可以理解为硬删除)',
    create_time DATETIME NOT NULL COMMENT '创建时间',
    update_time DATETIME NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='管理后台菜单表';


CREATE TABLE IF NOT EXISTS admin_role
(
    id INT NOT NULL AUTO_INCREMENT COMMENT '角色id',
    name VARCHAR(20) NOT NULL COMMENT '角色',
    description VARCHAR(100) NOT NULL DEFAULT '' COMMENT '描述',
    is_del TINYINT NOT NULL DEFAULT 0 COMMENT '0:正常，1:用户删除，9:系统删除(可以理解为硬删除)',
    create_time DATETIME NOT NULL COMMENT '创建时间',
    update_time DATETIME NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='管理后台角色表';

CREATE TABLE IF NOT EXISTS admin_role_menu
(
    id INT NOT NULL AUTO_INCREMENT,
    role_id INT NOT NULL COMMENT '角色id',
    menu_id INT NOT NULL COMMENT '菜单id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='角色对应的菜单列表';

CREATE TABLE IF NOT EXISTS admin_user_role
(
    id INT NOT NULL AUTO_INCREMENT,
    admin_id INT NOT NULL COMMENT '管理员角色id',
    role_id INT NOT NULL COMMENT '角色id',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='管理员对应的角色列表';

INSERT INTO admin_user (username, password, nickname, avatar, create_time, update_time)
VALUES ('admin', '21232f297a57a5a743894a0e4a801fc3', 'admin', null, '2018-05-20 15:32:06', '2018-05-15 15:32:26');

INSERT INTO `vue-admin`.admin_menu (id, parent_id, sort, name, href, icon, is_show, is_del, create_time, update_time)
VALUES
(1, 0, 1, '系统管理', '/sys', 'fa fa-cog', 1, 0, now(), now()),
(2, 1, 1, '菜单管理', '/sys/menuList', 'fa fa-navicon', 1, 0, now(), now()),
(3, 1, 2, '角色管理', '/sys/roleList', 'fa fa-universal-access', 1, 0, now(), now()),
(4, 1, 3, '用户管理', '/sys/userList', 'fa fa-user-plus', 1, 0, now(), now()),
(5, 1, 4, '资源管理', '/sys/resource', 'fa fa-database', 1, 0, now(), now())

INSERT INTO `vue-admin`.admin_role (id, name, description, is_del, create_time, update_time) VALUES (1, '系统管理员', '', 0, '2018-05-15 19:01:19', '2018-05-15 19:01:21');
INSERT INTO `vue-admin`.admin_user_role (admin_id, role_id) VALUES (1, 1);
INSERT INTO `vue-admin`.admin_role_menu (role_id, menu_id) VALUES (1, 1), (1, 2),(1, 3),(1, 4),(1, 5);