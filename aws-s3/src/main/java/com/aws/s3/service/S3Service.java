package com.aws.s3.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.Region;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

@Service
public class S3Service {

	private final S3Client s3Client;
	private final String bucketName = "your-bucket-name";

	public S3Service(@Value("${aws.accessKey}") String accessKey, @Value("${aws.secretKey}") String secretKey) {
		AwsBasicCredentials awsCredentials = AwsBasicCredentials.create(accessKey, secretKey);
		this.s3Client = S3Client.builder().region(Region.AP_Mumbai)
				.credentialsProvider(StaticCredentialsProvider.create(awsCredentials)).build();
	}

	public void uploadFileToS3(File file) {
		PutObjectRequest request = PutObjectRequest.builder().bucket(bucketName).key(file.getName()).build();

		PutObjectResponse response = s3Client.putObject(request, file.toPath());
		System.out.println("File uploaded successfully. ETag: " + response.eTag());
	}
}