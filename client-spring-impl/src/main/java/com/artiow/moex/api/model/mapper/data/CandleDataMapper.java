package com.artiow.moex.api.model.mapper.data;

import com.artiow.moex.api.model.Candle;
import com.artiow.moex.api.model.mapper.extractor.AttributeExtractor;
import lombok.val;

public class CandleDataMapper extends AbstractDataStreamMapper<Candle> {

    @Override
    protected Candle rowMapping(AttributeExtractor.Processor processor) {
        val result = new Candle();
        result.setOpen(processor.readBigDecimal("open"));
        result.setClose(processor.readBigDecimal("close"));
        result.setHigh(processor.readBigDecimal("high"));
        result.setLow(processor.readBigDecimal("low"));
        result.setValue(processor.readBigDecimal("value"));
        result.setVolume(processor.readBigDecimal("volume"));
        result.setBegin(processor.readDateTime("begin"));
        result.setEnd(processor.readDateTime("end"));
        return result;
    }
}
