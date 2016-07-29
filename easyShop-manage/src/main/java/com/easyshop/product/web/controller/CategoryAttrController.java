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
import com.easyshop.product.entity.CategoryAttr;
import com.easyshop.product.service.CategoryAttrService;

/**
 * <p> 目录属性控制器
 * @author yejunwu123@gmail.com
 * @since 2016年7月28日 下午4:37:43
 */
@Controller
@RequestMapping("system/category/attr/")
public class CategoryAttrController extends BaseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryAttrController.class);
	
	@Resource
	CategoryAttrService categoryAttrService;
	
	/**
	 * 列表数据
	 * @return
	 */
	@RequestMapping(value = "/list")
	public void list(Long categoryId, String attrName, HttpServletResponse response) {
		Query<Map<String, Object>> query = new Query<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>(2);
		map.put("categoryId", categoryId);
		map.put("attrName", attrName);
		query.setParams(map);
		Page page = categoryAttrService.find(query);
		super.jsonResponse(response, new PageView(page));
	}
	
	/**
	 * 添加主目录属性
	 * @param categoryAttr
	 * @param response
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(CategoryAttr categoryAttr, HttpServletResponse response) {
		try {
			categoryAttr.setCreateTime(new Date());
			categoryAttr.setLastUpdate(new Date());
			categoryAttrService.save(categoryAttr);
		} catch (Exception e) {
			LOGGER.error("目录'" + categoryAttr.getCategoryId() + "'属性添加失败", e);
			super.ajaxResponse(response, 1, "目录属性添加失败");
		}
		super.ajaxResponse(response, 0);
	}
	
	/**
	 * 获取类目属性信息
	 * @param id
	 * @param model
	 * @return json格式数据
	 */
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public void get(@PathVariable(value = "id") Long id, Model model, HttpServletResponse response) {
		CategoryAttr categoryAttr = categoryAttrService.get(id);
		super.jsonResponse(response, categoryAttr);
	}
	
	/**
	 * 类目属性修改
	 * @param brand
	 * @param response
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(CategoryAttr categoryAttr, HttpServletResponse response) {
		try {
			categoryAttrService.update(categoryAttr);
		} catch (Exception e) {
			LOGGER.error("目录'" + categoryAttr.getCategoryName() + "',属性'" + categoryAttr.getAttrName() + "'修改失败", e);
			super.ajaxResponse(response, 1, "目录属性修改失败");
		}
		super.ajaxResponse(response, 0);
	}
	
	/**
	 * 删除主目录
	 * @param id
	 * @param response
	 */
	@RequestMapping(value = "delete/{id}")
	public void delete(@PathVariable(value = "id") Long id, HttpServletResponse response) {
		try {
			categoryAttrService.delete(id);
		} catch (Exception e) {
			LOGGER.error("目录属性删除失败", e);
			super.ajaxResponse(response, 1, "目录属性删除失败");
		}
		super.ajaxResponse(response, 0);
	}
}
