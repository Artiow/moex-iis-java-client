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
public class SecurityPaperClientTest {

    @Autowired
    private RestTemplate restTemplate;

    private SecurityPaperClient client;


    @Before
    public void setUp() {
        client = new SecurityPaperClient(new MoexApiClient(restTemplate));
    }


    @Test
    public void testSearch() throws Exception {
        // act
        val result = client.search(null, null, null, null, null, null, null);

        // assert
        log.debug(JsonUtil.asPrettyJsonString(result));
        Assert.assertNotNull(result);
    }

    @Test
    public void testGetSpecification() throws Exception {
        // act
        val result = client.getSpecification("AAPL", null);

        // assert
        log.debug(JsonUtil.asPrettyJsonString(result));
        Assert.assertNotNull(result);
    }
}
