$(function() {
    //const test = $(".result").val();
    //console.log(test);
    //layer.msg(test);
    const status = $("#status").val();
    const uid = $("#uid").val();
    const result = $("#result").val();

    console.log("status：" + status);
    console.log("uid：" + uid);
    console.log("result：" + result);

    if( status === 204 ){
        console.log("查询错误，无此用户")
        layer.msg("请求路径错误，请检查网址", { time: 1050 });
        return false;
    }

    return true;



});
