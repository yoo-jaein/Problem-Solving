// 2020-08-22 Yoo Jaein
// [BOJ] 1032 명령 프롬프트
// 구현
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	
    	int N = Integer.parseInt(br.readLine());
    	String[] arr = new String[N];
    	for(int i=0; i<N; i++) {
    		arr[i] = br.readLine();
    	}
    	
    	String answer = "";
    	for(int j=0; j<arr[0].length(); j++) {
    		boolean flag = true;
    		char ch = arr[0].charAt(j);
    		
    		for(int i=1; i<N; i++) {
    			if(arr[i-1].charAt(j)==arr[i].charAt(j))
    				continue;
    			else {
    				flag = false;
    				break;
    			}
    		}
    		if(flag) answer += ch;
    		else answer += '?';
    	}
    	
    	System.out.println(answer);
    	
    	br.close();
    	return;
    }
}
