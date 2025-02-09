import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringTokenizer st;

        int n = Integer.parseInt(str);
        long[][] lines = new long[n][2];

        for(int i=0;i<n;i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(lines, Comparator.comparingLong((long[] o) -> o[0]));

        ArrayList<Long> draw = new ArrayList<>();
        
        draw.add(lines[0][0]);
        draw.add(lines[0][1]);

        for(int i=1;i<n;i++){
            long start = lines[i][0];
            long end = lines[i][1];

            if(draw.get(draw.size()-1)<start){
                draw.add(start);
                draw.add(end);
            }
            else{
                if(end > draw.get(draw.size()-1)){
                    draw.set(draw.size()-1,end);
                }
            }
        }

        long sum = 0;

        for(int i=1;i<draw.size();i=i+2){
            sum += (draw.get(i)-draw.get(i-1));
        }

        System.out.println(sum);

    }
}
