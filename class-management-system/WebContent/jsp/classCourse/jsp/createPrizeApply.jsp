<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link type="text/css" rel="stylesheet" href="${webPath}css/weishequ.css?v=2017030902">
<link type="text/css" rel="stylesheet" href="${webPath}css/common.css?v=2017030902">
<link rel="stylesheet" href="${webPath}js/ztree/css/zTreeStyle.css?v=2017030902" />
<link type="text/css" rel="stylesheet" href="${webPath}css/admin/viewrange.css?v=2017030902"/>
<script type="text/javascript" src="${webPath}static/js/box/viewrange/viewrange.js"></script>  


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
	        	<c:if test="${type == 1 }">
	        		<h2 id="surveytitle" class="f18 hei01 nobold lh30">奖学金申请</h2>
	        	</c:if>
	        	<c:if test="${type == 2 }">
	        		<h2 id="surveytitle" class="f18 hei01 nobold lh30">其他奖金申请</h2>
	        	</c:if>
	        </div>
      		<div class="m0a" style="margin-top:42px;width:480px">
		         <input id="id" type="hidden" value="${prizeApply.id}"/>
		         <input id="type" type="hidden" value="${type}"/>
		        <div class="f14 lh30  hei01  mt20 clearfix">
		          <label class="f14 fl hei01 w80 fl lh30 text-right">申请理由<font color="red">*</font>：</label>
		          <textarea id="applyReason" class="lh28 h56 w322 pl10 bd-hui02 fl ml10">${prizeApply.applyReason}</textarea>
		        </div>
		        
 
		        
		        <div class="form-group form-group-sm mt10">
		        <label class="f14 fl hei01 w80 fl lh30 text-right">奖金等级<font color="red">*</font>：</label>
					<select   id="prizeId" name="" style="margin-left:90px; width:300px;" class="form-control input-medium " >
                        <option value="" selected="selected" style="display: none">请选择奖金等级</option>
                        <option value="" style="width:300px;">请选择奖金等级</option>
                        <c:forEach items="${prizeAwards }" var="prizeAward">
							<option value="${prizeAward.prizeId }"  >${prizeAward.prizeName}</option>
						</c:forEach>
                    </select>
				</div>
		        
		        <div class="form-group form-group-sm mt10">
		        <label class="f14 fl hei01 w80 fl lh30 text-right">审核老师<font color="red">*</font>：</label>
					<select   id="teacherId" name="" style="margin-left:90px; width:300px;" class="form-control input-medium " >
                        <option value="" selected="selected" style="display: none">请选择审核老师</option>
                        <option value="" style="width:300px;">请选择审核老师</option>
                        <c:forEach items="${teachers }" var="teacher">
							<option value="${teacher.teacherKey }"  >${teacher.name}</option>
						</c:forEach>
                    </select>
				</div>
				 
 
		        <div class="f14 lh30  hei01  mt20 ml10 clearfix">
			       	<label class="f14 fl hei01 w80 fl lh30 text-right">&nbsp;</label>
			       	<p id="msg" style="color: red;"></p>
			       	<a onclick="createPrizeApply()" href="javascript:void(0)" class="f16 bai bg-huang-cur display-ib lh38 h38 bd-huang01 br4 text-center w158">保存</a>
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
 
 
String.prototype.replaceAll = function(s1,s2) { 
    return this.replace(new RegExp(s1,"gm"),s2); 
}
 
function back(){
	window.location.href=webPath+"prize/index.do?type="+${type};
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
function createPrizeApply(){
	
	 
	
	if($.trim($('#applyReason').val())=="请输入申请理由"){
		$('#msg').val("");
		return false;
	}
	if($.trim($('#applyReason').val()).length>200){
		$('#msg').html("申请理由不能超过200个字符！");
		return false;
	}
	if(getByteLen($.trim($('#applyReason').val()))<1){
		$('#msg').html("申请理由不能少于1个字！");
		return false;
	}
	 
	
	if($.trim($('#prizeId').val())==''){
		$('#msg').html("请选择奖金等级！");
		return false;
	}
	
	if($.trim($('#teacherId').val())==''){
		$('#msg').html("请选择审核老师！");
		return false;
	}
	 
	var parameters={};
	parameters['activityKey']=$('#id').val();
	parameters['applyReason']=$.trim($('#applyReason').val().replace(/\n/g,'###'));
	parameters['teacherId']=$.trim($('#teacherId').val())
	parameters['prizeId']=$.trim($('#prizeId').val());
	parameters['type']= $("#type").val();
	
	var url = "${webPath}prize/insertPrizeApply.do";
	if ( parameters['activityKey'] !='') {
		url = "${webPath}prize/toUpdatePrizeApply.do";
	}
 
	$.ajax({
		url : url,
		data : parameters,
		type : 'post',
		cache : false,
		dataType : 'json',
		success : function(data) {
			if(data.success!=null&&data.success){
				location.href = "${webPath}prize/index.do?type="+$("#type").val();
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