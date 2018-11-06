package pl.put.poznan.transformer.logic.transforms;

import pl.put.poznan.transformer.logic.TextTransformerInterface;

/**
 * Class used to make 'lower' transformation
 */

public class ToLowerTransformer implements TextTransformerInterface {
    /**
     * @param text
     * @return sformatowany text - zamiana na małe litery
     */
    public String transform(String text) {
        return text.toLowerCase();
    }
}