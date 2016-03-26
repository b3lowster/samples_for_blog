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
@ConfigurationProperties(prefix="sm", locations = "classpath:pojolist.properties")
public class PojoListContainer {

    private List<PojoSample> servers = new ArrayList<>();

    public List<PojoSample> getServers() {
        return servers;
    }

    public void setServers(List<PojoSample> servers) {
        this.servers = servers;
    }
}
