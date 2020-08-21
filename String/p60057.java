// 2020-08-21 Yoo Jaein
// [PRG] 문자열 압축
// 2020 카카오 공채

import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	
    	String s = br.readLine();
    	int min = 1001;
    	
    	if(s.length()==1) 
    		min = 1;
    	
    	// 문자열을 n개 단위로 자른다
    	for(int n=1; n<=s.length()/2; n++) {
    		String cmp = "";
	    	String now = "";
	    	String result = "";
	    	
    		int cnt = 1;
    		for(int j=0; j<=s.length()/n; j++) {
    			int start = j*n;
    			int end = n*(j+1) > s.length() ? s.length() : n*(j+1); // 마지막 인덱스가 문자열 길이를 넘을 때 처리
    			
    			now = cmp;
    			cmp = s.substring(start, end);
    			
    			if(now.equals(cmp)) {
    				cnt++;
    			}
    			else {
    				if(cnt>1)
    					result += String.valueOf(cnt)+now;
    				else
    					result += now;
    				
    				cnt = 1;
    			}
	    	}
    		
    		// 마지막 인덱스 처리
    		if(cnt>1)
				result += String.valueOf(cnt)+cmp;
			else
				result += cmp;
    		
	    	min = Math.min(min, result.length());
    	}
    	
    	System.out.println(min);
    	
    	br.close();
    	return;
    }
}
