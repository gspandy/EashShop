/**
 * 
 */
package com.easyshop.common.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.common.module.utils.fastjson.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.easyshop.common.web.AjaxResult;

/**
 * <p> 抽象控制器
 * @author yejunwu123@gmail.com
 * @since 2016年7月20日 下午6:10:23
 */
public class BaseController {
	private static final String RESPONSE_TYPE_JSON = "application/json";
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
	/**
	 * json string响应
	 * @param object
	 * @return
	 */
	protected String jsonResponseString(Object object) {
		return JsonUtil.object2JsonString(object);
	}
	
	/**
	 * 通过HttpServletResponse将结果转为json数据返回
	 * @param response
	 * @param obj
	 */
	protected void jsonResponse(HttpServletResponse response, Object obj) {
		response.setContentType(RESPONSE_TYPE_JSON);
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.write(JsonUtil.object2JsonString(obj));
			pw.flush();
		} catch (IOException e) {
			LOGGER.error("", e);
		} finally {
			if (null != pw) {
				pw.close();
			}
		}
	}
	
	/**
	 * ajax json返回
	 * @param status 状态,0:成功,1:失败
	 * @return
	 */
	protected String ajaxResultString(int status) {
		return jsonResponseString(new AjaxResult(status));
	}
	
	/**
	 * ajax json返回
	 * @param status 状态,0:成功,1:失败
	 * @param msg
	 * @return
	 */
	protected String ajaxResultString(int status, String msg) {
		return jsonResponseString(new AjaxResult(status, msg));
	}
	
	/**
	 * ajax操作返回结果信息
	 * @param status 状态,0:成功,1:失败
	 * @param msg 提示消息
	 * @return
	 */
	protected void ajaxResponse(HttpServletResponse response, int status) {
		jsonResponse(response, new AjaxResult(status));
	}
	
	/**
	 * ajax操作返回结果信息
	 * @param status 状态,0:成功,1:失败
	 * @param msg 提示消息
	 * @return
	 */
	protected void ajaxResponse(HttpServletResponse response, int status, String msg) {
		jsonResponse(response, new AjaxResult(status, msg));
	}
	
	/**
	 * 新增action
	 * @param model
	 */
	protected void addAction(Model model) {
		model.addAttribute("action", "add");
	}
	
	/**
	 * 更新action
	 * @param model
	 */
	protected void updateAction(Model model) {
		model.addAttribute("action", "update");
	}
}
