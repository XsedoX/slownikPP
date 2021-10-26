package Dictionary;

import java.util.List;

public class Dictionary implements IDictionary
{
    private List<String> words;
    private String language;
    protected Dictionary(String lang, List<String> words)
    {
        this.language = lang;
        this.words = words;
    }

    @Override
    public boolean searchWord(String word)
    {
        return words.stream().anyMatch(lword -> lword.contains(word));
    }

    @Override
    public String getLanguage() {
        return language;
    }

    @Override
    public List<String> getWords()
    {
        return words;
    }
}
