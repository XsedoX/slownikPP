package Dictionary;

import java.util.List;

public interface IDictionary {
    boolean searchWord(String word);
    String getLanguage();
    List<String> getWords();

}
