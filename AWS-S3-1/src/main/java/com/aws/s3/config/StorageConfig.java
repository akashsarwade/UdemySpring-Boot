package com.aws.s3.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfig {

	@Value("${cloud.aws.credentials.access-key}")
	private String accesKey;
	@Value("${cloud.aws.credentials.secret-key}")
	private String secretKey;
	@Value("${cloud.aws.region.static}")
	private String region;
	
	
	public AmazonS3 generateS3Client() {
		Awsc
	}
	
	
}
