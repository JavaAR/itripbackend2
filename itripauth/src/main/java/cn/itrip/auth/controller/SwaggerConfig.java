package cn.itrip.auth.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Swagger API文档生成工具初始化配置信息
 * <br/>
 * 要求jdk8
 *
 */
@EnableSwagger2 // 启用Swagger
@ComponentScan(basePackages = {"cn.itrip.auth.controller"}) // 扫描你希望生成API文档的包地址
@Configuration // Spring 注解 用于表示此类是进行Spring容器内部信息构建的
public class SwaggerConfig extends WebMvcConfigurationSupport {

	/**
	 * 通过createRestApi函数创建Docket的Bean之后，
	 * apiInfo()用来创建该Api的基本信息（这些基本信息会展现在文档页面中）
	 * select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，
	 * apis()函数扫描所有Controller中定义的API， 并产生文档内容（除了被@ApiIgnore指定的请求）
	 * @return
	 */
	@Bean // 它等价于以前你配置 <bean id="createRestApi" class="xxxx">xxxx</bean>
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}

	/**
	 * 创建该Api的基本信息（这些基本信息会展现在文档页面中）
     * title() : 页面的标题
     * termsOfServiceUrl(): 认证服务地址  访问swagger的基础路径
     * contact(): 联系邮箱
     * version(): 版本信息
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("爱旅行-认证模块API")
				.termsOfServiceUrl("http://localhost:9090/auth")
				.contact("ar17536352497@163.com")
				.build();
	}
}