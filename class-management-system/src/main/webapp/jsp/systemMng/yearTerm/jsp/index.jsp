<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link type="text/css" rel="stylesheet" href="${webPath}css/common.css?v=2017030902"/>
<link type="text/css" rel="stylesheet" href="${webPath}css/admin/index.css?v=2017030902"/>
<link type="text/css" rel="stylesheet" href="${webPath}css/user.css?v=2017030902">
<link rel="stylesheet" href="${webPath}js/ztree/css/zTreeStyle.css?v=2017030902" />
<script type="text/javascript" src="${webPath}js/jquery.divbox.js?v=2017030902"></script>
<script type="text/javascript" src="${webPath}static/js/layer/layer.js?v=2017030902"></script>
<script type="text/javascript" src="${webPath}js/public.js?v=2017030902"></script>
<script type="text/javascript" src="${webPath}js/visible.js?v=2017030902"></script>
<script type="text/javascript" src="${webPath}static/js/mustache/mustache.min.js?v=2017030902"></script>
<script type="text/javascript" src="${webPath}static/module/attend/js/app.js?v=2017030902"></script>
<script type="text/javascript" src="${webPath}static/module/attend/js/page.js?v=2017030902"></script>
<script type="text/javascript" src="${webPath}jsp/systemMng/yearTerm/js/yearTerm.js?v=2017030902"></script>
<script type="text/javascript" src="${webPath}static/js/box/viewrange/viewrange.js?v=2017030902"></script>
<script type="text/javascript" src="${webPath}js/ztree/js/jquery.ztree.all-3.5.min.js?v=2017030902"></script>
<style>
	.view-box{
		z-index:10005;
	}
	.ztree{
		height: auto;
	}
</style>
 <div class="bg-bai clearfix over-hidden parents">
	  <div class="" >
	  <div class="landtitle">
			<h3 class="col-xs-5">学年学期维护
<%-- 				<a class="blue f12" style="margin-left:18px;" href="JavaScript:window.open('${webPath}/helps/helps_list_80.html')"><img src="${webPath}images/admin/grayquestion.png" class="ver-3 mr5">使用帮助</a> --%>
			</h3>
		</div>
	   

	    <div class="mb10 mt10 searchVo">
				<form class=" form-inline form-inline-sm">
					<!-- 点击新建的时候是展示另外一个界面 -->
					<a role="button" class="btn btn-primary mr8" href="javascript:void(0);" onclick="add()"  >新增学年学期</a>
<!-- 					<div class="form-group form-group-sm"> -->
<!-- 						<input class="form-control input-large" id="searchTxt" param="search.content" placeholder="按学院名称查询"> -->
<!-- 					</div> -->
<!-- 					<a role="button" class="btn btn-success btn-primary">查询</a> -->
				</form>
		</div>


			    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="mytable caozuo  mb20 table">
					<tr>
							<th width="3%"><input type="checkbox" name="box_all" id="box_all"  onclick="check_all()" /><label for="checkbox"></label></th>
							<th class="text-left" width="30%">学年学期</th>
							<th class="text-left" width="30%">学年</th>
							<th class="text-left" width="15%">当前学期</th>
							<th class="text-center" width="20%"></th>
					</tr>
					<tbody id="container">
					</tbody>
			   </table>
				<div id="page"></div>
				<!-- 以下是每一行数据的模板，这个每个地方需要更具业务不同进行修改 -->
			   <textarea id="template" class="template" style="display: none">
				   {{#obj}}
				   	<tr>
					      <td class="text-center"><input type="checkbox" name="box" id="box" value="{{academyKey}}" /></td>
					      <td class="text-left">
 						{{yearTermName}}
						</td>
					      <td class="text-left"><span class="hui" >
					      {{yearName}}
					      </span></td>
					      <td class="text-left"><span class="hui" >
					      {{flagStr}}
					      </span></td>
					       <td><p class="clearfix text-right  pr8">
<!-- 					   		       <a class="ico-del icon-caozuo f0 fr mr10" href="javascript:void(0);" onclick="delConfirm('single','{{academyKey}}');" title="删除" >删除</a> -->
				   		   		<a role="button" class="btn btn-primary mr8" href="javascript:void(0);" onclick="update('{{yearTermKey}}')"  >设为当前学期</a>
				   		    </p>
				   		   </td>
					  </tr>
				   {{/obj}}
			   </textarea>

		</div>
   </div>
 </div>

<!-- 选择判断是否的选择面板 -->
 <div class="pop-up w360  bg-hui01" id="alertdiv7">
	<div class="pt30 pb30 text-center">
		<p id="p_result7" class="hei01 f16 mt16">确认删除所选中的?</p>
	</div>
	<p class="text-center mb40">
		<a href="javascript:void(0);" id="ok" class="f20 bai bg-lv-cur display-ib lh38 h38 bd-lv br4 text-center w158">确 定</a>
		<span><a href="javascript:void(0);"onclick="$('#alertdiv7').CloseDiv()" class="f20 hui display-ib w158 btn-bg02 bd-hui01 lh38 h38 br4 text-center ml6">取消</a></span>
	</p>
</div>
 <script type="text/javascript">
		//新增学年学期
		function add(){
			//执行删除方法
			var url="${webPath}/systemMng/yearTerm/insertYearTerm.do";
			$.post(url,function(json){
				if(json.success){
					$("#box_all").prop('checked', false);//去掉所有的行选择
					loadData(1); // 搜索查询默认查询第一页
				}
			});
		}
		function update(yearTermKey){
			//执行删除方法
			var url="${webPath}/systemMng/yearTerm/setCurrentYear.do?yearTermKey="+yearTermKey;
			$.post(url,function(json){
				if(json.success){
					$("#box_all").prop('checked', false);//去掉所有的行选择
					loadData(1); // 搜索查询默认查询第一页
				}
			});
		}
 </script>