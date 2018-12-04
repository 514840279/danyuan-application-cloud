$(function(){
  // 初始化方法
  init();
})

function init(){
    // 绑定事件
    $("#start_run").bind("click",startRun)
}

function startRun(){
    console.log(1)
    var url = "/start/run"
    var param = {"list":[{
        "uuid":'68103c87-e974-46e2-bf54-a3c1b817ab41',
        "url":"http://www.xuexi111.com/about/sitemap.html",
        "requestType":"requestGet",
        "charset":"UTF-8"
    }]}
    ajaxPost(url,param,successRun)
}
function successRun(result){
    console.log(result)
}