import java.util.*;

class Solution {  
    public boolean anagramStrings(String s, String t) {
        //your code goes here
        if(s.length()!=t.length()) return false;

        HashMap<Character,Integer>  mpp = new HashMap<>();

        char[] ans = s.toCharArray();

        for(char ch : ans){
            mpp.put(ch,mpp.getOrDefault(ch,0)+1);
        }

        char[] res = t.toCharArray();

         for(char ch : res){
            mpp.put(ch,mpp.getOrDefault(ch,0)-1);
        }

        for(int val:mpp.values()){
            if(val != 0){
                 return false;
            }
        }
    
    return true;

    }
}