import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        ArrayList<Integer> numberList = new ArrayList<>();
        ArrayList<String> signList = new ArrayList<>();
        ArrayList<Integer> minusNumberList = new ArrayList<>();

        StringTokenizer numberSt = new StringTokenizer(str, "+-");
        StringTokenizer signSt = new StringTokenizer(str, "0123456789");

        while(numberSt.hasMoreTokens()){
            numberList.add(Integer.parseInt(numberSt.nextToken()));
        }

        while(signSt.hasMoreTokens()){
            signList.add(signSt.nextToken());
        }

        minusNumberList.add(numberList.get(0)); //첫 번째 원소 넣기
        int index = 0;

        for(int i=0;i<signList.size();i++){
            if(signList.get(i).equals("+")){
                int a = numberList.get(i+1);
                int b = minusNumberList.get(index);
                minusNumberList.set(index,a+b);
            }

            if(signList.get(i).equals("-")){
                int a = numberList.get(i+1);
                minusNumberList.add(a);
                index++;
            }
        }

        int minus = minusNumberList.get(0);
        for(int i=1;i<minusNumberList.size();i++){
            minus -= minusNumberList.get(i);
        }
        System.out.println(minus);
        
    }
}