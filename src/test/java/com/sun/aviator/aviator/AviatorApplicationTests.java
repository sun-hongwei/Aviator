package com.sun.aviator.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AviatorApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("1231231");
    }

    @Test
    void aviatorTet(){
        //算术表达式
        Long result1 = (Long) AviatorEvaluator.execute("1+2+3");
        System.out.println(result1);//6

        Long result2 = (Long) AviatorEvaluator.execute("3+5/2");
        System.out.println(result2);//

    }

}
