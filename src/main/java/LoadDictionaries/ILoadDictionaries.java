package LoadDictionaries;

import Dictionary.Dictionary;

import java.io.IOException;
import java.util.Set;

public interface ILoadDictionaries {
    Set<Dictionary> getDictsSet() throws IOException;
}
