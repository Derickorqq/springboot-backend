package com.hospital.hospitalgd.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: hospital-gd
 * @description:
 * @author: Art
 * @create: 2019-04-08 15:07
 **/
@Data
public class UserSessionModel implements Serializable {
    private Integer userId;
    private String userName;
    private Integer roleId;
}
