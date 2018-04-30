package com.advanced.Jcase.Annotation3;

public class TestObj {

    @CheckAnno
    public void suanShu(){
        System.out.println("1234567890");
    }

    @CheckAnno
    public void jiafa(){
        System.out.println("1+1="+1+1);
    }

    @CheckAnno
    public void jianfa(){
        System.out.println("1-1="+(1-1));
    }

    @CheckAnno
    public void chengfa(){
        System.out.println("3 x 5="+ 3*5);
    }

    @CheckAnno
    public void chufa(){
        System.out.println("6 / 0="+ 6 / 0);
    }

    public void ziwojieshao(){
        System.out.println("我写的程序没有 bug!");
    }

}