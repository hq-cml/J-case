package com.Jcase.oop;

/**
 * 泛型应用
 * 泛型类
 * 泛型方法
 * 泛型接口
 */
public class GenericTypeDemo {
    public static void main(String[] args){
        //泛型类实例化
        Point<Integer, Integer> p1 = new Point<Integer, Integer>();
        p1.setX(10);
        p1.setY(20);
        int x = p1.getX();
        int y = p1.getY();
        System.out.println("This point is: " + x + ", " + y);
        p1.printPoint(p1.getX(), p1.getY());

        //再实例化一个
        Point<Double, String> p2 = new Point<Double, String>();
        p2.setX(25.4);
        p2.setY("东京180度");
        double m = p2.getX();
        String n = p2.getY();
        System.out.println("This point is：" + m + ", " + n);
        p2.printPoint(p2.getX(), p2.getY());

        //实例化一个泛型接口的实现类
        InfoIntfs<String> obj = new InfoImp<String>("AAAA");
        System.out.println("The var is: " + obj.getVar());
    }

}

//定义泛型类
class Point<T1, T2> {
    T1 x;
    T2 y;

    //setter & getter
    public T1 getX() {
        return this.x;
    }
    public T2 getY() {
        return this.y;
    }
    public void setX(T1 x) {
        this.x = x;
    }
    public void setY(T2 y) {
        this.y = y;
    }

    //定义泛型方法
    public <T1, T2> void printPoint(T1 x, T2 y) {
        T1 m = x;
        T2 n = y;
        System.out.println("This point is: "+ m + ", " + n);
    }
}

//定义泛型接口
interface InfoIntfs<T> {
    public T getVar();
}

//实现泛型的接口
class InfoImp<T> implements InfoIntfs<T> {
    private T var;

    //构造方法
    public InfoImp(T var) {
        this.var = var;
    }

    //实现方法
    public T getVar() {
        return this.var;
    }
}
