/**
 * Apache License 2.0
 */
package com.easyshop.product.service.impl;

import javax.annotation.Resource;

import org.common.module.mybatis.mapper.BaseMapper;
import org.common.module.mybatis.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import com.easyshop.product.entity.CategoryAttr;
import com.easyshop.product.mapper.CategoryAttrMapper;
import com.easyshop.product.service.CategoryAttrService;
/**
 * <p>类目属性
 * @author auto generated
 * @since 2016-06-13 17:06:05
 */
@Service
public class CategoryAttrServiceImpl extends BaseServiceImpl<CategoryAttr> implements CategoryAttrService {

	@Resource
	CategoryAttrMapper categoryAttrMapper;
	
	@Override
	protected BaseMapper<CategoryAttr> getMapper() {
		return categoryAttrMapper;
	}

}
