package org.backend.session.lld2.designpatterns.prototype.configurationObject;

public interface ConfigurationPrototypeRegistry {

    void addPrototype(Configuration user);

    Configuration getPrototype(ConfigurationType type);

    Configuration clone(ConfigurationType type);
}
