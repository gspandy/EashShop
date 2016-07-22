/**
 * Apache License 2.0
 */
package com.easyshop.product.service.impl;

import javax.annotation.Resource;

import org.common.module.mybatis.mapper.BaseMapper;
import org.common.module.mybatis.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import com.easyshop.product.entity.Brand;
import com.easyshop.product.mapper.BrandMapper;
import com.easyshop.product.service.BrandService;
/**
 * <p>品牌
 * @author auto generated
 * @since 2016-06-13 17:06:05
 */
@Service
public class BrandServiceImpl extends BaseServiceImpl<Brand> implements BrandService {
	
	@Resource
	BrandMapper brandMapper;

	@Override
	protected BaseMapper<Brand> getMapper() {
		return brandMapper;
	}

}
