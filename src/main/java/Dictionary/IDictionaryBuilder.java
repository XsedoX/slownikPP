package Dictionary;

import java.util.List;

public interface IDictionaryBuilder {
    IDictionaryBuilder language(String lang);
    IDictionaryBuilder wordsList(List<String> words);
    Dictionary build();

}
