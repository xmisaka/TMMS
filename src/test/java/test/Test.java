package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

public class Test {
    public static void path(HttpServletRequest request){
    	System.out.println(request.getPathInfo());
        System.out.println(request.getPathTranslated());
        System.out.println(request.getServletPath());
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HttpServletRequest request = null;
		Map<Integer,Integer> m1 = new HashMap<Integer,Integer>();  
        m1.put(1, 11);  
        m1.put(2, 22); 
        m1.put(3, 33); 
        m1.put(4, 44); 
        m1.put(5, 55); 
        m1.put(6, 66); 
        System.out.println("未移除前:"+m1.size());
        for(Integer in:m1.keySet()){
        	System.out.println(in);
        }
        m1.remove(2);
        m1.remove(3);
        System.out.println("移除后:"+m1.size());
        for(Entry<Integer, Integer> in:m1.entrySet()){
        	System.out.println(in);
        }
        System.out.println(Class.class.getClass().getResource("/").getPath());
        
	}

}
