package com.dockerworkshop.fileservice;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.core.region.RegionProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Configuration {

    @Bean(name = "amazonS3Client")
    public AmazonS3 amazonS3Client(AWSCredentialsProvider credentialsProvider,
                                   RegionProvider regionProvider,
                                   @Value("${aws.s3.default-endpoint:https://s3.amazonaws.com}") String endpoint) {

        return AmazonS3ClientBuilder.standard()
                .withCredentials(credentialsProvider)
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(endpoint, regionProvider.getRegion().getName()))
                .build();
    }
}
