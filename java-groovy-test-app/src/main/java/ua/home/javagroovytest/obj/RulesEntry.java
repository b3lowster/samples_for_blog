package ua.home.javagroovytest.obj;

import java.util.List;

/**
 * @author tsv@ciklum.net (Tsukanov Vladimir)
 */
public class RulesEntry {
    private List<FieldSetsEntry> fieldSets;
    private String name;

    public List<FieldSetsEntry> getFieldSets() {
        return fieldSets;
    }

    public void setFieldSets(List<FieldSetsEntry> fieldSets) {
        this.fieldSets = fieldSets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
