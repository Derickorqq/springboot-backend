package com.hospital.hospitalgd.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: hospital-gd
 * @description: 权限控制-角色类
 * @author: Art
 * @create: 2019-04-08 13:58
 **/
@Entity
@Table(name = "permission_role")
public class RoleEntity {
    @Id
    private Integer id;
    private String name;
    private byte is_valid = 1;

}
