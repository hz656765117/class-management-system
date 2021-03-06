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
	  		<input type="hidden" value="${type}" id="type">
	  		<c:if test="${type == 1 }">
	  			<h3 class="col-xs-5">奖学金管理 </h3>
	  		</c:if>
			<c:if test="${type == 2 }">
	  			<h3 class="col-xs-5">其他奖金管理 </h3>
	  		</c:if>
		</div>
	   

	    <div class="mb10 mt10 searchVo">
				<form class=" form-inline form-inline-sm">
					<c:if test="${user.type == '3' }"><!--  只有学生才能申请 -->
						<a role="button" class="btn btn-primary mr8" href="${webPath}prize/toPrizeApply.do?type=${type}"  >新建</a>
					</c:if>
					
					<a href="javascript:void(0);" onclick="delConfirm('all')" class="btn btn-default mr18 hui"><i class="ico-del-link icon-bg">批量删除</i></a>
					<!-- <div class="form-group form-group-sm">
						<input class="form-control input-large" id="searchTxt" param="search.content" placeholder="按账号名称查询">
					</div>
					<a role="button" class="btn btn-success btn-primary">查询</a> -->
				</form>
		</div>

			    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="mytable caozuo  mb20 table">
					<tr>
							<th width="3%"><input type="checkbox" name="box_all" id="box_all"  onclick="check_all()" /><label for="checkbox"></label></th>
							<th class="text-left" width="8%">申请学生</th>
							<th class="text-left" width="8%">申请状态</th>
							<th class="text-left" width="10%">奖金名称</th>
							<th class="text-left" width="15%">申请理由</th>
							<th class="text-left" width="8%">审核老师</th>
							<th class="text-left" width="15%">审核理由</th>
							<th  class="text-center" width="10%">申请时间</th>
							<th  class="text-center" width="10%">审核时间</th>
							<th class="text-center" width="10%"></th>
					</tr>
					<tbody id="container">
					</tbody>
			   </table>
				<div id="page"></div>
			   <textarea id="template" class="template" style="display: none">
				   {{#obj}}
				   	<tr>
					      <td class="text-center"><input type="checkbox" name="box" id="box" value="{{id}}" /></td>
					      <td class="text-left">
 							{{studentName}}
						  </td>
					      <td class="text-left"><span class="hui" >
					      {{auditStatus}}
					      </span></td>
					      
					      
					      <td class="text-left"><span class="hui" >
					      {{prizeTypeName}}
					      </span></td>
					      
						<td class="text-left"><span class="hui" >
					      {{applyReason}}
					      </span></td>
					      
					      <td class="text-left"><span class="hui" >
					      {{teacherName}}
					      </span></td>
						  
						  <td class="text-left"><span class="hui" >
					      {{comments}}
					      </span></td>
						  
						  <td class="text-center"><span class="hui">{{createtimeStr}}</span></td>
						  
						   <td class="text-center"><span class="hui">{{auditDatetimeStr}}</span></td>
					       <td><p class="clearfix text-right  pr8">
					   		       <a class="ico-del icon-caozuo f0 fr mr10" href="javascript:void(0);" onclick="delConfirm('single','{{id}}');" title="删除" >删除</a>
					   		       
					   		       <c:if test="${user.type != '3' }"><!-- 学生不能审核编辑 -->
					   		     	  <a class="ico-edit icon-caozuo f0 fr mr10" href="javascript:void(0);"onclick="getById('{{id}}');" title="编辑" >编辑</a>
					   		       </c:if>
				   		    </p>
				   		   </td>
					  </tr>
				   {{/obj}}
			   </textarea>

		</div>
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
 var type = '${type}';
 var setting1 = {
			check : {
				enable : true,
				chkStyle : "radio",
				radioType : "all",
				chkboxType : {
					"Y" : "p",
					"N" : "s"
				}
			},
			async : {
				enable : true,
				url : "${webPath}contacts/getNodeDept?type=-999",
				autoParam : [ "id" ],
				dataFilter : checkedNodes
			},
			view : {
				showIcon : false,
				showLine : false
			},
			data : {
				simpleData : {
					enable : true,
					idKey : "id",
					pIdKey : "parentId",
					rootPId : 0
				}
			}
		};


	var setting2 = {
			check : {
				enable : true,
				chkStyle : "checkbox",
				radioType : "all",
				chkboxType : {
					"Y" : "s",
					"N" : "s"
				}
			},
			async : {
				enable : true,
				url : "${webPath}account/getApps",
				autoParam : [ "id" ],
				dataFilter : checkedNodes
			},
			view : {
				showIcon : false,
				showLine : false
			},
			data : {
				simpleData : {
					enable : true,
					idKey : "id",
					pIdKey : "parentId",
					rootPId : 0
				}
			},
			callback:{
				onCheck: function(event, treeId, treeNode){
					//console.log(treeNode.code);
				}
			}
		};
	  var setcleck;
	  function showDIV(i, codes) {
		  if($("#alertdiv"+i).html()==undefined){
			  $("body").append(
						'<div class="neirong-pop user-pop pos-abs bg-bai display-no" id="alertdiv'+i+'" >'
						  +'<a href="javascript:void(0)" onclick="closeDIV('+i+')" class="fr f14 blue mr14 mt10">关闭</a>'
							+'<div class="pt15 pb20 pl20 mr20">'
								+'<br/>'
								+'<input type="hidden" id="" value="" />'
								+'<input type="hidden" id="" value="" />'
								+'<div class="clearfix">'
									+'<div class="" style="width:549px">'
									+'<p class="lh22 mt15 pb15 f14">选择管理应用<label class="fr" id="checkedAll"><input type="checkbox" onclick="checkedAll(this,'+i+');" />&nbsp;全选/反选</label></p>'
										+'<div class="bd-xu-hui01 over-auto h395 bg-hui">'
										+'<ul id=\"treeContext'+i+'\" class="ztree"></ul>'
										+'</div>'
										+'</div>'
										+'</div>'
								+'<div class="pt20 text-center">'
								+'<a href="javascript:void(0);" onclick="submNodes('+i+')" class="f20 bai bg-huang-cur display-ib lh38 h38 bd-huang01 br4 text-center w138">确 定</a> <a href="javascript:void(0)" onclick="closeDIV('+i+')" class="f20 hui display-ib w138 btn-bg02 bd-hui01 lh38 h38 br4 text-center ml6">取 消</a>'
								+'</div>'
								+'</div>'
								+'</div>;'
				);
		  }
		  $("#alertdiv1").CloseDiv();
		  jQuery("#alertdiv"+i).OpenDiv();

		  if(i==3){
			  $("#checkedAll").hide();
			  initTree(i,setting1);
		  }else if(i==4){
			  initTree(i,setting2);
		  }

		  //
		  setcleck = setInterval(function(){checkByEdit(codes, i);},100);

	  }

	  function closeDIV(showid) {
		  jQuery("#alertdiv"+showid).CloseDiv();
		  $("#alertdiv1").OpenDiv();
	  }

	  var person='';
	  var personName='';
	  var apps='';
	  var appNames='';
	  var code = '';
	  var codeNames = '';
	  function initTree(i,setting){
		 /*  var treeObj = $.fn.zTree.getZTreeObj("treeContext"+i);
		  //20170210
		  if(treeObj){
			 	 return;
		  } */
		   jQuery.fn.zTree.init(jQuery("#treeContext"+i), setting);
		}

	  function checkedNodes(treeId, parentNode, childNodes){
			  for(var i=0;i<childNodes.obj.length;i++){
				  var id= childNodes.obj[i].id+',';
				  /* if(treeId=='treeContext3' && person.indexOf(id)>=0){
					  childNodes.obj[i].checked=true;
				  }else if(treeId=='treeContext4' && apps.indexOf(id)>=0){
					  childNodes.obj[i].checked=true;
				  } */
				  childNodes.obj[i].open=true;
			  }
			  return childNodes.obj;
	  }

		function saveZtrChec(i){
			codeNames = '';
			var treeObj = $.fn.zTree.getZTreeObj("treeContext"+i);
			var cked=treeObj.getCheckedNodes(true);
			if(i==3){
				person='';
				personName='';
			}else if(i==4){
				apps='';
				appNames='';
			}

			var ids="";
			for(var j=0;j<cked.length;j++){
				if(!cked[j].isParent){
					ids+=cked[j].code+",";
					codeNames += cked[j].name + ',';
					/* if(i==3){
						personName+=cked[j].name+",";
					}else if(i==4){
						appNames+=cked[j].name+",";
					} */

				}
			}
			return ids;
		}


		function submNodes(i){
		 
 		    console.log(saveZtrChec(i));
 		    code = saveZtrChec(i);
 		    var codes = code.split(',');
 		    codes.pop();
 		 	//170210
			$('#appNames').data('codes', codes);


 		    if(codeNames){
 		    	$('#appNames').val(codeNames);
 		    } else {
 		    	$('#appNames').val('无任何权限');
 		    }
			closeDIV(i);
		}

		function checkedAll(e,i){
			var treeObj = $.fn.zTree.getZTreeObj("treeContext"+i);
			treeObj.checkAllNodes($(e).attr("checked")=='checked');
		}
		
		function getById (id){
			var url="${webPath}prize/toUpdatePrizeApply.do?id="+id+"&type="+$("#type").val();
			location = url;
		}

/* 		function getById (id){
			var url="${webPath}account/getById?id="+id;
			$.post(url,function(json){console.log(json)
				if(json.success){
					$("#account").val(json.obj.account);
					$("#account").attr("readonly","readonly");
					$("#appNames").val(json.obj.appNames);
					apps=json.obj.appIds;
					$('#viewrang').viewRange({
		                departEnable : true, //部门; true || false
		                departSelect : 'checkbox', //选择方式(单独部门为单选多选); 'checkbox' || 'radio'
		                personEnable : false,
		                initial : function(el, fn) {
		                	 
		                	initDept(id,el, fn) ;
		                }
		            });
					$('#alertdiv1').OpenDiv();
					$("#pwd").val("-pwd000");
					$("#pwd2").val("-pwd000");
					$("#confirm").attr("onclick","add("+id+")");

					//170210
					$('#appNames').data('codes', JSON.parse(json.obj.roles));
					code = JSON.parse(json.obj.roles).join(",");
					//checkByEdit(json.obj.rolesList, 4)
				}
			});
		}  */

		//编辑勾选 170210
		function checkByEdit(roles, i){
			var treeObj = $.fn.zTree.getZTreeObj("treeContext"+i);
			treeObj.checkAllNodes(false);
			for(var i = 0; i < roles.length; i++){
				var node = treeObj.getNodeByParam('code', roles[i]);
				treeObj.checkNode(node, true);
			}
			if(treeObj.getNodes()){
				clearInterval(setcleck);
			}
		}
		$('#appNames').click(function(event){
			var $this = $(this);
			var codes = $this.data('codes');
			console.log(codes);

			showDIV(4, codes);

		});

		function add(id){
			if($("#account").val()==''){
			    layer.alert('账号不能为空');
				return;
			}

			var model = new RegExp("^[a-zA-Z][a-zA-Z0-9]{3,19}$", "gi");
			if(!model.test($("#account").val())){
			    layer.alert('账号必须字母开头,长度在4-20位');
				return;

			}

			var model2 = new RegExp("^(?![\d]+$)(?![a-zA-Z]+$)(?![^\da-zA-Z]+$).{6,12}$", "gi");
			if(!model2.test($("#pwd").val())){
			    layer.alert('密码由字母和数字组成且长度在6-12位');
				return;
			}

			if($("#pwd").val()!=$("#pwd2").val()){
                layer.alert('2次输入的密码不一致');
				return;
			}

			if(code==''){
                layer.alert('请选择应用');
				return;
			}

			 selected = getSelectedItem('viewRange');
			var departments = selected.departments;

			var url="${webPath}account/insertOrUpdate";
			var data={};
			data['id']=id;
			data['account']=$("#account").val();
			data['pwd']=$("#pwd").val();
			//data['appIds']=apps;
			data['appNames']=$("#appNames").val();
            data['visibleDepartments']=departments.join(',');
            data['roles'] = code;

			$.post(url,data,function(json){
				if(json.success){
					location=location;
				} else {
                    layer.alert(json.msg);
				}
			});
		}

		function check_all(){
			$("input[name='box']").each(function(){
				$(this).attr("checked",$("#box_all").attr("checked")=='checked');
			});
		}


		function delete_all(type,id){
			var ids='';
			if(type=='all'){
				$("input[name='box']").each(function(){
					if($(this).attr("checked")=='checked'){
						ids+=$(this).val()+",";
					}
				});
				ids = ids.substring(0,ids.length-1);
			}else{
				ids=id;
			}

			if(ids=='' || ids==null){
                layer.alert('请至少选择一行');
				return ;
			}
			var url="${webPath}prize/deletePrizeApply.do?keyArr="+ids;
			$.post(url,function(json){
				if(json.success){
					$("#box_all").prop('checked', false)
					loadData(1); // 搜索查询默认查询第一页
					$('#alertdiv7').CloseDiv();
					
					/* location=location; */
				}
			});
		}



		function showAdd(){
			$("#confirm").attr("onclick","add(-1)");
			$("#account").removeAttr("readonly");
			$("#account").val("");
			$("#pwd").val("");
			$("#pwd2").val("");
			$("#appNames").val("无任何权限");
			appNames='';
			apps='';

            $('#viewrang').viewRange({
                departEnable : true, //部门; true || false
                departSelect : 'checkbox', //选择方式(单独部门为单选多选); 'checkbox' || 'radio'
                personEnable : false,
                initial : function(el, fn) {

                }
            });

			$('#alertdiv1').OpenDiv();
            $('#alertdiv1').css("z-index",9999);
            $("#BigDiv").css("z-index",9998);


		}

		function delConfirm(type,id){
			$('#ok').attr("onclick","delete_all('"+type+"',"+id+")");
			$('#alertdiv7').OpenDiv();
		}

		function initDept(contentId,el, fn) {
			  if (typeof contentId == 'undefined') {
			    $('.reviewrange-btn span').eq(0).click();
			    return;
			  }
			  $.ajax({
			    url: ctx + '/plugin/contactPlugin/listVisibleDept',
			    data: {
			      id: contentId
			    },
			    success: function(data) {
			      var list = data.obj;
			      if (list[0].id != '-9') {
			        var $html = $('<ul></ul>');
			        $.each(list, function(i, e) {
			          var $li = $('<li><p class="labelvalue">' + e.name + '</p><span class="closeicon"></span></li>');
			          $li.data('data', {
			            type: 'department',
			            id: e.id,
			            html: e.name
			          });
			          $li.find('.closeicon').click(function() {
			            $(this).parent().remove();
			            fn(); //personCheck
			          });
			          $html.append($li);
			        });
			        $(el).before($html.children());
			        $(el).closest('.reviewrange-frame').show().prev('.reviewrange-tab').find('li:last').addClass('vcur').siblings().removeClass('vcur');
			      };
			    }
			  })
			};
 </script>
 
 <script type="text/javascript" src="${webPath}jsp/appraisal/js/classCourse.js?v=2017030902"></script>