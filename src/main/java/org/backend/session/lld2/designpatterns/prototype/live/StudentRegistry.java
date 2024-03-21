package org.backend.session.lld2.designpatterns.prototype.live;

import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {

    private Map<String, Student> registry = new HashMap<>();

    public void setRegistry(String key, Student student){
        registry.put(key, student);
    }

    public Student getRegistry(String key){
        return registry.get(key);
    }
}
