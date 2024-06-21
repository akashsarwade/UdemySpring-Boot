package com.aws.s3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

@SpringBootApplication
public class AwsS3FileUploadingApplication implements CommandLineRunner {

	@Autowired
	private AmazonS3 s3Client;
	
	public static void main(String[] args) {
		SpringApplication.run(AwsS3FileUploadingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("List Of Files..");
		ListObjectsRequest listObjectsRequest = new ListObjectsRequest()
			    .withBucketName("hpebucket");
			ObjectListing objectListing;

			do {
			        objectListing = s3Client.listObjects(listObjectsRequest);
			        for (S3ObjectSummary objectSummary : 
			            objectListing.getObjectSummaries()) {
			            System.out.println( " - " + objectSummary.getKey() + "  " +
			                    "(size = " + objectSummary.getSize() + 
			                    ")");
			        }
			        listObjectsRequest.setMarker(objectListing.getNextMarker());
			} while (objectListing.isTruncated());
	        
	}

}
