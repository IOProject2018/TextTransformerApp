package pl.put.poznan.transformer.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class used to make 'duplicate' transformation
 * Deleting all duplications words
 */

public class DeleteDuplicateWordsTransformer implements TextTransformerInterface {

    public String transform(String text) {
        String regex = "\\b(\\w+)(\\s+\\1\\b)+";

        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Matcher m = p.matcher(text);
        while (m.find()) {
            text = text.replaceAll(m.group(), m.group(1));
        }

        return text;
    }
}
