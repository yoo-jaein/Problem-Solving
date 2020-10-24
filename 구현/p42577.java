// 2020-10-24 Yoo Jaein
// [PRG] 42577 전화번호 목록
// 구현

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean answer = true;
		String[] phone_book = {"2", "12", "1235"};
		
		label:
		for(int i=0; i<phone_book.length; i++) {
			for(int j=0; j<phone_book.length; j++) {
				if(i==j) continue;
				
				if(phone_book[i].startsWith(phone_book[j])) {
					answer = false;
					break label;
				}
			}
		}
		
		System.out.println(answer);
		
		br.close();
    	return;
    }
}