package com.artiow.moex.api.client;

import com.artiow.moex.api.model.schema.Document;
import com.artiow.moex.api.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
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
public class MoexApiClientTest {

    @Autowired
    private RestTemplate restTemplate;

    private MoexApiClient client;


    @Before
    public void setUp() {
        client = new MoexApiClient(restTemplate);
    }


    @Test
    public void testRequest() throws Exception {
        // arrange
        String uriString = "https://iss.moex.com/iss/securities.xml";

        // act
        Document document = client.request(uriString);

        // assert
        log.debug(JsonUtil.asPrettyJsonString(document));
        Assert.assertNotNull(document);
    }
}
