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
<script type="text/javascript" src="${webPath}jsp/academicScore/js/academicScore.js?v=2017030902"></script>
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
			<h3 class="col-xs-5">综合测评
				<%-- <a class="blue f12" style="margin-left:18px;" href="JavaScript:window.open('${webPath}/helps/helps_list_80.html')"><img src="${webPath}images/admin/grayquestion.png" class="ver-3 mr5">使用帮助</a> --%>
			</h3>
		</div>
	   

	    <div class="mb10 mt10 searchVo">
				<form class=" form-inline form-inline-sm">
					<c:if test="${user.type != '3' }">
						<a role="button" class="btn btn-primary mr8" onclick="setAcademicScore()" href="javascript:void(0);"  >初始化当前学期综合测评数据</a>
<!-- 						<a href="javascript:void(0);" onclick="delConfirm('all')" class="btn btn-default mr18 hui"><i class="ico-del-link icon-bg">批量删除</i></a> -->
					</c:if>
					
					<!-- <div class="form-group form-group-sm">
						<input class="form-control input-large" id="searchTxt" param="search.content" placeholder="按账号名称查询">
					</div> -->
					 
		            
<%-- 		            <div class="form-group form-group-sm">
		                <label class="control-label sr-only">学期:</label>
		                <select class="form-control input-medium" param="search.yearId">
		                    <option value="" selected="selected" style="display: none">请选择学期</option>
		                    <option value="0">全部分类</option>
		                    <c:forEach var="year" items="${years}">
					    		<option value="${year.yearTermKey}" >${year.yearTermName}</option>
					    	</c:forEach>>
		                </select>
		            </div> --%>
		            
		            <div class="form-group form-group-sm">
		                <label class="control-label sr-only">班级:</label>
		                <select class="form-control input-medium" param="search.classId">
		                    <option value="" selected="selected" style="display: none">请选择班级</option>
		                    <option value="0">全部分类</option>
		                    <c:forEach var="class" items="${classes}">
					    		<option value="${class.classKey}" >${class.className}</option>
					    	</c:forEach>>
		                </select>
		            </div>
		            
					<a role="button" class="btn btn-success btn-primary">查询</a> 
				</form>
		</div>


			    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="mytable caozuo  mb20 table">
					<tr>
							<th class="text-left" width="10%">学生名字</th>
							<th class="text-left" width="15%">班级</th>
							<th class="text-left" width="15%">学期</th>
							<th class="text-left" width="12%">学业成绩</th>
							<th class="text-left" width="12%">学业成绩排名</th>
							<th class="text-left" width="12%">体育成绩</th>
							<th class="text-left" width="12%">非学业成绩</th>
							<th class="text-left" width="12%">总分</th>
						<!-- 	<th  class="text-center" width="20%">创建时间</th> -->
							<th class="text-center" width="10%"> </th>
					</tr>
					<tbody id="container">
					</tbody>
			   </table>
				<div id="page"></div>
			   <textarea id="template" class="template" style="display: none">
				   {{#obj}}
				   	<tr>
					    
					      <td class="text-left">
 							{{studentName}}
						</td>
					      <td class="text-left"><span class="hui" >
					      {{className}}
					      </span></td>
						<td class="text-left"><span class="hui" >
					      {{yearName}}
					      </span></td>
					      <td class="text-left"><span class="hui" >
					      {{academicScore}}
					      </span></td>
					      <td class="text-left"><span class="hui" >
					      {{academicScoreSeq}}
					      </span></td>
					      <td class="text-left"><span class="hui" >
					      {{sportsScore}}
					      </span></td>
					      <td class="text-left"><span class="hui" >
					      {{notAcademicScore}}
					      </span></td>
					        <td class="text-left"><span class="hui" >
					      {{totalScore}}
					      </span></td>
						  <!-- <td class="text-center"><span class="hui">{{createtimeStr}}</span></td> -->
					       <td><p class="clearfix text-right  pr8">
					       <c:if test="${user.type != '3' }">
 					   		       <a class="ico-edit icon-caozuo f0 fr mr10" href="javascript:void(0);"onclick="getById('{{id}}','{{personId}}');" title="编辑" >编辑</a> 
				   		   </c:if>
				   		    </p>
				   		   </td>
					  </tr>
				   {{/obj}}
			   </textarea>

		</div>
   </div>
 </div>

 <!--新建-->
<div class="neirong-pop user-pop pos-abs bg-bai display-no" id="alertdiv1" >
 <a href="javascript:void(0)" onclick="closeDiv(1);" class="fr f14 blue mr14 mt10">关闭</a>
    <div class="cl"></div>
      <ul id ="fileupload_1"> </ul>
      <span id="loadingdiv" style="margin-left: 110px;display:none;"><img src="${webPath}images/loader.gif" /> 上传中...</span>
	 <div id="file_upload-queue" class="uploadify-queue"></div>

	 <div class="clearfix pb10">
		<p class="f14 lh30  hei01  mt10  fl" style="width:85px;padding-left:20px">账号</p>
	    <p class="h28  bd-hui02 mr10 fl mt10" style="width:300px">
	      <input id="account" class="noborder  h30 lh28 pct-w100" maxlength=""  style="text-indent:6px">
	    </p>
	     <div class="cl"></div>
	    <p style="color: #747474;padding-top: 10px;padding-left: 80px;">请输入4~20个字符，可使用字母、数字，需以字母开头</p>
	 </div>

	 <div class="clearfix pb10">
		<p class="f14 lh30  hei01  mt10  fl" style="width:85px;padding-left:20px">密码</p>
	    <p class="h28  bd-hui02 mr10 fl mt10" style="width:300px">
	      <input id="pwd" class="noborder  h30 lh28 pct-w100" maxlength="12" type="password" style="text-indent:6px">
	    </p>
	     <div class="cl"></div>
	    <p style="color: #747474;padding-top: 10px;padding-left: 80px;">请输入数字+英文组合的密码，密码长度为6-12个字符</p>
	 </div>

	 <div class="clearfix pb10">
		<p class="f14 lh30  hei01  mt10  fl" style="width:85px;padding-left:20px">确认密码</p>
	    <p class="h28  bd-hui02 mr10 fl mt10" style="width:300px">
	      <input id="pwd2" class="noborder  h30 lh28 pct-w100" maxlength="12" type="password" style="text-indent:6px">
	    </p>
	    <div class="cl"></div>
	    <p style="color: #747474;padding-top: 10px;padding-left: 80px;">请再次输入密码</p>
	 </div>

	 <div class="clearfix pb10">
		<p class="f14 lh30  hei01  mt10  fl" style="width:85px;padding-left:20px">管理应用</p>
	    <p class="h30  bd-hui02 mr10 fl mt10" style="width:300px">
	      <input id="appNames" data-codes=[] readonly="readonly"  value="无任何权限"  class="noborder  h28 lh28 pct-w100" maxlength="" style="text-indent:6px">
	    </p>
	 </div>

	<div class="clearfix pb10">
	<!-- 	<p class="f14 lh30  hei01  mt10  fl" style="width:85px;padding-left:20px">通讯录范围：</p>
		<div class="col-sm-7 plr-n">
			<input id="viewrang" type="text" placeholder="选择通讯录范围">
		</div> -->

		<div class="mb15" id="viewRange" style="display: none;">
			<label class="reviewrange-left" style="width:auto;padding-left:20px;">通讯录范围：</label>
			<div class="col-sm-5 plr-n pt6" style="margin:0 140px 0 20px;">
				<input id="viewrang" type="text" placeholder="在此输入搜索条件">
			</div>
		</div>
	</div>

	 <p class="red pt10" id="msg"></p>
     <div class="text-center mb20">
    	<a id="confirm" onclick="add(-1)" href="javascript:void(0);" class="f20 bai bg-huang-cur display-ib lh38 h38 bd-huang01 br4 text-center w158">确 定</a>
    	<a id="view" href="javascript:void(0);" onclick="$('#alertdiv1').CloseDiv()"  class="f20 bai bg-huang-cur display-ib lh38 h38 bd-huang01 br4 text-center w158 ml4">取消</a>
     </div>
</div>

 <div class="pop-up w360  bg-hui01" id="alertdiv7">
	<div class="pt30 pb30 text-center">
		<p id="p_result7" class="hei01 f16 mt16">确认删除所选中的?</p>
	</div>
	<p class="text-center mb40">
		<a href="javascript:void(0);" id="ok" class="f20 bai bg-lv-cur display-ib lh38 h38 bd-lv br4 text-center w158">确 定</a>
		<span><a href="javascript:void(0);"onclick="$('#alertdiv7').CloseDiv()" class="f20 hui display-ib w158 btn-bg02 bd-hui01 lh38 h38 br4 text-center ml6">取消</a></span>
	</p>
</div>

 <div class="pop-up w360  bg-hui01" id="alertdiv8">
	<div class="pt30 pb30 text-center">
		<p id="p_result" class="hei01 f16 mt16"></p>
	</div>
	<p class="text-center mb40">
		<a href="javascript:void(0);" onclick="$('#alertdiv8').CloseDiv()" class="f20 bai bg-lv-cur display-ib lh38 h38 bd-lv br4 text-center w158">确 定</a>
	</p>
</div>
 <script type="text/javascript">
 
 
 
		
 function getById (id,personId){
		var url="${webPath}academicScore/toUpdateNotAcademicScore.do?id="+id+"&personId="+personId;
		location = url;
	}

 
 
	function setAcademicScore(){
		  $.ajax({
			    url: ctx + '/academicScore/setAcademicScore.do',
			    /* data: {
			      id: contentId
			    }, */
			    success: function(data) {
			    	loadData(1);
			    	layer.alert("本学期综合测评数据初始化成功");
			    },
			    error: function(data){
			    	layer.alert("本学期综合测评数据初始化成功");
			    }
			  });
	}
 
 

		 
 </script>