package pl.put.poznan.transformer.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
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

        String result = text;
        for (String transform : transforms) result = findTransformer(transform).transform(result);

        return new Response(result);
    }

    /**
     * Helper function to find the correct class for the transformation
     * @param name a name of transformation requested by user
     * @return a proper transformer class served as an interface
     */
    private static TextTransformerInterface findTransformer(String name) {
        switch(name) {
            case "upper": return new ToUpperTransformer();
            case "lower": return new ToLowerTransformer();
            case "capitalize": return new ToCapitalizeTransformer();
            case "delete": return new DeletePLSymbolsTrarnsformer();
            case "inverse": return new InverseTextTransformer();
            case "duplicate": return new DeleteDuplicateWordsTransformer();
            case "latex": return new LatexSymbolsTransformer();
            case "verbal": return new NumToStringTransformer();
            case "no-shortcut": return new ToShortcutTransformer();
            default: return null; //TODO: make some NoOpController that does nothing
        }
    }
}


