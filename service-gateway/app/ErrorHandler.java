/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.encentral.test_project.commons.util.MyObjectMapper;
import com.google.common.collect.ImmutableMap;

import play.*;
import play.api.OptionalSourceMapper;
import play.api.routing.Router;
import play.http.DefaultHttpErrorHandler;
import play.mvc.Http.*;
import play.mvc.*;

import javax.inject.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 *
 * @author Akinniranye James Ayodele <kaimedavies@sycliff.com>
 */
@Singleton
public class ErrorHandler extends DefaultHttpErrorHandler {

    MyObjectMapper mapper;

    @Inject
    public ErrorHandler(Configuration configuration, Environment environment,
            OptionalSourceMapper sourceMapper, Provider<Router> routes, MyObjectMapper mapper) {
        super(configuration, environment, sourceMapper, routes);
        this.mapper = mapper;
    }

    private String covertToErrorMessage(String message) {
        message = message == null ? "" : message;
        try {
            return mapper.writeValueAsString(ImmutableMap.of("error", message));
        } catch (Exception e) {
        }
        return message;
    }

    @Override
    protected CompletionStage<Result> onForbidden(RequestHeader request, String message) {
        return CompletableFuture.completedFuture(
                Results.forbidden(covertToErrorMessage(message))
        );
    }

    protected CompletionStage<Result> onBadRequest(Http.RequestHeader rh, String message) {
        return CompletableFuture.completedFuture(
                Results.badRequest(covertToErrorMessage(message))
        );
    }

    protected CompletionStage<Result> onNotFound(Http.RequestHeader rh, String message) {
        return CompletableFuture.completedFuture(
                Results.notFound("Page not found for " + rh.path())
        );
    }

    public CompletionStage<Result> onServerError(Http.RequestHeader rh, Throwable thrwbl) {
        play.Logger.error("Server failed", thrwbl);
        return CompletableFuture.completedFuture(
                Results.internalServerError("Oops something went wrong")
        );
    }

}
