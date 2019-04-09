package com.hospital.hospitalgd.controller;

import com.hospital.hospitalgd.common.ServerResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * hospital-gd
 * 权限相关controller
 * Art
 * 2019-04-08 14:05
 **/
@RestController
@RequestMapping("permission")
public class PermissionController {

    //添加角色
    @PostMapping("addRole")
    public ServerResponse addRole(
            String name ,
            List<Integer> tasks
    ){
        return ServerResponse.createBySuccess();
    }
    //删除角色
    @PostMapping("delRole")
    public ServerResponse delRole(){
        return ServerResponse.createBySuccess();
    }
    //编辑角色
    @PostMapping("editRole")
    public ServerResponse editRole(){
        return ServerResponse.createBySuccess();
    }
    //添加用户
    @PostMapping("getRoles")
    public ServerResponse getRoles(){
        return ServerResponse.createBySuccess();
    }
}
