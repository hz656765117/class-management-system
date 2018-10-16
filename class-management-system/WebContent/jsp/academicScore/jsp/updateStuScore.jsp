<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link type="text/css" rel="stylesheet" href="${webPath}css/weishequ.css?v=2017030902">
<link type="text/css" rel="stylesheet" href="${webPath}css/common.css?v=2017030902">
<link rel="stylesheet" href="${webPath}js/ztree/css/zTreeStyle.css?v=2017030902" />
<link type="text/css" rel="stylesheet" href="${webPath}css/admin/viewrange.css?v=2017030902"/>
<script type="text/javascript" src="${webPath}static/js/box/viewrange/viewrange.js"></script>  
<link type="text/css" rel="stylesheet" href="${webPath}js/select/jquery.searchableSelect.css?v=2017030902"/>
<script type="text/javascript" src="${webPath}js/select/jquery.searchableSelect.js?v=2017030902"></script>

<style>
.reviewrange {
margin-top: 15px;
margin-left: 10px;
}

.searchable-select-dropdown {
z-index:9999;
}
</style>

<div class="clearfix parents">
	<div class="mt20 bg-bai clearfix over-hidden" style="height:auto!important; height:800px; min-height:800px;">
<%-- 		<div class="cont-l01 fl duiqi bg-hui05">
	       <ul id="nav-l" class="f16">
		       <jsp:include page="/pages/layouts/leftMenu.jsp" flush="true">
	               <jsp:param name="cur" value="vote" />
	           </jsp:include>
	       </ul>
		</div> --%>
    	<div class="">
	        <div class=" pos-rel mt14 pb10 ml20 mr20 bb-hui02 text-center clearfix"> <a href="javascript:void(0);" onclick="back()" class="w78 bd-hui02 display-ib text-center h28 lh26 f14 btn-hui01 pos-tp0"><i class="icon-bg icon-back">返回</i></a>
	        	<h2 id="surveytitle" class="f18 hei01 nobold lh30">设置非学业成绩</h2>
	        </div>
      		<div class="m0a" style="margin-top:42px;width:480px">
		     	
		     	
		     	
		        
		        <!-- <div class="mb15 mt10 f14" id="viewRange">
					<label class="f14 fl hei01 w80 fl lh30 text-right">学生姓名<font color="red">*</font>：</label>
					<div style="margin: 0 68px 0 88px">
						<input id="select" type="text" placeholder="在此输入部门名称和人名" style="width:250px">
					</div>
				</div>  -->
				
				<%-- <div class="f14 lh30  hei01  mt20 clearfix  yearDiv"  >
		          <label class="f14 fl hei01 w80 fl lh30 text-right">学年<font color="red">*</font>：</label>
		        	<select class="year"   >
				    	<option value="">--请选择--</option>
				    	 <c:forEach var="year" items="${years}">
				    		<option value="${year.yearTermKey}" >${year.yearTermName}</option>
				    	</c:forEach>
				    </select>
		        </div>
		        
		        
		        <div class="f14 lh30  hei01  mt20 clearfix courseDiv"  >
		          <label class="f14 fl hei01 w80 fl lh30 text-right">课程<font color="red">*</font>：</label>
		        	<select class="course"   >
				    	<option value="">--请选择--</option>
				    	<c:forEach var="course" items="${courses}">
				    		<option value="${course.id}" >${course.name}</option>
				    	</c:forEach>
				    </select>
		        </div> --%>
		        <input value="${stuScore.id }" id="id" type="hidden">
		        <div class="f14 lh30  hei01  mt20 clearfix">
		          <label class="f14 fl hei01 w100 fl lh30 text-right mr15">姓名：</label>
		          <div  >${stuScore.studentName }</div>
		        </div>
		        <div class="f14 lh30  hei01  mt20 clearfix">
		          <label class="f14 fl hei01 w100 fl lh30 text-right mr15">班级：</label>
		          <div  >${stuScore.className }</div>
		        </div>
		        <div class="f14 lh30  hei01  mt20 clearfix">
		          <label class="f14 fl hei01 w100 fl lh30 text-right mr15">学期：</label>
		          <div  >${stuScore.yearName }</div>
		        </div>
		        <div class="f14 lh30  hei01  mt20 clearfix">
		          <label class="f14 fl hei01 w100 fl lh30 text-right mr15">学业成绩：</label>
		          <div  >${stuScore.academicScore }</div>
		        </div>
		        <div class="f14 lh30  hei01  mt20 clearfix">
		          <label class="f14 fl hei01 w100 fl lh30 text-right mr15">体育成绩：</label>
		          <div  >${stuScore.sportsScore }</div>
		        </div>
				<div class="f14 lh30  hei01  mt20 clearfix">
		          <label class="f14 fl hei01 w100 fl lh30 text-right">非学业成绩<font color="red">*</font>：</label>
		          <input id="score" type="text" value="${stuScore.notAcademicScore}" placeholder="请输入分数" class="lh28 h28 w322 pl10 bd-hui02 fl ml10">
		        </div>
		        
 
		   		
		   		
		        
		        
		        
		        
		       
		        
		     
		        <div class="f14 lh30  hei01  mt20 ml10 clearfix">
			       	<label class="f14 fl hei01 w80 fl lh30 text-right">&nbsp;</label>
			       	<p id="msg" style="color: red;"></p>
			       	<a onclick="createStudentScore()" href="javascript:void(0)" class="f16 bai bg-huang-cur display-ib lh38 h38 bd-huang01 br4 text-center w158">保存</a>
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
	
	$(".courseDiv").find(".course").searchableSelect();
	$(".yearDiv").find(".year").searchableSelect();
	$("input[name=type]:eq(0)").prop("checked",true);
	
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
 


 $(function(){
	 $('#select').viewRange({
		 noSearch:false,
			appId: 'TPDY',
			tagEnable : false,
			departEnable: false,
			personEnable: true,
			personSelect : 'radio',
			initial: function(el, fn){
	    	 	if('${info.id}'){
	           	 initVisiable("vote",'${info.id}',el,fn);
	    		} 
	   		 }
		});
  });
function back(){
	window.location.href=webPath+"academicScore/index.do";
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
function createStudentScore(){
	
	var score = $("#score").val();
	 
	var parameters={};
	parameters['id']=$("#id").val();
	parameters['notAScore']=score;
	
	if(score>30){
		$('#msg').html("非学业成绩不能高于30分！");
		return false;
	}
	
	var url = "${webPath}academicScore/updateNotAcademicScore.do";
 
	$.ajax({
		url : url,
		data : parameters,
		type : 'post',
		cache : false,
		dataType : 'json',
		success : function(data) {
			if(data.success!=null&&data.success){
				location.href = "${webPath}academicScore/index.do";
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