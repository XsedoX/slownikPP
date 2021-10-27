package Dictionary;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Set;

public class Dictionary implements IDictionary
{
    private Set<String> words;
    private String language;

    public Dictionary(){}

    protected Dictionary(String lang, Set<String> words)
    {
        this.language = lang;
        this.words = words;
    }


    @Override
    @JsonIgnore
    public boolean searchWord(String word)
    {
        return words.stream().anyMatch(lword -> lword.equals(word));
    }

    @Override
    public String getLanguage() {
        return language;
    }

    public void setWords(Set<String> words) {
        this.words = words;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public Set<String> getWords()
    {
        return words;
    }

}
