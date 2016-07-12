package ua.home.events.listener;

import org.springframework.data.rest.core.annotation.*;
import ua.home.events.pojo.Asset;

/**
 * Vladimir Tsukanov
 *
 * @author tsv@ciklum.com
 */
@RepositoryEventHandler(Asset.class)
public class AssetEventHandler {

    @HandleBeforeSave
    public void beforeSaveEvent(Asset asset) {
        System.out.println("before save . asset object" + asset.toString());
    }

    @HandleAfterSave
    public void afterSaveEvent(Asset asset) {
        System.out.println("after save . asset object" + asset.toString());
    }

    @HandleBeforeCreate
    public void beforeCreateEvent(Asset asset) {
        System.out.println("before create . asset object" + asset.toString());
    }

    @HandleAfterCreate
    public void afterCreateEvent(Asset asset) {
        System.out.println("after create . asset object" + asset.toString());
    }
}
