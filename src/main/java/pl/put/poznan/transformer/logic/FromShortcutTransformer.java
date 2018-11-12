package pl.put.poznan.transformer.logic;

/**
 *  klasa do zmiany pełnych słów na skróty
 */
public class FromShortcutTransformer implements TextTransformerInterface
{
	/**
     * Funkcja transformująca tekst
     * @param text tekst bez skrótów przed transformacją
     * @return tekst ze skróconymi nazwami.
     */
	public String transform(String text)
	{
		text = text.replaceAll("na przykład", "np.");
		text = text.replaceAll("Na przykład", "Np." );
		text = text.replaceAll("Na Przykład", "NP.");
		text = text.replaceAll("NA PRZYKŁAD", "NP.");
		text = text.replaceAll("między innymi", "m.in.");
		text = text.replaceAll("Między innymi", "M.in.");
		text = text.replaceAll("Między Innymi", "M.In.");
		text = text.replaceAll("MIĘDZY INNYMI", "M.IN.");
		text = text.replaceAll("i tym podobne", "itp.");
		text = text.replaceAll("I tym podobne", "Itp.");
		text = text.replaceAll("I Tym Podobne", "ITP.");
		text = text.replaceAll("I TYM PODOBNE", "ITP.");
		text = text.replaceAll("i tak dalej", "itd.");
		text = text.replaceAll("I tak dalej", "Itd.");
		text = text.replaceAll("I Tak Dalej", "ITD.");
		text = text.replaceAll("I TAK DALEJ", "ITD.");
		text = text.replaceAll("profesor", "prof.");
		text = text.replaceAll("Profesor", "Prof.");
		text = text.replaceAll("PROFESOR", "PROF.");
		text = text.replaceAll("doktor", "dr");
		text = text.replaceAll("Doktor", "Dr" );
		text = text.replaceAll("DOKTOR", "DR");
		
		return text;
	}
}