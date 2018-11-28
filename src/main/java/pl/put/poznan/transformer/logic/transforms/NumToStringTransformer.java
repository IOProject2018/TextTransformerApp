package pl.put.poznan.transformer.logic.transforms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.transformer.logic.TextTransformerDecorator;
import pl.put.poznan.transformer.logic.TextTransformerInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


/**
 * Class used to convert integers and floats to Polish verbal representation
 */
public class NumToStringTransformer extends TextTransformerDecorator {

    public NumToStringTransformer(TextTransformerInterface transformerInterface) {
        super(transformerInterface);
    }

    private static final Logger logger = LoggerFactory.getLogger(NumToStringTransformer.class);

    /**
     * Main transformation function
     * @param textIn input text that contains numbers
     * @return formatted text with verbal numbers representation
     */
    public String transform(String textIn) {
        String text = super.transform(textIn);
        ArrayList<String> words = new ArrayList<>(Arrays.asList(text.split(" ")));
        return words.stream().map(NumToStringTransformer::floatToString).collect(Collectors.joining(" "));
    }

    /**
     * The function that converts string with digital to the text representation of number
     * @param word is a word that may be a float
     * @return is a text representation of number or unchanged word if is NaN
     */
    private static String floatToString(String word) {
        String czesci[] = {"dziesiąt", "setn", "tysięczn"};
        String koncowki[] = {"ych", "a", "e", "e", "e"};
        try {
            Float.parseFloat(word);
        } catch (NumberFormatException e) {
            return word;
        }

        String parts[] = word.split("[.,]");
        String reszta = "";
        if(parts.length > 1) {
            if(Integer.parseInt(parts[0])!=0)
                reszta += " i ";
            if(parts[1].length() > 3)
                parts[1] = parts[1].substring(0,3);
            int val = Integer.parseInt(parts[1]);
            reszta += intToString(val, true) + " ";
            reszta += czesci[parts[1].length()-1];
            if(val > 4) reszta += "ych";
            else reszta += koncowki[val];
        }

        return intToString(Integer.parseInt(parts[0]), false) + reszta;
    }

    /**
     * The function that converts integer in string to text representation of that integer
     * @param value is a value to be changed to text
     * @param isrest is true if number represent the rest
     * @return is a text representation of integer
     */
    private static String intToString(int value, Boolean isrest) {
        String jednosci[] = {"zero", "jeden", "dwa", "trzy", "cztery", "pięć", "sześć", "siedem", "osiem", "dziewięć"};
        String jedreszta[] = {"zero", "jedna", "dwie"};
        String nascie[] = {"dziesięć", "jedenaście", "dwanaście", "trzynaście", "czternaście", "piętnaście", "szesnaście", "siedemnaście", "osiemnaście", "dziewiętnaście"};
        String dziesiatki[] = {"dwadzieścia", "trzydzieści", "czterdzieści"};
        String setki[] = {"sto", "dwieście", "trzysta", "czterysta"};

        String result = "";

        if(value > 999999) {
            logger.warn("Input number "+value+"exceeded limit!");
            return String.valueOf(value);
        }

        if(value < 0) {
            result += "minus ";
            value *= -1;
        }

        while(value!=0) {
            if(isrest && value < 3) {
                result += jedreszta[value];
                break;
            }
            else if(value < 10) {
                result += jednosci[value];
                break;
            }
            else if(value < 20) {
                result += nascie[value%10];
                break;
            }
            else if(value < 50) {
                result += dziesiatki[(value/10)-2];
                value %= 10;
            }
            else if(value < 100) {
                result += jednosci[value/10]+"dziesiąt";
                value %= 10;
            }
            else if(value < 500) {
                result += setki[(value/100)-1];
                value %= 100;
            }
            else if(value < 1000) {
                result += jednosci[value/100]+"set";
                value%=100;
            }
            else if(value < 2000) {
                result += "tysiąc";
                value %= 1000;
            }
            else if(value < 5000) {
                result += jednosci[value/1000]+" tysiące";
                value %= 1000;
            }
            else {
                result += intToString(value/1000, false) + " tysięcy";
                value %= 1000;
            }

            result += " ";
        }

        return result;
    }
}
