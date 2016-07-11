package ua.home.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.home.sharedclients.intr.AssetClient;

/**
 * Vladimir Tsukanov
 *
 * @author tsv@ciklum.com
 */
@RestController
public class ProducerController {

    @Autowired
    private AssetClient assetClient;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    private void requestAssets() {
        assetClient.getAssets().getBody()
                .forEach(asset -> System.out.printf(asset.toString()));
    }
}
