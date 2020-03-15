package com.artiow.moex.api;

import com.artiow.moex.api.client.MoexApiClient;
import com.artiow.moex.api.model.SecurityPaperSearchResult;
import com.artiow.moex.api.model.SecurityPaperSpecification;
import com.artiow.moex.api.model.mapper.DocumentMapper;
import com.artiow.moex.api.model.mapper.SecurityPaperSearchResultMapper;
import lombok.val;

import java.util.List;

import static com.artiow.moex.api.util.QueryParamsBuilder.queryParamsBuilder;
import static com.artiow.moex.api.util.UriParamsBuilder.uriParamsBuilder;

public class SecurityPaperClient implements SecurityPaperResource {

    private final MoexApiClient client;

    private final DocumentMapper<List<SecurityPaperSearchResult>> searchResultMapper;
    private final DocumentMapper<SecurityPaperSpecification> specificationMapper;


    public SecurityPaperClient(MoexApiClient client) {
        this.client = client;
        this.searchResultMapper = new SecurityPaperSearchResultMapper();
        this.specificationMapper = __ -> { throw new UnsupportedOperationException(); };
    }


    @Override
    public List<SecurityPaperSearchResult> search(
            String query,
            String engine,
            String market,
            Boolean isTraded,
            Integer start,
            Integer limit,
            String lang
    ) {
        val queryParams = queryParamsBuilder(5)
                .set("q", query)
                .set("engine", engine)
                .set("market", market)
                .set("is_trading", isTraded)
                .set("start", start)
                .set("limit", limit)
                .set("lang", lang);

        return searchResultMapper.map(client.request(
                "https://iss.moex.com/iss/securities.xml", queryParams.build()
        ));
    }

    @Override
    public SecurityPaperSpecification getSpecification(
            String secid,
            String lang
    ) {
        val uriParams = uriParamsBuilder(1)
                .set("secid", secid);

        val queryParams = queryParamsBuilder(1)
                .set("lang", lang);

        return specificationMapper.map(client.request(
                "https://iss.moex.com/iss/securities/{secid}.xml", uriParams.build(), queryParams.build()
        ));
    }
}
