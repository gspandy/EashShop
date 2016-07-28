/**
 * Apache License 2.0
 */
package com.easyshop.product.service.impl;

import javax.annotation.Resource;

import org.common.module.mybatis.mapper.BaseMapper;
import org.common.module.mybatis.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import com.easyshop.product.entity.AttrVal;
import com.easyshop.product.mapper.AttrValMapper;
import com.easyshop.product.service.AttrValService;
/**
 * <p>属性值
 * @author auto generated
 * @since 2016-06-13 17:06:05
 */
@Service
public class AttrValServiceImpl extends BaseServiceImpl<AttrVal> implements AttrValService {

	@Resource
	AttrValMapper attrValMapper;
	
	@Override
	protected BaseMapper<AttrVal> getMapper() {
		return attrValMapper;
	}

}
