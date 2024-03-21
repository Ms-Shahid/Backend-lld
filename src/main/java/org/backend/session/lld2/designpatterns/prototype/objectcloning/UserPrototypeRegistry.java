package org.backend.session.lld2.designpatterns.prototype.objectcloning;

import java.util.HashMap;
import java.util.Map;

public interface UserPrototypeRegistry{

    void addPrototype(User user);

    User getPrototype(UserType type);

    User clone(UserType type);

}
