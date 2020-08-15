// 2020-08-16 Yoo Jaein
// [BOJ] 1157 단어 공부
// String

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	
    	String s = br.readLine().toUpperCase();
    	HashMap<Character, Integer> map = new HashMap<>();
    	
    	for(int i=0; i<s.length(); i++) {
    		if(map.containsKey(s.charAt(i)))
    			map.replace(s.charAt(i), map.get(s.charAt(i))+1);
    		else
    			map.put(s.charAt(i), 1);
    	}
    	
    	// value 내림차순 정렬
    	Stream<Map.Entry<Character, Integer>> sorted =
    		    map.entrySet().stream()
    		       .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
    	
    	int max = 0;
    	char ch = ' ';
    	
    	Iterator<Entry<Character, Integer>> it = sorted.iterator();    	
    	while(it.hasNext()) {
    		Entry<Character, Integer> e = it.next();
    		int v = e.getValue();
    		
    		if(max<v) {
    			max = v;
    			ch = e.getKey();
    		}
    		else if(max==v) {
    			ch = '?';
    			break;
    		}
    	}
    	
    	System.out.println(ch);
		br.close();
    	return;
    }
}
