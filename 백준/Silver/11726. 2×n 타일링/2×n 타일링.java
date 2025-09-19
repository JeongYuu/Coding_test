import java.io.*;

public class Main {
    static int[] arr = new int[1001];
    public static int f(int n){
        if(arr[n] != 0){
            return arr[n];
        }
        else if(n<=3){
            arr[n] = n;
            return n;

        }
        else{
            arr[n] =(f(n-1) + f(n-2))% 10007;
        }
        return arr[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.print(f(num));
    }
}