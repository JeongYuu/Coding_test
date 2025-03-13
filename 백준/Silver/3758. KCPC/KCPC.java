import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while(N--!=0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int numOfTeam = Integer.parseInt(st.nextToken());
            int numOfProblem = Integer.parseInt(st.nextToken());
            int myTeamID = Integer.parseInt(st.nextToken());
            int numOfLog = Integer.parseInt(st.nextToken());

            int logNum = 0;
            int[][] teamList = new int[numOfTeam][4+numOfProblem];

            while(logNum++!=numOfLog){
                st = new StringTokenizer(br.readLine());
                int teamID = Integer.parseInt(st.nextToken());
                int problemNum = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                if(teamList[teamID-1][problemNum] <= score){
                    teamList[teamID-1][problemNum]=score;
                }
                teamList[teamID-1][numOfProblem+1]++;
                teamList[teamID-1][numOfProblem+2]=logNum;

                teamList[teamID-1][numOfProblem+3] = teamID;
            }

            for(int i=1;i<1+numOfProblem;i++){
                for(int team=0;team<numOfTeam;team++) {
                    teamList[team][0] += teamList[team][i];
                }
            }

            Arrays.sort(teamList, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]!=o2[0] ? o2[0]-o1[0] : (o1[numOfProblem+1]!=o2[numOfProblem+1] ? o1[numOfProblem+1]-o2[numOfProblem+1] : o1[numOfProblem+2]-o2[numOfProblem+2]);
                }
            });

            for(int i=0;i<numOfTeam;i++){
                if(myTeamID==teamList[i][3+numOfProblem]){
                    System.out.println(i+1);
                    break;
                }
            }
        }
    }
}