
/**
 * 封装post统一处理跳转登录
 * 必需的 URL 参数规定您希望请求的 URL。
 * 可选的 data 参数规定连同请求发送的数据。
 * 可选的 callback 参数是请求成功后所执行的函数名
 *
*/
function postReq(urlPre,url,data,callback) {
    $.post(url,data,function (data){
        handleResult(urlPre,data,callback)
    });
}
function handleResult(urlPre,data,cusCallback) {
    //需要跳转到登录界面
    if(data.errno==10){
        window.location.href = urlPre+'/page/login';
    }else{
        cusCallback(data);
    }
}
