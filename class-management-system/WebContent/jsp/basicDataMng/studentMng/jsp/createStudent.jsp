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
<input type="hidden" id="hidden_initMjorKey" value="${student.majorKey}">
<input type="hidden" id="hidden_initClassKey" value="${student.classKey}">
<div class="clearfix parents">
	<div class="mt20 bg-bai clearfix over-hidden" style="height:auto!important; height:800px; min-height:800px;">
    	<div class="">
	        <div class=" pos-rel mt14 pb10 ml20 mr20 bb-hui02 text-center clearfix"> <a href="javascript:void(0);" onclick="back()" class="w78 bd-hui02 display-ib text-center h28 lh26 f14 btn-hui01 pos-tp0"><i class="icon-bg icon-back">返回</i></a>
	        	<c:if test="${not empty student.studentKey}">
		          	<h2 id="surveytitle" class="f18 hei01 nobold lh30">修改学生信息</h2>
		        </c:if>
	        	<c:if test="${empty student.studentKey}">
		          	<h2 id="surveytitle" class="f18 hei01 nobold lh30">新增学生信息</h2>
		        </c:if>
	        </div>
      		<div class="m0a" style="margin-top:42px;width:480px">
		        <div class="f14 lh30  hei01  mt20 clearfix">
		          <label class="f14 fl hei01 w80 fl lh30 text-right">学号<c:if test="${empty student.studentKey}"><font color="red">*</font></c:if>：</label>
		          <c:if test="${not empty student.studentKey}">
		          	<input id="type" type="hidden" value="update"/>
		          	<input id="studentKey" type="hidden" value="${student.studentKey}" >
		          	${student.studentKey}
		          </c:if>
		           <c:if test="${empty student.studentKey}">
		          	<input id="type" type="hidden" value="0"/>
		          	<input id="studentKey" type="text" value="${student.studentKey}" placeholder="请输入学号" class="lh28 h28 w322 pl10 bd-hui02 fl ml10">
		          </c:if>
		        </div>
		        <div class="f14 lh30  hei01  mt20 clearfix">
		          <label class="f14 fl hei01 w80 fl lh30 text-right">学生姓名<font color="red">*</font>：</label>
		          <input id="name" type="text" value="${student.name}" placeholder="请输入学生姓名" class="lh28 h28 w322 pl10 bd-hui02 fl ml10">
		        </div>
		         <div class="f14 lh30  hei01  mt20 clearfix">
		          <label class="f14 fl hei01 w80 fl lh30 text-right">性别<font color="red">*</font>：</label>
		          <input type="radio" value="1" name="sex" <c:if test="${student.sex!='2'}">checked="checked"</c:if>>男
		          <input type="radio" value="2" name="sex" <c:if test="${student.sex=='2'}">checked="checked"</c:if>>女
		        </div>
		        <div class="f14 lh30  hei01  mt20 clearfix">
		          <label class="f14 fl hei01 w80 fl lh30 text-right">身份证号：</label>
		          <input id="idcardNumber" type="text" value="${student.idcardNumber}" placeholder="请输入学生身份证号" class="lh28 h28 w322 pl10 bd-hui02 fl ml10">
		        </div>
		        <div class="f14 lh30  hei01  mt20 clearfix academyKeyDiv">
		          <label class="f14 fl hei01 w80 fl lh30 text-right">所属学院<font color="red">*</font>：</label>
		        	<select class="academyKey" >
				    	<option value="">--请选择--</option>
				    	<c:forEach var="academy" items="${academyList}">
				    		<option value="${academy.academyKey}" <c:if test="${academy.academyKey==student.academyKey}">selected="selected"</c:if>>${academy.academyName}</option>
				    	</c:forEach>
				    </select>
		        
		        </div>
		        <div class="f14 lh30  hei01  mt20 clearfix majorKeyDiv">
		          <label class="f14 fl hei01 w80 fl lh30 text-right">所属专业<font color="red">*</font>：</label>
				    <select class="majorKey">
				    	<option value="">--请选择--</option>
				    </select>
		        </div>
		         <div class="f14 lh30  hei01  mt20 clearfix classKeyDiv">
		          <label class="f14 fl hei01 w80 fl lh30 text-right">所属班级<font color="red">*</font>：</label>
				    <select class="classKey">
				    	<option value="">--请选择--</option>
				    </select>
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
<style>
.searchable-select-dropdown{
	z-index:9999;
}
</style>
<script>
var webPath="${webPath}";
$(function(){
 
	var surveyId = "${survey.id}";
	init();
	//下拉框处理
	$(".academyKeyDiv").find(".academyKey").searchableSelect();
	$(".majorKeyDiv").find(".majorKey").searchableSelect();
	$(".classKeyDiv").find(".classKey").searchableSelect();
	$(".academyKeyDiv").find("select.academyKey").next().find(".searchable-select-item").bind("click",function(e){
		loadMajorInfo($(this).attr("data-value"));
	});
	//初始化信息
	if($('select.academyKey').val()){
		loadMajorInfo($('select.academyKey').val(),$("#hidden_initMjorKey").val(),$("#hidden_initClassKey").val());
		loadClassInfo($('#hidden_initMjorKey').val(),$("#hidden_initClassKey").val());
	}
});
//加载专业下拉框信息
function loadMajorInfo(academyKey,majorKey,classKey){
	$.ajax({
		url : "${webPath}basicDataMng/studentMng/majorList.do",
		data : {"academyKey":academyKey},
		type : 'post',
		dataType : 'json',
		success : function(data) {
			var msg=data.obj;
			$(".majorKeyDiv").find("select.majorKey").html("<option value=''>--请选择--</option>");
			if(!classKey){//如果班级主键存在初始值
				$(".classKeyDiv").find("select.classKey").html("<option value=''>--请选择--</option>");
			}
			for (var i = 0; i < msg.length; i++) {
				var selected="";
				if(majorKey && msg[i].majorKey==majorKey){
					selected="selected='selected'";
				}
				$(".majorKeyDiv").find("select.majorKey").append("<option value='"+msg[i].majorKey+"' "+selected+">"+msg[i].majorName+"</option>");
			}
			//加载专业下拉框
			if($(".majorKeyDiv").find("select.majorKey").next().hasClass("searchable-select")){
				$(".majorKeyDiv").find("select.majorKey").next().remove();
				$(".majorKeyDiv").find(".majorKey").searchableSelect();
			}
			if(!classKey){//如果班级主键存在初始值
				//加载班级下拉框
				if($(".classKeyDiv").find("select.classKey").next().hasClass("searchable-select")){
					$(".classKeyDiv").find("select.classKey").next().remove();
					$(".classKeyDiv").find(".classKey").searchableSelect();
				}
			}
			$(".majorKeyDiv").find("select.majorKey").next().find(".searchable-select-item").bind("click",function(e){
				loadClassInfo($(this).attr("data-value"));
			});
		}
	});
}

//加载专业下拉框信息
function loadClassInfo(majorKey,classKey){
	$.ajax({
		url : "${webPath}basicDataMng/studentMng/classList.do",
		data : {"majorKey":majorKey},
		type : 'post',
		dataType : 'json',
		success : function(data) {
			var msg=data.obj;
			$(".classKeyDiv").find("select.classKey").html("<option value=''>--请选择--</option>");
			for (var i = 0; i < msg.length; i++) {
				var selected="";
				if(classKey && msg[i].classKey==classKey){
					selected="selected='selected'";
				}
				$(".classKeyDiv").find("select.classKey").append("<option value='"+msg[i].classKey+"' "+selected+">"+msg[i].className+"</option>");
			}
			//加载班级下拉框
			if($(".classKeyDiv").find("select.classKey").next().hasClass("searchable-select")){
				$(".classKeyDiv").find("select.classKey").next().remove();
				$(".classKeyDiv").find(".classKey").searchableSelect();
			}
		}
	});
}

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
	window.location.href=webPath+"basicDataMng/studentMng/index.do";
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
	if($.trim($('#studentKey').val())==''){
		$('#msg').html("学号不能为空！");
		return false;
	}
	if($.trim($('#name').val())==''){
		$('#msg').html("学生姓名不能为空！");
		return false;
	}
	if($.trim($('select.classKey').val())==''){
		$('#msg').html("所属班级不能为空！");
		return false;
	}
	 
	var parameters={};
	parameters['studentKey']=$('#studentKey').val();
	parameters['name']=$('#name').val();
	parameters['sex']=$("input[name=sex]:checked").val();
	parameters['idcardNumber']=$('#idcardNumber').val();
	parameters['classKey']=$('select.classKey').val();
	
	var url = "${webPath}basicDataMng/studentMng/insertStudent.do";
	if ( $('#type').val() =='update') {
		url = "${webPath}basicDataMng/studentMng/updateStudent.do";
	}
 
	$.ajax({
		url : url,
		data : parameters,
		type : 'post',
		cache : false,
		dataType : 'json',
		success : function(data) {
			if(data.success!=null&&data.success){
				location.href = "${webPath}basicDataMng/studentMng/index.do";
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