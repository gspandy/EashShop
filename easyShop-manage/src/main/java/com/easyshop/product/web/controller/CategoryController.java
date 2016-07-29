/**
 * 
 */
package com.easyshop.product.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.common.module.entity.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.easyshop.common.web.controller.BaseController;
import com.easyshop.product.entity.Category;
import com.easyshop.product.service.CategoryService;

/**
 * <p> 主目录控制器
 * @author yejunwu123@gmail.com
 * @since 2016年7月26日 下午2:12:15
 */
@Controller
@RequestMapping("system/category/")
public class CategoryController extends BaseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);
	
	@Resource
	CategoryService categoryService;
	
	/**
	 * 列表页面
	 * @return
	 */
	@RequestMapping(value = "/")
	public String toList() {
		return "product/category/list";
	}
	
	/**
	 * 列表数据
	 * @return
	 */
	@RequestMapping(value = "/list")
	public void list(@RequestParam(defaultValue = "0") Long id, HttpServletResponse response) {
		Query<Map<String, Object>> query = new Query<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>(1);
		map.put("pid", id);
		query.setParams(map);
		List<Category> categories = categoryService.list(query);
		super.jsonResponse(response, categories);
	}
	
	/**
	 * 添加主目录
	 * @param category
	 * @param response
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(Category category, HttpServletResponse response) {
		try {
			category.setCreateTime(new Date());
			category.setLastUpdate(new Date());
			categoryService.save(category);
		} catch (Exception e) {
			LOGGER.error("目录'" + category.getName() + "'添加失败", e);
			super.ajaxResponse(response, 1, "目录添加失败");
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
			categoryService.delete(id);
		} catch (Exception e) {
			LOGGER.error("目录删除失败", e);
			super.ajaxResponse(response, 1, "目录删除失败");
		}
		super.ajaxResponse(response, 0);
	}
}
