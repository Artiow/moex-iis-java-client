package com.artiow.moex.api.model.mapper.data;

import com.artiow.moex.api.model.Market;
import com.artiow.moex.api.model.mapper.extractor.AttributeExtractor;
import lombok.val;

public class MarketDataMapper extends AbstractDataStreamMapper<Market> {

    @Override
    protected Market rowMapping(AttributeExtractor.Processor processor) {
        val result = new Market();
        result.setId(processor.readInteger("id"));
        result.setName(processor.readString("NAME"));
        result.setTitle(processor.readString("title"));
        return result;
    }
}
