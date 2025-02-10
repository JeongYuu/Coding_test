import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);

        int[] switchArr = new int[n];

        str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        for(int i=0;i<n;i++){
            switchArr[i] = Integer.parseInt(st.nextToken());
        }

        str = br.readLine();
        int people = Integer.parseInt(str);

        for(int i=0;i<people;i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int sex = Integer.parseInt(st.nextToken());
            int standard = Integer.parseInt(st.nextToken());
            if(sex == 1){
                for(int k =standard-1;k<n;k=k+standard){
                    if(switchArr[k]==1) switchArr[k]=0;
                    else switchArr[k]=1;
                }
            }
            else{
                int k=1;
                standard--;

                if(switchArr[standard]==1) switchArr[standard]=0;
                else switchArr[standard]=1;

                while(true){
                    if(standard-k>=0 && standard+k<n && switchArr[standard-k]==switchArr[standard+k]){
                        if(switchArr[standard-k]==1){
                            switchArr[standard-k]=0;
                            switchArr[standard+k]=0;
                        }
                        else{
                            switchArr[standard-k]=1;
                            switchArr[standard+k]=1;
                        }
                    }
                    else{
                        break;
                    }
                    k++;
                }
            }
        }
        for(int k=0;k<n;k++) {
            System.out.print(switchArr[k]+" ");
            if(k!=0 && (k+1)%20==0) System.out.println();
        }
    }
}