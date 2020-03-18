package com.artiow.moex.api;

import com.artiow.moex.api.client.MoexApiClient;
import com.artiow.moex.api.model.Board;
import com.artiow.moex.api.model.Candle;
import com.artiow.moex.api.model.Engine;
import com.artiow.moex.api.model.Market;
import com.artiow.moex.api.model.mapper.*;
import lombok.val;

import java.time.LocalDate;
import java.util.List;

import static com.artiow.moex.api.util.QueryParamsBuilder.queryParamsBuilder;
import static com.artiow.moex.api.util.UriParamsBuilder.uriParamsBuilder;

public class EngineClient implements EngineResource {

    private final MoexApiClient client;

    private final DocumentMapper<List<Engine>> engineMapper;
    private final DocumentMapper<List<Market>> marketMapper;
    private final DocumentMapper<List<Board>> boardMapper;
    private final DocumentMapper<List<Candle>> candleMapper;


    public EngineClient(MoexApiClient client) {
        this.client = client;
        this.engineMapper = new EngineMapper();
        this.marketMapper = new MarketMapper();
        this.boardMapper = new BoardMapper();
        this.candleMapper = new CandleMapper();
    }


    @Override
    public List<Engine> getEngineList(
            String lang
    ) {
        val queryParams = queryParamsBuilder(1)
                .set("lang", lang);

        return engineMapper.map(client.request(
                "https://iss.moex.com/iss/engines.xml", queryParams.build()
        ));
    }

    @Override
    public List<Market> getMarketList(
            String engine,
            String lang
    ) {
        val uriParams = uriParamsBuilder(2)
                .set("engine", engine);

        val queryParams = queryParamsBuilder(1)
                .set("lang", lang);

        return marketMapper.map(client.request(
                "https://iss.moex.com/iss/engines/{engine}/markets.xml", uriParams.build(), queryParams.build()
        ));
    }

    @Override
    public List<Board> getBoardList(
            String engine,
            String market,
            String lang
    ) {
        val uriParams = uriParamsBuilder(2)
                .set("engine", engine)
                .set("market", market);

        val queryParams = queryParamsBuilder(1)
                .set("lang", lang);

        return boardMapper.map(client.request(
                "https://iss.moex.com/iss/engines/{engine}/markets/{market}/boards.xml", uriParams.build(), queryParams.build()
        ));
    }

    @Override
    public List<Candle> getCandles(
            String engine,
            String market,
            String board,
            String secid,
            LocalDate from,
            LocalDate to,
            Integer interval,
            Boolean reverse,
            String lang
    ) {
        val uriParams = uriParamsBuilder(4)
                .set("engine", engine)
                .set("market", market)
                .set("board", board)
                .set("secid", secid);

        val queryParams = queryParamsBuilder(5)
                .set("from", from)
                .set("till", to)
                .set("interval", interval)
                .set("iss.reverse", reverse)
                .set("lang", lang);

        return candleMapper.map(client.request(
                "https://iss.moex.com/iss/engines/{engine}/markets/{market}/boards/{board}/securities/{secid}/candles.xml", uriParams.build(), queryParams.build()
        ));
    }
}
