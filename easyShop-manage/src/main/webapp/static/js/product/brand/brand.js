/**
 * 属性
 */
var brandListGrid = null;
$(document).ready(function() {
	$.jgrid.defaults.styleUI = "Bootstrap";
	//attr grid
	brandListGrid = $("#brandList").jqGrid({
		url: ctx + '/system/brand/list',
		datatype: "json",
		height: 355,
		autowidth: true,
		shrinkToFit: true,
		rowNum: 10,
		rowList: [10,20,30],
		mtype: 'POST',
		colNames: ["序号", "品牌名称", "品牌标识", "链接", "创建时间", "更新时间"],
		colModel: [
			{name: "id", index: "id", hidden: true, editable: false, width: 30, sorttype: "int", search: false},
			{name: "name", index: "name", editable: false, width: 60},
			{name: "code", index:" code", editable: false, width: 80},
			{name: "url", index:" url", editable: false, width: 180},
			{name: "createTime", index: "createTime", editable: false, width: 90, sorttype: "date"},
			{name: "lastUpdate", index: "lastUpdate", editable: false, width: 90, sorttype: "date"}
		],
		pager: "#brandListPager",
		viewrecords: true,
		caption: "品牌列表",
		add: false,
		edit: false,
		hidegrid: false
	});
	brandListGrid.setSelection(4, true);
	brandListGrid.jqGrid("navGrid", "#brandListPager", {
		edit: false,
		add: false,
		del: false,
		search: false
	}, {
		height: 200,
		reloadAfterSubmit: true});
    $(window).bind("resize", function() {
    	var width = $(".jqGrid_wrapper").width();
    	brandListGrid.setGridWidth(width)
    });
    
  	//查询
    $("#queryBrand").click(function() { 
    	var params = $("#brandSearchForm").serializeObject();
    	var pd = brandListGrid.jqGrid('getGridParam', 'postData');
    	pd = $.extend(pd, params);
    	brandListGrid.jqGrid('setGridParam', 'postData', pd);
    	brandListGrid.trigger("reloadGrid");
    });
  	
  	//新增
	$("#addBrand").click(function() {
		$('#brandForm').attr("action", ctx + "/system/brand/add");
		$("#brandDialog [name='id']").val("");
    	$("#brandDialog [name='name']").val("");
    	$("#brandDialog [name='code']").val("");
    	$("#brandDialog [name='url']").val("");
		$('#brandDialog').modal();
	});
  	
	//修改
	$("#updBrand").click(function() {
		var id = brandListGrid.jqGrid('getGridParam', 'selrow');
		if (id) {
			$('#brandForm').attr("action", ctx + "/system/brand/update");
			$.ajax({
                type: "get",
                url: ctx + "/system/brand/get/" + id,
                async: false, //设为false就是同步请求
                //cache: false,
                success: function (data) {
                	//设置数据
                	$("#brandDialog [name='id']").val(data.id);
                	$("#brandDialog [name='name']").val(data.name);
                	$("#brandDialog [name='code']").val(data.code);
                	$("#brandDialog [name='url']").val(data.url);
                	$("#brandDialog").modal();
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
	$("#delBrand").click(function() {
		var id = brandListGrid.jqGrid('getGridParam', 'selrow');
		if (id) {
			$.ajax({
				type: 'get',
				dataType: 'json',
				url: ctx + "/system/brand/delete/" + id,
				success: function(data) {
					//var obj = $.parseJSON(data);
					responseTips(data);
					brandListGrid.trigger("reloadGrid");
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
		$("#brandForm").submit();
	});
	//提交表单
	$('#brandForm').form({
		dataType: "json",
	    onSubmit: function() {    
	    	/* var isValid = $(this).form('validate');
			return isValid;	// 返回false终止表单提交 */
			return true;
	    },    
	    success: function(data) {
	    	var obj = $.parseJSON(data);
	    	responseTips(obj);
	    	$('#brandDialog').modal('hide');
	    	brandListGrid.trigger("reloadGrid");
	    }    
	});
});