package ua.home.javagroovytest.function;

import ua.home.javagroovytest.exception.BaseException;
import ua.home.javagroovytest.obj.FieldSetsEntry;
import ua.home.javagroovytest.obj.FieldsEntry;
import ua.home.javagroovytest.obj.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tsv@ciklum.net (Tsukanov Vladimir)
 */
public class DataAdapter {

    public static final String FIELDSET_DATA = "data";

    private Message data;

    public DataAdapter(Message message) {
        this.data = message;
    }

    public List<String> getColumns() throws BaseException {
        List<FieldsEntry> flds = getFields(FIELDSET_DATA);
        List<String> res = new ArrayList<>(flds.size());
        for (FieldsEntry fld : flds) {
            String columnName = fld.getFieldName();
            res.add(columnName);
        }
        return res;
    }

    private List<FieldsEntry> getFields(String fieldsetName) throws BaseException {
        return getFieldSet(fieldsetName).getFields();
    }

    private FieldSetsEntry getFieldSet(String fieldsetName) throws BaseException {
        FieldSetsEntry fieldSet = null;
        for (FieldSetsEntry fs : data.getRule().getFieldSets()) {
            if (fs.getSetName().equals(fieldsetName)) {
                fieldSet = fs;
            }
        }
        if (fieldSet == null) {
            throw new BaseException("There is no fieldset with the name %s", fieldsetName);
        }
        return fieldSet;
    }
}
