package com.aws.s3;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;

@SpringBootApplication
public class AwsS3Application {

	private static final AWSCredentials credentials;
	private static String bucketName;

	static {
		// put your access key and secret key here
		credentials = new BasicAWSCredentials("AKIAVCZ63FJB5O3S3WMV", "U+PJ3pRwi9oq2GfFFlfXIk4LN59B1dX/0cdhZ1hy");
	}

	public static void main(String[] args) throws IOException {
		// set-up the client
		AmazonS3 s3client = AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.AP_SOUTH_1).build();

		AWSS3Service awsService = new AWSS3Service(s3client);

		bucketName = "hpebucket";

		// creating a bucket
		if (awsService.doesBucketExist(bucketName)) {
			System.out.println("Bucket name is not available." + " Try again with a different Bucket name.");
			return;
		}
		awsService.createBucket(bucketName);

		// list all the buckets
		for (Bucket s : awsService.listBuckets()) {
			System.out.println(s.getName());
		}

		// deleting bucket
		awsService.deleteBucket("hpebucket");

		// uploading object
		awsService.putObject(bucketName, "Document/hello.txt", new File("/Users/user/Document/hello.txt"));

		// listing objects
		ObjectListing objectListing = awsService.listObjects(bucketName);
		for (S3ObjectSummary os : objectListing.getObjectSummaries()) {
			System.out.println(os.getKey());
		}

		// downloading an object
		S3Object s3object = awsService.getObject(bucketName, "Document/hello.txt");
		S3ObjectInputStream inputStream = s3object.getObjectContent();
		FileUtils.copyInputStreamToFile(inputStream, new File("/Users/user/Desktop/hello.txt"));

		// copying an object
		awsService.copyObject("hpebucket", "picture/pic.png", "hpebucket", "Document/picture.png");

		// deleting an object
		awsService.deleteObject(bucketName, "Document/hello.txt");

		// deleting multiple objects
		String objkeyArr[] = { "Document/hello2.txt", "Document/picture.png" };

		DeleteObjectsRequest delObjReq = new DeleteObjectsRequest("hpebucket").withKeys(objkeyArr);
		awsService.deleteObjects(delObjReq);
	}
}