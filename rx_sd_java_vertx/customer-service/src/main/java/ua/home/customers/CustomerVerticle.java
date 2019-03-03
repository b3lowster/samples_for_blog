package ua.home.customers;

import ua.home.customers.util.ActionHelper;
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
import io.vertx.reactivex.ext.web.codec.BodyCodec;
import io.vertx.reactivex.ext.web.handler.BodyHandler;
import io.vertx.reactivex.servicediscovery.ServiceDiscovery;
import io.vertx.reactivex.servicediscovery.types.HttpEndpoint;

import java.util.List;

public class CustomerVerticle extends AbstractVerticle {

    private ServiceDiscovery discovery;

    private static final Logger logger = LoggerFactory.getLogger(CustomerVerticle.class);

    @Override
    public void start(Future<Void> fut) {
        Vertx vertx = Vertx.vertx();
        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());
        router.post("/api/customers/:id/accounts").handler(this::updateCustomerAccount);

        discovery = ServiceDiscovery.create(vertx);
        createHttpServer(router).subscribe((server, err) -> {
            if (err != null) {
                logger.error("Error while starting server", err);
            } else {
                logger.info("Server has been successfully started");
                discovery.rxGetRecords(record -> true)
                            .subscribe((records, throwable) -> {
                                logger.info(records);
                            });
            }
        });
    }

    private Single<HttpServer> createHttpServer(Router router) {
        return vertx
                .createHttpServer()
                .requestHandler(router)
                .rxListen(8090);
    }

    private void updateCustomerAccount(RoutingContext rc) {

        HttpEndpoint.rxGetWebClient(discovery, record -> {
                        return record.getName().equals("accounts");
                    })
                    .flatMap(httpClient -> {
                        return httpClient.get("/api")
                                    .as(BodyCodec.string())
                                    .rxSend();
                    }).subscribe((response, err) -> {
                        logger.info(response);
                        Single.just(new JsonObject("{\"customer\":\"test\"}")).subscribe(ActionHelper.ok(rc));
                    });
//        List<String> accounts = rc.getBodyAsJson().mapTo(List.class);
//        String customerId = rc.pathParam("id");
//        customerService.updateAccounts(customerId, accounts).subscribe(ActionHelper.ok(rc));
    }
}
