/**
 * 主目录
 */
var categoryAttrListGrid = null;
$(document).ready(function() {
	var mainCategorySetting = {
		data: {
  			simpleData: {
  				enable: true,
  				idKey: "id",
  				pIdKey: "pid",
  				rootPId: 0
  			}
  		},
  		view: {
			addHoverDom: function(treeId, treeNode){
				var sObj = $("#" + treeNode.tId + "_span");
				if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
				var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
					+ "' title='添加目录' onfocus='this.blur();'></span>";
				sObj.after(addStr);
				var btn = $("#addBtn_" + treeNode.tId);
				if (btn) btn.bind("click", function(){
					var zTree = $.fn.zTree.getZTreeObj("mainCategory");
					//弹出对话框
					$("#categoryDialog [name='name']").val("");
					$("#categoryDialog [name='pid']").val(treeNode.id);
					$('#categoryDialog').modal();
					//zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
					return false;
				});
			},
			removeHoverDom: function(treeId, treeNode){
				$("#addBtn_" + treeNode.tId).unbind().remove();
			},
			selectedMulti: false
		},
		async: {
			enable: true,
			url: ctx + "/system/category/list",
			autoParam: ["id"]
		},
		edit: {
            enable: true,
            drag:{
            	isCopy: false,
    			isMove: true
            },
            renameTitle: "修改目录名称",
            showRemoveBtn: function(treeId, treeNode) {
            	return 0 != treeNode.pid;
            },
            showRenameBtn: function(treeId, treeNode) {
            	return 0 != treeNode.pid;
            }
        },
		callback: {
			beforeRename: function(treeId, treeNode, newName) {
        		if (newName.length == 0) {
        			var data = {
    					status: 1,
    					msg: "名称不能为空"
    				};
    				responseTips(data);
    				return false;
    			}
        		return true;
        	},
        	onRename: function(event, treeId, treeNode, isCancel) {
        		alert(treeNode.name);
        	},
        	beforeRemove: function(treeId, treeNode) {
        		/*var isParent = treeNode.isParent;
        		if (1 == isParent) {
        			var data = {
    					status: 1,
    					msg: "该目录下有子目录,不允许直接删除"
    				};
    				responseTips(data);
    				return false;
        		}*/
        		//confirm
        		//alert("before remove");
        		console.log(treeNode);
        		var result = false;
        		var id = treeNode.id;
        		$.ajax({
                    type: "post",
                    url: ctx + "/system/category/delete/" + id,
                    async: false, //设为false就是同步请求
                    success: function (data) {
                    	responseTips(data);
                    	result = true;
                    }
                });
        		return result;
        	},
        	onRemove: function(event, treeId, treeNode) {
        		console.log("remove category " + treeNode.name);
        	},
        	beforeClick: function(treeId, treeNode, clickFlag) {
        		return !treeNode.isParent;
        	},
        	onClick: function(event, treeId, treeNode) {
        		var id = treeNode.id;
        		var pd = categoryAttrListGrid.jqGrid('getGridParam', 'postData');
            	pd = $.extend(pd, {"categoryId" : id});
            	categoryAttrListGrid.jqGrid('setGridParam', 'postData', pd);
            	categoryAttrListGrid.trigger("reloadGrid");
        	}
		}
	};
	var mainCategory = $.fn.zTree.init($("#mainCategory"), mainCategorySetting);
	
	$("#editBtn").click(function() {
		var newName = $("#categoryDialog [name='name']").val();
		var pid = $("#categoryDialog [name='pid']").val();
		$.ajax({
            type: "post",
            url: ctx + "/system/category/add",
            async: false, //设为false就是同步请求
            data: {
            	name: newName,
            	pid: pid
            },
            success: function (data) {
            	responseTips(data);
            	$('#categoryDialog').modal('hide');
            	//刷新树节点
            	var zTree = $.fn.zTree.getZTreeObj("mainCategory");
            	var nodes = zTree.getSelectedNodes();
            	/*var node = zTree.getNodeByTId(pid);
            	if (null == node) {
            		node = zTree.getNodeByTId("mainCategory_" + pid);
            	}
            	console.log(node);
            	if (!node.isParent) {
            		node = node.getParentNode();
            	}
            	console.log(node);*/
            	zTree.reAsyncChildNodes(nodes[0], "refresh", false);
            }
        });
	});
	
	/**************目录属性**************/
	$.jgrid.defaults.styleUI = "Bootstrap";
	//attr grid
	categoryAttrListGrid = $("#categoryAttrList").jqGrid({
		url: ctx + '/system/category/attr/list',
		datatype: "json",
		height: 355,
		autowidth: true,
		shrinkToFit: true,
		rowNum: 10,
		rowList: [10,20,30],
		mtype: 'POST',
		colNames: ["序号", "目录名称", "属性名称", "是否必须", "销售属性", "颜色属性", "创建时间", "更新时间"],
		colModel: [
			{name: "id", index: "id", hidden: true, editable: false, width: 30, sorttype: "int", search: false},
			{name: "categoryName", index: "categoryName", editable: false, width: 60},
			{name: "attrName", index:" attrName", editable: false, width: 80},
			{name: "required", index:" required", editable: false, width: 60, formatter: yesOrNoformatter},
			{name: "isSale", index:" isSale", editable: false, width: 60, formatter: yesOrNoformatter},
			{name: "isColor", index:" isColor", editable: false, width: 60, formatter: yesOrNoformatter},
			{name: "createTime", index: "createTime", editable: false, width: 90, sorttype: "date"},
			{name: "lastUpdate", index: "lastUpdate", editable: false, width: 90, sorttype: "date"}
		],
		pager: "#categoryAttrListPager",
		viewrecords: true,
		caption: "目录属性列表",
		add: false,
		edit: false,
		hidegrid: false
	});
	categoryAttrListGrid.setSelection(4, true);
	categoryAttrListGrid.jqGrid("navGrid", "#categoryAttrListPager", {
		edit: false,
		add: false,
		del: false,
		search: false
	}, {
		height: 200,
		reloadAfterSubmit: true});
    $(window).bind("resize", function() {
    	var width = $(".jqGrid_wrapper").width();
    	categoryAttrListGrid.setGridWidth(width)
    });
    
  //查询
    $("#queryCategoryAttr").click(function() { 
    	var params = $("#categoryAttrSearchForm").serializeObject();
    	var pd = categoryAttrListGrid.jqGrid('getGridParam', 'postData');
    	pd = $.extend(pd, params);
    	categoryAttrListGrid.jqGrid('setGridParam', 'postData', pd);
    	categoryAttrListGrid.trigger("reloadGrid");
    });
  	
  	//新增
	$("#addCategoryAttr").click(function() {
		var zTree = $.fn.zTree.getZTreeObj("mainCategory");
    	var nodes = zTree.getSelectedNodes();
    	if (nodes.length == 0) {
    		var data = {
				status: 1,
				msg: "请先选择一个目录"
			};
			responseTips(data);
			return false;
		}
    	var node = nodes[0];
    	if (node.isParent) {
    		var data = {
				status: 1,
				msg: "请先选择一个叶子目录"
			};
			responseTips(data);
			return false;
    	}
		$('#categoryAttrForm').attr("action", ctx + "/system/category/attr/add");
		$("#categoryAttrDialog [name='id']").val("");
		$("#categoryAttrDialog [name='categoryId']").val(node.id);
    	$("#categoryAttrDialog [name='categoryName']").val(node.name);
    	$("#categoryAttrDialog [name='attrId']").val("");
    	$("#categoryAttrDialog [name='attrName']").val("");
    	$("#categoryAttrDialog [name='required']").val("0");
    	$("#categoryAttrDialog [name='isSale']").val("0");
    	$("#categoryAttrDialog [name='isColor']").val("0");
		$('#categoryAttrDialog').modal();
	});
  	
	//修改
	$("#updCategoryAttr").click(function() {
		var id = categoryAttrListGrid.jqGrid('getGridParam', 'selrow');
		if (id) {
			$('#categoryAttrForm').attr("action", ctx + "/system/category/attr/update");
			$.ajax({
                type: "get",
                url: ctx + "/system/category/attr/get/" + id,
                async: false, //设为false就是同步请求
                //cache: false,
                success: function (data) {
                	//设置数据
                	$("#categoryAttrDialog [name='id']").val(data.id);
                	$("#categoryAttrDialog [name='categoryId']").val(data.categoryId);
                	$("#categoryAttrDialog [name='categoryName']").val(data.categoryName);
                	$("#categoryAttrDialog [name='attrId']").val(data.attrId);
                	$("#categoryAttrDialog [name='attrName']").val(data.attrName);
                	$("#categoryAttrDialog [name='required'][value='" + data.required + "']").attr("checked", true);
                	$("#categoryAttrDialog [name='isSale'][value='" + data.isSale + "']").val(data.isSale);
                	$("#categoryAttrDialog [name='isColor'][value='" + data.isColor + "']").val(data.isColor);
                	$("#categoryAttrDialog").modal();
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
	$("#delCategoryAttr").click(function() {
		var id = categoryAttrListGrid.jqGrid('getGridParam', 'selrow');
		if (id) {
			$.ajax({
				type: 'get',
				dataType: 'json',
				url: ctx + "/system/category/attr/delete/" + id,
				success: function(data) {
					//var obj = $.parseJSON(data);
					responseTips(data);
					categoryAttrListGrid.trigger("reloadGrid");
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
	
	$("#editCategoryAttrBtn").click(function() {
		$("#categoryAttrForm").submit();
	});
	//提交表单
	$('#categoryAttrForm').form({
		dataType: "json",
	    onSubmit: function() {    
	    	/* var isValid = $(this).form('validate');
			return isValid;	// 返回false终止表单提交 */
			return true;
	    },    
	    success: function(data) {
	    	var obj = $.parseJSON(data);
	    	responseTips(obj);
	    	$('#categoryAttrDialog').modal('hide');
	    	categoryAttrListGrid.trigger("reloadGrid");
	    }    
	});
	
	//属性提示
	var attrSuggest = $("#attrNameSuggest").bsSuggest({
		//indexId: 0,
		indexKey: 1,
		idField: "id",
		allowNoKeyword: false,
		multiWord: true,
		separator: ",",
		getDataMethod: "url",
		effectiveFields: ["id", "name", "code"],
		effectiveFieldsAlias: {
			id: "属性id",
			name: "属性名称",
			code: "属性标识"
		},
		showHeader: true,
		url: ctx + "/system/attribute/suggest?q=",
		//jsonp: "callback",
		//listAlign: "left",
		listStyle: {
	        "padding-top": 0,
	        "max-height": "375px",
	        "max-width": "800px",
	        "overflow": "auto",
	        "width": "100%",
	        "transition": "0.5s",
	        "-webkit-transition": "0.5s",
	        "-moz-transition": "0.5s",
	        "-o-transition": "0.5s"
	    },
		processData: function(json) {
			var i,
			len,
			data={
				value: []
			};
			if(!json || json.length == 0){
				return false;
			}
			len = json.length;
			for (i = 0; i < len; i++) {
				data.value.push({
					"id": json[i][0],
					"name": json[i][1],
					"code": json[i][2]
				});
			}
			return data;
		}
	});
	//属性自动提示时间监听
	$("#attrNameSuggest").on('dataRequestSuccess', function (event, result) {
        //console.log(result);
    }).on('onSetSelectValue', function (e, keyword) {
        //console.log('onSetSelectValue: ', keyword);
    	$("#categoryAttrDialog [name='attrId']").val(keyword.id);
    }).on('onUnsetSelectValue', function (e) {
        //console.log('onUnsetSelectValue');
    });
});

function yesOrNoformatter(cellvalue, options, rowObject) {
	console.log("cellvalue", cellvalue);
	if (1 == cellvalue) {
		return "是";
	} else {
		return "否";
	}
}