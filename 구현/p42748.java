// 2020-11-02 Yoo Jaein
// [PRG] 42748 K번째수
// 구현

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
      
        for(int i=0; i<commands.length; i++)
        {            
            // copyOf(원본 배열, 복사할 길이), copyOfRange(원본배열, 시작인덱스, 끝인덱스)
            int[] newArray = Arrays.copyOfRange(array,commands[i][0]-1, commands[i][1]);
            
            Arrays.sort(newArray);
            answer[i] = newArray[commands[i][2]-1];
        }
        return answer;
    }
    
}