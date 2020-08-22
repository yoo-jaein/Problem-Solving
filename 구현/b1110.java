// 2020-08-22 Yoo Jaein
// [BOJ] 1110 더하기 사이클
// 구현
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	
    	int N = Integer.parseInt(br.readLine());
    
    	int tmp = N;
    	
    	int i=0;
    	while(true) {
    		i++;
    		
    		int sum = 0;
    		
    		// 10보다 작다면 0을 붙인다.
    		String tmpstr = String.valueOf(tmp);
    		if(tmpstr.length()<2)
    			tmpstr = "0"+tmpstr;
    		
    		// 각 자리 숫자를 더한다.
    		sum += tmpstr.charAt(0)-'0';
    		sum += tmpstr.charAt(1)-'0';
    		String sumstr = String.valueOf(sum);
    		
    		// 가장 오른쪽(마지막 인덱스) 수끼리 이어붙인다.
    		String newstr = tmpstr.substring(tmpstr.length()-1) + sumstr.substring(sumstr.length()-1);
    		
    		if(Integer.parseInt(newstr)==N) break;
    		
    		// tmp를 갱신한다.
    		tmp = Integer.parseInt(newstr);
    	}
    	
    	System.out.println(i);
    		
    	br.close();
    	return;
    }
}
