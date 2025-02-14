import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;

        int T = Integer.parseInt(str);
        int classNum = 0;
        int stepSum = 0;
        int[] student = new int[20];

        ArrayList <Integer> list;
        
        while(T-- >0){
            stepSum  = 0;
            list = new ArrayList<>();
            
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            classNum = Integer.parseInt(st.nextToken());
            for(int i=0;i<20;i++){
                student[i] = Integer.parseInt(st.nextToken());
            }

            list.add(student[0]);

            for(int i=1;i<20;i++){
                int nextStudent = student[i];
                int index = list.size();
                for(int j=0;j<list.size();j++){
                    if(list.get(j)>nextStudent){
                        index = j;
                        break;
                    }
                }
                stepSum += list.size()-index;
                list.add(index,nextStudent);
            }

            System.out.println(classNum+" "+stepSum);
        }
    }
}
