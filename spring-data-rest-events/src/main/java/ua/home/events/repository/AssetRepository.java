package ua.home.events.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.home.events.pojo.Asset;

/**
 * Vladimir Tsukanov
 *
 * @author tsv@ciklum.com
 */
public interface AssetRepository extends MongoRepository<Asset, String> {
}
