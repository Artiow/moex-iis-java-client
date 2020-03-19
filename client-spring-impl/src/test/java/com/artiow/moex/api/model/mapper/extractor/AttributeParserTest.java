package com.artiow.moex.api.model.mapper.extractor;

import lombok.val;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

@RunWith(SpringRunner.class)
public class AttributeParserTest {

    private AttributeParser attributeParser;


    @Before
    public void setUp() {
        this.attributeParser = new AttributeParser();
    }


    @Test
    public void testParseBoolean() {
        // act
        val result1 = attributeParser.parse("true", Boolean.class);
        val result2 = attributeParser.parse("false", Boolean.class);
        val result3 = attributeParser.parse("1", Boolean.class);
        val result4 = attributeParser.parse("0", Boolean.class);
        // assert
        Assert.assertTrue(result1);
        Assert.assertFalse(result2);
        Assert.assertTrue(result3);
        Assert.assertFalse(result4);
    }

    @Test
    public void testParseNumber() {
        // act
        val result1 = attributeParser.parse("3", Number.class);
        val result2 = attributeParser.parse("3.14", Number.class);
        // assert
        Assert.assertEquals(3, result1.intValue());
        Assert.assertEquals(3.14, result2.doubleValue(), 0);
    }

    @Test
    public void testParseInteger() {
        // act
        val result = attributeParser.parse("3", Integer.class);
        // assert
        Assert.assertEquals(3, result.intValue());
    }

    @Test
    public void testParseLong() {
        // act
        val result = attributeParser.parse("3", Long.class);
        // assert
        Assert.assertEquals(3L, result.longValue());
    }

    @Test
    public void testParseBigDecimal() {
        // act
        val result = attributeParser.parse("3.14", BigDecimal.class);
        // assert
        Assert.assertEquals(new BigDecimal("3.14"), result);
    }

    @Test
    public void testParseString() {
        // act
        val result = attributeParser.parse("string", String.class);
        // assert
        Assert.assertEquals("string", result);
    }

    @Test
    public void testParseDate() {
        // act
        val result = attributeParser.parse("2000-01-01", LocalDate.class);
        // assert
        Assert.assertEquals(LocalDate.of(2000, Month.JANUARY, 1), result);
    }

    @Test
    public void testParseTime() {
        // act
        val result = attributeParser.parse("04:20:00", LocalTime.class);
        // assert
        Assert.assertEquals(LocalTime.of(4, 20, 0), result);
    }

    @Test
    public void testParseDateTime() {
        // act
        val result = attributeParser.parse("2000-01-01 04:20:00", LocalDateTime.class);
        // assert
        Assert.assertEquals(LocalDateTime.of(2000, Month.JANUARY, 1, 4, 20, 0), result);
    }
}
