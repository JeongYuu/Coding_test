import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int start = scanner.nextInt();
        int []list = new int[n];
        for(int i=0; i<n;i++){
            list[i] = scanner.nextInt();
        }
        Arrays.sort(list);

        for(int i=0; i<n;i++){
            if(start >= list[i]){
                start++;
            }
        }
        System.out.println(start);

    }
}