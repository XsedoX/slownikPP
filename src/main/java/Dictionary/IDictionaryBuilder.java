package Dictionary;

import java.util.List;
import java.util.Set;

public interface IDictionaryBuilder {
    IDictionaryBuilder language(String lang);
    IDictionaryBuilder wordsList(Set<String> words);
    Dictionary build();

}
