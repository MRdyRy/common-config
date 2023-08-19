package com.rudy.ryanto.commonconfig.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HikariDatasourceConfig {

    /**
     * This class is configuration for datasource
     */
    @Value("${db.host}")
    private String host;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    @Value("${db.max.pool}")
    private String maxPool;
    @Value("${db.min.pool}")
    private String minPool;
    @Value("${db.driver.class.name}")
    private String driverClassName;
    @Value("${db.min.pool.idle}")
    private String minPoolIdle;
    @Value("${db.leak.detect.threshold}")
    private String leakDetectionThreshold;
    @Value("${db.max.life.time}")
    private String maxLifeTime;
    @Value("${db.connect.time.out}")
    private String connectionTimeOut;
    @Value("${db.keepAlive}")
    private String keepAlive;

    public HikariConfig hikariConfig() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(host);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.setDriverClassName(driverClassName);
        hikariConfig.setMaximumPoolSize(Integer.parseInt(maxPool));
        hikariConfig.setMaximumPoolSize(Integer.parseInt(minPool));
        hikariConfig.setMinimumIdle(Integer.parseInt(minPoolIdle));
        hikariConfig.setLeakDetectionThreshold(Long.parseLong(leakDetectionThreshold));
        hikariConfig.setMaxLifetime(Long.parseLong(maxLifeTime));
        hikariConfig.setConnectionTimeout(Long.parseLong(connectionTimeOut));
        hikariConfig.setKeepaliveTime(Long.parseLong(keepAlive));
        hikariConfig.setPoolName("db-pool-");
        return hikariConfig;
    }

    @Bean
    public static HikariDataSource hikariDataSource() {
        return new HikariDataSource(hikariDataSource());
    }
}