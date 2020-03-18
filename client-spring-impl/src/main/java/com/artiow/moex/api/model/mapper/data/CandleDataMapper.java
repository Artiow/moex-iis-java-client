package com.artiow.moex.api.model.mapper.data;

import com.artiow.moex.api.model.Candle;
import com.artiow.moex.api.model.mapper.extractor.AttributeExtractor;
import lombok.val;

public class CandleDataMapper extends AbstractDataStreamMapper<Candle> {

    @Override
    protected Candle rowMapping(AttributeExtractor.Processor processor) {
        val result = new Candle();
        result.setOpen(processor.readDouble("open"));
        result.setClose(processor.readDouble("close"));
        result.setHigh(processor.readDouble("high"));
        result.setLow(processor.readDouble("low"));
        result.setValue(processor.readDouble("value"));
        result.setVolume(processor.readDouble("volume"));
        result.setBegin(processor.readDatetime("begin"));
        result.setEnd(processor.readDatetime("end"));
        return result;
    }
}
