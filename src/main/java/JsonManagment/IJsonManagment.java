package JsonManagment;

import Dictionary.Dictionary;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface IJsonManagment {
    boolean serializeDict(Dictionary dictionary);

}
