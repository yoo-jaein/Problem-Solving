// 2020-10-24 Yoo Jaein
// [PRG] 12924 숫자의 표현
// 구현

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 15;
		int result = 0;
		
		for(int i=1; i<=n; i++) {
			int sum = 0;
			for(int j=i; j<=n; j++) {
				sum += j;
				
				if(sum > n) break;
				if(sum == n) {
					result++;
					break;
				}
			}
		}
		
		System.out.print(result);
		
		br.close();
    	return;
    }
}