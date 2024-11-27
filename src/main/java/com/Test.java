package com;

import java.util.ArrayList;
import java.util.List;

public class Test {

    static Integer a = 9;
    public static Integer abc(){
       new Test().def();
       return 123;
    }

    public Test() {
        this.a = 10;
    }

    public Integer def(){
        Test.a = 11;
        List<String> xyz = new ArrayList<>();

        return 345;
    }
}
