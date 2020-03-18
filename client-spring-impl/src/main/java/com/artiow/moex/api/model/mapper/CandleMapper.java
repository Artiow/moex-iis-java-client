package com.artiow.moex.api.model.mapper;

import com.artiow.moex.api.model.Candle;
import com.artiow.moex.api.model.mapper.data.CandleDataMapper;

public class CandleMapper extends AbstractDocumentStreamMapper<Candle> {

    public CandleMapper() {
        super(new CandleDataMapper(), "candles");
    }
}
