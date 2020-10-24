-- ----------------------------
--  Table structure for cms_user_primary 用户主表
-- ----------------------------
CREATE TABLE cms_user_primary (
	create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    id int(11) NOT NULL AUTO_INCREMENT primary key,
    username varchar(50) not null comment '用户名',
    password varchar(64) not null comment '用户密码，MD5加密或sha256散列加密',
	salt varchar(64) not null comment '密码盐',
    email varchar(50) not null default '' comment '邮箱',
    login_count int(10) not null default 0 comment '登陆次数',
 	status tinyint(1) default '1' not null comment '状态',
 	deleted tinyint(1) default '1' not null comment '是否已删除 0:删除 1正常',
    UNIQUE KEY user_name_unique (username) USING BTREE,
    UNIQUE KEY user_email_unique (email) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO cms_user_primary (id, create_time, update_time, username, password, salt, email, login_count) VALUES (1, '2019-06-14 11:30:58', null, 'admin', 'e298f9b29585da289080ffebb32e6f931b52a61195bcf6246d3e0f24654897eb', '6e4abc9695661ce11f442eaea3cb6540', 'abc@126.com', 0);
INSERT INTO cms_user_primary (id, create_time, update_time, username, password, salt, email, login_count) VALUES (2, '2019-06-14 11:30:58', null, 'administrator', 'e298f9b29585da289080ffebb32e6f931b52a61195bcf6246d3e0f24654897eb', '6e4abc9695661ce11f442eaea3cb6540', 'def@126.com', 0);