<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link type="text/css" rel="stylesheet" href="${webPath}css/weishequ.css?v=2017030902">
<link type="text/css" rel="stylesheet" href="${webPath}css/common.css?v=2017030902">
<link rel="stylesheet" href="${webPath}js/ztree/css/zTreeStyle.css?v=2017030902" />
<link type="text/css" rel="stylesheet" href="${webPath}css/admin/viewrange.css?v=2017030902"/>
<%-- <script type="text/javascript" src="${webPath}/static/js/box/viewrange/viewrange.js?v=2017030902"></script> --%>
<link type="text/css" rel="stylesheet" href="${webPath}js/select/jquery.searchableSelect.css?v=2017030902"/>
<script type="text/javascript" src="${webPath}js/select/jquery.searchableSelect.js?v=2017030902"></script>

<style>
.reviewrange {
margin-top: 15px;
margin-left: 10px;
}
</style>

<div class="clearfix parents">
	<div class="mt20 bg-bai clearfix over-hidden" style="height:auto!important; height:800px; min-height:800px;">
    	<div class="">
	        <div class=" pos-rel mt14 pb10 ml20 mr20 bb-hui02 text-center clearfix"> <a href="javascript:void(0);" onclick="back()" class="w78 bd-hui02 display-ib text-center h28 lh26 f14 btn-hui01 pos-tp0"><i class="icon-bg icon-back">返回</i></a>
		          <h2 id="surveytitle" class="f18 hei01 nobold lh30">新增用户</h2>
	        </div>
      		<div class="m0a" style="margin-top:42px;width:480px">
		        <div class="f14 lh30  hei01  mt20 clearfix">
		          <label class="f14 fl hei01 w80 fl lh30 text-right">用户类型<font color="red">*</font>：</label>
				  <input type="radio" name="type" value="2" checked="checked">教师
				  <input type="radio" name="type" value="3">学生
		        </div>
		        <div class="f14 lh30  hei01  mt20 clearfix studentDiv" style="display:none; ">
		          <label class="f14 fl hei01 w80 fl lh30 text-right">用户<font color="red">*</font>：</label>
		        	<select class="student" >
				    	<option value="">--请选择--</option>
				    	<c:forEach var="stu" items="${studentList}">
				    		<option value="${stu.studentKey}" >${stu.name}</option>
				    	</c:forEach>
				    </select>
		        </div>
		        <div class="f14 lh30  hei01  mt20 clearfix teacherDiv">
		          <label class="f14 fl hei01 w80 fl lh30 text-right">用户<font color="red">*</font>：</label>
		        	<select class="teacher" >
				    	<option value="">--请选择--</option>
				    	<c:forEach var="tea" items="${teacherList}">
				    		<option value="${tea.teacherKey}" >${tea.name}</option>
				    	</c:forEach>
				    </select>
		        </div>
		        <div class="f14 lh30  hei01  mt20 clearfix">
		          <label class="f14 fl hei01 w80 fl lh30 text-right">密码<font color="red">*</font>：</label>
		          <input id="password" type="password"  placeholder="请输入密码" class="lh28 h28 w322 pl10 bd-hui02 fl ml10">
		        </div>
		        <div class="f14 lh30  hei01  mt20 clearfix">
		          <label class="f14 fl hei01 w80 fl lh30 text-right">重复密码<font color="red">*</font>：</label>
		          <input id="passwordTwo" type="password"  placeholder="请输入重复密码" class="lh28 h28 w322 pl10 bd-hui02 fl ml10">
		        </div>
		        <div class="f14 lh30  hei01  mt20 ml10 clearfix">
			       	<label class="f14 fl hei01 w80 fl lh30 text-right">&nbsp;</label>
			       	<p id="msg" style="color: red;"></p>
			       	<a onclick="createAcademy()" href="javascript:void(0)" class="f16 bai bg-huang-cur display-ib lh38 h38 bd-huang01 br4 text-center w158">保存</a>
			       	<a onclick="back();" href="javascript:void(0);" class="f16 hui display-ib w158 btn-bg02 bd-hui01 lh38 h38 br4 text-center  ml10">取消</a>
		        </div>
      		</div>
    	</div>
	</div>
</div>
<%-- <jsp:include page="/pages/module/common/view_range_model.jsp"></jsp:include> --%>
<script type="text/javascript" src="${webPath}static/js/app.js?v=2017030902"></script>
<script type="text/javascript" src="${webPath}static/js/My97DatePicker/WdatePicker.js?v=2017030902"></script>
<script type="text/javascript" src="${webPath}js/ztree/js/jquery.ztree.all-3.5.min.js?v=2017030902"></script>
<script>
var webPath="${webPath}";
$(function(){
 
	var surveyId = "${survey.id}";
	//下拉框处理
	$(".studentDiv").find(".student").searchableSelect();
	$(".teacherDiv").find(".teacher").searchableSelect();
	$("input[name=type]:eq(0)").prop("checked",true);
	$("input[name=type]").change(function(){
		var type=$("input[name=type]:checked").val();
		if(type=="3"){
			$("div.studentDiv").show();
			$("div.teacherDiv").hide();
		}else{
			$("div.studentDiv").hide();
			$("div.teacherDiv").show();
		}
	});
	
	init();
});

function init(){ 
	var head="${survey.head}"; 
	var tail="${survey.tail}";
	$("#head").val(head.replaceAll("###","\n")); 
	$("#tail").val(tail.replaceAll("###","\n")); 
	
}
String.prototype.replaceAll = function(s1,s2) { 
    return this.replace(new RegExp(s1,"gm"),s2); 
}
 

 
 //返回
function back(){
	window.location.href=webPath+"systemMng/user/index.do";
}
function getByteLen(val) {
    var len = 0;
    for (var i = 0; i < val.length; i++) {
        if (val[i].match(/[^x00-xff]/ig) != null){ //全角
     	   var reg = /\s/g;
          if(reg.test(val[i])){
         	 len += 1;
          }else{
         	 len += 1;
          }
        }else{
     	   len += 1;
        }
    }
    return len;
}
//保存
function createAcademy(){
	if($.trim($('#password').val())==''){
		$('#msg').html("密码不能为空！");
		return false;
	}
	if($.trim($('#passwordTwo').val())==''){
		$('#msg').html("重复密码不能为空！");
		return false;
	}
	if($.trim($('#password').val())!=$.trim($('#passwordTwo').val())){
		$('#msg').html("两次密码输入不一致！");
		return false;
	}
	var type=$("input[name=type]:checked").val();
	var parameters={};
	parameters['password']=$('#password').val();
	parameters['type']=type;
	if(type=='2'){
		parameters['userName']=$('select.teacher').val();
	}else{
		parameters['userName']=$('select.student').val();
	}
	if($.trim(parameters['userName'])==''){
		$('#msg').html("用户不能为空！");
		return false;
	}
	
	var url = "${webPath}systemMng/user/insertUser.do";
	$.ajax({
		url : url,
		data : parameters,
		type : 'post',
		cache : false,
		dataType : 'json',
		success : function(data) {
			if(data.success!=null&&data.success){
				location.href = "${webPath}systemMng/user/index.do";
			}else{
				alert(data.msg);
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			/* alert("会话已过期,请重新登陆"); */
			/* location.href = "${webPath}"; */
		}
	});
}

 Date.prototype.format =function(format){
		var o = {
			"M+" : this.getMonth()+1, //month
			"d+" : this.getDate(), //day
			"h+" : this.getHours(), //hour
			"m+" : this.getMinutes(), //minute
			"s+" : this.getSeconds(), //second
			"q+" : Math.floor((this.getMonth()+3)/3), //quarter
			"S" : this.getMilliseconds() //millisecond
		}
		if(/(y+)/.test(format)) format=format.replace(RegExp.$1,(this.getFullYear()+"").substr(4- RegExp.$1.length));
		for(var k in o)if(new RegExp("("+ k +")").test(format))
		format = format.replace(RegExp.$1,RegExp.$1.length==1? o[k] :("00"+ o[k]).substr((""+ o[k]).length));
		return format;
	}
</script>