package net.sf.jabref.model.entry;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BibtexEntryTypeArticle
{

    // Testes sobre o tipo BibtexEntryTypes.ARTICLE
    @Test
    public void testGetName()
    {
        assertEquals("Article", BibtexEntryTypes.ARTICLE.getName());
    }

    @Test
    public void testOptionalFields()
    {
        List<String> optionalFields = new ArrayList<>();
        optionalFields.add("volume");
        optionalFields.add("number");
        optionalFields.add("pages");
        optionalFields.add("month");
        optionalFields.add("issn");
        optionalFields.add("note");

        assertThat(optionalFields, is(BibtexEntryTypes.ARTICLE.getOptionalFields()));
    }

    @Test
    public void testRequiredFieldsFlat()
    {
        List<String> requiredFields = new ArrayList<>();
        requiredFields.add("author");
        requiredFields.add("title");
        requiredFields.add("journal");
        requiredFields.add("year");

        assertThat(requiredFields, is(BibtexEntryTypes.ARTICLE.getRequiredFieldsFlat()));
    }

    @Test
    public void testCompareTo()
    {
        // Retorno 1 significa que sao tipos diferentes
        assertEquals(-1, BibtexEntryTypes.ARTICLE.compareTo(BibtexEntryTypes.BOOK));
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
        assertThat(secondaryOptionalFields, is(BibtexEntryTypes.ARTICLE.getSecondaryOptionalFields()));
    }
}
