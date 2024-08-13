package org.backend.session.lld2.designpatterns.flyweight.graphic;

import java.util.HashMap;
import java.util.Map;

public class FlyweightRegistryImpl implements FlyweightRegistry{

    Map<GraphicType, GraphicIntrinsicState> graphicRegistry = new HashMap<>();
    @Override
    public void addFlyweight(GraphicIntrinsicState flyweight) {
        graphicRegistry.put(flyweight.getType(), flyweight);
    }

    @Override
    public GraphicIntrinsicState getFlyweight(GraphicType graphicType) {
        return graphicRegistry.get(graphicType);
    }
}
