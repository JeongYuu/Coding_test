import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);
        int[][] cookie = new int[n][n];
        int headX = 0;
        int headY = 0;
        for(int i=0;i<n;i++){
            str = br.readLine();
            for(int j =0;j<n;j++){
                char [] c = str.toCharArray();
                if(c[j]=='_') cookie[i][j] = 0;
                else cookie[i][j] = 1;
            }
        }
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++){
                if(cookie[i][j]==1){
                    headX = i;
                    headY = j;
                    break;
                }
            }
            if(headX!=0 || headY!=0) break;
        }
        System.out.println((headX+2)+" "+(headY+1));

        int heartX = headX+1;
        int heartY = headY;

        int leftArm = 0;
        int rightArm = 0;
        int waist = 0;
        int leftLeg = 0;
        int rightLeg = 0;
        int lastWaistX = 0;
        int lastWaistY = 0;

        for(int i=heartY-1;i>=0;i--){
            if(cookie[heartX][i]==1) leftArm++;
            else break;
        }
        System.out.print(leftArm+" ");

        for(int i=heartY+1;i<n;i++){
            if(cookie[heartX][i]==1) rightArm++;
            else break;
        }
        System.out.print(rightArm+" ");

        for(int i=heartX+1;i<n;i++){
            if(cookie[i][heartY]==1) {
                waist++;
                lastWaistX = i;
                lastWaistY = heartY;
            }
            else break;
        }
        System.out.print(waist+" ");

        for(int i=lastWaistX+1;i<n;i++){
            if(cookie[i][lastWaistY-1]==1) leftLeg++;
            else break;
        }
        System.out.print(leftLeg+" ");

        for(int i=lastWaistX+1;i<n;i++){
            if(cookie[i][lastWaistY+1]==1) rightLeg++;
            else break;
        }
        System.out.print(rightLeg);
    }
}