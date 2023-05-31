package com.mylearning.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.zaxxer.hikari.HikariDataSource;

/**
 * ClassName: Datasource
 * Package: com.mylearning.datasource
 * Description:
 *
 * @Author: Steven_LIU
 * @Create: 26/5/2023 - 7:41 pm
 * @Version: v1.0
 */
@Configuration
public class Datasource {
    @Bean
    @ConfigurationProperties("app.datasource") // 这里的app.datasource就是指的是application.yaml文件中的app - datasource属性
    public HikariDataSource hikariDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
}
