package src.temp;

public class finbonacci {

    public static void main(String[] args) {

        int n=150;

        for(int i=0;i<n;i++){
            System.out.print(fibonacci(i)+" ");
            System.out.println("");
        }


    }
    
    

    private static int fibonacci(int n) {

        if(n==0)
            return 0;
        else if(n==1 || n==2)
            return 1;
        else return fibonacci(n-1) + fibonacci(n-2);


    }
}
