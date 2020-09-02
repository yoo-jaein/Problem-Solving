// 2020-09-02 Yoo Jaein
// [PRG] 49993 스킬트리
// String

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		int answer = 0;
				
		for(int i=0; i<skill_trees.length; i++) {
			int index = 0;
			boolean check = true;
			
			for(int j=0; j<skill_trees[i].length(); j++) {
				if(index==skill.length()-1)
					break;
				
				if(skill.charAt(index)==skill_trees[i].charAt(j)) {
					index++;
					continue;					
				}
				
				if(skill.contains(skill_trees[i].substring(j,j+1))) {
					check = false;
					break;
				}
				
			}
			if(check) answer++;
		}
		System.out.println(answer);
		
    	return;
    }
}
