package com.ciklum.spocksample;

import com.ciklum.spocksample.engine.Parser;
import com.ciklum.spocksample.obj.*;
import net.javacrumbs.jsonunit.JsonAssert;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParserTest {

    Parser parser = new Parser();

    @Test
    public void testParsePerson() throws IOException {
        Address address = new Address();
        address.setCountry("USA");
        address.setZip("10002");
        address.setStreet("29th");
        address.setBuilding("19090");
        address.setApartment("9a");

        Role role = new Role();
        role.setRoleName("admin");
        Map<String, String> permissions = new HashMap<>();
        permissions.put("home", "READ");
        permissions.put("contacts", "WRITE");
        role.setPermissions(permissions);

        Person person = new Person();
        person.setAddress(address);
        person.setRole(role);

        Account account1 = new Account();
        account1.setIsMain(true);
        account1.setNumber("260089");
        account1.setRest(new BigDecimal("99.99"));

        Account account2 = new Account();
        account2.setIsMain(false);
        account2.setNumber("261091");
        account2.setRest(new BigDecimal("9.19"));

        Account account3 = new Account();
        account3.setIsMain(false);
        account3.setNumber("2620901");
        account3.setRest(new BigDecimal("55.77"));

        List<Account> accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        person.setAccounts(accounts);

        JsonAssert.assertJsonEquals(IOUtils.toString(getClass().getResourceAsStream("/person.json")),
                parser.parsePerson(person));
    }

    @Test
    public void testParseMessage() throws IOException {
        Message message = new Message();
        message.setText("message text");
        message.setSize(100000000000L);
        JsonAssert.assertJsonEquals(IOUtils.toString(getClass().getResourceAsStream("/message.json")),
                parser.parseMessage(message));
    }
}
