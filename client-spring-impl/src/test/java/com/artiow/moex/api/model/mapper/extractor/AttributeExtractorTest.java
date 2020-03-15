package com.artiow.moex.api.model.mapper.extractor;

import com.artiow.moex.api.model.schema.Column;
import com.artiow.moex.api.model.schema.Row;
import lombok.val;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.namespace.QName;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Collections;

import static java.util.Arrays.asList;

@RunWith(SpringRunner.class)
public class AttributeExtractorTest {

    private AttributeExtractor attributeExtractor;


    @Before
    public void setUp() {
        this.attributeExtractor = new AttributeExtractor(asList(
                newColumn("attrBoolean", "boolean"),
                newColumn("attrNumber", "number"),
                newColumn("attrInt32", "int32"),
                newColumn("attrInt64", "int64"),
                newColumn("attrString", "string"),
                newColumn("attrDate", "date"),
                newColumn("attrTime", "time"),
                newColumn("attrDatetime", "datetime")
        ));
    }


    @Test
    public void testReadBoolean() {
        // arrange
        val row1 = newRow("attrBoolean", "true");
        val row2 = newRow("attrBoolean", "false");
        val row3 = newRow("attrBoolean", "1");
        val row4 = newRow("attrBoolean", "0");
        // act
        val result1 = attributeExtractor.process(row1).readBoolean("attrBoolean");
        val result2 = attributeExtractor.process(row2).readBoolean("attrBoolean");
        val result3 = attributeExtractor.process(row3).readBoolean("attrBoolean");
        val result4 = attributeExtractor.process(row4).readBoolean("attrBoolean");
        // assert
        Assert.assertTrue(result1);
        Assert.assertFalse(result2);
        Assert.assertTrue(result3);
        Assert.assertFalse(result4);
    }

    @Test
    public void testReadNumber() {
        // arrange
        val row1 = newRow("attrNumber", "3");
        val row2 = newRow("attrNumber", "3.14");
        // act
        val result1 = attributeExtractor.process(row1).readNumber("attrNumber");
        val result2 = attributeExtractor.process(row2).readNumber("attrNumber");
        // assert
        Assert.assertEquals(3, result1.intValue());
        Assert.assertEquals(3.14, result2.doubleValue(), 0);
    }

    @Test
    public void testReadInteger() {
        // arrange
        val row = newRow("attrInt32", "3");
        // act
        val result = attributeExtractor.process(row).readInteger("attrInt32");
        // assert
        Assert.assertEquals(3, result.intValue());
    }

    @Test
    public void testReadLong() {
        // arrange
        val row = newRow("attrInt64", "3");
        // act
        val result = attributeExtractor.process(row).readLong("attrInt64");
        // assert
        Assert.assertEquals(3L, result.longValue());
    }

    @Test
    public void testReadString() {
        // arrange
        val row = newRow("attrString", "string");
        // act
        val result = attributeExtractor.process(row).readString("attrString");
        // assert
        Assert.assertEquals("string", result);
    }

    @Test
    public void testReadDate() {
        // arrange
        val row = newRow("attrDate", "2000-01-01");
        // act
        val result = attributeExtractor.process(row).readDate("attrDate");
        // assert
        Assert.assertEquals(LocalDate.of(2000, Month.JANUARY, 1), result);
    }

    @Test
    public void testReadTime() {
        // arrange
        val row = newRow("attrTime", "04:20:00");
        // act
        val result = attributeExtractor.process(row).readTime("attrTime");
        // assert
        Assert.assertEquals(LocalTime.of(4, 20, 0), result);
    }

    @Test
    public void testReadDatetime() {
        // arrange
        val row = newRow("attrDatetime", "2000-01-01 04:20:00");
        // act
        val result = attributeExtractor.process(row).readDatetime("attrDatetime");
        // assert
        Assert.assertEquals(LocalDateTime.of(2000, Month.JANUARY, 1, 4, 20, 0), result);
    }


    private Row newRow(String attrName, String attrValue) {
        val row = new Row();
        row.setAttributes(Collections.singletonMap(QName.valueOf(attrName), attrValue));
        return row;
    }

    private Column newColumn(String name, String type) {
        val column = new Column();
        column.setName(QName.valueOf(name));
        column.setType(type);
        return column;
    }
}
