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
        	<!-- 属性 -->
            <div class="col-sm-6">
                <div class="ibox ">
                    <div class="ibox-title">
                        <form action="" method="post" id="attrSearchForm">
	                    	<div class="row">
	                            <div class="col-sm-6 m-b-xs">
	                                <div class="input-group m-b">
	                                	<span class="input-group-btn"><button type="button" class="btn btn-default">属性名称</button></span>
	                                    <input name="name" type="text" class="form-control" placeholder="属性名称">
	                                </div>
	                            </div>
                                <div class="col-sm-6 m-b-xs">
	                                <div class="input-group m-b">
	                                	<span class="input-group-btn"><button type="button" class="btn btn-default">属性标识</button></span>
	                                    <input name="code" type="text" class="form-control" placeholder="属性标识">
	                                </div>
	                            </div>
	                        </div>
                        </form>
                        <div class="row">
                            <div class="col-sm-12 m-b-xs">
                                <button id="queryAttr" class="btn btn-success" type="button"><i class="fa fa-eye"></i>&nbsp;查询</button>
                                <button id="addAttr" class="btn btn-primary" type="button"><i class="fa fa-check"></i>&nbsp;添加</button>
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
            <!-- 属性值 -->
            <div class="col-sm-6">
                <div class="ibox ">
                    <div class="ibox-title">
                        <form action="" method="post" id="attrValSearchForm">
	                    	<div class="row">
	                            <div class="col-sm-6 m-b-xs">
	                                <div class="input-group m-b">
	                                	<span class="input-group-btn"><button type="button" class="btn btn-default">属性值</button></span>
	                                    <input name="value" type="text" class="form-control" placeholder="属性值名称">
	                                </div>
	                            </div>
	                        </div>
                        </form>
                        <div class="row">
                            <div class="col-sm-12 m-b-xs">
                                <button id="queryAttrVal" class="btn btn-success" type="button"><i class="fa fa-eye"></i>&nbsp;查询</button>
                                <button id="addAttrVal" class="btn btn-primary"><i class="fa fa-check"></i>&nbsp;添加</button>
                                <button id="updAttrVal" class="btn btn-info" type="button"><i class="fa fa-paste"></i>&nbsp;修改</button>
                                <button id="delAttrVal" class="btn btn-warning" type="button"><i class="fa fa-warning"></i>&nbsp;删除</button>
                            </div>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <div class="jqGrid_wrapper">
                            <table id="attrValList"></table>
                            <div id="attrValListPager"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <jsp:include page="edit.jsp"/>
    <jsp:include page="editVal.jsp"/>
    
	<script src="${ctx }/static/js/product/attr/attr.js"></script>
</body>
</html>