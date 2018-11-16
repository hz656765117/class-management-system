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
	        <div class=" pos-rel mt14 pb10 ml20 mr20 bb-hui02 text-center clearfix">
<!-- 		          <h2 id="surveytitle" class="f18 hei01 nobold lh30">选择班级</h2> -->
	        </div>
      		<div class="m0a" style="margin-top:42px;width:480px;padding-left:30px;">
		        <div class="f14 lh30  hei01  mt20 clearfix academyKeyDiv">
		          <label class="f14 fl hei01 w80 fl lh30 text-right">学院<font color="red">*</font>：</label>
		        	<select class="academyKey" >
				    	<option value="">--请选择--</option>
				    	<c:forEach var="academy" items="${academyList}">
				    		<option value="${academy.academyKey}" <c:if test="${academy.academyKey==student.majorPO.academyKey}">selected="selected"</c:if>>${academy.academyName}</option>
				    	</c:forEach>
				    </select>
		        
		        </div>
		        <div class="f14 lh30  hei01  mt20 clearfix majorKeyDiv">
		          <label class="f14 fl hei01 w80 fl lh30 text-right">专业<font color="red">*</font>：</label>
				    <select class="majorKey">
				    	<option value="">--请选择--</option>
				    </select>
		        </div>
		         <div class="f14 lh30  hei01  mt20 clearfix classKeyDiv">
		          <label class="f14 fl hei01 w80 fl lh30 text-right">班级<font color="red">*</font>：</label>
				    <select class="classKey">
				    	<option value="">--请选择--</option>
				    </select>
		        </div>
		        <div class="f14 lh30  hei01  mt20 ml10 clearfix">
<!-- 			       	<label class="f14 fl hei01 w80 fl lh30 text-right">&nbsp;</label> -->
			       	<p id="msg" style="color: red;"></p>
			       	<a onclick="createAcademy(2)" href="javascript:void(0)" class="f16 bai bg-huang-cur display-ib lh38 h38 bd-huang01 br4 text-center w158">查看</a>
		       		<a onclick="createAcademy(1)" href="javascript:void(0)" class="f16 bai bg-huang-cur display-ib lh38 h38 bd-huang01 br4 text-center w158">编辑</a>
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
});
//加载专业下拉框信息
function loadMajorInfo(academyKey,majorKey){
	$.ajax({
		url : "${webPath}basicDataMng/studentMng/majorList.do",
		data : {"academyKey":academyKey},
		type : 'post',
		dataType : 'json',
		success : function(data) {
			var msg=data.obj;
			$(".majorKeyDiv").find("select.majorKey").html("<option value=''>--请选择--</option>");
			$(".classKeyDiv").find("select.classKey").html("<option value=''>--请选择--</option>");
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
			//加载班级下拉框
			if($(".classKeyDiv").find("select.classKey").next().hasClass("searchable-select")){
				$(".classKeyDiv").find("select.classKey").next().remove();
				$(".classKeyDiv").find(".classKey").searchableSelect();
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
function createAcademy(type){
	if($.trim($('select.classKey').val())==''){
		$('#msg').html("班级不能为空！");
		return false;
	}
	location.href = "${webPath}/studyMng/schedule/setClassCourse.do?classKey="+$('select.classKey').val()+"&type="+type;
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