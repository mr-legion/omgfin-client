package io.algostrategy.client.omgfin.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.algostrategy.client.omgfin.constant.OmgfinApiConstants;
import io.algostrategy.client.omgfin.domain.web.AssetFee;
import io.algostrategy.client.omgfin.exception.OmgfinWebParsingException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to parse Omgfin web pages.
 */
public class OmgfinWebParser {

    private static final String FEE_PATH = "/exchange/hypertext/fee_table";

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final OkHttpClient okHttpClient;

    public OmgfinWebParser(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public List<AssetFee> parseAssetFees() {

        Request request = new Request.Builder().url(OmgfinApiConstants.BASE_URL + FEE_PATH).build();

        try (Response response = okHttpClient.newCall(request).execute()) {

            List<AssetFee> assetFees = new ArrayList<>();

            Document doc = Jsoup.parse(response.body().string());

            Elements trs = doc.select("table tbody tr");

            for (int i = 2; i < trs.size(); i++) {

                Element tr = trs.get(i);
                Elements tds = tr.getElementsByTag("td");

                String assetSymbol = tds.get(0).firstElementChild().text();
                Double withdrawFee = Double.parseDouble(tds.get(5).firstElementChild().text().split(" ")[0]);

                assetFees.add(new AssetFee(assetSymbol, withdrawFee));
            }

            return assetFees;
        } catch (Exception e) {
            throw new OmgfinWebParsingException("failed to parse asset fees", e);
        }
    }
}
