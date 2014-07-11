package ua.home.javagroovytest.obj;

import java.util.List;

/**
 * @author tsv@ciklum.net (Tsukanov Vladimir)
 */
public class FieldSetsEntry {

    private List<FieldsEntry> fields;
    private String setName;

    public List<FieldsEntry> getFields() {
        return fields;
    }

    public void setFields(List<FieldsEntry> fields) {
        this.fields = fields;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }
}
