package ua.home.configurationproperties.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Vladimir Tsukanov
 *
 * @author tsv@ciklum.com
 */
@Component
@ConfigurationProperties(prefix = "s", locations = "classpath:map.properties")
public class PojoMap {

    private Map<String, String> servers = new HashMap<>();

    public Map<String, String> getServers() {
        return servers;
    }
}
