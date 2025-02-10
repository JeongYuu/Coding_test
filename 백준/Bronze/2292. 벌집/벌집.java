import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int n = Integer.parseInt(str);
        int i=0;
        while(true){
            if(n<=1+(6+(i-1)*3)*i){
                System.out.println(i+1);
                break;
            }
            i++;
        }
    }
}