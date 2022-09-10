package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String projectId = "my-gcp-4b96b";
		String bucketName="bucketdemoir03";
		Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
		storage.create(BucketInfo.of(bucketName));
	}

}
