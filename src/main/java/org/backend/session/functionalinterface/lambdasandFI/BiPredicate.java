package org.backend.session.functionalinterface.lambdasandFI;

public class BiPredicate implements java.util.function.BiPredicate<String, Integer> {
    @Override
    public boolean test(String s, Integer integer) {

        if( s.length() > integer ) return true;
        return false;
    }
}
