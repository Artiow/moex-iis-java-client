package com.artiow.moex.api;

import com.artiow.moex.api.model.Board;
import com.artiow.moex.api.model.Engine;
import com.artiow.moex.api.model.Market;

import java.util.List;

public interface EngineResource {

    List<Engine> getEngineList();

    List<Market> getMarketList(String engine);

    List<Board> getBoardList(String engine, String market);
}
