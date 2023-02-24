package io.algostrategy.client.omgfin.impl;

import io.algostrategy.client.omgfin.OmgfinApiError;
import io.algostrategy.client.omgfin.exception.OmgfinApiException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import static io.algostrategy.client.omgfin.impl.OmgfinApiServiceGenerator.getOmgfinApiError;

/**
 * An adapter/wrapper that transform a response to the {@link CompletableFuture}.
 */
public class RetrofitCallbackAdapter<T> implements Callback<T> {

    private final CompletableFuture<T> future;

    public RetrofitCallbackAdapter(CompletableFuture<T> future) {
        this.future = future;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            future.complete(response.body());
        } else {
            try {
                OmgfinApiError apiError = getOmgfinApiError(response);
                onFailure(call, new OmgfinApiException(apiError));
            } catch (IOException e) {
                onFailure(call, new OmgfinApiException(e));
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (t instanceof OmgfinApiException) {
            future.completeExceptionally(t);
        } else {
            future.completeExceptionally(new OmgfinApiException(t));
        }
    }
}
