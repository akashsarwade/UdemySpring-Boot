package com.upload.file.s3.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;

@Service
public class FileStoreService {

	private final AmazonS3 amazonS3 = null;

	public void upload(String path, String fileName, Optional<Map<String, String>> optionalMetaData,
			InputStream inputStream) {
		ObjectMetadata objectMetadata = new ObjectMetadata();
		optionalMetaData.ifPresent(map -> {
			if (!map.isEmpty()) {
				map.forEach(objectMetadata::addUserMetadata);
			}
		});
		try {
			amazonS3.putObject(path, fileName, inputStream, objectMetadata);
		} catch (Exception e) {
			throw new IllegalStateException("Failde to upload file", e);
		}
	}

	public byte[] download(String path, String key) {
		try {
			com.amazonaws.services.s3.model.S3Object obj = amazonS3.getObject(path, key);
			S3ObjectInputStream objectContent = obj.getObjectContent();
			return IOUtils.toByteArray(objectContent);
		} catch (AmazonServiceException | IOException e) {
			throw new IllegalStateException("Failde to download the file", e);
		}
	}
}
