<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>目录管理</title>
    <link href="${ctx }/static/lib/hplus/css/plugins/zTreeStyle/zTreeStyle.css" rel="stylesheet">
    <style type="text/css">
		.ztree li span.button.add {
			margin-left: 2px; 
			margin-right: -1px; 
			background-position: -144px 0; 
			vertical-align: top; 
			*vertical-align: middle
		}
	</style>
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-5">
                <div class="ibox ">
                    <div class="ibox-title">
                        <h5>主目录</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <ul id="mainCategory" class="ztree"></ul>
                    </div>
                </div>
            </div>
            <div class="col-sm-7">
            	<div class="ibox ">
                    <div class="ibox-title">
                        <form action="" method="post" id="categoryAttrSearchForm">
	                    	<div class="row">
	                            <div class="col-sm-4">
	                                <div class="input-group">
	                                	<span class="input-group-btn"><button type="button" class="btn btn-default">属性名称</button></span>
	                                    <input name="attrName" type="text" class="form-control" placeholder="属性名称">
	                                </div>
	                            </div>
	                            <div class="col-sm-8">
	                                <button id="queryCategoryAttr" class="btn btn-success" type="button"><i class="fa fa-eye"></i>&nbsp;查询</button>
	                                <button id="addCategoryAttr" class="btn btn-primary" type="button"><i class="fa fa-check"></i>&nbsp;添加</button>
	                                <button id="updCategoryAttr" class="btn btn-info" type="button"><i class="fa fa-paste"></i>&nbsp;修改</button>
	                                <button id="delCategoryAttr" class="btn btn-warning" type="button"><i class="fa fa-warning"></i>&nbsp;删除</button>
	                            </div>
	                        </div>
                        </form>
                    </div>
                    <div class="ibox-content">
                        <div class="jqGrid_wrapper">
                            <table id="categoryAttrList"></table>
                            <div id="categoryAttrListPager"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <jsp:include page="edit.jsp"/>
    
    <script src="${ctx }/static/lib/hplus/js/plugins/ztree/jquery.ztree.all-3.5.min.js"></script>
    <script src="${ctx }/static/lib/hplus/js/plugins/suggest/bootstrap-suggest.min.js"></script>
	<script src="${ctx }/static/js/product/category/category.js"></script>
</body>
</html>