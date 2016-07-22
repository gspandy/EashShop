<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal inmodal" id="attrDialog" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content animated bounceInRight">
	    	<div class="modal-header">
	        	<button type="button" class="close" data-dismiss="modal">
	            	<span aria-hidden="true">&times;</span><span class="sr-only">关闭</span>
	            </button>
	            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
	            <span class="modal-title">编辑属性</span>
	        </div>
	        <div class="modal-body">
	        	<form id="attrForm" action="" method="post" class="form-horizontal">
					<div class="form-group">
	                    <label class="col-sm-3 control-label">属性名称：</label>
	                    <div class="col-sm-8">
	                    	<input type="hidden" name="id" value="${attr.id }"/>
	                        <input type="text" name="name" placeholder="属性名称" class="form-control" value="${attr.name }"/>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-sm-3 control-label">属性标识：</label>
	                    <div class="col-sm-8">
	                        <input name="code" type="text" placeholder="属性标识" class="form-control" value="${attr.code }"/>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-sm-3 control-label">扩展字段1：</label>
	                    <div class="col-sm-8">
	                        <input type="text" name="field1" placeholder="扩展字段1" class="form-control" value="${attr.field1 }"/>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-sm-3 control-label">扩展字段2：</label>
	                    <div class="col-sm-8">
	                        <input type="text" name="field2" placeholder="扩展字段2" class="form-control" value="${attr.field2 }"/>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-sm-3 control-label">扩展字段3：</label>
	                    <div class="col-sm-8">
	                        <input type="text" name="field3" placeholder="扩展字段3" class="form-control" value="${attr.field3 }"/>
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