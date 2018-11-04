package pl.put.poznan.transformer.logic;

/**
 *  Class used to make 'lower' transformation
 */

public class ToLowerTransformer implements TextTransformerInterface {
    public String transform(String text) {
        return text.toLowerCase();
    }
}