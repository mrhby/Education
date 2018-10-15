$(document).ready(function() {
    $("#register").click(function () {
        var stunam = $('input[name=stunam]');
        var password = $('input[name=password]');
        var repassword = $('input[name=repassword]');
        if (stunam.val() == "") {
            $("#div1").html("<p>*用户名不能为空</p>");
        }
        if (password.val() == "") {
            $("#div2").html("<p>*密码不能为空</p>");
        }
        if (repassword.val() == "") {
            $("#div3").html("<p>*重新输入密码不能为空</p>");
        }
        if (password.val() != repassword.val()) {
            $('#div3').html("<p>*两次输入的密码不相同</p>");
        }
        else {
            $.ajax({
                url: "RegisterServlet",
                type: "post",
                dataType: "text",
                data: {"stunam": stunam.val(), "password": password.val()},
                async: true,
                success: function (data) {
                    if (data == "true") {
                        alert("注册成功");
                        window.location.href = "StudentLogin.html";
                        window.event.returnValue = false;
                    }
                    else {
                        alert("用户名已被注册");
                        $("[name='stunam']").val("");
                    }
                },
                error: function () {
                    alert("ajax请求错误");
                }
            })
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
    $("#password").blur(function() {
        var password = $('input[name=password]');
        if(password.val() == ""){
            $("#div2").html("<p>*密码不能为空</p>");
        }
        else{
            $("#div2").html("");
        }
    });
    $("#repassword").blur(function() {
        var repassword = $('input[name=repassword]');
        var password = $('input[name=password]');
        if(repassword.val() == ""){
            $("#div3").html("<p>*重新输入密码不能为空</p>");
        }
        else{
            $("#div3").html("");
        }
        if(password.val() !=repassword.val()){
            $("#div3").html("");
            $('#div3').html("<p>*两次输入的密码不相同</p>");
        }
    });
    $( "#datepicker" ).datepicker({
        changeMonth: true,
        changeYear: true,
        dateFormat: "yy-mm-dd",
        showButtonPanel: true,
        yearRange: "1900:2018"
    });
});





