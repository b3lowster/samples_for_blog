package com.ciklum.spocksample

import com.ciklum.spocksample.obj.Account
import com.ciklum.spocksample.obj.Address
import com.ciklum.spocksample.obj.Message
import com.ciklum.spocksample.engine.Parser
import com.ciklum.spocksample.obj.Person
import com.ciklum.spocksample.obj.Role
import net.javacrumbs.jsonunit.JsonAssert
import org.codehaus.groovy.runtime.IOGroovyMethods
import spock.lang.Specification
/**
 * @author tsv@ciklum.com
 */
class ParserSpec extends Specification {

    def parser = new Parser();

    def testParseMessage() {

        given: "Message initialization"
        def message = new Message(text: "message text", size: 100000000000)

        expect: "Message should be match"
        JsonAssert.assertJsonEquals(IOGroovyMethods.getText(getClass().getResourceAsStream("/message.json")),
                parser.parseMessage(message));
    }
    
    def testParsePerson() {

        given: "Person initialization"
        def person = new Person(address: new Address(country: "USA", zip: "10002", street: "29th", building: "19090", apartment: "9a"),
        role: new Role(roleName: "admin", permissions: ['home':'READ', 'contacts':'WRITE']),
        accounts: [new Account(number: "260089", rest: 99.99, main: true), new Account(number: "261091", rest: 9.19, main: false),
                   new Account(number: "2620901", rest: 55.77, main: false)])

        expect: "Person should be match"
        JsonAssert.assertJsonEquals(IOGroovyMethods.getText(getClass().getResourceAsStream("/person.json")),
                parser.parsePerson(person));
    }
}
