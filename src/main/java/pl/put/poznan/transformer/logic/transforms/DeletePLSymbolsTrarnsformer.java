package pl.put.poznan.transformer.logic.transforms;

import pl.put.poznan.transformer.logic.TextTransformerInterface;

import java.text.Normalizer;
import java.util.regex.Pattern;
/**
 *  Class used to make 'delete' transformation
 *  Deleting all PL special symbols
 */
public class DeletePLSymbolsTrarnsformer implements TextTransformerInterface {

    /**
     * @param text
     * @return sformatowany text - po usunięciu polskich znaków
     */
    public String transform(String text) {
            text = text.replaceAll("Ł", "L");
            text = text.replaceAll("ł", "l");
            String nfdNormalizedString = Normalizer.normalize(text, Normalizer.Form.NFD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            return pattern.matcher(nfdNormalizedString).replaceAll("");
    }
}
