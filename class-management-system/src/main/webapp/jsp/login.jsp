<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
</head>
<link href="${webPath}css/easyui/easyui.css" rel="stylesheet" type="text/css"/>
<link href="${webPath}css/easyui/easyui_animation.css" rel="stylesheet" type="text/css"/>
<link href="${webPath}css/easyui/easyui_plus.css" rel="stylesheet" type="text/css"/>
<link href="${webPath}css/easyui/insdep_theme_default.css" rel="stylesheet" type="text/css"/>
<link href="${webPath}css/easyui/icon.css" rel="stylesheet" type="text/css"/>
<script src='${webPath}css/easyui/jquery.min.js' type='text/javascript'></script>
<script src='${webPath}css/easyui/jquery.easyui.min.js' type='text/javascript'></script>
<script src='${webPath}css/easyui/jqueryExtend.js' type='text/javascript'></script>
<body class="theme-login-layout">
		<div class="theme-login-header"></div>
		<div id="theme-login-form">
            <form id="form" class="theme-login-form" method="post">  
            <dl>
                <dt><img src="${webPath}images/logo_icon.png"></dt>
                <dd>
                	<select name="type" id="theme-login-select" class="theme-login-select" style="width:100%;">   
                    	<option value="0">请选择用户类型</option>  
                        <option value="1">管理员</option>   
                        <option value="2">教师</option>
                        <option value="3">学生</option>  
                    </select>  
                </dd>
                <dd><input id="userName" name="userName" class="theme-login-text"  style="width:100%;"/></dd>
                <dd><input id="password" name="password" class="theme-login-text"  style="width:100%;"/></dd>
                <dd>
                	<a class="submit">登陆</a>
<!--                 	<a class="easyui-linkbutton button">忘记密码</a> -->
                </dd>
            </dl>
            </form>
        </div>

    	<div class="theme-login-footer">
        </div>
<script>
$(function(){
	/*布局部分*/
	$('#theme-login-layout').layout({
		fit:true/*布局框架全屏*/
	});   
	
	/*表单定义*/
	$('#theme-login-select').combobox({    
		/*通过ajax取数据
		url:'userclass.json',    
		valueField:'id',
		textField:'text'
		*/
		editable:false /*不允许用户通过输入选择*/
	});  
	
	$('#userName').textbox({    
		prompt:'用户名',
		required:true,
		missingMessage:"请输入用户名"
	});
	$('#password').textbox({    
		type:"password",
		prompt:'密码',
		required:true,
		missingMessage:"请输入密码"
	});
	
	$('.submit').bind("click",function(){
		$(this).submit();
	}).linkbutton(); 
	
	/*验证码tooltip*/
	$('#form').form({
		url:"${webPath}login/in.do",
		onSubmit:function(){
			var res=$(this).form('enableValidation').form('validate');
			res?$.messager.progress():"";
			return res;
		},
		success: function(msg){ 
		    $.messager.progress('close');
			try 
			{ 
				var data=JSON.parse(msg);
				if (data.success){    
					window.open("${webPath}systemMng/user/toDesktop.do","_self");
				}else{
					$.messager.alert('提示',"用户名或密码错误！",'error',function(){
						$('#userName,#password').textbox('clear');
					});
				}
			} 
			catch (e) 
			{ 
				
			} 
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			console.info(XMLHttpRequest);
			console.info(textStatus);
			console.info(errorThrown);
		}
	});	
	/*验证码tooltip*/
});
</script>

</body>
</html>
