package com.cyh.wyf.test;

import java.util.ArrayList;
import java.util.List;

public class Test {

	
			public static void main(String[] args){
				List  aa = new ArrayList();
				String bb = "{a=1,b=2}";
				aa.add(bb);
				System.out.println(aa);
			
				
			}
			public int[] add(int[] a){
				int[] b = {};
				for (int i = 0; i < a.length; i++) {
					a[i]+=1;
					System.out.println(a[i]);
				}
				
				return b ;
			}
			
			
}
