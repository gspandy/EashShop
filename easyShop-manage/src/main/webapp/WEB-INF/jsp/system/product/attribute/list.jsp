<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>属性管理</title>
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox ">
                    <div class="ibox-title">
                        <form action="" method="post" id="attrSearchForm">
	                    	<div class="row">
	                            <div class="col-sm-3 m-b-xs">
	                                <div class="input-group m-b">
	                                	<span class="input-group-btn"><button type="button" class="btn btn-default">属性名称</button></span>
	                                    <input name="name" type="text" class="form-control" placeholder="属性名称">
	                                </div>
	                            </div>
                                <div class="col-sm-3 m-b-xs">
	                                <div class="input-group m-b">
	                                	<span class="input-group-btn"><button type="button" class="btn btn-default">属性标识</button></span>
	                                    <input name="code" type="text" class="form-control" placeholder="属性标识">
	                                </div>
	                            </div>
	                            <div class="col-sm-6 m-b-xs">
	                                <div class="input-group m-b">
	                                	<span class="input-group-btn"><button type="button" class="btn btn-default">更新时间</button></span>
	                                    <div class="input-daterange input-group" id="datepicker">
			                                <input id="startTime" type="text" class="form-control" name="startUpdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss', maxDate:'#F{$dp.$D(\'endTime\')}', readOnly:true})"/>
			                                <span class="input-group-addon">到</span>
			                                <input id="endTime" type="text" class="form-control" name="endUpdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss', maxDate:'%y-%M-%d %H:%m:%s', minDate:'#F{$dp.$D(\'startTime\')}', readOnly:true})"/>
			                            </div>
	                                </div>
	                            </div>
	                        </div>
                        </form>
                        <div class="row">
                            <div class="col-sm-5 m-b-xs">
                                <button id="queryAttr" class="btn btn-success" type="button"><i class="fa fa-eye"></i>&nbsp;查询</button>
                                <button id="addAttr" class="btn btn-primary"><i class="fa fa-check"></i>&nbsp;添加</button>
                                <button id="updAttr" class="btn btn-info" type="button"><i class="fa fa-paste"></i>&nbsp;修改</button>
                                <button id="delAttr" class="btn btn-warning" type="button"><i class="fa fa-warning"></i>&nbsp;删除</button>
                            </div>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <div class="jqGrid_wrapper">
                            <table id="attrList"></table>
                            <div id="attrListPager"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <div class="modal inmodal" id="editDialog" tabindex="-1" role="dialog" aria-hidden="true"></div>
    
    <script>
        $(document).ready(function() {
        	$.jgrid.defaults.styleUI = "Bootstrap";
        	$("#attrList").jqGrid({
        		url: ctx + '/system/attribute/list',
        		datatype: "json",
        		height: 350,
        		autowidth: true,
        		shrinkToFit: true,
        		rowNum: 10,
        		rowList: [10,20,30],
        		mtype: 'POST',
        		colNames: ["序号", "属性名称", "属性标识", "创建时间", "更新时间"],
        		colModel: [
        			{name: "id", index: "id", hidden: true, editable: false, width: 60, sorttype: "int", search: false},
        			{name: "name", index: "name", editable: false, width: 90},
        			{name: "code", index:" code", editable: false, width: 120},
        			{name: "createTime", index: "createTime", editable: false, width: 90, sorttype: "date"},
        			{name: "lastUpdate", index: "lastUpdate", editable: false, width: 90, sorttype: "date"}
        		],
        		pager: "#attrListPager",
        		viewrecords: true,
        		caption: "属性列表",
        		add: true,
        		edit: true,
        		addtext: "Add",
        		edittext: "Edit",
        		hidegrid: false
        	});
        	$("#attrList").setSelection(4, true);
        	$("#attrList").jqGrid("navGrid", "#attrListPager", {
        		edit: true,
        		add: true,
        		del: true,
        		search: false
        	}, {
        		height: 200,
        		reloadAfterSubmit: true});
	        $(window).bind("resize", function() {
	        	var width = $(".jqGrid_wrapper").width();
	        	$("#attrList").setGridWidth(width)
	        });
	        
	      	//查询
	        $("#queryAttr").click(function() { 
	        	var params = $("#attrSearchForm").serializeObject();
	        	var pd = $("#attrList").jqGrid('getGridParam', 'postData');
	        	pd = $.extend(pd, params);
	        	$("#attrList").jqGrid('setGridParam', 'postData', pd);
	        	$("#attrList").trigger("reloadGrid");
	        });
	      	
	      	//新增
			$("#addAttr").click(function() {
				$("#editDialog").bedialog({
				    url: "${ctx}/system/attribute/add"
				});
			});
	      	
			//修改
			$("#updAttr").click(function() {
				var id = $("#attrList").jqGrid('getGridParam', 'selrow');
				if (id) {
					$("#editDialog").bedialog({
					    url: "${ctx}/system/attribute/update/" + id
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
			$("#delAttr").click(function() {
				var id = $("#attrList").jqGrid('getGridParam', 'selrow');
				if (id) {
					$.ajax({
	    				type:'get',
	    				dataType: 'json',
	    				url:"${ctx}/system/auth/user/delete/" + id,
	    				success: function(data) {
	    					//var obj = $.parseJSON(data);
	    					responseTips(data);
	    					$("#attrList").trigger("reloadGrid");
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
        
        function processResult(data) {
        	var obj = $.parseJSON(data);
	    	responseTips(obj);
	    	console.log($('#editDialog'));
	    	$('#editDialog').modal('hide');
	    	$("#attrList").trigger("reloadGrid");
        }
    </script>
</body>
</html>