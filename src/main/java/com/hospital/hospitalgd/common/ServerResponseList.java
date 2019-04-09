package com.hospital.hospitalgd.common;


import java.io.Serializable;

/**
 * Created by geely
 */
@SuppressWarnings(value = {"unused"})
//保证序列化json的时候,如果是null的对象,key也会消失
public class ServerResponseList<T> implements Serializable {

    private T list;

    private ServerResponseList(T data){
        this.list = data;
    }


    public T getList(){
        return list;
    }

    public static <T> ServerResponseList<T> getList(T list){
        return new ServerResponseList<>(list);
    }

}
