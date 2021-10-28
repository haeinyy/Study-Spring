package com.ssafy.mvc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Test {

	public static void main(String[] args) {
		
//		List list = new ArrayList(); // java.util.ArrayList$Itr
//		List list = new LinkedList(); // java.util.LinkedList$ListItr
		List list = new Vector(); // java.util.Vector$Itr
		list.add("홍길동");
		list.add("손오공");
		list.add("사오정");
		
		Iterator it = list.iterator(); // factory method
		System.out.println(it.getClass().getName());
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
