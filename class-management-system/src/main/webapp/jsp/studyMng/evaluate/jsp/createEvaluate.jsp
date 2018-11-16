<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link type="text/css" rel="stylesheet" href="${webPath}css/weishequ.css?v=2017030902">
<link type="text/css" rel="stylesheet" href="${webPath}css/common.css?v=2017030902">
<link rel="stylesheet" href="${webPath}js/ztree/css/zTreeStyle.css?v=2017030902" />
<link type="text/css" rel="stylesheet" href="${webPath}css/admin/viewrange.css?v=2017030902"/>

<input type="hidden" id="evaluateKey" value="${evaluatePO.evaluateKey}">
<input type="hidden" id="yearTermKey" value="${evaluatePO.yearTermKey}">
<table class="k-wt-table" style="width:99%;">
	<tr>
		<td class="k-wt-title">主题：</td>
		<td class="k-wt-content"><input id="title" type="text" value="${evaluatePO.title}" style="width:300px;"   class="lh28 h28 w322 pl10 bd-hui02 fl ml10"></td>
	</tr>
	<tr>
		<td class="k-wt-title">发布状态：</td>
		<td class="k-wt-content"><input type="checkbox" id="status" value="1" <c:if test="${evaluatePO.status==1}">checked=checked</c:if>>已发布(<font color="red">注：发布之后将不能再进行修改，请慎重操作</font>)</td>
	</tr>
	<tr>
		<th class="k-wt-header" colspan="2"style="padding-top: 2px;padding-bottom: 2px;">评价项
			<a href="javascript:void(0);" onclick="addOptionFunc()" class="w78 bd-hui02 display-ib text-center h28 lh26 f14 btn-hui01">新增</a>
			<a href="javascript:void(0);" onclick="save()" style="float: right;margin-right: 30px;" class="w78 bd-hui02 display-ib text-center h28 lh26 f14 btn-hui01">保存</a>
		</th>
	</tr>
</table>
	<table class="k-wt-table optionTable" style="width:99%;">
		<c:if test="${fn:length(list)==0}">
			<tr>
				<td class="k-wt-content seq" style="width:40px;">1</td>
				<td class="k-wt-content"><input type="text" value="" style="width:80%;"   class="lh28 h28 w322 pl10 bd-hui02 fl ml10 optionTitle"></td>
				<td class="k-wt-content" style="width:40px;">
					<a class="ico-del icon-caozuo f0 fr mr10" href="javascript:void(0);" onclick="deleteFunc(this);" title="删除" >删除</a>
				</td>
			</tr>
		</c:if>
		<c:if test="${fn:length(list)!=0}">
			<c:forEach var="row" items="${list}">
				<tr>
					<td class="k-wt-content seq" style="width:40px;" data-nh-uuid="${row.optionKey}">${row.seq}</td>
					<td class="k-wt-content"><input type="text" value="${row.content}" style="width:80%;"   class="lh28 h28 w322 pl10 bd-hui02 fl ml10 optionTitle"></td>
					<td class="k-wt-content" style="width:40px;">
						<a class="ico-del icon-caozuo f0 fr mr10" href="javascript:void(0);" onclick="deleteFunc(this);" title="删除" >删除</a>
					</td>
				</tr>
			</c:forEach>
		</c:if>
		
	</table>
</table>
<script>
//新增评价项
function addOptionFunc(){
	$("table.optionTable").append('<tr><td class="k-wt-content seq" style="width:40px;">1</td>'
			+'<td class="k-wt-content"><input type="text" value="" style="width:80%;"   class="lh28 h28 w322 pl10 bd-hui02 fl ml10 optionTitle"></td>'
			+'<td class="k-wt-content" style="width:40px;">'
			+'	<a class="ico-del icon-caozuo f0 fr mr10" href="javascript:void(0);" onclick="deleteFunc(this);" title="删除" >删除</a>'
			+'</td></tr>');
	setOptionSeq();
}
function setOptionSeq(){
	$("table.optionTable").find("td.seq").each(function(index){
		$(this).text(index+1);
	});
}
function deleteFunc(obj){
	var $obj=$(obj).parent().parent();
	$obj.remove();
	setOptionSeq();
}

function save(){
	if(!$("#title").val()){
		alert("主题不能为空");
		return;
	}
	var evaluatePO={};
	evaluatePO.evaluateKey=$("#evaluateKey").val();
	evaluatePO.yearTermKey=$("#yearTermKey").val();
	evaluatePO.title=$("#title").val();
	evaluatePO.status=$("#status").prop("checked")?1:0;
	var optionList=[]; 
	var $objTr=$(".optionTable").find("tr");
	for (var i = 0; i < $objTr.length; i++) {
		var $obj=$objTr.eq(i);
		if(!$obj.find(".optionTitle").val()){
			alert("评价项不能为空");
			return;
		}
		var option={
				optionKey:$obj.find(".seq").attr("data-nh-uuid"),
				seq:$obj.find(".seq").text(),
				content:$obj.find(".optionTitle").val(),
				evaluateKey:$("#evaluateKey").val()
		}
		optionList.push(option);
	}
	
	$.ajax({
		url : "${webPath}studyMng/evaluate/insertEvaluate.do",
		data : {"poStr":JSON.stringify(evaluatePO),"optionListStr":JSON.stringify(optionList)},
		type : 'post',
		dataType : 'json',
		success : function(data) {
			if(data.success!=null&&data.success){
				location.href = "${webPath}studyMng/evaluate/index.do";
			}else{
				alert(data.msg);
			}
		}
	});
	
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