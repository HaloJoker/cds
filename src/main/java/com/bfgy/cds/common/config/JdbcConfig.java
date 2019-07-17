package com.bfgy.cds.common.config;

import com.github.pagehelper.PageInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Author liuzhiqiang
 * @Date 2019/7/15
 */

@Configuration
@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@MapperScan(value = {"com.bfgy.cds.dao"})
public class JdbcConfig {

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return  new ConfigurationCustomizer(){
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
                // 设置MyBatis分页插件
                PageInterceptor pageInterceptor = new PageInterceptor();
                Properties properties = new Properties();
                properties.setProperty("helperDialect", "Mysql");
                /**
                 * 分页合理化参数，默认值为false。
                 * 当该参数设置为 true 时，pageNum<=0 时会查询第一页，
                 * pageNum>pages（超过总数时），会查询最后一页。
                 * 默认false 时，直接根据参数进行查询。
                 */
                properties.setProperty("reasonable", "false");
                properties.setProperty("offsetAsPageNum", "true");
                properties.setProperty("rowBoundsWithCount", "true");
                properties.setProperty("supportMethodsArguments", "true");
                properties.setProperty("params", "count=countSql");
                properties.setProperty("autoRuntimeDialect", "true");
                pageInterceptor.setProperties(properties);
                configuration.addInterceptor(pageInterceptor);
            }
        };
    }
}
