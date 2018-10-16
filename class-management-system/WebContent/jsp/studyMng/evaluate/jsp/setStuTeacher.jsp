<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link type="text/css" rel="stylesheet" href="${webPath}css/weishequ.css?v=2017030902">
<link type="text/css" rel="stylesheet" href="${webPath}css/common.css?v=2017030902">
<link rel="stylesheet" href="${webPath}js/ztree/css/zTreeStyle.css?v=2017030902" />
<link type="text/css" rel="stylesheet" href="${webPath}css/admin/viewrange.css?v=2017030902"/>

<input type="hidden" id="teacherKey" value="${teacherPO.teacherKey}">
<input type="hidden" id="evaluateKey" value="${evaluatePO.evaluateKey}">
<input type="hidden" id="studentKey" value="${studentKey}">
<table class="k-wt-table" style="width:99%;">
	<tr>
		<td class="k-wt-title">主题：</td>
		<td class="k-wt-content">${evaluatePO.title}</td>
	</tr>
	<tr>
		<td class="k-wt-title">待评价教师：</td>
		<td class="k-wt-content">${teacherPO.name}</td>
	</tr>
	<tr>
		<th class="k-wt-header" colspan="2"style="padding-top: 2px;padding-bottom: 2px;">评价项
			<a href="javascript:void(0);" onclick="save()" style="float: right;margin-right: 30px;" class="w78 bd-hui02 display-ib text-center h28 lh26 f14 btn-hui01">提交</a>
		</th>
	</tr>
</table>
<table class="k-wt-table optionTable" style="width:99%;">
	<c:forEach var="row" items="${list}" varStatus="seq">
		<tr data-nh-optionKey="${row.optionKey}">
			<td class="k-wt-content" width="60%;">
				${row.seq}、${row.content}
			</td>
			<td class="k-wt-content" >
				<input type="radio" name="score${row.seq}" value="1">1分
				<input type="radio" name="score${row.seq}" value="2">2分
				<input type="radio" name="score${row.seq}" value="3">3分
				<input type="radio" name="score${row.seq}" value="4">4分
				<input type="radio" name="score${row.seq}" value="5">5分
				<input type="radio" name="score${row.seq}" value="6">6分
				<input type="radio" name="score${row.seq}" value="7">7分
				<input type="radio" name="score${row.seq}" value="8">8分
				<input type="radio" name="score${row.seq}" value="9">9分
				<input type="radio" name="score${row.seq}" value="10">10分
			</td>
		</tr>
	</c:forEach>
</table>


<script>
function save(){
	var $trObjs=$(".optionTable").find("tr");
	var totalScore=0;
	var stuOptionList=[];
	for (var i = 0; i < $trObjs.length; i++) {
		var $obj=$trObjs.eq(i);
		if($obj.find("input[type=radio]:checked").length<=0){
			alert("存在评价项没有打分！");
			return;
		}
		var score=parseInt($obj.find("input[type=radio]:checked").val());
		totalScore+=score;
		stuOptionList.push({
			optionKey:$obj.attr("data-nh-optionKey"),
			score:score
		});
	}
	var eavlStuMap={
		teacherKey:$("#teacherKey").val(),
		evaluateKey:$("#evaluateKey").val(),
		studentKey:$("#studentKey").val(),
		totalScore:totalScore
	}
	$.ajax({
		url : "${webPath}studyMng/evaluate/insertStuEval.do",
		data : {"eavlStuStr":JSON.stringify(eavlStuMap),"stuOptionStr":JSON.stringify(stuOptionList)},
		type : 'post',
		dataType : 'json',
		success : function(data) {
			if(data.success!=null&&data.success){
				location.href = "${webPath}studyMng/evaluate/stuIndex.do";
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