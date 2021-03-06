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
<script type="text/javascript" src="${webPath}jsp/studyMng/evaluate/js/stuIndex.js?v=2017030902"></script>
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
			<h3 class="col-xs-5">学生评教活动(每个学生只能看到直接任课教师的评教活动)
			</h3>
		</div>
	   

	    <div class="mb10 mt10 searchVo">
				<form class=" form-inline form-inline-sm">
					<!-- 点击新建的时候是展示另外一个界面 -->
					<div class="form-group form-group-sm">
						<input class="form-control input-large" id="searchTxt" param="search.content" placeholder="按学院名称查询">
					</div>
					<a role="button" class="btn btn-success btn-primary">查询</a>
				</form>
		</div>


			    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="mytable caozuo  mb20 table">
					<tr>
							<th width="3%"><input type="checkbox" name="box_all" id="box_all"  onclick="check_all()" /><label for="checkbox"></label></th>
							<th class="text-left" width="35%">评教活动</th>
							<th class="text-left" width="20%">待评价教师</th>
							<th  class="text-left" width="25%">学年学期</th>
							<th  class="text-left" width="15%">状态</th>
							<th class="text-center" width="15%"></th>
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
 						{{title}}
						</td>
						 <td class="text-left">
 						{{teacherName}}
						</td>
					      <td class="text-left"><span class="hui" >
					      {{yearTermName}}
					      </span></td>
					      <td class="text-left"><span class="hui" >
					      {{statusStr}}
					      </span></td>
					       <td><p class="clearfix text-right  pr8">
					   		       <a class="ico-edit icon-caozuo f0 fr mr10" href="javascript:void(0);"onclick="getById('{{evaluateKey}}','{{teacherKey}}','{{studentKey}}','{{totalScore}}');" title="编辑" >编辑</a>
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
		//checkbox选择所有点击事件触发的方法
		function check_all(){
			$("input[name='box']").each(function(){
				$(this).attr("checked",$("#box_all").attr("checked")=='checked');
			});
		}

		
		//获取修改面板		
		function getById (evaluateKey,teacherKey,studentKey,totalScore){
			if(totalScore && totalScore!='null'){
				alert("该条评教信息已经提交！");
				return;
			}
			var url="${webPath}studyMng/evaluate/toCreateStuTeacher.do?evaluateKey="+evaluateKey+"&teacherKey="+teacherKey+"&studentKey="+studentKey;
			location = url;
		}
 </script>