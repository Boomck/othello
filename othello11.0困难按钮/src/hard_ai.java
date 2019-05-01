/**
 * Created by Administrator on 2018/4/23.
 */
public class hard_ai {
    test q = new test();
    int xChess=-1,yChess=-1;
    int lastScore=-999999;
    int count=0;
    int[][][] temp =new int[16][10][10];//0为无子，1为白子，-1为黑子，2为白子可落子，-2为黑子可落子
    int[][] base;
    int[][] weight = {{0,0,0,0,0,0,0,0,0,0},
            {0,100, -5, 10, 5, 5, 10, -5, 100,0},
            {0,-5, -45, 1, 1, 1, 1, -45, -5,0},
            {0,10, 1, 3, 2, 2, 3, 1, 10,0},
            {0,5, 1, 2, 1, 1, 2, 1, 5,0},
            {0,5, 1, 2, 1, 1, 2, 1, 5,0},
            {0,10, 1, 3, 2, 2, 3, 1, 10,0},
            {0,-5, -45, 1, 1, 1, 1, -45, -5,0},
            {0,100, -5, 10, 5, 5, 10, -5, 100,0},
            {0,0,0,0,0,0,0,0,0,0}

    };
    public hard_ai(int[][] base){
        this.base=base;
    }

    public void startAi(int round){
        init_threedimension();
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        System.out.println(getScore(base,-1)+"这是黑色的得分");
        printBase(base);
        alphaBetaCutBranch(0, 8,1, -999990000, 999990000,base);
        System.out.println("=========================================");
        printBase(base);
        if(xChess==-1&&yChess==-1)return;
        else{
            Chess.base[xChess][yChess]=round;
            q.changechess(base,yChess,xChess,round);
        }
    }

    void copybase() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                temp[count][i][j] = base[i][j];
            }
        }
        count++;
    }
    void reBase() {
        count--;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                base[i][j]=temp[count][i][j];
            }
        }

    }

    boolean underall(int[][] base) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (base[i][j] == 0||base[i][j]==-2||base[i][j]==2) return false;
            }
        }
        return true;
    }

    private int alphaBetaCutBranch(int h,int deep, int player, int alpha, int beta,int[][] base) { //h搜索深度，player=1表示自己,player=0表示对手,range代表范围，用数组表示，分别是i（行）的开始结束，j（列）的开始结束
        int p,p2;
        p = getScore(base,player);
        p2 = getScore(base,-player);
        if (h == deep || underall(base))   //若到达深度 或是出现胜负
        {
            return p - p2;
        }
        if (player == 1) {//AI
            for (int i = 0; i <10; i++) {
                for (int j = 0; j <10; j++) {
                    if (base[i][j] == 2) {
                        copybase();
//                        base[i][j]=player;
                        q.changechess(base,j,i,player);
                        int ans = alphaBetaCutBranch(h + 1, deep, player^1 , alpha, beta,base);
                        if (ans > alpha) {    //通过向上传递的子节点beta值修正alpha值
                            alpha = ans;
                            if (h == 0) {
                                lastScore = ans;
                                xChess = i;       //记录位置
                                yChess = j;
                            }
                        }
                        reBase();
                        if (alpha >= beta)   //发生 alpha剪枝
                        {
                            return alpha;
                        }
                    }
                }
            }
            return alpha;
        } else {//对手
            for (int i = 0; i <10; i++) {
                for (int j = 0; j <10; j++) {
                    if (base[i][j] == -2) {
                        copybase();
//                        base[i][j] = player;
                        q.changechess(base,j,i,player);
                        int ans = alphaBetaCutBranch(h + 1, deep,player^1, alpha, beta, base);
                        reBase();
                        if (ans < beta) {     //通过向上传递的子节点alpha值修正beta值
                            beta = ans;
                        }
                        if (alpha >= beta)   //发生 beta剪枝
                        {
                            return beta;
                        }
                    }
                }
            }
            return beta;
        }
    }

    public int getScore(int[][] base,int player){
        int score=0;
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                if (base[i][j] == player) {
                    score+=weight[i][j];
                }
            }
        }
        return score;
    }

    private void printBase(int[][] base){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(base[i][j]+" ");
            }
            System.out.println("");
        }
    }
    private void init_threedimension(){
        for (int i = 0; i < 16 ; i++) {
            for (int j = 0; j <10 ; j++) {
                for (int k = 0; k <10 ; k++) {
                    temp[i][j][k] = 0;
                }
            }
        }
    }
}
