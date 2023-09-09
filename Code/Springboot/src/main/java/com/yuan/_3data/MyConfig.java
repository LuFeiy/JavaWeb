package com.yuan._3data;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class MyConfig {

    @Bean
    @ConfigurationProperties("spring.datasource")//复用配置文件的数据源配置
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();

       //druidDataSource.setUrl();
       //druidDataSource.setUsername();
       //druidDataSource.setPassword();

        return druidDataSource;
    }
}
