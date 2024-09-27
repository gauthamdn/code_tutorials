package src.Sep_22_2024;

/*
* Given a string s, find the length of the longest
substring
 without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.

* */

public class Exercise1 {

    public static void main(String[] args) {

        String s = "abcabcbb";
        //String s = "pwwkew";
        //String s = "111111";
        //String s ="";
        String maxLengthStr = "";
        String finalMaxLengthStr = "";
        int maxLength = 1;

        for(int i=0;i<s.length();i++){
            // Assign maxLength string to the first char
            maxLengthStr = String.valueOf(s.charAt(i));

            for(int j=i+1;j<s.length();j++){

                // Check if the next char is already in the MaxlengthString , if yes , then reset the max length string, else increment
                if(maxLengthStr.contains(String.valueOf(s.charAt(j)))){
                    maxLengthStr="";
                    break;
                }else {
                    maxLengthStr+=s.charAt(j);
                    if(maxLengthStr.length()>maxLength){
                        maxLength++;
                        finalMaxLengthStr = maxLengthStr;
                    }

                }
            }
        }

        System.out.println("Max Length = "+finalMaxLengthStr.length()+", Max Length String is : "+finalMaxLengthStr);

    }


}
