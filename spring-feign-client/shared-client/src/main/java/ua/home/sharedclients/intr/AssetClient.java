package ua.home.sharedclients.intr;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.home.sharedclients.dto.Asset;

import java.util.List;

/**
 * Vladimir Tsukanov
 *
 * @author tsv@ciklum.com
 */
@FeignClient(name = "consumer", url = "http://localhost:8081")
public interface AssetClient {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    ResponseEntity<List<Asset>> getAssets();
}
