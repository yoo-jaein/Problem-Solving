// 2021-01-28 Yoo Jaein
// [BOJ] 10825 국영수
// 구현

import java.io.*;
import java.util.*;

public class Main {
	
	static class Student {
		String name;
		int kor;
		int eng;
		int mat;
		
		public Student(String name, int kor, int eng, int mat) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.mat = mat;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Student> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int mat = Integer.parseInt(st.nextToken());
			
			list.add(new Student(name, kor, eng, mat));
		}
		
		Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.kor == o2.kor) {
					if(o1.eng == o2.eng) {
						if(o1.mat == o2.mat) {
							// 국어 영어 수학 점수가 같을 때
							return o1.name.compareTo(o2.name);
						}
						// 국어 영어 점수가 같을 때
						return o2.mat - o1.mat;
					}
					// 국어 점수가 같을 때
					return o1.eng - o2.eng;
				}
				// 아니면
				return o2.kor - o1.kor;
			}
		});
		
		for(Student s : list) {
			System.out.println(s.name);
		}
		
		br.close();
		return;
	}
}