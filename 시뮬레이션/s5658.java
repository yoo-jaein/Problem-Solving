// 2020-10-11 Yoo Jaein
// [SWEA] 5658 보물상자 비밀번호
// 시뮬레이션

import java.io.*;
import java.util.*;

public class Main {

	public static int toDecimal(String s) {
		int result = 0;
		
		for(int i=s.length()-1, j=0; i>=0; i--, j++) {
			int num;
			if(Character.isDigit(s.charAt(i)))
				num = Integer.parseInt(s.substring(i, i+1));
			else if(s.charAt(i)=='A')
				num = 10;
			else if(s.charAt(i)=='B')
				num = 11;
			else if(s.charAt(i)=='C')
				num = 12;
			else if(s.charAt(i)=='D')
				num = 13;
			else if(s.charAt(i)=='E')
				num = 14;
			else if(s.charAt(i)=='F')
				num = 15;
			else
				num = 16;
			result += (int) Math.pow(16, j) * num;
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		String str = sc.next();
		int rotate = n/4;
		
		HashSet<String> set = new HashSet<String>();
		Deque<String> d = new LinkedList<String>();
		
		// 덱에 숫자 하나씩 넣음
		for(int i=0; i<str.length(); i++) {
			d.addLast(str.substring(i, i+1));
		}
		
		// idx 1부터 rotate-1 번까지 회전
		for(int i=0; i<rotate; i++) {
			// 셋에 입력
			int cnt = 0;
			StringBuilder sb = new StringBuilder();
			
			for(String s : d) {
				if(cnt==rotate) {
					set.add(sb.toString());
					
					sb = new StringBuilder();
					cnt = 0;
				}
				sb.append(s);
				cnt++;
			}
			set.add(sb.toString());
			
			// 회전
			d.addFirst(d.pollLast());
		}
		
		ArrayList<String> list = new ArrayList<>();
		for(String s : set) {
			list.add(s);
		}
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				// 16진수 내림차순
				int num1 = toDecimal(s1);
				int num2 = toDecimal(s2);
				
				if(num1<num2) return 1;
				else return -1;
			}
		});
		
		String s = list.get(k-1);
		
		int answer = toDecimal(s);
		System.out.println(answer);			
		
		br.close();
    	return;
    }
}