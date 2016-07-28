/**
 * 
 */
package com.easyshop.product.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.common.module.entity.query.Page;
import org.common.module.entity.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easyshop.common.web.PageView;
import com.easyshop.common.web.controller.BaseController;
import com.easyshop.product.entity.AttrVal;
import com.easyshop.product.service.AttrValService;

/**
 * <p> 属性值控制器
 * @author yejunwu123@gmail.com
 * @since 2016年6月17日 下午1:17:39
 */
@Controller
@RequestMapping("system/attrval/")
public class AttributeValueController extends BaseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AttributeValueController.class);
	
	@Resource
	AttrValService attrValService;
	
	/**
	 * 列表数据
	 * @return
	 */
	@RequestMapping(value = "/list")
	public void list(Integer attrId, String value, HttpServletResponse response) {
		Query<Map<String, Object>> query = new Query<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>(4);
		map.put("attrId", attrId);
		map.put("value", value);
		query.setParams(map);
		Page page = attrValService.find(query);
		super.jsonResponse(response, new PageView(page));
	}
	
	/**
	 * 添加属性值
	 * @param attrVal
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(AttrVal attrVal, HttpServletResponse response) {
		try {
			attrVal.setCreateTime(new Date());
			attrVal.setLastUpdate(new Date());
			attrValService.save(attrVal);
		} catch (Exception e) {
			LOGGER.error("属性值'" + attrVal.getValue() + "'添加失败", e);
			super.ajaxResponse(response, 1, "属性值添加失败");
		}
		super.ajaxResponse(response, 0);
	}
	
	/**
	 * 获取属性信息
	 * @param id
	 * @param model
	 * @return json格式数据
	 */
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public void get(@PathVariable(value = "id") Long id, Model model, HttpServletResponse response) {
		AttrVal attrVal = attrValService.get(id);
		super.jsonResponse(response, attrVal);
	}
	
	/**
	 * 属性值修改
	 * @param attrVal
	 * @param response
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(AttrVal attrVal, HttpServletResponse response) {
		try {
			attrValService.update(attrVal);
		} catch (Exception e) {
			LOGGER.error("属性值'" + attrVal.getValue() + "'修改失败", e);
			super.ajaxResponse(response, 1, "属性值修改失败");
		}
		super.ajaxResponse(response, 0);
	}
	
	/**
	 * 删除属性
	 * @param id
	 * @param response
	 */
	@RequestMapping(value = "delete/{id}")
	public void delete(@PathVariable(value = "id") Long id, HttpServletResponse response) {
		try {
			attrValService.delete(id);
		} catch (Exception e) {
			LOGGER.error("属性值删除失败", e);
			super.ajaxResponse(response, 1, "属性值删除失败");
		}
		super.ajaxResponse(response, 0);
	}
}
