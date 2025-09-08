import java.io.*;

public class Main {
    static int[] arr = new int[12];
    public static int func(int num){
        if(arr[num]!=0) return arr[num];
        else if(num == 1) return 1;
        else if(num==2) return 2;
        else if(num==3) return 4;
        else{
            return func(num-1)+func(num-2)+func(num-3);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        while(number-->0){
            int N = Integer.parseInt(br.readLine());
            System.out.println(func(N));
        }
    }
}