<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal inmodal" id="categoryDialog" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content animated bounceInRight">
	    	<div class="modal-header">
	        	<button type="button" class="close" data-dismiss="modal">
	            	<span aria-hidden="true">&times;</span><span class="sr-only">关闭</span>
	            </button>
	            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
	            <span class="modal-title">编辑目录</span>
	        </div>
	        <div class="modal-body">
	        	<form id="categoryForm" action="" method="post" class="form-horizontal">
					<div class="form-group">
	                    <label class="col-sm-3 control-label">目录名称：</label>
	                    <div class="col-sm-8">
	                    	<input type="hidden" name="pid"/>
	                        <input type="text" name="name" placeholder="目录名称" class="form-control" value=""/>
	                    </div>
	                </div>
				</form>
	        </div>
	        <div class="modal-footer">
	            <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
	            <button id="editBtn" type="button" class="btn btn-primary">保存</button>
	        </div>
		</div>
	</div>
</div>

<div class="modal inmodal" id="categoryAttrDialog" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content animated bounceInRight">
	    	<div class="modal-header">
	        	<button type="button" class="close" data-dismiss="modal">
	            	<span aria-hidden="true">&times;</span><span class="sr-only">关闭</span>
	            </button>
	            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
	            <span class="modal-title">编辑目录</span>
	        </div>
	        <div class="modal-body">
	        	<form id="categoryAttrForm" action="" method="post" class="form-horizontal">
					<div class="form-group">
	                    <label class="col-sm-3 control-label">目录名称：</label>
	                    <div class="col-sm-8">
	                    	<input type="hidden" name="id"/>
	                    	<input type="hidden" name="categoryId"/>
	                        <input type="text" name="categoryName" placeholder="目录名称" class="form-control" value=""/>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-sm-3 control-label">属性名称：</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group">
	                    		<input type="hidden" name="attrId"/>
	                    		<input type="text" name="attrName" class="form-control" id="attrNameSuggest">
	                            <div class="input-group-btn">
	                                <button type="button" class="btn btn-white dropdown-toggle" data-toggle="dropdown">
	                                    <span class="caret"></span>
	                                </button>
	                            </div>
	                            <ul class="dropdown-menu dropdown-menu-right" role="menu"></ul>
	                    	</div>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-sm-3 control-label">是否必填：</label>
	                    <div class="col-sm-8">
	                        <div class="radio radio-info radio-inline">
                                <input type="radio" value="1" name="required" id="required1">
                                <label for="required1"> 是 </label>
                            </div>
                            <div class="radio radio-success radio-inline">
                                <input type="radio" value="0" name="required" checked="checked" id="required2">
                                <label for="required2"> 否 </label>
                            </div>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-sm-3 control-label">销售属性：</label>
	                    <div class="col-sm-8">
	                        <div class="radio radio-info radio-inline">
                                <input type="radio" value="1" name="isSale" id="isSale1">
                                <label for="isSale1"> 是 </label>
                            </div>
                            <div class="radio radio-success radio-inline">
                                <input type="radio" value="0" name="isSale" checked="checked" id="isSale2">
                                <label for="isSale2"> 否 </label>
                            </div>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-sm-3 control-label">颜色属性：</label>
	                    <div class="col-sm-8">
	                        <div class="radio radio-info radio-inline">
                                <input type="radio" value="1" name="isColor" id="isColor1">
                                <label for="isColor1"> 是 </label>
                            </div>
                            <div class="radio radio-success radio-inline">
                                <input type="radio" value="0" name="isColor" checked="checked" id="isColor2">
                                <label for="isColor2"> 否 </label>
                            </div>
	                    </div>
	                </div>
				</form>
	        </div>
	        <div class="modal-footer">
	            <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
	            <button id="editCategoryAttrBtn" type="button" class="btn btn-primary">保存</button>
	        </div>
		</div>
	</div>
</div>