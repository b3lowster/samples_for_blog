package ua.home.events.listener;

import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

/**
 * Vladimir Tsukanov
 *
 * @author tsv@ciklum.com
 */
@Component
public class AppEventListener extends AbstractRepositoryEventListener {

    @Override
    protected void onBeforeCreate(Object entity) {
        System.out.println("before create . common object" + entity.toString());
    }

    @Override
    protected void onAfterCreate(Object entity) {
        System.out.println("after create . common object" + entity.toString());
    }

    @Override
    protected void onBeforeSave(Object entity) {
        System.out.println("before save . common object" + entity.toString());
    }

    @Override
    protected void onAfterSave(Object entity) {
        System.out.println("after save . common object" + entity.toString());
    }
}
