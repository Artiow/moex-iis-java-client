package com.artiow.moex.api.model.mapper.data;

import com.artiow.moex.api.model.SecurityPaperSearchResult;
import com.artiow.moex.api.model.mapper.extractor.AttributeExtractor;
import lombok.val;

public class SecurityPaperSearchResultDataMapper extends AbstractDataStreamMapper<SecurityPaperSearchResult> {

    @Override
    protected SecurityPaperSearchResult rowMapping(AttributeExtractor.Processor processor) {
        val result = new SecurityPaperSearchResult();
        result.setId(processor.readInteger("id"));
        result.setSecid(processor.readString("secid"));
        result.setShortname(processor.readString("shortname"));
        result.setRegnumber(processor.readString("regnumber"));
        result.setName(processor.readString("name"));
        result.setIsin(processor.readString("isin"));
        result.setIsTraded(processor.readBoolean("is_traded"));
        result.setEmitentId(processor.readInteger("emitent_id"));
        result.setEmitentTitle(processor.readString("emitent_title"));
        result.setEmitentInn(processor.readString("emitent_inn"));
        result.setEmitentOkpo(processor.readString("emitent_okpo"));
        result.setGosreg(processor.readString("gosreg"));
        result.setType(processor.readString("type"));
        result.setGroup(processor.readString("group"));
        result.setPrimaryBoardid(processor.readString("primary_boardid"));
        result.setMarketpriceBoardid(processor.readString("marketprice_boardid"));
        return result;
    }
}
