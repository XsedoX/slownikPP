package Dictionary;

import java.util.List;

public class DictionaryBuilder implements IDictionaryBuilder {

    private List<String> words;
    private String lang;

    @Override
    public Dictionary build()
    {
        return new Dictionary(this.lang, this.words);
    }

    @Override
    public IDictionaryBuilder language(String lang)
    {
        this.lang = lang;
        return this;
    }

    @Override
    public IDictionaryBuilder wordsList(List<String> words)
    {
        this.words = words;
        return this;
    }

}
