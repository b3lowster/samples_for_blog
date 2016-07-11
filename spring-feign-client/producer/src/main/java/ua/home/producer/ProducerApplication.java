package ua.home.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Vladimir Tsukanov
 *
 * @author tsv@ciklum.com
 */
@SpringBootApplication
@EnableFeignClients(basePackageClasses = ua.home.sharedclients.intr.AssetClient.class)
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

}
