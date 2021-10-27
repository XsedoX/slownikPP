package LoadDictionaries;

import Dictionary.Dictionary;
import JsonManagment.JsonManagment;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class LoadDictionaries implements ILoadDictionaries {
    private Set<Dictionary> dictsSet = new HashSet<>();
    private JsonManagment jsonManagment = new JsonManagment();
    public LoadDictionaries() {}

    @Override
    public Set<Dictionary> getDictsSet() throws IOException {
        File dictionariesFilesNames = new File("src/main/Dictionaries/");
        String[] dictFiles = dictionariesFilesNames.list();
        if(dictFiles!=null) {
            for (String path : dictFiles)
                dictsSet.add(jsonManagment.desarializeDict(path));
        }
        return dictsSet;
    }


}
