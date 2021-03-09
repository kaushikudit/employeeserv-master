package com.paypal.bfs.test.employeeserv.converters;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.exception.CustomException;
import com.paypal.bfs.test.employeeserv.util.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
@Slf4j
public class AddressConverter implements AttributeConverter<Address, String> {
    @Override
    public String convertToDatabaseColumn(Address address) {
        try {
            return JsonParser.objectToJson(address);
        } catch (Exception ex) {
            log.error("Something went wrong while converting {} to json string.", address);
            throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong while converting address to json string.");
        }
    }

    @Override
    public Address convertToEntityAttribute(String address) {
        try {
            return JsonParser.generalJsonToObject(address, Address.class);
        } catch (Exception ex) {
            log.error("Something went wrong while converting {} to address.", address);
            throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong while converting json string to address.");
        }
    }
}
