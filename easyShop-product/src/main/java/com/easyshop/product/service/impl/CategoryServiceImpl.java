/**
 * Apache License 2.0
 */
package com.easyshop.product.service.impl;

import javax.annotation.Resource;

import org.common.module.mybatis.mapper.BaseMapper;
import org.common.module.mybatis.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import com.easyshop.product.entity.Category;
import com.easyshop.product.mapper.CategoryMapper;
import com.easyshop.product.service.CategoryService;
/**
 * <p>商品分类
 * @author auto generated
 * @since 2016-06-13 17:06:05
 */
@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

	@Resource
	CategoryMapper categoryMapper;
	
	@Override
	protected BaseMapper<Category> getMapper() {
		return categoryMapper;
	}

	
	@Override
	public int save(Category entity) {
		//将父级分类的isParent字段更新为1
		Long pid = entity.getPid();
		if (null != pid) {
			Category parent = get(pid);
			if (null != parent) {
				if (0 == parent.getIsParent()) {
					parent.setIsParent(1);
					update(parent);
				}
			}
		}
		return super.save(entity);
	}
}
