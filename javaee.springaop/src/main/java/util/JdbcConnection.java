package util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.stereotype.Component;

/**
 * @author ckf48
 */
@Component
public class JdbcConnection {
    private HikariDataSource hikariDataSource;

    public JdbcConnection() {
        final String url = "jdbc:mysql://127.0.0.1:3306/homeworks?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
        final String driverName = "com.mysql.cj.jdbc.Driver";
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("123456");
        hikariConfig.setDriverClassName(driverName);
        hikariConfig.setJdbcUrl(url);
        hikariDataSource = new HikariDataSource(hikariConfig);

        hikariDataSource.setIdleTimeout(60000);
        hikariDataSource.setConnectionTimeout(60000);
        hikariDataSource.setValidationTimeout(3000);
        hikariDataSource.setMaxLifetime(60000);
        hikariDataSource.setMaximumPoolSize(10);
    }

    public HikariDataSource getHikariDataSource() {
        return hikariDataSource;
    }
}
