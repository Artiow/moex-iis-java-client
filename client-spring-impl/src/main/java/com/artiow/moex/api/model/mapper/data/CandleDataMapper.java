package com.artiow.moex.api.model.mapper.data;

import com.artiow.moex.api.model.Candle;
import com.artiow.moex.api.model.mapper.extractor.AttributeExtractor;
import lombok.val;

public class CandleDataMapper extends AbstractDataStreamMapper<Candle> {

    @Override
    protected Candle rowMapping(AttributeExtractor.Processor processor) {
        val result = new Candle();
        result.setOpen(processor.readString("open"));
        result.setClose(processor.readString("close"));
        result.setHigh(processor.readString("high"));
        result.setLow(processor.readString("low"));
        result.setValue(processor.readString("value"));
        result.setVolume(processor.readString("volume"));
        result.setBegin(processor.readString("begin"));
        result.setEnd(processor.readString("end"));
        return result;
    }
}
