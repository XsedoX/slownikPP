package JsonManagment;

import Dictionary.Dictionary;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public interface IJsonManagment {
    boolean serializeDict(Dictionary dictionary);
    Dictionary desarializeDict(String filePath) throws IOException;

}
