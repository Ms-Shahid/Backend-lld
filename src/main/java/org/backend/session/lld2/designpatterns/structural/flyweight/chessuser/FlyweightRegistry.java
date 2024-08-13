package org.backend.session.lld2.designpatterns.flyweight.chessuser;

public interface FlyweightRegistry {

    void addFlyweight(ChessUserIntrinsicState flyweight);

    ChessUserIntrinsicState getFlyweight(String email);
}
