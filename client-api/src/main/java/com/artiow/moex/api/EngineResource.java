package com.artiow.moex.api;

import com.artiow.moex.api.model.Board;
import com.artiow.moex.api.model.Candle;
import com.artiow.moex.api.model.Engine;
import com.artiow.moex.api.model.Market;

import java.time.LocalDate;
import java.util.List;

public interface EngineResource {

    /**
     * Returns available trading MOEX systems.
     *
     * @param lang the response language code;
     * @return the list of engines.
     * @see <a href="http://iss.moex.com/iss/reference/40">/iss/engines</a>
     */
    List<Engine> getEngineList(
            String lang
    );

    /**
     * Returns a list of trading MOEX system markets.
     *
     * @param engine the engine name to be searched;
     * @param lang   the response language code;
     * @return the list of markets.
     * @see <a href="http://iss.moex.com/iss/reference/42">/iss/engines/[engine]/markets</a>
     */
    List<Market> getMarketList(
            String engine,
            String lang
    );

    /**
     * Returns a list of market trading modes for the selected trading MOEX system.
     *
     * @param engine the engine name to be searched;
     * @param market the market name to be searched;
     * @param lang   the response language code;
     * @return the list of boards.
     * @see <a href="http://iss.moex.com/iss/reference/43">/iss/engines/[engine]/markets/[market]/boards</a>
     */
    List<Board> getBoardList(
            String engine,
            String market,
            String lang
    );

    /**
     * Returns a list of HLOCV candles of the specified security paper for the selected trading mode.
     *
     * @param engine   the engine name to be searched;
     * @param market   the market name to be searched;
     * @param board    the board string identifier to be searched;
     * @param secid    the security paper identifier;
     * @param from     the start data date;
     * @param to       the end data date;
     * @param interval the candle period in minutes;
     * @param reverse  the sign that candles are in reverse orderж
     * @param lang     the response language code;
     * @return the list of candles.
     * @see <a href="http://iss.moex.com/iss/reference/46">/iss/engines/[engine]/markets/[market]/boards/[board]/securities/[security]/candles</a>
     */
    List<Candle> getCandles(
            String engine,
            String market,
            String board,
            String secid,
            LocalDate from,
            LocalDate to,
            Integer interval,
            Boolean reverse,
            String lang
    );
}
