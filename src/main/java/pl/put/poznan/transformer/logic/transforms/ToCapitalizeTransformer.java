package pl.put.poznan.transformer.logic.transforms;

import pl.put.poznan.transformer.logic.TextTransformerDecorator;
import pl.put.poznan.transformer.logic.TextTransformerInterface;

/**
 *  Class used to make 'capitalize' transformation
 */

public class ToCapitalizeTransformer extends TextTransformerDecorator {

    public ToCapitalizeTransformer(TextTransformerInterface transformerInterface) {
        super(transformerInterface);
    }

    /**
     * @param textIn
     * @return sformatowany text - słowa zaczynają się wielką literą
     */
    public String transform(String textIn) {
        String text = super.transform(textIn);
        StringBuilder result = new StringBuilder(text.length());
        String words[] = text.split(" ");
        for (String word : words) {
            result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");

        }

        return result.toString().trim();
    }
}
