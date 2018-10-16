<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link type="text/css" rel="stylesheet" href="${webPath}css/weishequ.css?v=2017030902">
<link type="text/css" rel="stylesheet" href="${webPath}css/common.css?v=2017030902">
<link rel="stylesheet" href="${webPath}js/ztree/css/zTreeStyle.css?v=2017030902" />
<link type="text/css" rel="stylesheet" href="${webPath}css/admin/viewrange.css?v=2017030902"/>

<input type="hidden" id="hidden_type" value="${type}">
<div class="clearfix parents">
	<div class="mt20 bg-bai clearfix over-hidden" style="height:auto!important; height:800px; min-height:800px;margin-top: 0px;">
    	<div class="">
	        <div class=" pos-rel mt14 pb10 ml20 mr20 bb-hui02 text-center clearfix" style="padding-bottom: 3px;height:43px;"> 
	        	<a href="javascript:void(0);" onclick="back()" class="w78 bd-hui02 display-ib text-center h28 lh26 f14 btn-hui01 pos-tp0"><i class="icon-bg icon-back">返回</i></a>
	        	<c:if test="${type=='1'}">
		        	<a onclick="addClassCourseBtn(${clsssPO.classKey})" href="javascript:void(0)" class="f16 bai bg-huang-cur display-ib lh38 h38 bd-huang01 br4 text-center w158">设置</a>
	        	</c:if>
	        </div>
      		<div class="m0a" style="margin-top:42px;">
		        
		        <div style="width:100%;overflow: auto;" id="psch_scheduletabStript_classsSchedule_height">
					<div style="width:640px;margin:0px auto;">
						<div style="width:100%;height:30px;line-height: 30px;text-align: center;">
							<span style="font-size: 15pt;" class="nh-class-title">${clsssPO.className}课程表</span>
						</div>
						<table class="k-wt-table" id="psch_scheduletabStript_classsSchedule_table">
							<tr>
								<td class="k-wt-content" style="width:80px;text-align: center;"></td>
								<td class="k-wt-content" style="width:80px;text-align: center;">星期一</td>
								<td class="k-wt-content" style="width:80px;text-align: center;">星期二</td>
								<td class="k-wt-content" style="width:80px;text-align: center;">星期三</td>
								<td class="k-wt-content" style="width:80px;text-align: center;">星期四</td>
								<td class="k-wt-content" style="width:80px;text-align: center;">星期五</td>
								<td class="k-wt-content" style="width:80px;text-align: center;">星期六</td>
								<td class="k-wt-content" style="width:80px;text-align: center;">星期天</td>
							</tr>
							<c:forEach var="row" begin="0" end="8" varStatus="seq" items="${scheduleList}">
								<tr>
									<td class="k-wt-content" data-nh-weekSeq="0" data-nh-orderSeq="${seq.index+1}" style="width:80px;text-align: center;">第${seq.index+1}节课</td>
									<c:forEach begin="1" end="7" varStatus="col">
										<td class="k-wt-content courseTd" style="height:65px;text-align: center;" data-nh-weekSeq="${col.index}" data-nh-orderSeq="${seq.index+1}" style="width:80px;text-align: center;">
											${row[fn:trim(col.index)].courseName}<br/>
											${row[fn:trim(col.index)].teacherName}<br/>
											<c:if test="${not empty row[fn:trim(col.index)].startWeekSeq}">第${row[fn:trim(col.index)].startWeekSeq}-${row[fn:trim(col.index)].endWeekSeq}周</c:if>
										</td>
									</c:forEach>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
		        
      		</div>
    	</div>
	</div>
</div>



<script>
//表示是编辑模式
if($("#hidden_type").val()=='1'){
	$(".courseTd").click(function(){
		$(".selected").removeClass("selected");
		$(this).addClass("selected");
	});
}
//返回
function back(){
	if($("#hidden_type").val()=='3'){
		window.location.href="/class-management-system/systemMng/user/toDesktop.do";
	}else{
		window.location.href="/class-management-system/studyMng/schedule/index.do";		
	}
	
}
function addClassCourseBtn(classKey){
	var $obj=$(".selected");
	if($obj.length<0){
		alert("请选择要设置的节次！");
		return;
	}
	var weekSeq=$obj.attr("data-nh-weekSeq");
	var orderSeq=$obj.attr("data-nh-orderSeq");
	window.location.href="/class-management-system/studyMng/schedule/addClassCourse.do?classKey="+classKey+"&weekSeq="+weekSeq+"&orderSeq="+orderSeq;
}

</script>
<style>
.selected{
	background: grey !important;
    color: white;
}
.k-wt-table {
	border-style:solid;
	border-color:#CCCCCC;
	border-width:1px;
	border-collapse:collapse;
}
.k-wt-table .k-wt-header{
	background:#DAECF4;
	border-style:solid;
	border-color:#CCCCCC;
	border-width:0px 1px 1px 0px;
    padding:0.5em 0.6em 0.4em;
    text-align:left;
}
.k-wt-table .k-wt-title{
	background:#fff;
	border-style:solid;
	border-color:#CCCCCC;
	border-width:1px;
    padding:0.5em 0.6em 0.4em;
    text-align:right;
}
.k-wt-table .k-wt-content{
	background:#fff;
	border-style:solid;
	border-color:#CCCCCC;
	border-width:1px;
    padding:0.5em 0.6em 0.4em;
    text-align:left;
    cursor: pointer;
}
.k-wt-table .k-wt-footer {
	border-style: solid;
	border-color: #CCCCCC;
	border-width: 0px 1px 1px 0px;
    padding: 0.5em 0.6em 0.4em;
    text-align: center;
}
</style>