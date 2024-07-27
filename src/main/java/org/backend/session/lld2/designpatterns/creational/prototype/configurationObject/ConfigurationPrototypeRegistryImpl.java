package org.backend.session.lld2.designpatterns.prototype.configurationObject;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationPrototypeRegistryImpl implements ConfigurationPrototypeRegistry{

    Map<ConfigurationType, Configuration> typeConfigurationMap = new HashMap<>();

    @Override
    public void addPrototype(Configuration user) {
        typeConfigurationMap.put(user.getType(), user);
    }

    @Override
    public Configuration getPrototype(ConfigurationType type) {
        return typeConfigurationMap.get(type);
    }

    @Override
    public Configuration clone(ConfigurationType type) {
        Configuration config = typeConfigurationMap.get(type);
        return config != null ? config.clone() : null;
    }
}
