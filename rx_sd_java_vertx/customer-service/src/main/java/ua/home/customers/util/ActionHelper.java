package ua.home.customers.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.vertx.core.json.Json;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.reactivex.ext.web.RoutingContext;

import java.util.NoSuchElementException;

public class ActionHelper {

    private static final Logger logger = LoggerFactory.getLogger(ActionHelper.class);

    /**
     * Returns a bi-consumer writing the received {@link AsyncResult} to the routing context and setting
     * the HTTP status to the given status.
     *
     * @param context the routing context
     * @param status  the status
     * @return the bi-consumer
     */
    private static <T> BiConsumer<T, Throwable> writeJsonResponse(RoutingContext context, int status) {
        return (res, err) -> {
            if (err != null) {
                if (err instanceof NoSuchElementException) {
                    context.response().setStatusCode(404).end(err.getMessage());
                } else {
                    context.fail(err);
                }
            } else {
                if (res instanceof String) {
                        context.response().setStatusCode(status)
                                            .putHeader("content-type", "application/json; charset=utf-8")
                                            .end(Json.encodePrettily(res));
                } else {
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
                    try {
                        logger.error(String.format("Customer has been successfully created: %s", Json.encodePrettily(mapper.writeValueAsString(res))));
                        context.response()
                                .setStatusCode(status)
                                .putHeader("Content-type", "application/json; charset=utf-8")
                                .end(mapper.writeValueAsString(res));
                    } catch (JsonProcessingException e) {
                        context.response().setStatusCode(500).setStatusMessage("Cannot serialize object").end();
                    }
                }
            }
        };
    }

    public static <T> BiConsumer<T, Throwable> ok(RoutingContext rc) {
        return writeJsonResponse(rc, 200);
    }

    public static <T> BiConsumer<T, Throwable> created(RoutingContext rc) {
        return writeJsonResponse(rc, 201);
    }

    public static Action noContent(RoutingContext rc) {
        return () -> rc.response().setStatusCode(204).end();
    }

    public static Consumer<Throwable> onError(RoutingContext rc) {
        return err -> {
            if (err instanceof NoSuchElementException) {
                rc.response().setStatusCode(404).end(err.getMessage());
            } else {
                rc.fail(err);
            }
        };
    }
}
