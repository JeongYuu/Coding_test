import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;

        int N = Integer.parseInt(str);
        int[] km = new int[N-1];
        int[] city = new int[N];
        int[] grade = new int[N-1];
        int sum = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();

        str = br.readLine();
        st = new StringTokenizer(str, " ");

        for(int i=0;i<N-1;i++) {
            km[i] = Integer.parseInt(st.nextToken());
            sum += km[i];
        }

        str = br.readLine();
        st = new StringTokenizer(str, " ");

        for(int i=0;i<N;i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N-1;i++) {
            grade[i] = city[i];
        }

        Arrays.sort(grade);

        int num=1;

        for(int i=0;i<N-1;i++) {
            hm.putIfAbsent(grade[i],num++);
        }

        int answer = 0;

        for(int i=0;i<N-1;i++){
            if(hm.get(city[i])!=1){
                answer += km[i]*city[i];
                sum -= km[i];
            }
            else{
                answer += sum*city[i];
                break;
            }
        }

        System.out.println(answer);

    }
}