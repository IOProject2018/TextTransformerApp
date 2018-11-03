package pl.put.poznan.transformer.logic;
/**
 *  Class used to make 'inverse' transformation
 *  Inverse whole text with the same size of characters
 */
public class InverseTextTransformer implements TextTransformerInterface {

    public String transform(String text) {
        StringBuilder result = new StringBuilder();
        result.append(text);
        result = result.reverse();
        return result.toString();
    }
}
