package ua.home.javagroovytest.obj;

/**
 * @author tsv@ciklum.net (Tsukanov Vladimir)
 */
public class Message {

    RulesEntry rule;

    public Message(RulesEntry rule) {
        this.rule = rule;
    }

    public RulesEntry getRule() {
        return rule;
    }

    public void setRule(RulesEntry rule) {
        this.rule = rule;
    }
}
