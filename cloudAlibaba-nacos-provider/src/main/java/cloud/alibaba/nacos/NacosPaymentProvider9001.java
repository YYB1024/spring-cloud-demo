package cloud.alibaba.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yangyanbin
 * @since 20231011
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class NacosPaymentProvider9001 {
    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentProvider9001.class,args);
    }
}
