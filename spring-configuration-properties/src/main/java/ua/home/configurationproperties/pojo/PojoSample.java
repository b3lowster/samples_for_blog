package ua.home.configurationproperties.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Vladimir Tsukanov
 *
 * @author tsv@ciklum.com
 */
@Component
@ConfigurationProperties(prefix = "pj", locations = "classpath:pojo.properties")
public class PojoSample {

    private String host;

    private int port;

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "PojoSample{" +
                "host='" + host + '\'' +
                ", port=" + port +
                '}';
    }
}
