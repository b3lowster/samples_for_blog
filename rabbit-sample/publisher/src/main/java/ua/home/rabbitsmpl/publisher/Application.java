package ua.home.rabbitsmpl.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tsv@ciklum.com
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    AmqpTemplate amqpTemplate;

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        amqpTemplate.convertAndSend("q1", "message for q-1");
        amqpTemplate.convertAndSend("q2", "message for q-2");
    }
}
