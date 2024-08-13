package org.backend.session.lld2.designpatterns.flyweight.chessuser;

import java.util.HashMap;
import java.util.Map;

public class FlyweightRegistryimpl implements FlyweightRegistry{

    private Map<String, ChessUserIntrinsicState> flyWeightRegistry = new HashMap<>();

    @Override
    public void addFlyweight(ChessUserIntrinsicState flyweight) {
        flyWeightRegistry.put(flyweight.getEmail(), flyweight);
    }

    @Override
    public ChessUserIntrinsicState getFlyweight(String email) {
        return flyWeightRegistry.get(email);
    }
}
