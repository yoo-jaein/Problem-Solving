// 2020-11-02 Yoo Jaein
// [PRG] 42576 완주하지 못한 선수
// Data Structure: HashMap

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        
        // HashMap에 pName,value 입력
        for(String pName : participant) {
            if (map.containsKey(pName)) {
                Integer value = map.get(pName);
                map.replace(pName, ++value);
            } 
            else {
                map.put(pName, 1);
            }
        }
        
        // HashMap에 cName있는지 체크, 있으면 value--
        for(String cName : completion) {
            Integer value = map.get(cName);
            map.replace(cName, --value);
        }
        
        // HashMap에 value!=0인 name을 answer에 담기
        Set<String> keys = map.keySet();
        for (String key : keys) {
            if (map.get(key)!=0) { 
                answer = key;
                break;
            }
        }
        
        return answer;
    }
}