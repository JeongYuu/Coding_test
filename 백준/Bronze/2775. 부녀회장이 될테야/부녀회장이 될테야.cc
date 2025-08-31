#include <iostream>
using namespace std;

int main() {
  int list[15][14] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
  for(int i=1; i<15; i++){
    for(int j =1 ; j<14;j++){
      list[i][0] = 1;
      list[i][j] = list[i-1][j] + list[i][j-1];
    }
  }

  int num;
  cin >> num;
  int k, n;
  for(int i=0; i< num ;i++){
    cin >> k >> n;
    cout << list[k][n-1] << endl;
  }  
}