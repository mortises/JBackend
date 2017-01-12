//存放主要交互逻辑的js代码

var userReq = {
    Entity : {
         "userId" : 0,
        "userName" : "",
        "userPhone" : 0,
        "createTime" : 0,
        "score" : "",
        "pwd" : ""
    },

    signupController: "../signup",
    sigupSuccUrl: "",

    //验证手机号
    validatePhone: function (phone) {
        if (phone && phone.length == 11 && !isNaN(phone)) {
            return true;//直接判断对象会看对象是否为空,空就是undefine就是false; isNaN 非数字返回true
        } else {
            return false;
        }
    },
    //详情页秒杀逻辑
    init:  function () {
        $('#signup').click(function () {
            userReq.Entity.userName = $('#form-username').val();
            userReq.Entity.pwd = $('#form-password').val();
            userReq.Entity.userPhone =  parseInt($('#form-phone').val());
            userReq.register();
        });
    },

    register: function () {
        //执行购买请求
        $.ajax({
            type : "POST",
            contentType : 'application/json; charset=utf-8',
            dataType : 'json',
            url : userReq.signupController,
            data : JSON.stringify(userReq.Entity), //JSON.stringify(search),
            success : function(result) {
                alert("succeed");
            },
            error: function(e){
                alert("error")
            }
        });

    },


}