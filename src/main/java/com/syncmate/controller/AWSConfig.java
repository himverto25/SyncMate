// code referenced from internet
/*
Spring-Boot based starters to connect to AWS services such as EC2 instance, ELB
i.e. Elastic Load Balancer, AWS RDS etc.
*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.elasticloadbalancingv2.AmazonElasticLoadBalancing;
import com.amazonaws.services.elasticloadbalancingv2.AmazonElasticLoadBalancingClientBuilder;
import com.amazonaws.services.elasticloadbalancingv2.model.DescribeTargetGroupsRequest;
import com.amazonaws.services.elasticloadbalancingv2.model.DescribeTargetGroupsResult;

@SpringBootApplication
public class AWSConfig {

    public static void main(String[] args) {
        SpringApplication.run(AWSConfig.class, args);
    }

    @Bean
    public AmazonEC2 amazonEC2Client() {
        // access key and secret access key both are required to authenticate to AWS
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials("accessKey", "secretKey");
        return AmazonEC2ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }

    @Bean
    public AmazonElasticLoadBalancing amazonELBClient() {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials("accessKey", "secretKey");
        return AmazonElasticLoadBalancingClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }

    // Example method to interact with AWS services
    public void describeTargetGroups(AmazonElasticLoadBalancing elbClient) {
        DescribeTargetGroupsRequest request = new DescribeTargetGroupsRequest();
        DescribeTargetGroupsResult result = elbClient.describeTargetGroups(request);
        // Processing to be done as required
        // as per the real-time implementation
    }
}
