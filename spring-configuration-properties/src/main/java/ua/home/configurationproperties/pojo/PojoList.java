package ua.home.configurationproperties.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Vladimir Tsukanov
 *
 * @author tsv@ciklum.com
 */
@Component
@ConfigurationProperties(prefix="my", locations = "classpath:list.properties")
public class PojoList {

    private List<String> servers = new ArrayList<>();

    public List<String> getServers() {
        return this.servers;
    }
}
