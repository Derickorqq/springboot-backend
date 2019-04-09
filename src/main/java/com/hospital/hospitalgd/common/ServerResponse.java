package com.hospital.hospitalgd.common;


import java.io.Serializable;

/**
 * Created by geely
 * 接口响应的统一包装类
 */
@SuppressWarnings(value = {"unused","unchecked"})
//保证序列化json的时候,如果是null的对象,key也会消失
public class ServerResponse<T> implements Serializable {

    private int errno;
    private String msginfo;
    private T msg;

    private ServerResponse(int errno){
        this.errno = errno;
    }
    private ServerResponse(int errno, T msg){
        this.errno = errno;
        this.msg = msg;
    }

    private ServerResponse(int errno, String msginfo, T msg){
        this.errno = errno;
        this.msginfo = msginfo;
        this.msg = msg;
    }

    private ServerResponse(int errno, String msginfo){
        this.errno = errno;
        this.msginfo = msginfo;
    }

    //使之不在json序列化结果当中
    public boolean isSuccess(){
        return this.errno == ResponseCode.SUCCESS.getCode();
    }

    public int getErrno(){
        return errno;
    }
    public T getMsg(){
        return msg;
    }
    public String getMsginfo(){
        return msginfo;
    }


    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msginfo){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),msginfo);
    }

    public static <T> ServerResponse<T> createBySuccessObject(T msg){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),msg);
    }


    /**
    * @Description: 包装列表数据
    * @Param: [msg]
    * @Return: com.huohuacity.huohuacity.common.ServerResponse<T>
    */
    public static <T> ServerResponse<T> createBySuccessList(T msg){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), (T) ServerResponseList.getList(msg));
    }

    /**
    * @Description: 返回的数据格式是
     * {
     *     "errno": 0,
     *     "msginfo": null,
     *     "msg": {
     *         "result": "取关成功"
     *     },
     *     "success": true
     * }
    * @Param: [msg]
    * @Return: com.huohuacity.huohuacity.common.ServerResponse
    */
    /*public static <T> ServerResponse createBySuccessMapMessage(T msg){
        HashMap<String,T> map = new HashMap();
        map.put("result",msg);
        return new ServerResponse(ResponseCode.SUCCESS.getCode(), map);
    }*/
    public static <T> ServerResponse<T> createBySuccessMapMessage(T msg){
        return new ServerResponse(ResponseCode.SUCCESS.getCode(), (T)ServerResponseMap.getMap(msg));
    }

    public static <T> ServerResponse<T> createBySuccess(String msginfo,T msg){
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),msginfo, (T) ServerResponseList.getList(msg));
    }

    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }


    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage){
        return new ServerResponse<>(ResponseCode.ERROR.getCode(),errorMessage);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode,String errorMessage){
        return new ServerResponse<>(errorCode,errorMessage);
    }
   /* public static <T> ServerResponse<T> createByNoDataCodeMessage(){
        return new ServerResponse<>(ResponseCode.NO_DATA.getCode(),ResponseCode.NO_DATA.getDesc());
    }*/

}
