<#import "spring.ftl" as spring />
<html>
<head>
    <script src="<@spring.url'/pub/js/jquery-3.3.1.min.js'/>"></script>
    <script src="<@spring.url'/bootstrap-3.3.7-dist/js/bootstrap.min.js'/>"></script>
    <script src="<@spring.url'/mine/js/query.js'/>"></script>
</head>
<body>
    <h1>hello world</h1>
    <div>main页面</div>
<button onclick="loginOut()">清缓存</button>
</body>

<script>

    <#--退出登录-->
    function loginOut() {
        var data = {};
        data.userName = '11';
        data.psd = '你好';
        postReq('${preUrl}','${preUrl}/loginOut',data,function (data) {
            console.log("退出");
            console.log(data);
            //退出成功
            if(data.errno==0){
                <#--window.location.href = '${preUrl}/page/login';-->
            }
        });
    }
</script>
</html>