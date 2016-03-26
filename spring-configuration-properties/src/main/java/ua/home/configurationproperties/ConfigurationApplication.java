package ua.home.configurationproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.home.configurationproperties.pojo.PojoList;
import ua.home.configurationproperties.pojo.PojoListContainer;
import ua.home.configurationproperties.pojo.PojoMap;
import ua.home.configurationproperties.pojo.PojoSample;

/**
 * @author tsv@ciklum.com
 */
@SpringBootApplication
public class ConfigurationApplication implements CommandLineRunner {

    @Autowired
    private PojoList pojoList;

    @Autowired
    private PojoMap pojoMap;

    @Autowired
    private PojoSample pojoSample;

    @Autowired
    private PojoListContainer pojoListContainer;

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationApplication.class, args);
    }

    public void run(String... args) throws Exception {
        pojoList.getServers();
        pojoMap.getServers();
        pojoSample.toString();
        pojoListContainer.getServers();
    }
}
