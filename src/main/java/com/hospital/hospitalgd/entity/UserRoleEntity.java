package com.hospital.hospitalgd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: hospital-gd
 * @description: 权限控制-用户角色关联表
 * @author: Art
 * @create: 2019-04-08 13:58
 **/
@Entity
@Table(name = "permission_user_role")
public class UserRoleEntity {
    @Id
    private Integer id;
    private Integer role_id;
    private byte is_valid = 1;
}
