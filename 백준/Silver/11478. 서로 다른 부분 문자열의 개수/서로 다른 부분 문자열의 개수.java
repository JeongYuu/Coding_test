import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        Set<String> set = new HashSet<>();

        for (int i=0; i<string.length(); i++){
            for (int j=i+1; j<=string.length(); j++){
                set.add(string.substring(i,j));
            }
        }

        System.out.println(set.size());
    }
}