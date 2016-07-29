/**
 * 
 */
package org.easyshop.product;

import org.common.module.generator.Config;
import org.common.module.generator.extension.mybatis.MybatisModuleAutoGenerator;
import org.junit.Test;

/**
 * <p> 商品模块代码生成
 * @author yejunwu123@gmail.com
 * @since 2016年6月11日 下午9:03:57
 */
public class ProductCodeGenerateTest {
	@Test
	public void testGenerate() {
		Config config = new Config();
		config.setDriverClass("com.mysql.jdbc.Driver")
			.setUsername("root")
			.setPassword("passw0rd")
			.setUrl("jdbc:mysql://127.0.0.1:3306/easy_shop")
			.setLicense("Apache License 2.0")
			.setGenerateBean(true)
			.setBeanExtends("BaseEntity")
			.setBeanExtendsPackage("org.common.module.entity")
			.setBeanPackage("com.easyshop.product.entity")
			//.setIncludeTables("attr,attr_val,brand,category,category_attr,product,product_attr,product_image,sku")
			.setIncludeTables("category_attr")
			.setExcludeFields("DELETED,VERSION")
			.setSaveDir("d:/test")
			.setGenerateService(true)
			.setServicePackage("com.easyshop.product.service")
			.setServiceExtendClass("BaseService<{0}>")
			.setServiceExtendClassPackage("org.common.module.mybatis.service")
			.setServiceImplExtendClass("BaseServiceImpl<{0}>")
			.setServiceImplExtendClassPackage("org.common.module.mybatis.service.impl")
			;
		MybatisModuleAutoGenerator generator = new MybatisModuleAutoGenerator("com.easyshop.product.mapper");
		generator.setMapperExtendsClass("BaseMapper<{0}>");
		generator.setMapperExtendsClassPackage("org.common.module.mybatis.mapper");
		generator.generate(config);
	}
}
