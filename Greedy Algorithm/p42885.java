// 2020-08-25 Yoo Jaein
// [PRG] 42885 구명보트
// Greedy Algorithm
import java.io.*;
import java.util.*;

public class Main {
		
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
    	int answer = 0;
    	
    	int[] people = {10, 20, 30, 40, 50, 60, 70, 80, 90};
    	int limit = 100;
    	
    	// people 정렬한 후,
    	// 앞에서부터 접근 & 뒤에서부터 접근을 동시에 사용한다.
    	
    	Arrays.sort(people);
    	int i=0, j;
    	
    	for(j=people.length-1; i<j; j--) {
    		if(people[i]+people[j]>limit) answer++; // people[j]를 보트에 태운다.
    		else { // limit 안에 들어오면 people[j]와 함께
    			answer++;
    			i++; // people[i]를 보트에 태운다.
    		}
    	}
    	if(i==j) answer++; // 마지막에 혼자 남는 경우
    	
    	
    	System.out.println(answer);
    	
    	br.close();
    	return;
    }
}
