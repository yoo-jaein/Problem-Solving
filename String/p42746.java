// 2020-09-16 Yoo Jaein
// [PRG] 42746 가장 큰 수
// String

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] numbers = {6,10,2};
		String answer = "";
		
        String[] arr = new String[numbers.length];
        for (int i=0; i<numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);
            }
        });
        
        for(int i=0; i<arr.length; i++)
        	answer += arr[i];
        
        if(answer.charAt(0)=='0') answer = "0";
        System.out.println(answer);
		
		br.close();
		return;
    }
}
