package cl.amsa.consultaservicios.datasources;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class Datasource {

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String userName;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.driver-class-name}")
	private String driver;

	@Bean
	public DataSource getDatasource() {
		@SuppressWarnings("rawtypes")
		DataSourceBuilder dataSoruceBuilder = DataSourceBuilder.create();
		dataSoruceBuilder.driverClassName(this.getDriver());
		dataSoruceBuilder.url(this.getUrl());
		dataSoruceBuilder.username(this.getUserName());
		dataSoruceBuilder.password(this.getPassword());
		return dataSoruceBuilder.build();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

}
