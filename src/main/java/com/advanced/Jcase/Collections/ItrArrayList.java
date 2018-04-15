package com.advanced.Jcase.Collections;

import java.util.*;

public class ItrArrayList {
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        list.add("Hello");
        list.add("World");
        list.add("HAHAHAHA");

        //第1种遍历，把链表变为数组相关的内容进行遍历
        String[] strArray=new String[list.size()];
        list.toArray(strArray);
        for(int i=0;i<strArray.length;i++) //这里也可以改写为  foreach(String str:strArray)这种形式
        {
            System.out.println(strArray[i]);
        }

        //第2种遍历方法使用foreach遍历List
        for (String str : list) {            //也可以改写for(int i=0;i<list.size();i++)这种形式
            System.out.println(str);
        }

        //第3种遍历 使用迭代器进行相关遍历
        Iterator<String> itr=list.iterator();
        while(itr.hasNext())//判断下一个元素之后有值
        {
            System.out.println(itr.next());
        }
    }
}
