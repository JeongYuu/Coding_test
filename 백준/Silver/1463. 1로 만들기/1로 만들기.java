import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        int []arr = new int[number+1];
        arr[1] = 0;
        for(int i=2;i<=number;i++){
            arr[i] = arr[i-1] + 1;
            if(i % 2 == 0){
                arr[i] = Math.min(arr[i/2] + 1, arr[i]);
            }
            if(i % 3 == 0){
                arr[i] = Math.min(arr[i/3] + 1, arr[i]);
            }
        }
        System.out.println(arr[number]);
    }
}