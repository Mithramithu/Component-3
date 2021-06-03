package com.tweetapp.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDBConfig {
	// @Value("${amazon.dynamodb.endpoint}")dynamodb.us-east-2.awazonaws.com
	public static final String SERVICE_ENDPOINT="dynamodb.us-east-2.amazonaws.com";
	// @Value("${amazon.aws.region}")
	public static final String REGION="us-east-2";
	// @Value("${amazon.aws.accesskey}")
	public static final String ACCESS_KEY="AKIARDB7PQGC7BHGRPXF";
	// @Value("${amazon.aws.secretkey}")
	public static final String SECRET_KEY="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";

	@Bean
	public DynamoDBMapper mapper() {
		return new DynamoDBMapper(amazonDynamoDBConfig());
	}

	private AmazonDynamoDB amazonDynamoDBConfig() {
		return AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(SERVICE_ENDPOINT, REGION))
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY)))
				.build();
	}
}
