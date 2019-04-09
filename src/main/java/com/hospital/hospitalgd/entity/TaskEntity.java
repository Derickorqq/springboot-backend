package com.hospital.hospitalgd.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: hospital-gd
 * @description: 权限控制-菜单类
 * @author: Art
 * @create: 2019-04-08 13:58
 **/
@Entity
@Table(name = "permission_task")
public class TaskEntity {
    @Id
    private Integer id;
    private Integer name;
    private Integer path;
    private Integer parent_id;
    private byte is_valid = 1;

}
