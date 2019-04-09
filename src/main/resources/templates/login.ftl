<#import "spring.ftl" as spring />
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="<@spring.url'/bootstrap-3.3.7-dist/css/bootstrap.min.css'/>"/>
        <script src="<@spring.url'/pub/js/jquery-3.3.1.min.js'/>"></script>
        <script src="<@spring.url'/pub/js/jquery.cookie.min.js'/>"></script>
        <script src="<@spring.url'/bootstrap-3.3.7-dist/js/bootstrap.min.js'/>"></script>
        <script src="<@spring.url'/mine/js/query.js'/>"></script>
    </head>
    <body>
<div class="container" style="width: 300px;margin-top: 8%;">
        <form class="form-signin" >
        <h2 class="form-signin-heading">请登录</h2>
        <label for="inputUserName" class="sr-only">账号</label>
        <input type="text" id="inputUserName" name="userName" class="form-control" placeholder="账号" required="" autofocus="" value=""/>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" name="psd" class="form-control" placeholder="密码" required="" value=""/>
        <div class="checkbox">
        <label>
            <input type="checkbox"  id="checkbox"/>记住密码
        </label>
            <label style="display: none" id="tip" >
                <span  class="error" style="color: red;">账号或密码错误</>
            </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="button" onclick="dolgin()" >登录</button>
</form>
</div>
</body>
<script>
    <#--加载页面后自动读取cookies并补全表单-->
    var cookiesStr = $.cookie('loginInfo');
    if(cookiesStr !=null && cookiesStr != undefined){
        var cookies = JSON.parse(cookiesStr);
        $("#inputUserName").val(cookies.name);
        $("#inputPassword").val(cookies.psd);
        $("#checkbox").attr("checked", cookies.checked);
    }else{
        $("#checkbox").attr("checked", false);
    }

    function dolgin() {
        //获取表单值
        var name = $("#inputUserName").val();
        var psd = $("#inputPassword").val();
        var checked = $("#checkbox").prop("checked");

        //构造登录参数
        var param = {};
        param.userName = name;
        param.psd = psd;
        postReq('${preUrl}','${preUrl}/login',param,function (data) {
            if(data.errno==0){//登录成功
                //是否记住密码
                var cookies = {};
                cookies.name = name;
                cookies.psd = psd;
                cookies.checked = checked;
                if(checked){//记住密码
                    //设置cookies 并保存7天,任何路径想都能读取该cookies（默认只能在设置页面读取cookies）
                    $.cookie('loginInfo', JSON.stringify(cookies), { expires: 7,path: '/'});
                }else{//不记住密码
                    $.cookie('loginInfo', '', { expires: -1,path:'/' });
                }
                //调准到首页
                window.location.href = '${preUrl}/page/main';
            }else if(data.errno==3){//账号密码错误提醒
                $("#tip").show();
            }
        });
    }
</script>
</html>