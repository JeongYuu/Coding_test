import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int []arr = new int[42];

    public static int f(int[] arr,int num){
        arr[0] = 1;
        arr[1] = 0;
        arr[2] = 1;
        if(arr[num]!=0) {
            return arr[num];
        }
        if(arr[num] == 0 && num != 1){
            arr[num] = f(arr, num-1)+f(arr,num-2);
        }
        return arr[num];
    }

    public static void main(String[] args) throws IOException {
        for(int i=3;i<41;i++){
            arr[i] = f(arr,i);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int N = Integer.parseInt(str);
        while(N-->0){
            str = br.readLine();
            int n = Integer.parseInt(str);
            System.out.println(f(arr, n)+" "+f(arr, n+1));
        }
    }
}