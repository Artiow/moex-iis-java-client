package com.artiow.moex.api;

import com.artiow.moex.api.client.MoexApiClient;
import com.artiow.moex.api.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RestTemplate.class})
public class EngineClientTest {

    @Autowired
    private RestTemplate restTemplate;

    private EngineClient client;


    @Before
    public void setUp() {
        client = new EngineClient(new MoexApiClient(restTemplate));
    }


    @Test
    public void testGetEngineList() throws Exception {
        // act
        val result = client.getEngineList(null);

        // assert
        log.debug(JsonUtil.asPrettyJsonString(result));
        Assert.assertNotNull(result);
    }

    @Test
    public void testGetMarketList() throws Exception {
        // act
        val result = client.getMarketList("stock", null);

        // assert
        log.debug(JsonUtil.asPrettyJsonString(result));
        Assert.assertNotNull(result);
    }

    @Test
    public void testGetBoardList() throws Exception {
        // act
        val result = client.getBoardList("stock", "shares", null);

        // assert
        log.debug(JsonUtil.asPrettyJsonString(result));
        Assert.assertNotNull(result);
    }

    @Test
    public void testGetCandles() throws Exception {
        // act
        val result = client.getCandles("stock", "shares", "TQBR", "GAZP", null, null, null, true, null);

        // assert
        log.debug(JsonUtil.asPrettyJsonString(result));
        Assert.assertNotNull(result);
    }
}
