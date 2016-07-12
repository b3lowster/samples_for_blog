package ua.home.events.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.home.events.listener.AssetEventHandler;

/**
 * Vladimir Tsukanov
 *
 * @author tsv@ciklum.com
 */
@Configuration
public class AppConfig {

    @Bean
    AssetEventHandler assetEventHandler() {
        return new AssetEventHandler();
    }
}
