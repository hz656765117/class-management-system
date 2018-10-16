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
	        	<h2 id="surveytitle" class="f18 hei01 nobold lh30">新建班委</h2>
	        </div>
      		<div class="m0a" style="margin-top:42px;width:480px">
		     
		        
		        <div class="mb15 mt10 f14" id="viewRange">
					<label class="f14 fl hei01 w80 fl lh30 text-right">学生姓名<font color="red">*</font>：</label>
					<div style="margin: 0 68px 0 88px">
						<input id="select" type="text" placeholder="在此输入部门名称和人名" style="width:250px">
					</div>
				</div> 
		        
<!-- 		        <div class="f14 lh30  hei01  mt20 clearfix">
		       		 <label class="f14 fl hei01 w80 fl lh30 text-right">班委类别<font color="red">*</font>：</label>
		       		<select   id="teacherId" name="" style="margin-left:90px; width:300px;" class="form-control input-medium " >
                        <option value="" style="width:600px;">请选择审核老师</option>
                        <option value="" style="width:300px;">请选择审核老师</option>
                        <option value="" style="width:300px;">请选择审核老师</option>
                        <option value="" style="width:300px;">请选择审核老师</option>
                         
                    </select>
		       
		        </div> -->
		   		
		   		
		   		<div class="f14 lh30  hei01  mt20 clearfix committeeDiv"  >
		          <label class="f14 fl hei01 w80 fl lh30 text-right">班委类型<font color="red">*</font>：</label>
		        	<select class="committee"   >
				    	<option value="">--请选择--</option>
				    	<option value="1">班长</option>
				    	<option value="2">学习委员</option>
				    	<option value="3">生活委员</option>
				    	<option value="4">体育委员</option>
				    </select>
		        </div>
		        
		        
		     
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
	
	$(".committeeDiv").find(".committee").searchableSelect();
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
	window.location.href=webPath+"classCommittee/index.do";
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
	
	var personArr = getSelectedItem('viewRange').persons;
	if (  personArr == null || personArr.length == 0  || (personArr[0] == -9)  ) {
		$('#msg').html("学生不能为空！");
		return;
	}else if ( personArr.length > 1){
		$('#msg').html("只能选择一学生！");
		return;
	} 
	
	var committee = $('select.committee').val();
	if (committee == null || committee == '' ) {
		$('#msg').html("请选择班委！");
		return;
	}
	 
	var parameters={};
	//parameters['activityKey']=$('#id').val();
	parameters['banweiCode']=committee;
	parameters['studentKey']=personArr[0];
 
	var url = "${webPath}classCommittee/insertClassCommittee.do";
 
 
	$.ajax({
		url : url,
		data : parameters,
		type : 'post',
		cache : false,
		dataType : 'json',
		success : function(data) {
			if(data.success!=null&&data.success){
				location.href = "${webPath}classCommittee/index.do";
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