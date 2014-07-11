package ua.home.javagroovytest.function;

import org.junit.Assert;
import org.junit.Test;
import ua.home.javagroovytest.exception.BaseException;
import ua.home.javagroovytest.function.DataAdapter;
import ua.home.javagroovytest.obj.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tsv@ciklum.net (Tsukanov Vladimir)
 */
public class DataAdapterTest {

    @Test
    public void testGetColumns() throws BaseException {
        FieldSetsEntry fieldsSet = new FieldSetsEntry();
        fieldsSet.setSetName("data");
        FieldsEntry fe1 = new FieldsEntry();
        fe1.setFieldName("first_column");
        FieldsEntry fe2 = new FieldsEntry();
        fe2.setFieldName("second_column");
        FieldsEntry fe3 = new FieldsEntry();
        fe3.setFieldName("third_column");
        List<FieldsEntry> fieldsEntries = new ArrayList<>();
        fieldsEntries.add(fe1);
        fieldsEntries.add(fe2);
        fieldsEntries.add(fe3);
        fieldsSet.setFields(fieldsEntries);
        List<FieldSetsEntry> fieldsSets = new ArrayList<>();
        fieldsSets.add(fieldsSet);

        RulesEntry rule = new RulesEntry();
        rule.setFieldSets(fieldsSets);

        List<String> columns = new DataAdapter(new Message(rule)).getColumns();

        Assert.assertEquals(3, columns.size());
    }
}
