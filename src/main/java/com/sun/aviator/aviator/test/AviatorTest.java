package com.sun.aviator.aviator.test;

import com.googlecode.aviator.AviatorEvaluator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hibernate.validator.internal.util.CollectionHelper.newHashMap;

public class AviatorTest {

    public static void main(String[] args) {
        //算术表达式
        Long result1 = (Long) AviatorEvaluator.execute("1+2+3");
        System.out.println(result1);//6

        Double result2 = (Double) AviatorEvaluator.execute("2.5+2.5");
        System.out.println(result2);//

        Double result3 = (Double) AviatorEvaluator.execute("5%2+0.000000000");
        System.out.println(result3);//

        //逻辑表达式
        Boolean result4 = (Boolean)AviatorEvaluator.execute("3>1 && 2!=4 || true");
        System.out.println(result4);//true

        Boolean result5 = (Boolean)AviatorEvaluator.execute("3>1 && 2!=4 || 123");
        System.out.println(result5);//true

        Boolean result6 = (Boolean)AviatorEvaluator.execute("3==1");
        System.out.println(result6);//false

        //变量和字符串相加
        Map env = new HashMap();
        env.put("yourname","aviator1");
        env.put("yourname","aviator2");
        String result7 = (String)AviatorEvaluator.execute(" 'hello ' + yourname ", env);
        System.out.println(result7);

        //三元表达式
        String result8=(String)AviatorEvaluator.execute("3>0 ? 'yes':'no'");
        System.out.println(result8);

        //函数调用
        Boolean result9 =  (Boolean) AviatorEvaluator.execute("string.length('hello') == 5");    //求字符串长度
        System.out.println(result9);
        AviatorEvaluator.execute("string.contains('hello','h')");  //判断字符串是否包含字符串AviatorEvaluator.execute("string.startsWith('hello','h')");  //是否以子串开头AviatorEvaluator.execute("string.endsWith('hello','llo')");是否以子串结尾
        AviatorEvaluator.execute("math.pow(-3,2)");   //求n次方
        AviatorEvaluator.execute("math.sqrt(14.0)");   //开 平方根
        AviatorEvaluator.execute("math.sin(20)");    //正弦函数

        Double result10 = (Double) AviatorEvaluator.execute("1000+100.0*99-(600-3*15)/(((68-9)-3)*2-100)+10000%7*71");
        System.out.println(result10);
    }
}
