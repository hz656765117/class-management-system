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
	        	<h2 id="surveytitle" class="f18 hei01 nobold lh30">新建活动</h2>
	        </div>
      		<div class="m0a" style="margin-top:42px;width:480px">
		        <div class="f14 lh30  hei01  mt20 clearfix">
		          <input id="id" type="hidden" value="${activity.activityKey}"/>
		          <label class="f14 fl hei01 w80 fl lh30 text-right">活动名称<font color="red">*</font>：</label>
		          <input id="title" type="text" value="${activity.title}" placeholder="请输入活动名称" class="lh28 h28 w322 pl10 bd-hui02 fl ml10">
		        </div>
	<%-- 	        <div class="f14 lh30  hei01  mt20 clearfix">
		          <label class="f14 fl hei01 w80 fl lh30 text-right">活动描述：</label>
		          <select id="classify" class="lh30 h30  pt4 pb4 bd-hui02 fl ml10" style="width:334px">
		           	<c:forEach items="${typeListTK }" var="types">
					<option value="${types.type }" <c:if test="${createType==types.type}">selected</c:if>>${types.name}</option>
					</c:forEach>
		          </select>
		        </div> --%>
		        
		        <div class="f14 lh30  hei01  mt20 clearfix">
		          <label class="f14 fl hei01 w80 fl lh30 text-right">活动描述：</label>
		          <textarea id="comments" class="lh28 h56 w322 pl10 bd-hui02 fl ml10">${activity.comments}</textarea>
		        </div>
		        
		        <div class="f14 lh30  hei01  mt20  clearfix courseDiv"  >
		          <label class="f14 fl hei01 w80 fl mr10 lh30 text-right">班级<font color="red">*</font>：</label>
		        	<select class="course"   >
				    	<option value="">--请选择--</option>
				    	<option value="0"  <c:if test="${activity.classId==0}">selected="selected"</c:if>>全部班级</option>
				    	<c:forEach var="class" items="${classes}">
				    		<option value="${class.classKey}" <c:if test="${activity.classId==class.classKey}">selected="selected"</c:if> >${class.className}</option>
				    	</c:forEach>
				    </select>
		        </div>
		        
		        <!-- <div class="mb15 mt10 f14" id="viewRange">
					<label class="f14 fl hei01 w80 fl lh30 text-right">活动成员：</label>
					<div style="margin: 0 68px 0 88px">
						<input id="select" type="text" placeholder="在此输入部门名称和人名" style="width:250px">
					</div>
				</div>  -->
		        
		        <div class="f14 lh30  hei01  mt20 clearfix">
		          <label class="f14 fl hei01 w80 fl lh30 text-right">活动时间<font color="red">*</font>：</label>
		          <%-- <input id="deadline" value="${survey.deadline}" class="lh28 h28 w322 pl10 bd-hui02 fl ml10 Wdate" type="text" onclick="WdatePicker()" readonly="readonly" value=""/> --%>
		          <input id="activityTime" value='<fmt:formatDate value="${activity.activityTime}" pattern="yyyy-MM-dd HH:mm"/>' class="lh28 h28 w322 pl10 bd-hui02 fl ml10 Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'%y-%M-%d %H:%m'})" readonly="readonly"/>
		        </div>
		         <!-- <div class="mb15 mt10 f14" id="viewRange">
						<label class="f14 fl hei01 w80 fl lh30 text-right">可见范围：</label>
						<div style="margin: 0 68px 0 88px">
							<input id="select" type="text" placeholder="在此输入部门名称和人名" style="width:250px">
						</div>
					</div> -->
		        <%-- <jsp:include page="/pages/module/common/view_range.jsp"></jsp:include> --%>
			   <%--  <div class="f14 lh30  hei01  mt20 clearfix">
		          <label class="f14 fl hei01 w80 fl lh30 text-right">首语：</label>
		          <textarea id="head" class="lh28 h56 w322 pl10 bd-hui02 fl ml10">${survey.head}</textarea>
		        </div>
		        <div class="f14 lh30  hei01  mt20 clearfix">
		          <label class="f14 fl hei01 w80 fl lh30 text-right">尾语：</label>
		          <textarea id="tail" class="lh28 h56 w322 pl10 bd-hui02 fl ml10">${survey.tail}</textarea>
		        </div> --%>
		        
		     
		        <div class="f14 lh30  hei01  mt20 ml10 clearfix">
			       	<label class="f14 fl hei01 w80 fl lh30 text-right">&nbsp;</label>
			       	<p id="msg" style="color: red;"></p>
			       	<a onclick="createActivity()" href="javascript:void(0)" class="f16 bai bg-huang-cur display-ib lh38 h38 bd-huang01 br4 text-center w158">保存</a>
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
			tagSelect : 'radio',
			initial: function(el, fn){
	    	 	if('${info.id}'){
	           	 initVisiable("vote",'${info.id}',el,fn);
	    		} 
	   		 }
		});
  });
function back(){
	window.location.href=webPath+"activity/index.do";
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
function createActivity(){
	if($.trim($('#title').val())=='' ||$.trim($('#title').val())=="请输入活动名称"){
		$('#msg').html("活动名称不能为空！");
		return false;
	}
	if($.trim($('#activityTime').val())==''){
		$('#msg').html("活动时间时间不能为空！");
		return false;
	}
	if(getByteLen($.trim($('#title').val()))>64){
		$('#msg').html("活动名称不能超过64个字！");
		return false;
	}
	if(getByteLen($.trim($('#title').val()))<1){
		$('#msg').html("活动名称不能少于1个字！");
		return false;
	}
	
	if($.trim($('#comments').val())=="请输入活动内容"){
		$('#comments').val("");
	}
	if($.trim($('#comments').val()).length>4000){
		$('#msg').html("活动内容超过4000个字符！");
		return false;
	}
	if(getByteLen($.trim($('#comments').val()))<1){
		$('#msg').html("活动内容不能少于1个字！");
		return false;
	}
	
	/* var personArr = getSelectedItem('viewRange').persons; */
	 var classId = $('select.course').val();
	if (classId == null || classId == '' ) {
		$('#msg').html("请选择班级！");
		return;
	}
	 
	var parameters={};
	parameters['activityKey']=$('#id').val();
	parameters['title']=$('#title').val();
	parameters['activityTime']=$('#activityTime').val();
	parameters['comments']=$('#comments').val().replace(/\n/g,'###');
	/* parameters['persons']= personArr.join(','); */
	parameters['classId']= classId;
	var url = "${webPath}activity/insertActivity.do";
	if ( parameters['activityKey'] !='') {
		url = "${webPath}activity/updateActivity.do";
	}
 
	$.ajax({
		url : url,
		data : parameters,
		type : 'post',
		cache : false,
		dataType : 'json',
		success : function(data) {
			if(data.success!=null&&data.success){
				location.href = "${webPath}activity/index.do";
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