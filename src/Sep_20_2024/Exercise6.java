package src.Sep_20_2024;

/*
Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
For the last line of text, it should be left-justified, and no extra space is inserted between words.
Note:
A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.

        Example 1:
Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
        [
        "This    is    an",
        "example  of text",
        "justification.  "
        ]
*/


import java.util.Arrays;

public class Exercise6 {

    public static String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
    static int maxWidth=16;

    public static void main(String[] args) {

        // method to split the words into multiple lines for the given maxWidth
        String[] broken_text = break_text(words,maxWidth);

        // method to center justify the first two lines
        String[] justified_text = new String[broken_text.length];
        for(int i=0;i<broken_text.length-1;i++){
            justified_text[i] = center_justify_text(broken_text[i],maxWidth);
        }

        // method to left justify the last row
        justified_text[broken_text.length-1] = left_justify_text(broken_text[broken_text.length-1],maxWidth);


        System.out.println("Final Output:[");
        for(int i=0;i<justified_text.length;i++){
            System.out.println(justified_text[i].toString());
        }
        System.out.println("]");


    }

    private static String left_justify_text(String s,int maxWidth) {

        int num_of_words = word_count(s);
        int num_of_chars = s.length();
        int num_of_space_needed = maxWidth - num_of_chars;

        //   System.out.println("num_of_words: "+num_of_words+"num_of_chars: "+num_of_chars+"num_of_space_needed: "+num_of_space_needed);
        s = add_right_padding(s,num_of_space_needed);
        //   System.out.println("left_justified_text is : "+s);
        return s;
    }

    private static String add_right_padding(String s, int numOfCharNeeded) {
        for (int i = 0; i < numOfCharNeeded; i++) {
            s+=" ";
        }
        return s;
    }

    private static int word_count(String s) {
        int word_count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ' && Character.isLetter(s.charAt(i+1)) && (i > 0)){
                word_count++;
            }
        }
        word_count++;
        return word_count;
    }

    private static String center_justify_text(String s, int maxWidth) {

        //trim any leading spaces in the string1 s
        // This method uses slot based logic.
        // Identify the number of spaces to add ( maxWidth - numofchars)
        // identify the number of slots to fill these spaces inbetween the words ( eg: so if there are 3 words in a line, 2 slots to fill the spaces)
        s = s.trim();
        int num_of_words = word_count(s);
        int num_of_chars = s.length();
        int num_of_space_needed = maxWidth - num_of_chars;

        //  System.out.println("num_of_words: "+num_of_words+" num_of_chars: "+num_of_chars+" num_of_space_needed: "+num_of_space_needed);
        int num_of_slots_to_add_space = num_of_words-1;

        // split the input string s by space
        String[] temp_text = s.split(" ");

        //update num of spaces needed value, because split function removes those spaces which were already in the input string s
        num_of_space_needed += num_of_slots_to_add_space;


        String[] space_slot_String = new String[num_of_slots_to_add_space];

        // ensure no null values
        for(int i=0;i<space_slot_String.length;i++){
            space_slot_String[i]="";
        }

        // logic to add spaces to the slots
        for(int i=0;i<num_of_space_needed;i++) {

            // below loop is add space to each slot available
            for(int j=0;j<num_of_slots_to_add_space;j++){
                space_slot_String[j] += " ";
                if(j+1<num_of_slots_to_add_space && i+1<num_of_space_needed) {
                    i++;
                    // increment the i counter after adding a space or break in case of last word
                }
                else
                    break;
            }
        }

        // assign spaces to the text array against each word
        for(int j=0;j<space_slot_String.length;j++){
            temp_text[j]+=space_slot_String[j];

        }

        // assign the final array to a the string s
        s="";
        for(int i=0;i<temp_text.length;i++){
            s+= temp_text[i];
        }
        return s;

    }

    private static String[] break_text(String[] words, int maxWidth) {

        String[] maxWidth_adjusted_text = new String[words.length];
        String temp_sentence = "";
        int maxWidth_adjusted_text_index = 0;
        for (int i = 0; i < words.length; i++) {


            if(temp_sentence.length()+words[i].length()<=16){
                //    System.out.println("temp sentance is still less than 16");
                temp_sentence = temp_sentence+" "+words[i];
            }else{
                //   System.out.println("temp sentance more than 16 so break");
                maxWidth_adjusted_text[maxWidth_adjusted_text_index]=temp_sentence;
                maxWidth_adjusted_text_index++;
                //assign the last word that exceed 16char to temp sentence
                temp_sentence=words[i];
                if(i==words.length-1){
                    // assign the last word in the array to justified text
                    maxWidth_adjusted_text[maxWidth_adjusted_text_index]=words[i];
                    maxWidth_adjusted_text_index++;
                }
            }

        }

        int justified_text_size = 0;


        for(int i=0;i<maxWidth_adjusted_text.length;i++){
            if(maxWidth_adjusted_text[i]!=null){
                justified_text_size++;
                System.out.println(maxWidth_adjusted_text[i]);
            }

        }
        String[] final_text = new String[justified_text_size];

        for(int i=0;i<final_text.length;i++){
            final_text[i]=maxWidth_adjusted_text[i];
        }


        return final_text;


    }

}
