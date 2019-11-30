/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encentral.test_project.commons.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.vavr.jackson.datatype.VavrModule;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 *
 * @author Akinniranye James Ayodele <kaimedavies@sycliff.com>
 */
public class MyObjectMapper extends ObjectMapper {

    public final static SimpleDateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    public final static SimpleDateFormat DATEFORMAT_NO_TIMEZONE = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public MyObjectMapper() {
        super();
        this.setDateFormat(DATEFORMAT);
        this.registerModule(new VavrModule());
        this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //add this
        //this.configure(ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

    }

    public MyObjectMapper(JsonFactory factory) {
        super(factory);
        this.setDateFormat(DATEFORMAT);
        this.registerModule(new VavrModule());
        this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    @Override
    public String writeValueAsString(Object value) throws JsonProcessingException {
        DATEFORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.setDateFormat(DATEFORMAT);
        return super.writeValueAsString(value);

    }

    public String writeValueAsString(Object value, SimpleDateFormat format) throws JsonProcessingException {
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.setDateFormat(format);
        String json = super.writeValueAsString(value);
        DATEFORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.setDateFormat(DATEFORMAT);
        return json;
    }

    public <T extends Object> T readValue(String content, Class<T> valueType) throws IOException, JsonParseException, JsonMappingException {
        DATEFORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.setDateFormat(DATEFORMAT);
        return super.readValue(content, valueType);
    }

    @Override
    public SimpleDateFormat getDateFormat() {
        return DATEFORMAT;
    }

}
