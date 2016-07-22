/**
 * 属性
 */
var attrListGrid = null;
var attrValListGrid = null;
$(document).ready(function() {
	$.jgrid.defaults.styleUI = "Bootstrap";
	//attr grid
	attrListGrid = $("#attrList").jqGrid({
		url: ctx + '/system/attribute/list',
		datatype: "json",
		height: 355,
		autowidth: true,
		shrinkToFit: true,
		rowNum: 10,
		rowList: [10,20,30],
		mtype: 'POST',
		colNames: ["序号", "属性名称", "属性标识", "创建时间", "更新时间"],
		colModel: [
			{name: "id", index: "id", hidden: true, editable: false, width: 30, sorttype: "int", search: false},
			{name: "name", index: "name", editable: false, width: 80},
			{name: "code", index:" code", editable: false, width: 100},
			{name: "createTime", index: "createTime", editable: false, width: 110, sorttype: "date"},
			{name: "lastUpdate", index: "lastUpdate", editable: false, width: 110, sorttype: "date"}
		],
		pager: "#attrListPager",
		viewrecords: true,
		caption: "属性列表",
		add: false,
		edit: false,
		hidegrid: false
	});
	attrListGrid.setSelection(4, true);
	attrListGrid.jqGrid("navGrid", "#attrListPager", {
		edit: false,
		add: false,
		del: false,
		search: false
	}, {
		height: 200,
		reloadAfterSubmit: true});
	
	//attr val grid
	attrValListGrid = $("#attrValList").jqGrid({
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
			{name: "id", index: "id", hidden: true, editable: false, width: 30, sorttype: "int", search: false},
			{name: "name", index: "name", editable: false, width: 80},
			{name: "code", index:" code", editable: false, width: 100},
			{name: "createTime", index: "createTime", editable: false, width: 110, sorttype: "date"},
			{name: "lastUpdate", index: "lastUpdate", editable: false, width: 110, sorttype: "date"}
		],
		pager: "#attrValListPager",
		viewrecords: true,
		caption: "属性值列表",
		add: false,
		edit: false,
		hidegrid: false
	});
	attrValListGrid.setSelection(4, true);
	attrValListGrid.jqGrid("navGrid", "#attrValListPager", {
		edit: false,
		add: false,
		del: false,
		search: false
	}, {
		height: 200,
		reloadAfterSubmit: true});
	
    $(window).bind("resize", function() {
    	var width = $(".jqGrid_wrapper").width();
    	attrListGrid.setGridWidth(width)
    });
    
  	//查询
    $("#queryAttr").click(function() { 
    	var params = $("#attrSearchForm").serializeObject();
    	var pd = attrListGrid.jqGrid('getGridParam', 'postData');
    	pd = $.extend(pd, params);
    	attrListGrid.jqGrid('setGridParam', 'postData', pd);
    	attrListGrid.trigger("reloadGrid");
    });
  	
  	//新增
	$("#addAttr").click(function() {
		/* $("#editDialog").bedialog({
		    url: "${ctx}/system/attribute/add"
		}); */
		$('#attrForm').attr("action", ctx + "/system/attribute/add");
		$("#attrDialog [name='id']").val("");
    	$("#attrDialog [name='name']").val("");
    	$("#attrDialog [name='code']").val("");
    	$("#attrDialog [name='field1']").val("");
    	$("#attrDialog [name='field2']").val("");
    	$("#attrDialog [name='field3']").val("");
		$('#attrDialog').modal();
	});
  	
	//修改
	$("#updAttr").click(function() {
		var id = attrListGrid.jqGrid('getGridParam', 'selrow');
		if (id) {
			/* $("#attrDialog").bedialog({
			    url: "${ctx}/system/attribute/update/" + id
			}); */
			$('#attrForm').attr("action", ctx + "/system/attribute/update");
			$.ajax({
                type: "get",
                url: ctx + "/system/attribute/get/" + id,
                async: false, //设为false就是同步请求
                //cache: false,
                success: function (data) {
                	//设置数据
                	$("#attrDialog [name='id']").val(data.id);
                	$("#attrDialog [name='name']").val(data.name);
                	$("#attrDialog [name='code']").val(data.code);
                	$("#attrDialog [name='field1']").val(data.field1);
                	$("#attrDialog [name='field2']").val(data.field2);
                	$("#attrDialog [name='field3']").val(data.field3);
                	$("#attrDialog").modal();
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
  	
	//删除
	$("#delAttr").click(function() {
		var id = attrListGrid.jqGrid('getGridParam', 'selrow');
		if (id) {
			$.ajax({
				type: 'get',
				dataType: 'json',
				url: ctx + "/system/attribute/delete/" + id,
				success: function(data) {
					//var obj = $.parseJSON(data);
					responseTips(data);
					attrListGrid.trigger("reloadGrid");
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
	
	$("#editBtn").click(function() {
		$("#attrForm").submit();
	});
	//提交表单
	$('#attrForm').form({
		dataType: "json",
	    onSubmit: function() {    
	    	/* var isValid = $(this).form('validate');
			return isValid;	// 返回false终止表单提交 */
			return true;
	    },    
	    success: function(data) {
	    	var obj = $.parseJSON(data);
	    	responseTips(obj);
	    	$('#attrDialog').modal('hide');
	    	attrListGrid.trigger("reloadGrid");
	    }    
	});
});