<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>品牌管理</title>
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox ">
                    <div class="ibox-title">
                        <form action="" method="post" id="brandSearchForm">
	                    	<div class="row">
	                            <div class="col-sm-3">
	                                <div class="input-group">
	                                	<span class="input-group-btn"><button type="button" class="btn btn-default">品牌名称</button></span>
	                                    <input name="name" type="text" class="form-control" placeholder="品牌名称">
	                                </div>
	                            </div>
                                <div class="col-sm-3">
	                                <div class="input-group">
	                                	<span class="input-group-btn"><button type="button" class="btn btn-default">品牌标识</button></span>
	                                    <input name="code" type="text" class="form-control" placeholder="品牌标识">
	                                </div>
	                            </div>
	                            <div class="col-sm-6">
	                                <button id="queryBrand" class="btn btn-success" type="button"><i class="fa fa-eye"></i>&nbsp;查询</button>
	                                <button id="addBrand" class="btn btn-primary" type="button"><i class="fa fa-check"></i>&nbsp;添加</button>
	                                <button id="updBrand" class="btn btn-info" type="button"><i class="fa fa-paste"></i>&nbsp;修改</button>
	                                <button id="delBrand" class="btn btn-warning" type="button"><i class="fa fa-warning"></i>&nbsp;删除</button>
	                            </div>
	                        </div>
                        </form>
                    </div>
                    <div class="ibox-content">
                        <div class="jqGrid_wrapper">
                            <table id="brandList"></table>
                            <div id="brandListPager"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <jsp:include page="edit.jsp"/>
    
	<script src="${ctx }/static/js/product/brand/brand.js"></script>
</body>
</html>