package io.algostrategy.client.omgfin;

import io.algostrategy.client.omgfin.impl.OmgfinApiAsyncRestClientImpl;
import io.algostrategy.client.omgfin.impl.OmgfinApiRestClientImpl;
import io.algostrategy.client.omgfin.impl.OmgfinApiService;
import io.algostrategy.client.omgfin.impl.OmgfinApiServiceGenerator;
import okhttp3.OkHttpClient;

/**
 * A factory for creating Omgfin API client objects.
 */
public class OmgfinApiClientFactory {

    private final OmgfinApiServiceGenerator serviceGenerator;

    public OmgfinApiClientFactory() {
        this.serviceGenerator = new OmgfinApiServiceGenerator(new OkHttpClient());
    }

    public OmgfinApiClientFactory(ApiInteractionConfig apiInteractionConfig) {
        this(new OkHttpClient(), apiInteractionConfig);
    }

    public OmgfinApiClientFactory(OkHttpClient client, ApiInteractionConfig apiInteractionConfig) {
        OkHttpClient newClient = client.newBuilder()
                .proxySelector(new CustomProxySelector(apiInteractionConfig.getProxies()))
                .addInterceptor(new RateLimitInterceptor(
                        apiInteractionConfig.getMaxRequestsPerSecond(),
                        apiInteractionConfig.getMaxApiKeyUsagePerSecond()
                )).build();
        this.serviceGenerator = new OmgfinApiServiceGenerator(newClient);
    }

    /**
     * New instance without authentication.
     *
     * @return the Omgfin API client factory
     */
    public static OmgfinApiClientFactory newInstance() {
        return new OmgfinApiClientFactory();
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public OmgfinApiRestClient newRestClient() {
        return new OmgfinApiRestClientImpl(serviceGenerator.createService(OmgfinApiService.class));
    }

    /**
     * Creates a new asynchronous/non-blocking REST client.
     */
    public OmgfinApiAsyncRestClient newAsyncRestClient() {
        return new OmgfinApiAsyncRestClientImpl(serviceGenerator.createService(OmgfinApiService.class));
    }
}
