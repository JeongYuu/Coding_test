import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;
        Set<Integer> set = new HashSet<>();
        int n=Integer.parseInt(str);
        StringBuilder sb = new StringBuilder();

        String calcul;
        int num;
        for(int i=0;i<n;i++){
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            calcul = st.nextToken();
            switch(calcul){
                case "all":
                    set.clear();
                    for(int j=1;j<=20;j++) {
                        set.add(j);
                    }
                    break;
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    set.add(num);
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    set.remove(num);
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    sb.append(set.contains(num) ? "1\n" : "0\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    if (set.contains(num)) set.remove(num);
                    else set.add(num);
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        System.out.print(sb);
    }
}
