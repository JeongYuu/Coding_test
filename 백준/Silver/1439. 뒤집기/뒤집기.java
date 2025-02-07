import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String start = str.substring(0,1);
        String [] arr0 = str.split("1+");
        String [] arr1 = str.split("0+");
        if(arr0.length == 0 || arr1.length == 0) {
            System.out.println("0");
        }
        else{
            if(start.equals("0")){
                System.out.println(Math.min(arr0.length, arr1.length - 1));
            }
            else{
                System.out.println(Math.min(arr0.length-1, arr1.length));
            }
        }
    }
}