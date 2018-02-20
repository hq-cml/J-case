package com.Jcase;

import java.util.*;

/**
 * 哈希表使用
 */
public class HashDemo {
    public static void main(String args[]){
        Hashtable ha=new Hashtable();
        ha.put("one",new Integer(1));
        ha.put("two",new Integer(2));
        ha.put("three",new Integer(3));
        ha.put("four",new Double(12.3));

        //哈希表遍历
        Set s=ha.keySet();
        for(Iterator<String> i=s.iterator();i.hasNext();){
            Object idx = i.next();
            System.out.println(idx.toString() + " : " + ha.get(idx));
        }
    }
}
