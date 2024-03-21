package org.backend.session.lld2.designpatterns.prototype.objectcloning;

import java.util.HashMap;
import java.util.Map;

public class UserRegistry implements UserPrototypeRegistry {

    private Map<UserType, User> userregistry = new HashMap<>();


    @Override
    public void addPrototype(User user) {
        userregistry.put(user.getType(), user);
    }

    @Override
    public User getPrototype(UserType type) {
        return userregistry.get(type);
    }

    @Override
    public User clone(UserType type) {
        User prototype = userregistry.get(type);
        return prototype != null ? prototype.cloneObject() : null;
    }
}
