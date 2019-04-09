package com.hospital.hospitalgd.common;



import java.io.Serializable;

/**
 * @program: huohuacity
 * @description: 返回map数据包
 * @author: Art
 * @create: 2018-07-17 18:29
 **/
@SuppressWarnings(value = {"unused"})
public class ServerResponseMap <T> implements Serializable {
    private T result;

    private ServerResponseMap(T data){
        this.result = data;
    }

    public static <T> ServerResponseMap<T> getMap(T map){
        return new ServerResponseMap<>(map);
    }
}
