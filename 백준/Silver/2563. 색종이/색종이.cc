#include <iostream>
using namespace std;
int main(){
  int list[100][100] = {0};
  int sum = 0;

  int num, x ,y;
  cin >> num;
  for(int i = 0; i< num; i++){
    cin >> x >> y ;
    for(int j =0; j < 10; j++){
      for(int jj =0; jj < 10; jj++)
      {list[x+j][y+jj] = 1;}
    }
  }
  for(int i = 0;i<100;i++){
    for(int ii = 0;ii<100;ii++){
      if(list[i][ii] == 1) sum += 1;
    }
  }
  
  cout << sum;
}