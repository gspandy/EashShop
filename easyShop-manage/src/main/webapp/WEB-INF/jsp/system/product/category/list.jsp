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
                        <h5>目录属性</h5>
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
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <jsp:include page="edit.jsp"/>
    
    <script src="${ctx }/static/lib/hplus/js/plugins/ztree/jquery.ztree.all-3.5.min.js"></script>
	<script src="${ctx }/static/js/product/category/category.js"></script>
</body>
</html>