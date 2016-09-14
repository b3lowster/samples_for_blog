package com.ciklum.spocksample.engine;

import com.ciklum.spocksample.obj.Message;
import com.ciklum.spocksample.obj.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

public class Parser {

    public String parsePerson(Person person) throws IOException {
        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        StringWriter stringEmp = new StringWriter();
        objectMapper.writeValue(stringEmp, person);

        return stringEmp.getBuffer().toString();
    }

    public String parseMessage(Message message) throws IOException {
        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        StringWriter stringEmp = new StringWriter();
        objectMapper.writeValue(stringEmp, message);

        return stringEmp.getBuffer().toString();
    }
}
