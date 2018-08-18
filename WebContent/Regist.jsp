<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="css/style.css" />
	<link type="text/css" rel="stylesheet" href="css/input.css" />
	
    <script type="text/javascript" src="js/jquery-1.11.1.min_044d0927.js"></script>
	<script type="text/javascript" src="js/jquery.bxslider_e88acd1b.js"></script>
    
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>    
        
	<script type="text/javascript" src="js/select.js"></script>
    
	<script type="text/javascript" src="js/lrscroll.js"></script>
    
    <script type="text/javascript" src="js/iban.js"></script>
    <script type="text/javascript" src="js/fban.js"></script>
    <script type="text/javascript" src="js/f_ban.js"></script>
    <script type="text/javascript" src="js/mban.js"></script>
    <script type="text/javascript" src="js/bban.js"></script>
    <script type="text/javascript" src="js/hban.js"></script>
    <script type="text/javascript" src="js/tban.js"></script>
    
	<script type="text/javascript" src="js/lrscroll_1.js"></script>
    <script type="text/javascript">
    function changeImg(){
    	var img = document.getElementById("ValiImg");
    	img.setAttribute("src","${pageContext.request.contextPath }/ValiImg?time="+new Date().getTime());
    }

   
    </script>
    
<title>尤洪</title>
</head>
<body>  
<!--Begin Header Begin-->
<div class="soubg">
	<div class="sou">
        <span class="fr">
        	<span class="fl">你好，请<a href="Login.jsp">登录</a>&nbsp; <a href="Regist.jsp" style="color:#ff4e00;">免费注册</a></span>
            <span class="fl">|&nbsp;关注我们：</span>
            <span class="s_sh"><a href="#" class="sh1">新浪</a><a href="#" class="sh2">微信</a></span>
            <span class="fr">|&nbsp;<a href="#">手机版&nbsp;<img src="images/s_tel.png" align="absmiddle" /></a></span>
        </span>
    </div>
</div>
<!--End Header End--> 
<!--Begin Login Begin-->
<div class="log_bg">	
    <div class="top">
        <div class="logo"><a href="Index.html"><img src="images/logo.png" /></a></div>
    </div>
	<div class="regist">
    	<div class="log_img"><img src="images/l_img.png" width="611" height="425" /></div>
		<div class="reg_c" >
		
        	<form action="" method="post" id="RegForm">
            <table border="0" style="width:420px; font-size:14px;margin-top:10px;" cellspacing="0" cellpadding="0" >
              <tr height="50" valign="top">
              	<td width="95">&nbsp;</td>
                <td>
                	<span class="fl" style="font-size:24px;">注册</span>
                    <span class="fr">已有商城账号，<a href="Login.jsp" style="color:#ff4e00;">我要登录</a></span>
                </td>
              </tr>
              <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;用户名 &nbsp;</td>
                <td><input type="text" value="${param.loginName}" id="User_LoginName_input" class="l_user" name="loginName" placeholder="请输入您的用户名"  />
                </td>
              </tr>
              <tr>
              	<td></td>
              	<td><span id="User_LoginName_input_span" style="font-size:12px;color:red;"></span></td>
              </tr>
              <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;密码 &nbsp;</td>
                <td><input type="password" value="" id="User_password_input" class="l_pwd" name="password" placeholder="请输入您的密码 "  /></td>
              </tr>
               <tr>
              	<td></td>
              	<td><span id="User_password_input_span" style="font-size:12px;color:red;"></span></td>
              </tr>
              <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;确认密码 &nbsp;</td>
                <td><input type="password" value="" id="User_password2_input" class="l_pwd"  name="password2" placeholder="请输入确认密码" /></td>
              </tr>
               <tr>
              	<td></td>
              	<td><span id="User_password2_input_span" style="font-size:12px;color:red;"></span></td>
              </tr>
               <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;真实姓名 &nbsp;</td>
                <td><input type="text" value="${param.userName}" id="User_userName_input" class="l_user" name="userName" placeholder="请输入您的真实姓名" /></td>
              </tr>
              <tr>
              	<td></td>
              	<td><span id="User_userName_input_span" style="font-size:12px;color:red;"></span></td>
              </tr>
               <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;性别 &nbsp;</td>
                <td><input type="radio" name="sex" id="sex1_update_input" value="1" checked="checked"> 男
                	<input type="radio" name="sex" id="sex2_update_input" value="0" > 女
                </td>
              </tr>
               <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;身份证号码 &nbsp;</td>
                <td><input type="text" value="" id="User_indentityCode_input" class="l_user" name="identityCode" placeholder="请输入您的身份证号码" /></td>
              </tr>
              <tr>
              	<td></td>
              	<td><span id="User_indentityCode_input_span" style="font-size:12px;color:red;"></span></td>
              </tr>
              <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;邮箱 &nbsp;</td>
                <td><input type="text" value="${param.email}" id="User_email_input" class="l_email" name="email" placeholder="请输入您的邮箱" /></td>
              </tr>
              <tr>
              	<td></td>
              	<td><span id="User_email_input_span" style="font-size:12px;color:red;"></span></td>
              </tr>
              <tr height="50">
                <td align="right"><font color="#ff4e00">*</font>&nbsp;手机 &nbsp;</td>
                <td><input type="text" value="${param.mobile}" id="User_mobile_input" class="l_tel" name="mobile" placeholder="请输入您的手机号码 " /></td>
              </tr>
              <tr>
              	<td></td>
              	<td><span id="User_mobile_input_span" style="font-size:12px;color:red;"></span></td>
              </tr>
              <tr height="50">
               <td align="right"> <font color="#ff4e00">*</font>&nbsp;验证码 &nbsp;</td>
                <td>
                    <input type="text" name="ValiImg" value="${param.ValiImg}" class="l_ipt" id="User_Vail_input" />
                    <img src="${pageContext.request.contextPath }/ValiImg"  id = "ValiImg" style="cursor:pointer;" onclick="changeImg()" />
                    <a href="javascript:changeImg()" style="font-size:12px; font-family:'宋体';">换一张</a>
                </td>
              </tr>
             <tr>
              	<td></td>
              	<td><span id="User_ValiImg_input_span" style="font-size:12px;color:red;"></span></td>
              </tr>
              <tr>
              	<td>&nbsp;</td>
                <td style="font-size:12px; padding-top:20px;">
                	<span style="font-family:'宋体';" class="fl">
                    	<label class="r_rad"><input type="checkbox" /></label><label class="r_txt">我已阅读并接受《用户协议》</label>
                    </span>
                </td>
              </tr>
              <tr height="60" >
              	<td>&nbsp;</td>
                <td><input type="button" value="立即注册" class="log_btn" id="UserRegBtn" /></td>
              </tr>
            </table>
            </form>
        </div>
    </div>
</div>
<!--End Login End--> 
<!--Begin Footer Begin-->
<div class="btmbg">
    <div class="btm">
        备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com   Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 , Technical Support: Dgg Group <br />
        <img src="images/b_1.gif" width="98" height="33" /><img src="images/b_2.gif" width="98" height="33" /><img src="images/b_3.gif" width="98" height="33" /><img src="images/b_4.gif" width="98" height="33" /><img src="images/b_5.gif" width="98" height="33" /><img src="images/b_6.gif" width="98" height="33" />
    </div>    	
</div>
<!--End Footer End -->    
 <script type="text/javascript">
 var regPassword = /^[a-zA-Z0-9]{4,6}$/;//密码正则表达式
 var reg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;//邮箱正则表达式
 var regIndentityCode = /^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;//身份证正则表达式
 var regMobile = /^1[3|4|5|8][0-9]\d{4,8}$/;//手机正则表达式
 var regName = /(^[a-zA-Z0-9_-]{4,8}$)|(^[\u2E80-\u9FFF]{2,5})/;//名字正则表达式
 var flag = false;//设置全局的标志，返回异步检验用户名是否存在的标志
 
 //用户名验证
 $("#User_LoginName_input").change(function(){
		//拿到要校验的数据，使用正则表达式
		checkName();
 });
 //校验用户名
 function checkName(ele){
	 var loginName = $("#User_LoginName_input").val();
		var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
		if(!regName.test(loginName)){
			$("#User_LoginName_input_span").text("用户名可以是2-5位中文或者6-16位英文和数字的组合").css("color","red");
			flag = false;
			return;
		}
		$.ajax({
			url:"${pageContext.request.contextPath}/VailNameServlet",
			data:"loginName="+loginName,
			type:"POST",
			success:function(msg){
				var result = JSON.parse(msg);
				//用户名存在
				if(result.hasOwnProperty("faile")){
					$("#User_LoginName_input_span").text(result.faile).css("color","red");
					flag = false;
				}else{
					$("#User_LoginName_input_span").text(result.success).css("color","green");
					flag = true;
				}
			}
		});
 }
 //校验数据
 function checkUserOther(ele,reg,ele_input,msg){
	 var eleVal = $(ele).val();
	 var regele = reg;
	 if(!regele.test(eleVal)){
		 $(ele_input).text(msg);
		 return false;
	 }else if(eleVal == ""){
		 $(ele_input).text("");
		 $(ele_input).text("该项为必填项，不能为空");
	 }
	 $(ele_input).text("");
	return true;
 }
 	//邮箱验证
 	$("#User_email_input").change(function(){
		//校验邮箱信息
		checkUserOther("#User_email_input",reg,"#User_email_input_span","邮箱格式不正确");
	});
 	//前端判断身份证格式
	$("#User_indentityCode_input").change(function(){
		checkUserOther("#User_indentityCode_input",regIndentityCode,"#User_indentityCode_input_span","身份证格式不正确");
	});
	//前端判断手机格式
	$("#User_mobile_input").change(function(){
		checkUserOther("#User_mobile_input",regMobile,"#User_mobile_input_span","手机号码格式不正确");
	});
	//前端判断密码格式
	$("#User_password_input").change(function(){
		checkUserOther("#User_password_input",regPassword,"#User_password_input_span","密码必须为数字或字母，只能为4~6位");
	});
	//校验确认密码的函数
	function checkPwd(){
		var password1 = $("#User_password_input").val();
		var password2 = $("#User_password2_input").val();
		var regPassword = /^[a-zA-Z0-9]{4,6}$/;
		if(!regPassword.test(password2)){
			$("#User_password2_input_span").text("密码必须为数字或字母，只能为4~6位");
			return false;
		}else if(password1 != password2){
			$("#User_password2_input_span").text("两次密码不一致");
			return false;
		}
		$("#User_password2_input_span").text("");
		return true;
		
	}
	//确定密码的校验
	$("#User_password2_input").change(function(){
		checkPwd();
	});
	//真实姓名的验证
	$("#User_userName_input").change(function(){
		checkUserOther("#User_userName_input",regName,"#User_userName_input_span","用户名可以是2-5位中文或者4-8位英文和数字的组合");
	});

	
		//点击注册
		$(document).on("click","#UserRegBtn",function(){
		checkName();
		if(!flag){return;}//由于是异步请求，所以不能直接写if(!checkName()){return;},因为异步仍然会执行后面的代码
		else if(!checkUserOther("#User_password_input",regPassword,"#User_password_input_span","密码必须为数字或字母，只能为4~6位")){return;}
		else if(!checkPwd()){return;}
		else if(!checkUserOther("#User_userName_input",regName,"#User_userName_input_span","用户名可以是2-5位中文或者4-8位英文和数字的组合")){return;}
		else if(!checkUserOther("#User_indentityCode_input",regIndentityCode,"#User_indentityCode_input_span","身份证格式不正确")){return;}
		else if(!checkUserOther("#User_email_input",reg,"#User_email_input_span","邮箱格式不正确")){return;}
		else if(!checkUserOther("#User_mobile_input",regMobile,"#User_mobile_input_span","手机号码格式不正确")){return;}
		
		$.ajax({
			url:"${pageContext.request.contextPath }/UserRegistServlet",
			type:"POST",
			data:$("#RegForm").serialize(),
			success:function(msg){
				var result = JSON.parse(msg);
				console.log(result);
				console.log(result.msg.state)
				//{"msg":{"data":{"ValiImg":"验证码错误"},"msg":"处理失败","state":0}}
				if("0" == result.msg.state){
					$("#User_ValiImg_input_span").text(result.msg.data.ValiImg);
				}else if(result.msg.state == "1"){
					//{"msg":{"data":{"user":{"email":"135224544@qq.com","indentityCode":"142230199603112058","loginName":"张颢轩","mobile":"1814454337","password":"6c14da109e294d1e8155be8aa4b1ce8e","sex":0,"type":0,"userName":"张颢轩"}},"msg":"处理成功","state":1}}
					window.location.href="${pageContext.request.contextPath }/Login.jsp";
					
				}
			},
			error:function(){
				alert("服务器繁忙,请稍后再试！！！");
			}
		});
	});
 </script>
</body>

</html>
