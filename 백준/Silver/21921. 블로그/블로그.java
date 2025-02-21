import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        ArrayList<Integer> list = new ArrayList<>();

        str = br.readLine();
        st = new StringTokenizer(str," ");

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int window = X;
        boolean flag = false;
        int tempt = 0;

        for(int i=0;i<N;i++){
            if(i == window-1) flag = true;
            if(i >= window){
                tempt -= arr[i-window];
            }
            tempt += arr[i];
            if(flag && tempt!=0) list.add(tempt);
        }
        
        if(list.size()==0){
            System.out.println("SAD");
            return;
        }

        int max = 0;
        for(int i:list){
            max = Math.max(max,i);
        }

        int count = 0;
        for(int i:list){
            if(i==max) count++;
        }

        System.out.println(max);
        System.out.println(count);
    }
}