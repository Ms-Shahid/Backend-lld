package org.backend.session.lld2.designpatterns.flyweight.chessuser;

import lombok.Getter;

@Getter
public class ChessUserExtrinsicState {

    private Color colour;
    private int currentGameStreak;
    private ChessUserIntrinsicState chessUserIntrinsicState;
}

