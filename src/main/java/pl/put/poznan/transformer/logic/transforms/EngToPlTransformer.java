package pl.put.poznan.transformer.logic.transforms;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.Translation;
import pl.put.poznan.transformer.logic.TextTransformerDecorator;
import pl.put.poznan.transformer.logic.TextTransformerInterface;

public class EngToPlTransformer extends TextTransformerDecorator {

    public EngToPlTransformer(TextTransformerInterface transformerInterface) {
        super(transformerInterface);
    }

    public String transform(String textIn) {
        String text = super.transform(textIn);

        Translate translate = TranslateOptions.newBuilder().build().getService();
        TranslateOption srcLang = Translate.TranslateOption.sourceLanguage("en");
        TranslateOption tgtLang = Translate.TranslateOption.targetLanguage("pl");

        Translation translation = translate.translate(text, srcLang, tgtLang);
        return translation.getTranslatedText();
    }
}
