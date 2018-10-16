<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link type="text/css" rel="stylesheet" href="${webPath}css/weishequ.css?v=2017030902">
<link type="text/css" rel="stylesheet" href="${webPath}css/common.css?v=2017030902">
<link rel="stylesheet" href="${webPath}js/ztree/css/zTreeStyle.css?v=2017030902" />
<link type="text/css" rel="stylesheet" href="${webPath}css/admin/viewrange.css?v=2017030902"/>

<table class="k-wt-table" style="width:99%;">
	<tr>
		<td class="k-wt-title">主题：</td>
		<td class="k-wt-content">${evaluatePO.title}</td>
	</tr>
	<tr>
		<td class="k-wt-title">评价学生：</td>
		<td class="k-wt-content">${studentPO.name}</td>
	</tr>
	<tr>
		<th class="k-wt-header" colspan="2"style="padding-top: 2px;padding-bottom: 2px;">评价项
		</th>
	</tr>
</table>
<table class="k-wt-table optionTable" style="width:99%;">
	<c:forEach var="row" items="${list}" varStatus="seq">
		<tr data-nh-optionKey="${row.optionKey}">
			<td class="k-wt-content" style="width:50px;text-align:center;">
				${row.score}分
			</td>
			<td class="k-wt-content" >
				${row.seq}、${row.content}
			</td>
		</tr>
	</c:forEach>
</table>


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