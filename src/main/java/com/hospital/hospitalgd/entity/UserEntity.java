package com.hospital.hospitalgd.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: hospital-gd
 * @description: 权限控制-用户类
 * @author: Art
 * @create: 2019-04-08 13:58
 **/
@Entity
@Table(name = "pub_user")
public class UserEntity {
    @Id
    private Integer id;
    private Integer userName;
    private Integer psd;
    private byte is_valid = 1;

}
