package com.paypal.bfs.test.employeeserv.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class JsonParser {

    /** This method will return customized model object from a given json String here the input type
     * for the method is json string and class name of the domain that you want output as.
     *
     * @param json - json String that needs to be converted
     * @param cls  - .class name for the pojo
     * @return - object
     */
    public static <T> T generalJsonToObject(final String json, final Class<?> cls) {
        final ObjectMapper mapper = new ObjectMapper();
        T object = null;

        try {
            object = (T) mapper.readValue(json, cls);
        } catch (final IOException e1) {
//            log.error("{}", e1);
        }
        return object;
    }

    /** This method will convert any model object into json string The key for the json string is
     * being mapped from getters of your pojo.
     *
     * @param  - obj
     * @return Json from Object
     */
    public static String objectToJson(final Object obj) {
        final ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;
        try {
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            jsonInString = mapper.writeValueAsString(obj);
        } catch (final IOException e1) {
//            log.error("{}", e1);
        }
        return jsonInString;
    }
}
