package pl.put.poznan.transformer.logic;

/**
 *  Class used to make 'capitalize' transformation
 */

public class ToCapitalizeTransformer implements TextTransformerInterface {

    public String transform(String text) {

        StringBuilder result = new StringBuilder(text.length());
        String words[] = text.split(" ");
        for (String word : words) {
            result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");

        }

        return result.toString();
    }
}
