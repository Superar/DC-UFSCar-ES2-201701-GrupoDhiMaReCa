package net.sf.jabref.logic.integrity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import net.sf.jabref.logic.integrity.IntegrityCheck.Checker;
import net.sf.jabref.logic.l10n.Localization;
import net.sf.jabref.model.entry.BibEntry;
import net.sf.jabref.model.entry.FieldName;
import net.sf.jabref.model.strings.StringUtil;

/**
 * Currently only checks the key if there is an author, year, and title present.
 */
public class BibtexkeyChecker implements Checker {

    @Override
    public List<IntegrityMessage> check(BibEntry entry) {
        Optional<String> valuekey = entry.getCiteKeyOptional();
        Optional<String> valueauthor = entry.getField(FieldName.AUTHOR);
        Optional<String> valuetitle = entry.getField(FieldName.TITLE);
        Optional<String> valueyear = entry.getField(FieldName.YEAR);
        String authortitleyear = entry.getAuthorTitleYear(100);
        char primeira;
        java.lang.String prim;
        String especial = ",.;:<>|!@#£$§%&/{([)]=}'?)_-";

        if (!valueauthor.isPresent() || !valuetitle.isPresent() || !valueyear.isPresent()) {
            return Collections.emptyList();
        }

        if (StringUtil.isBlank(valuekey)) {
            return Collections.singletonList(new IntegrityMessage(
                    Localization.lang("empty BibTeX key") + ": " + authortitleyear, entry, BibEntry.KEY_FIELD));
        }

        if (valuekey.get().length() < 2 ){
            return Collections.singletonList(new IntegrityMessage(
                    Localization.lang("BibTex key has less than 2 letters") + ": " + authortitleyear, entry, BibEntry.KEY_FIELD));
        }

        if ( Character.isDigit(valuekey.get().charAt(0))==true)
        {
            return Collections.singletonList(new IntegrityMessage(
                    Localization.lang("Primeiro caracter deve ser letra") + ": " + authortitleyear, entry, BibEntry.KEY_FIELD));
        }
        primeira = (valuekey.get().charAt(0));
        prim =  String.valueOf(primeira);

        if (prim.matches("[!#@$%¨&*0-9].*")){
            return Collections.singletonList(new IntegrityMessage(
                    Localization.lang("Primeiro caracter deve ser letra") + ": " + authortitleyear, entry, BibEntry.KEY_FIELD));
        }



            return Collections.emptyList();
    }
}
