package ua.home.accounts;

import ua.home.accounts.util.ActionHelper;
import io.reactivex.Single;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.reactivex.config.ConfigRetriever;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.core.http.HttpServer;
import io.vertx.reactivex.ext.mongo.MongoClient;
import io.vertx.reactivex.ext.web.Router;
import io.vertx.reactivex.ext.web.RoutingContext;
import io.vertx.reactivex.ext.web.handler.BodyHandler;
import io.vertx.reactivex.servicediscovery.ServiceDiscovery;
import io.vertx.reactivex.servicediscovery.types.HttpEndpoint;
import io.vertx.servicediscovery.Record;

public class AccountVerticle extends AbstractVerticle {

    private ServiceDiscovery discovery;

    private static final Logger logger = LoggerFactory.getLogger(AccountVerticle.class);

    @Override
    public void start(Future<Void> fut) {
        Vertx vertx = Vertx.vertx();
        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());
        router.get("/api/account").handler(this::get);

        discovery = ServiceDiscovery.create(vertx);
        createHttpServer(router).subscribe((server, err) -> {
            if (err != null) {
                logger.error("Error while starting server", err);
            } else {
                logger.info("Server has been successfully started");
                discovery.rxPublish(HttpEndpoint.createRecord("accounts", "localhost", 8080, "/api"))
                        .subscribe((rec,error) -> {
                            if (error != null) {
                                logger.error("Error while starting record", err);
                            } else {
                                logger.info("Record has been successfully published");
                                discovery.rxGetRecords(record -> true)
                                        .subscribe((records, throwable) -> {
                                            logger.info(records);
                                        });
                            }
                        });
            }
        });
    }

    private Single<HttpServer> createHttpServer(Router router) {
        return vertx
                .createHttpServer()
                .requestHandler(router)
                .rxListen(8080);
    }

    private void get(RoutingContext rc) {
        Single.just(new JsonObject("{\"account\":\"test\"}")).subscribe(ActionHelper.ok(rc));
    }
}
