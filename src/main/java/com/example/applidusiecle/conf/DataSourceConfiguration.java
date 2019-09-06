package com.example.applidusiecle.conf;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "com.risa.dao")
public class DataSourceConfiguration {

    @Value("${datasource.host}")
    private String host;

    @Value("${datasource.dbname}")
    private String dbName;

    @Value("${datasource.username}")
    private String username;

    @Value("${datasource.password}")
    private String password;

    @Value("${datasource.port}")
    private String port;

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://" + this.host + ":" + this.port + "/" + this.dbName);
        dataSource.setUsername(this.username);
        dataSource.setPassword(this.password);
        return dataSource;
    }
    

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(this.dataSource());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(final DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setFailFast(true);
        ssfb.setDataSource(dataSource);

        final PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        ssfb.setMapperLocations(resolver.getResources("classpath*:mapper/*Mapper.xml"));

        return ssfb.getObject();
    }

}
