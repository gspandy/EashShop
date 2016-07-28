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