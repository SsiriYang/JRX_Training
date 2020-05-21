package com.codeyang.jrxtraining.ExceptionStudy;

/**
 * @Author 41765
 * @Creater 2020/5/15 0:18
 * Description
 * 自定义异常继承Exception
 */

public class AgeException extends Exception {
    public AgeException(String msg)
    {
        super(msg);
    }
}