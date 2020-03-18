package com.artiow.moex.api.model.mapper;

import com.artiow.moex.api.model.Market;
import com.artiow.moex.api.model.mapper.data.MarketDataMapper;

public class MarketMapper extends AbstractDocumentStreamMapper<Market> {

    public MarketMapper() {
        super(new MarketDataMapper(), "markets");
    }
}
