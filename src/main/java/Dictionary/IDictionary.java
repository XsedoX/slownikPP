package Dictionary;

import java.util.List;
import java.util.Set;

public interface IDictionary {
    boolean searchWord(String word);
    String getLanguage();
    Set<String> getWords();

}
