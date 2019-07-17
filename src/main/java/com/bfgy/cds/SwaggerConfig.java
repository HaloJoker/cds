package com.bfgy.cds;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author liuzhiqiang
 * @Date 2019/2/2
 *
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {


	@Value("${swagger.show}")
	private boolean swaggerShow;

	// 定义分隔符,配置Swagger多包
	private static final String splitor = ";";

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.enable(swaggerShow)
				// 详细定制
				.apiInfo(apiInfo())
				.select()
				// 指定当前包路径，这里就添加了两个包，注意方法变成了basePackage，中间加上成员变量splitor
				//.apis(basePackage("com.ycb.ycs.portal"+splitor+"com.ycb.ycs.shop"+splitor+"com.ycb.ycs.sales"))
				.apis(basePackage("com.bfgy.cds"+splitor))
				// 扫描所有 .apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();

	}

	// 构建 api文档的详细信息函数
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				// 页面标题
				.title("********公司 API 文档 ")
				.version("1.0")
				// 描述
				.description("后端 API 文档").build();
	}

	/**
	 * 重写basePackage方法，使能够实现多包访问，复制贴上去
	 * @author  liuzhiqiang
	 * @date 2019/3/26
	 * @param
	 * @return com.google.common.base.Predicate<springfox.documentation.RequestHandler>
	 */
	public static Predicate<RequestHandler> basePackage(final String basePackage) {
		return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
	}

	private static Function<Class<?>, Boolean> handlerPackage(final String basePackage)     {
		return input -> {
			// 循环判断匹配
			for (String strPackage : basePackage.split(splitor)) {
				boolean isMatch = input.getPackage().getName().startsWith(strPackage);
				if (isMatch) {
					return true;
				}
			}
			return false;
		};
	}


	private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
		return Optional.fromNullable(input.declaringClass());
	}

}