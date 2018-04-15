package com.J8.Jcase;

import java.util.*;

/**
 * Lambda
 */
public class LambdaDemo2 {
    public static void main(String args[]) {
        Arrays.asList( "d", "b", "a" ).forEach( e -> System.out.println( e ) );

        System.out.println();
        List<String> s = Arrays.asList( "d", "b", "a" );
        s.sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
        s.forEach(e->System.out.println(e));
    }
}
