package utility;

import java.util.HashMap;
import java.util.Map;

//This class is imported into the steps class so that data can be shared between steps using scenario context
public class ScenarioContext {

    private final Map<String, Object> scenarioContext;

    public ScenarioContext(){
        scenarioContext = new HashMap<>();
    }

    public void setContext(String key, Object value) {
        scenarioContext.put(key, value);
    }

    public Object getContext(String key){
        return scenarioContext.get(key);
    }
}
