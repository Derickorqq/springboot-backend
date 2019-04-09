package com.hospital.hospitalgd.controller;

import com.hospital.hospitalgd.common.ConstPool;
import com.hospital.hospitalgd.common.ResponseCode;
import com.hospital.hospitalgd.common.ServerResponse;
import com.hospital.hospitalgd.model.UserSessionModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * hospital-gd
 * Art
 * 2019-04-08 12:43
 **/

@RestController

public class LoginController {

    @PostMapping("login")
    public ServerResponse doLogin( HttpServletRequest request,
                                   String userName,
                                   String psd){
        //获取用户id
        UserSessionModel userSessionModel = new UserSessionModel();
        userSessionModel.setUserId(1);
        userSessionModel.setRoleId(2);
        userSessionModel.setUserName(userName);
        if(userName!=null&&psd!=null){
            if(userName.equals("test")&&psd.equals("123")){
                request.getSession().setAttribute(ConstPool.SESSION_USER_INFO_KEY_PRE,userSessionModel);
                return ServerResponse.createBySuccess();
            }else{
                return ServerResponse.createByErrorCodeMessage(ResponseCode.FAIL.getCode(),"账号密码错误");
            }
        }
        return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"登录过期");
    }

    //退出登录
    @PostMapping("loginOut")
    public ServerResponse loginOut( HttpServletRequest request
    ){
        request.getSession().setAttribute("userInfo",null);
        return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"登录过期");
    }
}
