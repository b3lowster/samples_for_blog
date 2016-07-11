package ua.home.consumer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ua.home.sharedclients.dto.Asset;
import ua.home.sharedclients.intr.AssetClient;

import java.util.Arrays;
import java.util.List;

/**
 * Vladimir Tsukanov
 *
 * @author tsv@ciklum.com
 */
@RestController
public class ConsumerController implements AssetClient {

    @Override
    public ResponseEntity<List<Asset>> getAssets() {
        return new ResponseEntity<List<Asset>>(Arrays.asList(new Asset("1", "name_1"), new Asset("2", "name_2")), HttpStatus.OK) ;
    }
}
