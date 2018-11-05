package pl.put.poznan.transformer.logic;
/**
 *  Class used to make 'latex like' transformation
 */
public class LatexSymbolsTransformer implements TextTransformerInterface {
    public String transform(String text) {
            text = text.replace("&", "\\&");
            text = text.replace("$", "\\$");
            return text;
    }
}
