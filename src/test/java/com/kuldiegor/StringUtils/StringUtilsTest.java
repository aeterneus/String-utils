package com.kuldiegor.StringUtils;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test
    public void parse() {
        String text = "<div class=1>" +
                "<div class=2/>" +
                "</div>";
        String begin = "<div class=1>";
        String end = "</div>";
        String expected = "<div class=2/>";
        String actual = StringUtils.parse(text,begin,end);
        assertEquals(expected,actual);
    }

    @Test
    public void parse1() {
        String text = "<div class=1>" +
                "<div class=2/>" +
                "</div>";
        String begin = "<div ";
        String end = "div";
        String expected = "class=1><";
        String actual = StringUtils.parse(text,begin,end);
        assertEquals(expected,actual);
    }

    @Test
    public void parse2() {
        String text = "<div class=1>" +
                "<div class=2/>" +
                "</div>" +
                "</div>" +
                "</div>";
        String begin = "<div ";
        String end = "div";
        String expected = "class=1><";
        String actual = StringUtils.parse(text,begin,end);
        assertEquals(expected,actual);
    }

    @Test
    public void parse3() {
        String text = "<div class=1>" +
                "<div class=2/>" +
                "</div>" +
                "</div>" +
                "</div>";
        String begin = null;
        String end = "div";
        String expected = "<";
        String actual = StringUtils.parse(text,begin,end);
        assertEquals(expected,actual);
    }

    @Test
    public void parse4() {
        String text = "<div class=1>" +
                "<div class=2/>" +
                "</div>" +
                "</div>" +
                "</div>";
        String begin = "<div ";
        String end = null;
        String expected = "class=1><div class=2/></div></div></div>";
        String actual = StringUtils.parse(text,begin,end);
        assertEquals(expected,actual);
    }

    @Test
    public void parse5() {
        String text = "<div class=1>" +
                "<div class=2/>" +
                "</div>" +
                "</div>" +
                "</div>";
        String begin = null;
        String end = null;
        String expected = "<div class=1><div class=2/></div></div></div>";
        String actual = StringUtils.parse(text,begin,end);
        assertEquals(expected,actual);
    }

    @Test
    public void parse6() {
        String text = "<div class=1>" +
                "<div class=2/>" +
                "</div>" +
                "</div>" +
                "</div>";
        String begin = "<div ";
        String end = "</div>";
        Cursor cursor = new Cursor(5);
        String expected = "class=2/>";
        String actual = StringUtils.parse(text,begin,end,cursor);
        assertEquals(expected,actual);
    }

    @Test
    public void parse7() {
        String text = "<div class=1>" +
                "<div class=2/>" +
                "</div>" +
                "</div>" +
                "</div>";
        String begin = "<div class=3";
        String end = "</div>";
        Cursor cursor = new Cursor(5);
        String expected = null;
        String actual = StringUtils.parse(text,begin,end,cursor);
        assertEquals(expected,actual);
    }

    @Test
    public void parse8() {
        String text = "<div class=1>" +
                "<div class=2/>" +
                "</div>" +
                "</div>" +
                "</div>";
        String begin = "<div class=1";
        String end = "</div2>";
        Cursor cursor = new Cursor(5);
        String expected = null;
        String actual = StringUtils.parse(text,begin,end,cursor);
        assertEquals(expected,actual);
    }

    @Test
    public void smartParse() {
        String text = "<div class=1>" +
                "<div class=2/>" +
                "</div>";
        String begin = "<div class=1>";
        String end = "</div>";
        String expected = "<div class=2/>";
        String repeatBegin = "</div>";
        String actual = StringUtils.smartParse(text,begin,end,repeatBegin);
        assertEquals(expected,actual);
    }

    @Test
    public void smartParse1() {
        String text = "<div class=1>" +
                "<div class=2/>" +
                "</div>";
        String begin = "<div ";
        String end = "div";
        String repeatBegin = "</div>";
        String expected = "class=1><";
        String actual = StringUtils.smartParse(text,begin,end,repeatBegin);
        assertEquals(expected,actual);
    }

    @Test
    public void smartParse2() {
        String text = "<div class=1>" +
                "<div class=2/>" +
                "</div>" +
                "</div>" +
                "</div>";
        String begin = "<div ";
        String end = "div";
        String repeatBegin = "<div";
        String expected = "class=1><div class=2/></";
        String actual = StringUtils.smartParse(text,begin,end,repeatBegin);
        assertEquals(expected,actual);
    }

    @Test
    public void smartParse3() {
        String text = "<div class=1>" +
                "<div class=2/>" +
                "</div>" +
                "</div>" +
                "</div>";
        String begin = null;
        String end = "div";
        String repeatBegin = "<div";
        String expected = "<div class=1><div class=2/></";
        String actual = StringUtils.smartParse(text,begin,end,repeatBegin);
        assertEquals(expected,actual);
    }

    @Test
    public void smartParse4() {
        String text = "<div class=1>" +
                "<div class=2/>" +
                "</div>" +
                "</div>" +
                "</div>";
        String begin = "<div ";
        String end = null;
        String repeatBegin = "<div";
        String expected = "class=1><div class=2/></div></div></div>";
        String actual = StringUtils.smartParse(text,begin,end,repeatBegin);
        assertEquals(expected,actual);
    }

    @Test
    public void smartParse5() {
        String text = "<div class=1>" +
                "<div class=2/>" +
                "</div>" +
                "</div>" +
                "</div>";
        String begin = null;
        String end = null;
        String repeatBegin = "<div";
        String expected = "<div class=1><div class=2/></div></div></div>";
        String actual = StringUtils.smartParse(text,begin,end,repeatBegin);
        assertEquals(expected,actual);
    }

    @Test
    public void smartParse6() {
        String text = "<div class=1>" +
                "<div class=2/>" +
                "</div>" +
                "</div>" +
                "</div>";
        String begin = "<div ";
        String end = "</div>";
        String repeatBegin = "<div";
        Cursor cursor = new Cursor(5);
        String expected = "class=2/>";
        String actual = StringUtils.smartParse(text,begin,end,repeatBegin,cursor);
        assertEquals(expected,actual);
    }

    @Test
    public void smartParse7() {
        String text = "<div class=1>" +
                "<div class=2/>" +
                "</div>" +
                "</div>" +
                "</div>";
        String begin = "<div class=3";
        String end = "</div>";
        String repeatBegin = "<div";
        Cursor cursor = new Cursor(5);
        String expected = null;
        String actual = StringUtils.smartParse(text,begin,end,repeatBegin,cursor);
        assertEquals(expected,actual);
    }

    @Test
    public void smartParse8() {
        String text = "<div class=1>" +
                "<div class=2/>" +
                "</div>" +
                "</div>" +
                "</div>";
        String begin = "<div class=1";
        String end = "</div2>";
        String repeatBegin = "<div";
        Cursor cursor = new Cursor(5);
        String expected = null;
        String actual = StringUtils.smartParse(text,begin,end,repeatBegin,cursor);
        assertEquals(expected,actual);
    }

    @Test
    public void smartParse9() {
        String text = "<div class=1>" +
                "<div class=2/>" +
                "</div>" +
                "</div>" +
                "</div>";
        String begin = "<div class=1>";
        String end = "</div>";
        String repeatBegin = "<div";
        Cursor cursor = new Cursor();
        String expected = "<div class=2/></div>";
        String actual = StringUtils.smartParse(text,begin,end,repeatBegin,cursor);
        assertEquals(expected,actual);
    }

    @Test
    public void smartParseWithXML() {
        String text = "<div class=1>" +
                "<div class=2/>" +
                "</div>" +
                "</div>" +
                "</div>";
        String begin = "<div class=1>";
        String end = "</div>";
        String repeatBegin = "<div";
        Cursor cursor = new Cursor();
        String expected = "<div class=2/>";
        String actual = StringUtils.smartParse(text,begin,end,repeatBegin,true,cursor);
        assertEquals(expected,actual);
    }

    @Test
    public void smartParseWithXML1() {
        String text = "<div class=1>" +
                "<div class=2>" +
                "<div class=3/>" +
                "<div class=3/>" +
                "</div>" +
                "</div>" +
                "</div>" +
                "</div>" +
                "</div>";
        String begin = "<div class=1>";
        String end = "</div>";
        String repeatBegin = "<div";
        Cursor cursor = new Cursor();
        String expected = "<div class=2><div class=3/><div class=3/></div>";
        String actual = StringUtils.smartParse(text,begin,end,repeatBegin,true,cursor);
        assertEquals(expected,actual);
    }

    @Test
    public void smartParseWithXML2() {
        String text = "<div class=1>" +
                "<div class=2>" +
                "<div class=3/>" +
                "<div class=3/>" +
                "<div class=4>" +
                "</div>" +
                "</div>" +
                "</div>" +
                "</div>" +
                "</div>";
        String begin = "<div class=1>";
        String end = "</div>";
        String repeatBegin = "<div";
        Cursor cursor = new Cursor();
        String expected = "<div class=2><div class=3/><div class=3/><div class=4></div></div>";
        String actual = StringUtils.smartParse(text,begin,end,repeatBegin,true,cursor);
        assertEquals(expected,actual);
    }

    @Test
    public void smartParseWithXML3() {
        String text = "<div class=1>" +
                "<div class=2>" +
                "<div class=3/>" +
                "<div class=3/>" +
                "<div class=4>" +
                "<div class=5>" +
                "</div>" +
                "</div>" +
                "</div>" +
                "</div>" +
                "</div>";
        String begin = "<div class=1>";
        String end = "</div>";
        String repeatBegin = "<div";
        Cursor cursor = new Cursor();
        String expected = "<div class=2><div class=3/><div class=3/><div class=4><div class=5></div></div></div>";
        String actual = StringUtils.smartParse(text,begin,end,repeatBegin,true,cursor);
        assertEquals(expected,actual);
    }
}