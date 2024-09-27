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
        String maxLengthStr = "";
        String finalMaxLengthStr = "";
        int maxLength = 1;

        for(int i=0;i<s.length();i++){
           // System.out.print(s.charAt(i));
            maxLengthStr = String.valueOf(s.charAt(i));
            //System.out.println("maxLengthStr: "+maxLengthStr);
            for(int j=i+1;j<s.length();j++){
              //  System.out.println("Comparing maxLengthStr: "+maxLengthStr+" with char at j="+j+" is " + s.charAt(j));
                if(maxLengthStr.contains(String.valueOf(s.charAt(j)))){
                  //  System.out.println("In IF" );
                    maxLengthStr="";
                   break;
                }else {
                   // System.out.println("IN ELSE");
                    maxLengthStr+=s.charAt(j);
                    if(maxLengthStr.length()>maxLength){
                        maxLength++;
                      //  System.out.println("maxlength= "+maxLengthStr);
                        finalMaxLengthStr = maxLengthStr;
                    }

                }
            }
        }

        System.out.println("Max Length = "+finalMaxLengthStr.length()+" Max Length String is : "+finalMaxLengthStr);

    }


}
