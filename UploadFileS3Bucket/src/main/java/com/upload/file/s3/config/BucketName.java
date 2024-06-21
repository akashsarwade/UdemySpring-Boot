package com.upload.file.s3.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
In the BucketName enum above we pass in the bucket name that we created in the Amazon console earlier. The bucket will be used to store all of our file uploads.

@AllArgsConstructor annotation generates a constructor with the bucketName variable in the enum.
@Getter annotation generates a getter for the bucketName variable in the enum.
*/

@AllArgsConstructor
@Getter
public enum BucketName {

	TODO_IMAGE("spring-amazon-storage");

	private final String bucketNameq;

}
