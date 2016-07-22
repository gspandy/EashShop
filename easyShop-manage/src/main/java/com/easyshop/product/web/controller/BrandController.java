/**
 * 
 */
package com.easyshop.product.web.controller;

import java.util.Date;

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
import com.easyshop.product.entity.Brand;
import com.easyshop.product.service.BrandService;

/**
 * <p> 品牌控制器
 * @author yejunwu123@gmail.com
 * @since 2016年7月22日 下午12:17:33
 */
@Controller
@RequestMapping("system/brand/")
public class BrandController extends BaseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BrandController.class);
	
	@Resource
	BrandService brandService;
	
	/**
	 * 列表页面
	 * @return
	 */
	@RequestMapping(value = "/")
	public String toList() {
		return "product/brand/list";
	}
	
	/**
	 * 列表数据
	 * @return
	 */
	@RequestMapping(value = "/list")
	public void list(String name, String code, Date startTime, Date endTime, HttpServletResponse response) {
		Query<Brand> query = new Query<Brand>();
		Brand brand = new Brand();
		brand.setName(name);
		brand.setCode(code);
		query.setParams(brand);
		Page page = brandService.find(query);
		super.jsonResponse(response, new PageView(page));
	}
	
	/**
	 * 添加品牌
	 * @param attr
	 * @param response
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(Brand brand, HttpServletResponse response) {
		try {
			brand.setCreateTime(new Date());
			brandService.save(brand);
		} catch (Exception e) {
			LOGGER.error("品牌'" + brand.getName() + "'添加失败", e);
			super.ajaxResponse(response, 1, "品牌添加失败");
		}
		super.ajaxResponse(response, 0);
	}
	
	/**
	 * 获取品牌信息
	 * @param id
	 * @param model
	 * @return json格式数据
	 */
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public void get(@PathVariable(value = "id") Long id, Model model, HttpServletResponse response) {
		Brand brand = brandService.get(id);
		super.jsonResponse(response, brand);
	}
	
	/**
	 * 品牌修改
	 * @param brand
	 * @param response
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(Brand brand, HttpServletResponse response) {
		try {
			brandService.update(brand);
		} catch (Exception e) {
			LOGGER.error("品牌'" + brand.getName() + "'修改失败", e);
			super.ajaxResponse(response, 1, "品牌修改失败");
		}
		super.ajaxResponse(response, 0);
	}
	
	/**
	 * 删除品牌
	 * @param id
	 * @param response
	 */
	@RequestMapping(value = "delete/{id}")
	public void delete(@PathVariable(value = "id") Long id, HttpServletResponse response) {
		try {
			brandService.delete(id);
		} catch (Exception e) {
			LOGGER.error("品牌删除失败", e);
			super.ajaxResponse(response, 1, "品牌删除失败");
		}
		super.ajaxResponse(response, 0);
	}
}
