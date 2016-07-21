<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>权限管理</title>
	<%@include file="../../common/commonHeader.jspf" %>
    <!-- Data Tables -->
	<link href="${ctx }/static/lib/hplus/css/plugins/jqgrid/ui.jqgrid.css" rel="stylesheet">
	<link href="${ctx }/static/lib/hplus/css/plugins/toastr/toastr.min.css" rel="stylesheet">
	<link href="${ctx }/static/lib/hplus/css/plugins/chosen/chosen.css" rel="stylesheet">
	<link href="${ctx }/static/lib/hplus/css/style.min.css?v=4.0.0" rel="stylesheet">
	<link href="${ctx }/static/lib/hplus/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
	<style>
        /* Additional style to fix warning dialog position */
        #alertmod_table_list_2 {
            top: 900px !important;
        }
    </style>
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox ">
                    <div class="ibox-title">
                        <h5>用户授权/权限管理</h5>
                    </div>
                    <div class="ibox-content">
                    	<form action="" method="post" id="pSearchForm">
	                    	<div class="row">
	                            <div class="col-sm-3 m-b-xs">
	                                <div class="input-group m-b">
	                                	<span class="input-group-btn"><button type="button" class="btn btn-default">资源名称</button></span>
	                                    <input name="resourceName" type="text" class="form-control" placeholder="资源名称">
	                                </div>
	                            </div>
                                <div class="col-sm-3 m-b-xs">
	                                <div class="input-group m-b">
	                                	<span class="input-group-btn"><button type="button" class="btn btn-default">操作类型</button></span>
	                                    <select class="form-control" name="operationId">
							            	<option value="">操作类型</option>
											<c:forEach items="${operations }" var="operation">
												<option value="${operation.id }">${operation.description }</option>
											</c:forEach>
										</select>
	                                </div>
	                            </div>
	                        </div>
                        </form>
                        <div class="row">
                            <div class="col-sm-4 m-b-xs">
                                <button id="queryPrivilege" class="btn btn-success btn-xs" type="button"><i class="fa fa-eye"></i>&nbsp;查询</button>
                                <button id="addPrivilege" class="btn btn-primary btn-xs"><i class="fa fa-check"></i>&nbsp;添加</button>
                                <button id="updPrivilege" class="btn btn-info btn-xs" type="button"><i class="fa fa-paste"></i>&nbsp;修改</button>
                                <button id="delPrivilege" class="btn btn-warning btn-xs" type="button"><i class="fa fa-warning"></i>&nbsp;删除</button>
                            </div>
                        </div>
                        <div class="jqGrid_wrapper">
                            <table id="privilegeList"></table>
                            <div id="privilegeListPager"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <div class="modal inmodal" id="editDialog" tabindex="-1" role="dialog" aria-hidden="true"></div>

    <%@include file="../../common/globalScript.jspf" %>
    <script src="${ctx }/static/lib/hplus/js/plugins/peity/jquery.peity.min.js"></script>
    <script src="${ctx }/static/lib/hplus/js/plugins/jqgrid/i18n/grid.locale-cn.js"></script>
    <script src="${ctx }/static/lib/hplus/js/plugins/jqgrid/jquery.jqGrid.min.js"></script>
    <script src="${ctx }/static/lib/hplus/js/content.min.js?v=1.0.0"></script>
    <script src="${ctx }/static/lib/hplus/js/plugins/serialize/jquery.serialize-object.min.js"></script>
    <script src="${ctx }/static/lib/hplus/js/plugins/bedialog/jquery.bedialog.js"></script>
    <script src="${ctx }/static/lib/hplus/js/plugins/form/jquery.form.js"></script>
    <script src="${ctx }/static/lib/hplus/js/plugins/toastr/toastr.min.js"></script>
    <script src="${ctx }/static/lib/hplus/js/plugins/chosen/chosen.jquery.js"></script>
    <script src="${ctx }/static/lib/hplus/js/plugins/sweetalert/sweetalert.min.js"></script>
    <script>
        $(document).ready(function() {
        	$.jgrid.defaults.styleUI = "Bootstrap";
        	$("#privilegeList").jqGrid({
        		url: ctx + '/system/auth/privilege/list',
        		datatype: "json",
        		height: 350,
        		autowidth: true,
        		shrinkToFit: true,
        		rowNum: 10,
        		rowList: [10,20,30],
        		colNames: ["序号", "资源名称", "操作名称", "描述"],
        		colModel: [
        			{name: "id", index: "id", hidden: true, editable: false, width: 60, sorttype: "int", search: false},
        			{name: "resourceName", index: "resourceName", editable: true, width: 90},
        			{name: "operation", index:" operation", editable: true, width: 120},
        			{name: "description", index: "description", editable: true, width: 120}
        		],
        		pager: "#privilegeListPager",
        		viewrecords: true,
        		caption: "权限列表",
        		add: true,
        		edit: true,
        		addtext: "Add",
        		edittext: "Edit",
        		mtype: "POST",
        		hidegrid: false
        	});
        	$("#privilegeList").setSelection(4, true);
        	$("#privilegeList").jqGrid("navGrid", "#privilegeListPager", {
        		edit: true,
        		add: true,
        		del: true,
        		search: false
        	}, {
        		height: 200,
        		reloadAfterSubmit: true
        	});
	        $(window).bind("resize", function() {
	        	var width = $(".jqGrid_wrapper").width();
	        	$("#privilegeList").setGridWidth(width)
	        });
	        
	      	//查询
	        $("#queryPrivilege").click(function() { 
	        	var params = $("#pSearchForm").serializeObject();
	        	console.log(params);
	        	var pd = $("#privilegeList").jqGrid('getGridParam', 'postData');
	        	pd = $.extend(pd, params);
	        	console.log(pd);
	        	$("#privilegeList").jqGrid('setGridParam', 'postData', pd);
	        	$("#privilegeList").trigger("reloadGrid");
	        });
	      	
	      	//新增
			$("#addPrivilege").click(function() {
				$("#editDialog").bedialog({
				    url: "${ctx}/system/auth/privilege/add"
				});
			});
	      	
			//修改
			$("#updPrivilege").click(function() {
				var id = $("#privilegeList").jqGrid('getGridParam', 'selrow');
				if (id) {
					$("#editDialog").bedialog({
					    url: "${ctx}/system/auth/privilege/update/" + id
					});
				} else {
					var data = {
						status: 1,
						msg: "请先选择一行"
					};
					responseTips(data);
				}
			});
	      	
			//删除
			$("#delPrivilege").click(function() {
				var id = $("#privilegeList").jqGrid('getGridParam', 'selrow');
				if (id) {
					swal({
		                title: "确定删除?",
		                text: "删除后将无法恢复,请谨慎操作!",
		                type: "warning",
		                showCancelButton: true,
		                confirmButtonColor: "#DD6B55",
		                confirmButtonText: "删除",
		                closeOnConfirm: false
		            }, function (isConfirm) {
		            	if (isConfirm) {
		            		$.ajax({
		        				type:'get',
		        				dataType: 'json',
		        				url: "${ctx}/system/auth/privilege/delete/" + id,
		        				success: function(data) {
		        					//var obj = $.parseJSON(data);
		        					responseTips(data);
		        					$("#privilegeList").trigger("reloadGrid");
		        					swal.close();
		        				}
		        			});
		            	}
		            });
				} else {
					var data = {
						status: 1,
						msg: "请先选择一行"
					};
					responseTips(data);
				}
			});
        });
    </script>
</body>
</html>