/**
 * 主目录
 */
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
});