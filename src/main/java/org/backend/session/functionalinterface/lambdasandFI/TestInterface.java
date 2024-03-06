package org.backend.session.functionalinterface.lambdasandFI;

@FunctionalInterface
public interface TestInterface {

    void fun();

    default void fun1() {
        System.out.println("Default method ");
    }
//    void fun2();  This is cause issue due to the property of functional interface


}
