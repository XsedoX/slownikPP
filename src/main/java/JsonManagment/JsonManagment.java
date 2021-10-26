package JsonManagment;

import Dictionary.Dictionary;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class JsonManagment implements IJsonManagment {
    private ObjectMapper mapper = new ObjectMapper();

    public JsonManagment() {}

    @Override
    public boolean serializeDict(Dictionary dictionary)
    {
        mapper.registerModule(new JodaModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(new File("src/main/Dictionaries/" + dictionary.getLanguage() + ".json"), dictionary);
            return true;
        } catch (IOException e)
        {
            return false;
        }
    }
}
