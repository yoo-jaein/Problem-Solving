// 2020-10-24 Yoo Jaein
// [PRG] 12911 다음 큰 숫자
// 수학

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int answer = 0;
		int n = 15;
		boolean flag = false;
		
		int num = n;
		int cnt = 0; // n을 2진수로 변환했을 때 1의 개수
		
		while(num!=0) {
			if(num%2==1)
				cnt++;
			num /= 2;
		}
		
		int next = n+1;
		while(!flag) {
			int tmp = next;
			int cnt2 = 0;
			
			while(tmp!=0) {
				if(tmp%2==1)
					cnt2++;
				tmp /= 2;
			}
			
			if(cnt==cnt2)
				break;
			
			next++;
		}
		answer = next;
		
		System.out.println(answer);
		
		br.close();
    	return;
    }
}