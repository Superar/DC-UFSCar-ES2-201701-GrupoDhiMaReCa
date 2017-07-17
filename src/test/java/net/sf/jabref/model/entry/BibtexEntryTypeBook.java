package net.sf.jabref.model.entry;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BibtexEntryTypeBook
{

    // Testes sobre o tipo BibtexEntryTypes.BOOK
    @Test
    public void testGetName()
    {
        assertEquals("Book", BibtexEntryTypes.BOOK.getName());
    }

    @Test
    public void testOptionalFields()
    {
        List<String> optionalFields = new ArrayList<>();
        optionalFields.add("volume");
        optionalFields.add("number");
        optionalFields.add("series");
        optionalFields.add("address");
        optionalFields.add("edition");
        optionalFields.add("month");
        optionalFields.add("isbn");
        optionalFields.add("note");

        assertThat(optionalFields, is(BibtexEntryTypes.BOOK.getOptionalFields()));
    }

    @Test
    public void testRequiredFieldsOr()
    {
        List<String> requiredFields = new ArrayList<>();
        requiredFields.add("title");
        requiredFields.add("publisher");
        requiredFields.add("year");
        requiredFields.add("author/editor");

        assertThat(requiredFields, is(BibtexEntryTypes.BOOK.getRequiredFields()));
    }

    @Test
    public void testRequiredFieldsFlat()
    {
        List<String> requiredFields = new ArrayList<>();
        requiredFields.add("title");
        requiredFields.add("publisher");
        requiredFields.add("year");
        requiredFields.add("author");
        requiredFields.add("editor");

        assertThat(requiredFields, is(BibtexEntryTypes.BOOK.getRequiredFieldsFlat()));
    }

    @Test
    public void testCompareTo()
    {
        // Retorno 1 significa que sao tipos diferentes
        assertEquals(1, BibtexEntryTypes.BOOK.compareTo(BibtexEntryTypes.ARTICLE));
    }

    @Test
    public void testPrimaryOptionalFields()
    {
        // Metodo retorna os optionalFields
        testOptionalFields();
    }

    @Test
    public void testSecondaryOptionalFields()
    {
        List<String> secondaryOptionalFields = new ArrayList<>();
        // Todos os campos opciionais de BOOK sao primarios
        assertThat(secondaryOptionalFields, is(BibtexEntryTypes.BOOK.getSecondaryOptionalFields()));
    }
}
