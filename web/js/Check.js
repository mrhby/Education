$(document).ready(function() {
    $("#login").click(function () {
        var stunam = $('input[name=stunam]');
        var password = $('input[name=password]');
        var code = $('input[name=code]');
        if (stunam.val() == "") {
            $("#div1").html("<p>*用户名不能为空</p>");
        }
        if(password.val() == ""){
            $("#div2").html("<p>*密码不能为空</p>")
        }
        if(code.val() == ""){
            $("#div3").html("<p>*验证码不能为空</p>");
        }
        else {
            $.ajax({
                url: "LoginServlet",
                type: "post",
                dataType: "text",
                data: {"stunam": stunam.val(), "password": password.val(), "code": code.val()},
                async: true,
                success: function (data) {
                    if (data == "true") {
                        window.location.href = "../jsp/mainPage.jsp";
                        window.event.returnValue = false;
                    }
                    else if (data == "验证码输入错误") {
                        alert("验证码输入错误");
                        $("[name='code']").val("");
                    }
                    else if (data == "用户名或密码输入错误") {
                        alert("用户名或密码输入错误");
                        $("[name='stunam']").val("");
                        $("[name='password']").val("");
                    }
                    else if (data == "验证码为空") {
                        alert("验证码为空");
                        $("#div3").html("<p>*验证码不能为空</p>");
                    }
                },
                error: function () {
                    alert("ajax请求错误");
                }
            })
        }
    });
    $("#password").blur(function () {
        var password = $('input[name=password]');
        if (password.val() == "") {
            $("#div2").html("<p>*密码不能为空</p>");
        }
        else {
            $("#div2").html("");
        }
    });
    $("#stunam").blur(function () {
        var stunam = $('input[name=stunam]');
        if (stunam.val() == "") {
            $("#div1").html("<p>*用户名不能为空</p>");
        }
        else {
            $("#div1").html("");
        }
    });
    $("#code").blur(function () {
        var code = $('input[name=code]');
        if (code.val() == "") {
            $("#div3").html("<p>*验证码不能为空</p>");
        }
        else {
            $("#div3").html("");
        }
    });

});

