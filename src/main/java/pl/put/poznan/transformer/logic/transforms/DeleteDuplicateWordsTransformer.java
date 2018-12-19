package pl.put.poznan.transformer.logic.transforms;

import pl.put.poznan.transformer.logic.TextTransformerDecorator;
import pl.put.poznan.transformer.logic.TextTransformerInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class used to make 'duplicate' transformation
 * Deleting all duplications words
 */

public class DeleteDuplicateWordsTransformer extends TextTransformerDecorator {

    public DeleteDuplicateWordsTransformer(TextTransformerInterface transformerInterface) {
        super(transformerInterface);
    }

    /**
     * @param textIn
     * @return sformatowany text - po usunięciu duplikatów
     */
    public String transform(String textIn) {
        String text = super.transform(textIn);

        String regex = "\\b(\\w+)(\\s+\\1\\b)+";

        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Matcher m = p.matcher(text);
        while (m.find()) {
            text = text.replaceAll(m.group(), m.group(1));
        }

        return text;
    }
}
