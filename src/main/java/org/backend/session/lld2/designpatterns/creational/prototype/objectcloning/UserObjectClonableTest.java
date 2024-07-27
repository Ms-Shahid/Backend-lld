package org.backend.session.lld2.designpatterns.prototype.objectcloning;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserObjectClonableTest {

    @Test
    public void testUserCloning(){

        User originalUser = new User(12L, "Akanksha", "example.com", "Anks12", 26, UserType.ADMIN);
        originalUser.setEmail("anks@example.com");
    }
}
