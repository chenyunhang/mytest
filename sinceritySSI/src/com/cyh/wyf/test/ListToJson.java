package com.cyh.wyf.test;

import java.util.LinkedList;
import java.util.List;

import com.cyh.wyf.entity.Person;

import net.sf.json.JSONArray;

public class ListToJson {  
	  
    public static void main(String[] args) {  
        List list = new LinkedList();  
        for(int i=0;i<3;i++){  
            Person p = new Person();  
            p.setAge(i);  
            p.setName("name"+i);  
            list.add(p);  
        }  
        JSONArray jsonarray = JSONArray.fromObject(list);  
        System.out.println(jsonarray);  
    }  
  
} 