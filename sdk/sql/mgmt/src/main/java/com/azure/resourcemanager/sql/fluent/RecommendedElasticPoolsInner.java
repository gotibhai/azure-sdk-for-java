// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.sql.fluent;

import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.Headers;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.management.exception.ManagementException;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.sql.fluent.inner.RecommendedElasticPoolInner;
import com.azure.resourcemanager.sql.fluent.inner.RecommendedElasticPoolListMetricsResultInner;
import com.azure.resourcemanager.sql.fluent.inner.RecommendedElasticPoolListResultInner;
import com.azure.resourcemanager.sql.fluent.inner.RecommendedElasticPoolMetricInner;
import reactor.core.publisher.Mono;

/** An instance of this class provides access to all the operations defined in RecommendedElasticPools. */
public final class RecommendedElasticPoolsInner {
    private final ClientLogger logger = new ClientLogger(RecommendedElasticPoolsInner.class);

    /** The proxy service used to perform REST calls. */
    private final RecommendedElasticPoolsService service;

    /** The service client containing this operation class. */
    private final SqlManagementClientImpl client;

    /**
     * Initializes an instance of RecommendedElasticPoolsInner.
     *
     * @param client the instance of the service client containing this operation class.
     */
    RecommendedElasticPoolsInner(SqlManagementClientImpl client) {
        this.service =
            RestProxy
                .create(RecommendedElasticPoolsService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for SqlManagementClientRecommendedElasticPools to be used by the proxy
     * service to perform REST calls.
     */
    @Host("{$host}")
    @ServiceInterface(name = "SqlManagementClientR")
    private interface RecommendedElasticPoolsService {
        @Headers({"Accept: application/json", "Content-Type: application/json"})
        @Get(
            "/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Sql"
                + "/servers/{serverName}/recommendedElasticPools/{recommendedElasticPoolName}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<SimpleResponse<RecommendedElasticPoolInner>> get(
            @HostParam("$host") String host,
            @QueryParam("api-version") String apiVersion,
            @PathParam("subscriptionId") String subscriptionId,
            @PathParam("resourceGroupName") String resourceGroupName,
            @PathParam("serverName") String serverName,
            @PathParam("recommendedElasticPoolName") String recommendedElasticPoolName,
            Context context);

        @Headers({"Accept: application/json", "Content-Type: application/json"})
        @Get(
            "/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Sql"
                + "/servers/{serverName}/recommendedElasticPools")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<SimpleResponse<RecommendedElasticPoolListResultInner>> listByServer(
            @HostParam("$host") String host,
            @QueryParam("api-version") String apiVersion,
            @PathParam("subscriptionId") String subscriptionId,
            @PathParam("resourceGroupName") String resourceGroupName,
            @PathParam("serverName") String serverName,
            Context context);

        @Headers({"Accept: application/json", "Content-Type: application/json"})
        @Get(
            "/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Sql"
                + "/servers/{serverName}/recommendedElasticPools/{recommendedElasticPoolName}/metrics")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<SimpleResponse<RecommendedElasticPoolListMetricsResultInner>> listMetrics(
            @HostParam("$host") String host,
            @QueryParam("api-version") String apiVersion,
            @PathParam("subscriptionId") String subscriptionId,
            @PathParam("resourceGroupName") String resourceGroupName,
            @PathParam("serverName") String serverName,
            @PathParam("recommendedElasticPoolName") String recommendedElasticPoolName,
            Context context);
    }

    /**
     * Gets a recommended elastic pool.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value
     *     from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param recommendedElasticPoolName The name of the recommended elastic pool to be retrieved.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a recommended elastic pool.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<RecommendedElasticPoolInner>> getWithResponseAsync(
        String resourceGroupName, String serverName, String recommendedElasticPoolName) {
        if (this.client.getHost() == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter this.client.getHost() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (serverName == null) {
            return Mono.error(new IllegalArgumentException("Parameter serverName is required and cannot be null."));
        }
        if (recommendedElasticPoolName == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter recommendedElasticPoolName is required and cannot be null."));
        }
        final String apiVersion = "2014-04-01";
        return FluxUtil
            .withContext(
                context ->
                    service
                        .get(
                            this.client.getHost(),
                            apiVersion,
                            this.client.getSubscriptionId(),
                            resourceGroupName,
                            serverName,
                            recommendedElasticPoolName,
                            context))
            .subscriberContext(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext())));
    }

    /**
     * Gets a recommended elastic pool.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value
     *     from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param recommendedElasticPoolName The name of the recommended elastic pool to be retrieved.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a recommended elastic pool.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SimpleResponse<RecommendedElasticPoolInner>> getWithResponseAsync(
        String resourceGroupName, String serverName, String recommendedElasticPoolName, Context context) {
        if (this.client.getHost() == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter this.client.getHost() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (serverName == null) {
            return Mono.error(new IllegalArgumentException("Parameter serverName is required and cannot be null."));
        }
        if (recommendedElasticPoolName == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter recommendedElasticPoolName is required and cannot be null."));
        }
        final String apiVersion = "2014-04-01";
        return service
            .get(
                this.client.getHost(),
                apiVersion,
                this.client.getSubscriptionId(),
                resourceGroupName,
                serverName,
                recommendedElasticPoolName,
                context);
    }

    /**
     * Gets a recommended elastic pool.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value
     *     from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param recommendedElasticPoolName The name of the recommended elastic pool to be retrieved.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a recommended elastic pool.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<RecommendedElasticPoolInner> getAsync(
        String resourceGroupName, String serverName, String recommendedElasticPoolName) {
        return getWithResponseAsync(resourceGroupName, serverName, recommendedElasticPoolName)
            .flatMap(
                (SimpleResponse<RecommendedElasticPoolInner> res) -> {
                    if (res.getValue() != null) {
                        return Mono.just(res.getValue());
                    } else {
                        return Mono.empty();
                    }
                });
    }

    /**
     * Gets a recommended elastic pool.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value
     *     from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param recommendedElasticPoolName The name of the recommended elastic pool to be retrieved.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a recommended elastic pool.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public RecommendedElasticPoolInner get(
        String resourceGroupName, String serverName, String recommendedElasticPoolName) {
        return getAsync(resourceGroupName, serverName, recommendedElasticPoolName).block();
    }

    /**
     * Returns recommended elastic pools.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value
     *     from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents the response to a list recommended elastic pool request.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<RecommendedElasticPoolInner>> listByServerSinglePageAsync(
        String resourceGroupName, String serverName) {
        if (this.client.getHost() == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter this.client.getHost() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (serverName == null) {
            return Mono.error(new IllegalArgumentException("Parameter serverName is required and cannot be null."));
        }
        final String apiVersion = "2014-04-01";
        return FluxUtil
            .withContext(
                context ->
                    service
                        .listByServer(
                            this.client.getHost(),
                            apiVersion,
                            this.client.getSubscriptionId(),
                            resourceGroupName,
                            serverName,
                            context))
            .<PagedResponse<RecommendedElasticPoolInner>>map(
                res ->
                    new PagedResponseBase<>(
                        res.getRequest(), res.getStatusCode(), res.getHeaders(), res.getValue().value(), null, null))
            .subscriberContext(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext())));
    }

    /**
     * Returns recommended elastic pools.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value
     *     from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents the response to a list recommended elastic pool request.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<RecommendedElasticPoolInner>> listByServerSinglePageAsync(
        String resourceGroupName, String serverName, Context context) {
        if (this.client.getHost() == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter this.client.getHost() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (serverName == null) {
            return Mono.error(new IllegalArgumentException("Parameter serverName is required and cannot be null."));
        }
        final String apiVersion = "2014-04-01";
        return service
            .listByServer(
                this.client.getHost(),
                apiVersion,
                this.client.getSubscriptionId(),
                resourceGroupName,
                serverName,
                context)
            .map(
                res ->
                    new PagedResponseBase<>(
                        res.getRequest(), res.getStatusCode(), res.getHeaders(), res.getValue().value(), null, null));
    }

    /**
     * Returns recommended elastic pools.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value
     *     from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents the response to a list recommended elastic pool request.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<RecommendedElasticPoolInner> listByServerAsync(String resourceGroupName, String serverName) {
        return new PagedFlux<>(() -> listByServerSinglePageAsync(resourceGroupName, serverName));
    }

    /**
     * Returns recommended elastic pools.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value
     *     from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents the response to a list recommended elastic pool request.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<RecommendedElasticPoolInner> listByServerAsync(
        String resourceGroupName, String serverName, Context context) {
        return new PagedFlux<>(() -> listByServerSinglePageAsync(resourceGroupName, serverName, context));
    }

    /**
     * Returns recommended elastic pools.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value
     *     from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents the response to a list recommended elastic pool request.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<RecommendedElasticPoolInner> listByServer(String resourceGroupName, String serverName) {
        return new PagedIterable<>(listByServerAsync(resourceGroupName, serverName));
    }

    /**
     * Returns recommended elastic pool metrics.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value
     *     from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param recommendedElasticPoolName The name of the recommended elastic pool to be retrieved.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents the response to a list recommended elastic pool metrics request.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<RecommendedElasticPoolMetricInner>> listMetricsSinglePageAsync(
        String resourceGroupName, String serverName, String recommendedElasticPoolName) {
        if (this.client.getHost() == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter this.client.getHost() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (serverName == null) {
            return Mono.error(new IllegalArgumentException("Parameter serverName is required and cannot be null."));
        }
        if (recommendedElasticPoolName == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter recommendedElasticPoolName is required and cannot be null."));
        }
        final String apiVersion = "2014-04-01";
        return FluxUtil
            .withContext(
                context ->
                    service
                        .listMetrics(
                            this.client.getHost(),
                            apiVersion,
                            this.client.getSubscriptionId(),
                            resourceGroupName,
                            serverName,
                            recommendedElasticPoolName,
                            context))
            .<PagedResponse<RecommendedElasticPoolMetricInner>>map(
                res ->
                    new PagedResponseBase<>(
                        res.getRequest(), res.getStatusCode(), res.getHeaders(), res.getValue().value(), null, null))
            .subscriberContext(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext())));
    }

    /**
     * Returns recommended elastic pool metrics.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value
     *     from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param recommendedElasticPoolName The name of the recommended elastic pool to be retrieved.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents the response to a list recommended elastic pool metrics request.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PagedResponse<RecommendedElasticPoolMetricInner>> listMetricsSinglePageAsync(
        String resourceGroupName, String serverName, String recommendedElasticPoolName, Context context) {
        if (this.client.getHost() == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter this.client.getHost() is required and cannot be null."));
        }
        if (this.client.getSubscriptionId() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getSubscriptionId() is required and cannot be null."));
        }
        if (resourceGroupName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null."));
        }
        if (serverName == null) {
            return Mono.error(new IllegalArgumentException("Parameter serverName is required and cannot be null."));
        }
        if (recommendedElasticPoolName == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter recommendedElasticPoolName is required and cannot be null."));
        }
        final String apiVersion = "2014-04-01";
        return service
            .listMetrics(
                this.client.getHost(),
                apiVersion,
                this.client.getSubscriptionId(),
                resourceGroupName,
                serverName,
                recommendedElasticPoolName,
                context)
            .map(
                res ->
                    new PagedResponseBase<>(
                        res.getRequest(), res.getStatusCode(), res.getHeaders(), res.getValue().value(), null, null));
    }

    /**
     * Returns recommended elastic pool metrics.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value
     *     from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param recommendedElasticPoolName The name of the recommended elastic pool to be retrieved.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents the response to a list recommended elastic pool metrics request.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<RecommendedElasticPoolMetricInner> listMetricsAsync(
        String resourceGroupName, String serverName, String recommendedElasticPoolName) {
        return new PagedFlux<>(
            () -> listMetricsSinglePageAsync(resourceGroupName, serverName, recommendedElasticPoolName));
    }

    /**
     * Returns recommended elastic pool metrics.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value
     *     from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param recommendedElasticPoolName The name of the recommended elastic pool to be retrieved.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents the response to a list recommended elastic pool metrics request.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<RecommendedElasticPoolMetricInner> listMetricsAsync(
        String resourceGroupName, String serverName, String recommendedElasticPoolName, Context context) {
        return new PagedFlux<>(
            () -> listMetricsSinglePageAsync(resourceGroupName, serverName, recommendedElasticPoolName, context));
    }

    /**
     * Returns recommended elastic pool metrics.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value
     *     from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param recommendedElasticPoolName The name of the recommended elastic pool to be retrieved.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return represents the response to a list recommended elastic pool metrics request.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<RecommendedElasticPoolMetricInner> listMetrics(
        String resourceGroupName, String serverName, String recommendedElasticPoolName) {
        return new PagedIterable<>(listMetricsAsync(resourceGroupName, serverName, recommendedElasticPoolName));
    }
}
