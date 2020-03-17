package com.artiow.moex.api.model.mapper.table;

import com.artiow.moex.api.model.SecurityPaperBoard;
import com.artiow.moex.api.model.mapper.extractor.AttributeExtractor;
import lombok.val;

public class SecurityPaperBoardTableMapper extends AbstractTableMapper<SecurityPaperBoard> {

    @Override
    protected SecurityPaperBoard rowMapping(AttributeExtractor.Processor processor) {
        val result = new SecurityPaperBoard();
        result.setSecid(processor.readString("secid"));
        result.setBoardid(processor.readString("boardid"));
        result.setTitle(processor.readString("title"));
        result.setBoardGroupId(processor.readInteger("board_group_id"));
        result.setMarketId(processor.readInteger("market_id"));
        result.setMarket(processor.readString("market"));
        result.setEngineId(processor.readInteger("engine_id"));
        result.setEngine(processor.readString("engine"));
        result.setIsTraded(processor.readBoolean("is_traded"));
        result.setDecimals(processor.readInteger("decimals"));
        result.setHistoryFrom(processor.readDate("history_from"));
        result.setHistoryTill(processor.readDate("history_till"));
        result.setListedFrom(processor.readDate("listed_from"));
        result.setListedTill(processor.readDate("listed_till"));
        result.setIsPrimary(processor.readBoolean("is_primary"));
        result.setCurrencyid(processor.readString("currencyid"));
        return result;
    }
}
