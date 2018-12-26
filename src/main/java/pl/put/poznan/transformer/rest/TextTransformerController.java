package pl.put.poznan.transformer.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.TextTransformerImpl;
import pl.put.poznan.transformer.logic.TextTransformerInterface;
import pl.put.poznan.transformer.logic.transforms.*;
import pl.put.poznan.transformer.model.Response;

import java.util.Arrays;

/**
 * Main controller class of the application
 */
@CrossOrigin
@RestController
@RequestMapping("/{text}")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    //Probably we may only want to use GET at this moment

    /**
     * @param text a text passed by user via GET request
     * @param transforms a comma-separated list of transforms the user wants to perform
     * @return a serialized JSON object containing transformed text
     */
    @CrossOrigin
    @GetMapping(produces = "application/json")
    public Response get(@PathVariable String text,
                        @RequestParam(value = "transforms", defaultValue = "upper") String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        String result = createTransformationChain(transforms).transform(text);

        return new Response(result);
    }

    /**
     * Helper function to create decorated transformation chain for strings
     * @param transforms is an array of string transform directives
     * @return an interface representing transform chain
     */
    private static TextTransformerInterface createTransformationChain(String[] transforms) {
        TextTransformerInterface chain = new TextTransformerImpl();
        for (String transform : transforms) chain = decorateTransformer(transform, chain);
        return chain;
    }

    /**
     * Helper function to find the correct class for the transformation
     * @param name a name of transformation requested by user
     * @return a proper transformer class served as an interface
     */
    private static TextTransformerInterface decorateTransformer(String name, TextTransformerInterface transformerInterface) {
        switch(name) {
            case "upper": return new ToUpperTransformer(transformerInterface);
            case "lower": return new ToLowerTransformer(transformerInterface);
            case "capitalize": return new ToCapitalizeTransformer(transformerInterface);
            case "delete": return new DeletePLSymbolsTrarnsformer(transformerInterface);
            case "inverse": return new InverseTextTransformer(transformerInterface);
            case "duplicate": return new DeleteDuplicateWordsTransformer(transformerInterface);
            case "latex": return new LatexSymbolsTransformer(transformerInterface);
            case "verbal": return new NumToStringTransformer(transformerInterface);
            case "no-shortcut": return new ToShortcutTransformer(transformerInterface);
            case "make-shortcuts": return new FromShortcutTransformer(transformerInterface);
            case "translate": return new EngToPlTransformer(transformerInterface);
            default: return transformerInterface;
        }
    }
}


