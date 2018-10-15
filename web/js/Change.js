$(document).ready(function() {
    $("#change").click(function () {
        var oldpassword = $('input[name=oldpassword]').val();
        var newpassword = $('input[name=newpassword]').val();
        var repassword = $('input[name=repassword]').val();
        var action = $('input[name=action]').val();
        if (oldpassword == "") {
            $("#div1").html("<p>*原来的密码不能为空</p>");
        }
        if (newpassword == "") {
            $("#div2").html("<p>*新密码不能为空</p>");
        }
        if (repassword == "") {
            $("#div3").html("<p>*确认密码不能为空</p>");
        }
        if (newpassword != repassword) {
            $('#div3').html("<p>*两次输入的密码不相同</p>");
        }
        else {
            $.ajax({
                url: "../ChangeServlet",
                type: "post",
                dataType: "text",
                data: {"oldpassword": oldpassword, "newpassword": newpassword, "action": action},
                async: true,
                success: function (data) {
                    if (data == "true") {
                        alert("修改密码成功");
                        window.location.href = "mainPage.jsp";
                        window.event.returnValue = false;
                    }
                    else{
                        alert("原来密码输入错误，请重新输入");
                        $("[name='oldpassword']").val("");
                    }
                },
                error: function () {
                    alert("ajax请求错误");
                }
            });
        }
    });
    $("#oldpassword").blur(function () {
        var oldpassword = $('input[name=oldpassword]');
        if(oldpassword.val() == "") {
            $("#div1").html("<p>*原来的密码不能为空</p>");
        }
        else {
            $("#div1").html("");
        }
    });
    $("#newpassword").blur(function() {
        var newpassword = $('input[name=newpassword]');
        if(newpassword.val() == ""){
            $("#div2").html("<p>*密码不能为空</p>");
        }
        else{
            $("#div2").html("");
        }
    });
    $("#repassword").blur(function() {
        var repassword = $('input[name=repassword]');
        var newpassword = $('input[name=newpassword]');
        if(repassword.val() == ""){

            $("#div3").html("<p>*重新输入密码不能为空</p>");
        }
        else{
            $("#div3").html("");
        }
        if(newpassword.val() !=repassword.val()){
            $("#div3").html("");
            $('#div3').html("<p>*两次输入的密码不相同</p>");
        }
    });

});