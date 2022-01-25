package com.futureaisoft.config;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@Configuration
@ConfigurationProperties(prefix = "app")
@ComponentScan(basePackages = "com.futureaisoft")
public class AppConfig {
    private List<String> authorizedRedirectUris = new ArrayList<>();

    private String tokenSecret;

    private long tokenExpirationMsec;

	public List<String> getAuthorizedRedirectUris() {
		return authorizedRedirectUris;
	}

	public void setAuthorizedRedirectUris(List<String> authorizedRedirectUris) {
		this.authorizedRedirectUris = authorizedRedirectUris;
	}

	public String getTokenSecret() {
		return tokenSecret;
	}

	public void setTokenSecret(String tokenSecret) {
		this.tokenSecret = tokenSecret;
	}

	public long getTokenExpirationMsec() {
		return tokenExpirationMsec;
	}

	public void setTokenExpirationMsec(long tokenExpirationMsec) {
		this.tokenExpirationMsec = tokenExpirationMsec;
	}
    
    
}