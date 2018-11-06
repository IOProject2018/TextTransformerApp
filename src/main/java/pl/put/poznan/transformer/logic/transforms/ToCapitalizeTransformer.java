package pl.put.poznan.transformer.logic.transforms;

import pl.put.poznan.transformer.logic.TextTransformerInterface;

/**
 *  Class used to make 'capitalize' transformation
 */

public class ToCapitalizeTransformer implements TextTransformerInterface {

    /**
     * @param text
     * @return sformatowany text - słowa zaczynają się wielką literą
     */
    public String transform(String text) {

        StringBuilder result = new StringBuilder(text.length());
        String words[] = text.split(" ");
        for (String word : words) {
            result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");

        }

        return result.toString();
    }
}
