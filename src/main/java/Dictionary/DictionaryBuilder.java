package Dictionary;

import java.util.List;
import java.util.Set;

public class DictionaryBuilder implements IDictionaryBuilder {

    private Set<String> words;
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
    public IDictionaryBuilder wordsList(Set<String> words)
    {
        this.words = words;
        return this;
    }

}
