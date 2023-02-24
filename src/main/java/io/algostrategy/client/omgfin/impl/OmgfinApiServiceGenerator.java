package io.algostrategy.client.omgfin.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.algostrategy.client.omgfin.OmgfinApiError;
import io.algostrategy.client.omgfin.exception.OmgfinApiException;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;

import static io.algostrategy.client.omgfin.constant.OmgfinApiConstants.BASE_URL;

/**
 * Generates a Omgfin API implementation based on @see {@link OmgfinApiService}.
 */
public class OmgfinApiServiceGenerator {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Converter.Factory converterFactory = JacksonConverterFactory.create(mapper);
    @SuppressWarnings("unchecked")
    private static final Converter<ResponseBody, OmgfinApiError> errorBodyConverter =
            (Converter<ResponseBody, OmgfinApiError>) converterFactory.responseBodyConverter(
                    OmgfinApiError.class, new Annotation[0], null);

    static {
        mapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
    }

    private final OkHttpClient client;

    public OmgfinApiServiceGenerator(OkHttpClient client) {
        this.client = client;
    }

    public <S> S createService(Class<S> serviceClass) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(converterFactory)
                .client(client)
                .build();

        return retrofit.create(serviceClass);
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                OmgfinApiError apiError = getOmgfinApiError(response);
                throw new OmgfinApiException(apiError);
            }
        } catch (IOException e) {
            throw new OmgfinApiException(e);
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    public static OmgfinApiError getOmgfinApiError(Response<?> response) throws IOException, OmgfinApiException {
        return errorBodyConverter.convert(response.errorBody());
    }

}
