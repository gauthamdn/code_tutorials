package src;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineCount {

    public static void  main(String[] args) throws IOException {

        int nbLinesTotal=0;
        File f = new File("src/Sep_20_2024/Exercise5.java");
        if(f.exists()){
            try {
                BufferedReader bf = new BufferedReader(new FileReader(f));
                String s;
                while((s = bf.readLine())!=null) {
                    if(s.length() > 0 && !s.contains("//") && !s.contains("/*")) {
                        nbLinesTotal++;
                    }
                }
                bf.close();

                System.out.println(nbLinesTotal);
            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }



    }

}
