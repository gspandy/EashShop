/**
 * Apache License 2.0
 */
package com.easyshop.product.service.impl;

import javax.annotation.Resource;

import org.common.module.mybatis.mapper.BaseMapper;
import org.common.module.mybatis.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import com.easyshop.product.entity.Attr;
import com.easyshop.product.mapper.AttrMapper;
import com.easyshop.product.service.AttrService;
/**
 * <p>属性
 * @author auto generated
 * @since 2016-06-13 17:06:05
 */
@Service
public class AttrServiceImpl extends BaseServiceImpl<Attr> implements AttrService {

	@Resource
	AttrMapper attrMapper;
	
	@Override
	protected BaseMapper<Attr> getMapper() {
		return attrMapper;
	}

}
