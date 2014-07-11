package ua.home.javagroovytest.function

import org.junit.Assert
import org.junit.Test
import ua.home.javagroovytest.obj.FieldSetsEntry
import ua.home.javagroovytest.obj.FieldsEntry
import ua.home.javagroovytest.obj.Message
import ua.home.javagroovytest.obj.RulesEntry

/**
 * @author tsv@ciklum.net (Tsukanov Vladimir)
 */
class DataAdapterGroovyTest {

    @Test
    public void testGetColumns() {
        FieldSetsEntry fieldsSet = new FieldSetsEntry(setName:"data", fields:[new FieldsEntry(fieldName:"first_column"),
                                                                              new FieldsEntry(fieldName:"second_column"),
                                                                              new FieldsEntry(fieldName:"third_column")]);

        DataAdapter adapter = new DataAdapter(new Message(new RulesEntry(fieldSets:[fieldsSet])));

        def columns = adapter.getColumns();
        Assert.assertEquals(3, columns.size());
    }
}
