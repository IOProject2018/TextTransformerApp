package pl.put.poznan.transformer.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.*;

import java.util.Arrays;

/**
 * @author
 */
@RestController
@RequestMapping("/{text}")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    //Probably we may only want to use GET at this moment

    /**
     * @param text
     * @param transforms
     * @return
     */
    @GetMapping(produces = "application/json")
    public Response get(@PathVariable String text,
                        @RequestParam(value = "transforms", defaultValue = "upper,escape") String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        String result = text;

        // do the transformation, you should run your logic here, below just a silly example
        TextTransformerInterface transformer = null;
        for (String transform : transforms) {
            if (transform.equals("upper"))
                transformer = new ToUpperTransformer();

            if (transform.equals("lower"))
                transformer = new ToLowerTransformer();

            if (transform.equals("capitalize"))
                transformer = new ToCapitalizeTransformer();

            if (transform.equals("delete"))
                transformer = new DeletePLSymbolsTrarnsformer();

            if (transform.equals("inverse"))
                transformer = new InverseTextTransformer();
            
            if(transform.equals("no-shortcut"))
                transformer = new ToShortcutTransformer();

            if (transform.equals("duplicate"))
                transformer = new DeleteDuplicateWordsTransformer();

            if (transform.equals("latex"))
                transformer = new LatexSymbolsTransformer();


            result = transformer.transform(text);
        }

        return new Response(result);
    }
}


