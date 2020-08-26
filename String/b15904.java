// 2020-08-26 Yoo Jaein
// [BOJ] 15904 UCPC는 무엇의 약자일까?
// String

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	
		String s = br.readLine();
		
		char[] ucpc = {'U', 'C', 'P', 'C'};
        int index = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)==ucpc[index])
                index++;

            if(index==4) {
                System.out.println("I love UCPC");
                break;
            }
        }
        
        if(index!=4)
        	System.out.println("I hate UCPC");
		
		br.close();
    	return;
    }
}
