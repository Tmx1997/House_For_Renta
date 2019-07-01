//获取cookie
function getCookie(name) {
    var cookies = document.cookie;
    var list = cookies.split("; ");
    // 解析出名/值对列表
    for(var i = 0; i < list.length; i++) {
        var arr = list[i].split("=");
        //解析出名和值
        if(arr[0] == name)
            return decodeURIComponent(arr[1]);
        // 对cookie值解码
    }
    return "";}
    //获取上下文
    function getContextPath() {
    var contextPath=document.location.pathname;
    var index=contextPath.substr(1).indexOf("/");
    contextPath=contextPath.substr(0,index+1);
    return contextPath;
}
//图片预览
function changePicture() {
    var read=new FileReader();
    var f =$("#picture")[0].files[0];
    read.readAsDataURL(f);
    read.onload=function (e) {
        $("#img01").attr("src",this.result);
        $("#img01").css("display","block");
    }
}
//获取页眉
function getPageHeader() {
    var name=getCookie("username");
    $("#welcome").html("【欢迎--"+"<font color='#ff1493'>"+name+"</font>"+"--】")
}
//cookie判断未登录则返回登录页面
function logDetector() {
    var userName=getCookie("username");
    console.log(userName);
    if(userName===''){
        window.location=getContextPath()+"/page/login.htm";
    }
}
function delCookie(name)
{
    $.cookie(name,'',{expires:-1,path:'/'})
}
//退出登录
function logOut() {
    delCookie("username");
    delCookie("userId");
    document.location=getContextPath()+'/page/login.htm'
}
UrlParm = function() { // url参数
    var data, index;
    (function init() {
        data = [];
        index = {};
        var u = window.location.search.substr(1);
        if (u != '') {
            var parms = decodeURIComponent(u).split('&');
            for (var i = 0, len = parms.length; i < len; i++) {
                if (parms[i] != '') {
                    var p = parms[i].split("=");
                    if (p.length == 1 || (p.length == 2 && p[1] == '')) {// p | p=
                        data.push(['']);
                        index[p[0]] = data.length - 1;
                    } else if (typeof(p[0]) == 'undefined' || p[0] == '') { // =c | =
                        data[0] = [p[1]];
                    } else if (typeof(index[p[0]]) == 'undefined') { // c=aaa
                        data.push([p[1]]);
                        index[p[0]] = data.length - 1;
                    } else {// c=aaa
                        data[index[p[0]]].push(p[1]);
                    }
                }
            }
        }
    })();
    return {
        // 获得参数,类似request.getParameter()
        parm : function(o) { // o: 参数名或者参数次序
            try {
                return (typeof(o) == 'number' ? data[o][0] : data[index[o]][0]);
            } catch (e) {
            }
        },
        //获得参数组, 类似request.getParameterValues()
        parmValues : function(o) { //  o: 参数名或者参数次序
            try {
                return (typeof(o) == 'number' ? data[o] : data[index[o]]);
            } catch (e) {}
        },
        //是否含有parmName参数
        hasParm : function(parmName) {
            return typeof(parmName) == 'string' ? typeof(index[parmName]) != 'undefined' : false;
        },
        // 获得参数Map ,类似request.getParameterMap()
        parmMap : function() {
            var map = {};
            try {
                for (var p in index) {  map[p] = data[index[p]];  }
            } catch (e) {}
            return map;
        }
    }
}();