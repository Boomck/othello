public class normal_ai {//ai为白子
    test q =new test();
    void local_solution(int[][] base,int round){
        int number=0,x=-1,y=-1;
        for (int i = 0; i < 10 ; i++) {
            for (int j = 0; j <10 ; j++) {
                if(base[i][j]==2){
                    if(q.changechesssum(base,j,i,round)>=number){
                        number=q.changechesssum(base,j,i,round);
                        x=i;
                        y=j;
                    }
                }
            }
        }
        if(x==-1&&y==-1)return;
        else{
            Chess.base[x][y] = round;
            q.changechess(base,y,x,round);
        }
    }
}

