/**
 * 
 */
package com.easyshop.product.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

import com.easyshop.common.util.CollectionUtils;
import com.easyshop.common.web.PageView;
import com.easyshop.common.web.controller.BaseController;
import com.easyshop.product.entity.Attr;
import com.easyshop.product.service.AttrService;

/**
 * <p> 属性控制器
 * @author yejunwu123@gmail.com
 * @since 2016年6月17日 下午1:17:39
 */
@Controller
@RequestMapping("system/attribute/")
public class AttributeController extends BaseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AttributeController.class);
	
	@Resource
	AttrService attrService;
	
	/**
	 * 列表页面
	 * @return
	 */
	@RequestMapping(value = "/")
	public String toList() {
		return "product/attribute/list";
	}
	
	/**
	 * 列表数据
	 * @return
	 */
	@RequestMapping(value = "/list")
	public void list(String name, String code, Date startTime, Date endTime, HttpServletResponse response) {
		Query<Map<String, Object>> query = new Query<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>(4);
		map.put("name", name);
		map.put("code", code);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		query.setParams(map);
		Page page = attrService.find(query);
		super.jsonResponse(response, new PageView(page));
	}
	
	/**
	 * 添加属性
	 * @param attr
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(Attr attr, HttpServletResponse response) {
		try {
			attr.setCreateTime(new Date());
			attrService.save(attr);
		} catch (Exception e) {
			LOGGER.error("属性'" + attr.getName() + "'添加失败", e);
			super.ajaxResponse(response, 1, "属性添加失败");
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
		Attr attr = attrService.get(id);
		super.jsonResponse(response, attr);
	}
	
	/**
	 * 属性修改
	 * @param attr
	 * @param response
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(Attr attr, HttpServletResponse response) {
		try {
			attrService.update(attr);
		} catch (Exception e) {
			LOGGER.error("属性'" + attr.getName() + "'修改失败", e);
			super.ajaxResponse(response, 1, "属性修改失败");
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
			attrService.delete(id);
		} catch (Exception e) {
			LOGGER.error("属性删除失败", e);
			super.ajaxResponse(response, 1, "属性删除失败");
		}
		super.ajaxResponse(response, 0);
	}
	
	/**
	 * 自动提示
	 * @param name
	 */
	@RequestMapping(value = "suggest")
	public void suggest(String q, HttpServletResponse response) {
		Query<Map<String, Object>> query = new Query<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>(1);
		map.put("name", q);
		query.setParams(map);
		List<Attr> attrs = attrService.list(query);
		List<String[]> results = new ArrayList<String[]>();
		if (CollectionUtils.isNotEmpty(attrs)) {
			for (Attr attr : attrs) {
				results.add(new String[]{attr.getId().toString(), attr.getName(), attr.getCode()});
			}
		}
		super.textResponse(response, results);
	}
}
