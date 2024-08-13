package org.backend.session.lld2.designpatterns.flyweight.chessuser;

import lombok.Getter;

@Getter
public class ChessUserIntrinsicState {

    private String name;
    private int age;
    private String gender;
    private String email;
    private String phoneNumber;
    private Byte[] photo;
}
