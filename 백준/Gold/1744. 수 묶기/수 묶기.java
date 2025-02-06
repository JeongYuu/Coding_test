import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int num = Integer.parseInt(str);
        ArrayList<Integer> plusList = new ArrayList<>();
        ArrayList<Integer> minusList = new ArrayList<>();

        int number = 0;
        boolean check0 = false;

        for(int i=0;i<num;i++){
            str = br.readLine();
            number = Integer.parseInt(str);
            if(number < 0) minusList.add(number);
            else if(number > 0) plusList.add(number);
            else check0 = true;
        }

        Collections.sort(plusList);
        Collections.sort(minusList);

        int minusNumber = minusList.size();

        int sum = 0;
        while(!plusList.isEmpty()){
            int last = plusList.get(plusList.size()-1);
            int last_1 = 0;
            if(plusList.size()!=1) {
                last_1 = plusList.get(plusList.size() - 2);
            }
            if(plusList.size()>1){
                if(last != 1 && last_1 != 1) {
                    sum += last * last_1;
                }
                else{
                    sum += last;
                    sum += last_1;
                }
                plusList.remove(plusList.size()-1);
                plusList.remove(plusList.size()-1);
            }
            else{
                sum += last;
                plusList.remove(plusList.size()-1);
            }
        }

        if(minusNumber % 2 != 0 && check0){
            minusList.remove(minusList.size()-1);
        }

        while (!minusList.isEmpty()){
            int last = minusList.get(0);
            int last_1 = 0;
            if (minusList.size() != 1) {
                last_1 = minusList.get(1);
            }
            if (minusList.size() > 1) {
                sum += last * last_1;
                minusList.remove(0);
                minusList.remove(0);
            } else if (minusList.size() == 1) {
                sum += minusList.get(0);
                minusList.remove(0);
            }
        }
        System.out.println(sum);
    }
}