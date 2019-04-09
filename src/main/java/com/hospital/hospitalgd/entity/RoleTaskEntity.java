package com.hospital.hospitalgd.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: hospital-gd
 * @description: 权限控制-角色人物关连表
 * @author: Art
 * @create: 2019-04-08 13:58
 **/
@Entity
@Table(name = "permission_role_task")
public class RoleTaskEntity {
    @Id
    private Integer id;
    private Integer role_id;
    private Integer task_id;
    private byte is_valid = 1;

}
