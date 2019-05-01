import javax.swing.*;
import java.awt.*;

public class test {//白子为1，黑子为-1，白字可下为2，黑子可下为-2
    public boolean whitecandown(int[][] base){
        int num = 0;
        for (int i = 1 ; i < 9; i++)
        {
            for (int j = 1; j < 9 ; j++)
            {
                if (base[i][j] == 1)
                {
                    int L = j-1;
                    int R = 8-j;
                    int U = i-1;
                    int D = 8-i;
                    //左右搜索
                    for (int k = 1; k < L  ; k++) {//向左
                        if (base[i][j-k] == 0 || base[i][j-k] == 2 || base[i][j-k] == -2)
                            break;
                        if (base[i][j-k] == -1 && (base[i][j-k-1] == 0 || base[i][j-k-1] == -2 || base[i][j-k-1] == 2))
                        {
                            base[i][j-k-1] = 2;
                            num++;
                        }
                    }
                    for (int k = 1; k < R; k++) {//向右
                        if (base[i][j+k] == 0 || base[i][j+k] == -2 || base[i][j+k] == 2)
                            break;
                        if (base[i][j+k] == -1 && (base[i][j+k+1] == 0 || base[i][j+k+1] == -2 || base[i][j+k+1] == 2))
                        {
                            base[i][j+k+1] = 2;
                            num++;
                        }
                    }
                    //上下搜索
                    for (int k = 1; k < U ; k++) {//向上
                        if (base[i-k][j] == 0 || base[i-k][j] == -2 || base[i-k][j] == 2)
                            break;
                        if (base[i-k][j] == -1 && (base[i-k-1][j] == 0 || base[i-k-1][j] == -2 || base[i-k-1][j] == 2))
                        {
                            base[i-k-1][j] = 2;
                            num++;
                        }
                    }
                    for (int k = 1; k < D ; k++) {//向下
                        if (base[i+k][j] == 0 || base[i+k][j] == 2 || base[i+k][j] == -2)
                            break;
                        if (base[i+k][j] == -1 && (base[i+k+1][j] == 0 || base[i+k+1][j] == -2 || base[i+k+1][j] == 2))
                        {
                            base[i+k+1][j] = 2;
                            num++;
                        }
                    }
//                    for (int k = 1; k < 9 ; k++) {//直线判断
//                        if(base[i][k] ==-1 && (base[i][k+1]==0 || base[i][k-1]==0))
//                        {
//                            if(k>j)
//                            {
//                                base[i][k+1] = 2;
//                                num++;
//                            }
//                            else
//                            {
//                                base[i][k-1] = 2;
//                                num++;
//                            }
//                        }
//                        if(base[k][j] == -1 && (base[k+1][j]==0 || base[k-1][j]==0))
//                        {
//                            if(k>i)
//                            {
//                                base[k+1][j] = 2;
//                                num++;
//                            }
//                            else
//                            {
//                                base[k-1][j] = 2;
//                                num++;
//                            }
//                        }
//                    }
                    //右斜搜索
                    if(i>j)//4,2
                    {
                        int k = j-1;//1
                        int p = 8-i;//4
                        for (int l = 1; l <= k ; l++) {//左上搜索
                            if (base[i-l][j-l]==0 || base[i-l][j-l]==-2 || base[i-l][j-l]==2)
                                break;
                            if (base[i-l][j-l]==-1&&(base[i-l-1][j-l-1]==0 || base[i-l-1][j-l-1]==-2 || base[i-l-1][j-l-1]==2))
                            {
                                base[i-l-1][j-l-1] = 2;
                                num++;
                            }
                        }
                        for (int l = 1; l <= p ; l++) {//右下搜索
                            if (base[i+l][j+l]==0 || base[i+l][j+l]==-2 || base[i+l][j+l]==2)
                                break;
                            if (base[i+l][j+l]==-1&&(base[i+l+1][j+l+1]==0 || base[i+l+1][j+l+1]==2 || base[i+l+1][j+l+1]==-2))
                            {
                                base[i+l+1][j+l+1] = 2;
                                num++;
                            }
                        }
                    }
                    if (i<=j)//5,5
                    {
                        int k = i-1;//4
                        int p = 8-j;//3
                        for (int l = 1; l <= k ; l++) {//左上搜索
                            if (base[i-l][j-l]==0 || base[i-l][j-l]==-2 || base[i-l][j-l]==2)
                                break;
                            if (base[i-l][j-l]==-1&&(base[i-l-1][j-l-1]==0 || base[i-l-1][j-l-1]==-2 || base[i-l-1][j-l-1]==2))
                            {
                                base[i-l-1][j-l-1] = 2;
                                num++;
                            }
                        }
                        for (int l = 1; l <= p ; l++) {//右下搜索
                            if (base[i+l][j+l]==0 || base[i+l][j+l]==2 || base[i+l][j+l]==-2)
                                break;
                            if (base[i+l][j+l]==-1&&(base[i+l+1][j+l+1]==0 || base[i+l+1][j+l+1]==-2 || base[i+l+1][j+l+1]==2))
                            {
                                base[i+l+1][j+l+1] = 2;
                                num++;
                            }
                        }
                    }
                    //左斜搜索
                    if (i+j<=8&&i>j)
                    {
                        int k = i-1;
                        int p = j-1;
                        for (int l = 1; l <= p; l++) {//左下搜索
                            if (base[i+l][j-l] == 0 || base[i+l][j-l] == -2 || base[i+l][j-l] == 2)
                                break;
                            if (base[i+l][j-l]==-1&&(base[i+l+1][j-l-1]==0 || base[i+l+1][j-l-1]==-2 || base[i+l+1][j-l-1]==2))
                            {
                                base[i+l+1][j-l-1]=2;
                                num++;
                            }
                        }
                        for (int l = 1; l < k; l++) {//右上搜索
                            if (base[i-l][j+l]==0 || base[i-l][j+l]==-2 || base[i-l][j+l]==2)
                                break;
                            if (base[i-l][j+l]==-1&&(base[i-l-1][j+l+1]==0 || base[i-l-1][j+l+1]==-2 || base[i-l-1][j+l+1]==2))
                            {
                                base[i-l-1][j+l+1]=2;
                                num++;
                            }
                        }
                    }
                    if(i+j<=8&&i<=j)
                    {
                        int k = j-1;
                        int p = i-1;
                        for (int l = 1; l <= p ; l++) {//右上搜索
                            if (base[i-l][j+l]==0 || base[i-l][j+l]==-2 || base[i-l][j+l]==2)
                                break;
                            if(base[i-l][j+l]==-1&&(base[i-l-1][j+l+1]==0 || base[i-l-1][j+l+1]==-2 || base[i-l-1][j+l+1]==2))
                            {
                                base[i-l-1][j+l+1]=2;
                                num++;
                            }
                        }
                        for (int l = 1; l < k ; l++) {//左下搜索
                            if (base[i+l][j-l]==0 || base[i+l][j-l]==-2 || base[i+l][j-l]==2)
                                break;
                            if(base[i+l][j-l]==-1&&(base[i+l+1][j-l-1]==0 || base[i+l+1][j-l-1]==-2 || base[i+l+1][j-l-1]==2))
                            {
                                base[i+l+1][j-l-1]=2;
                                num++;
                            }
                        }
                    }
                    if (i+j>8&&i>j)//5,4
                    {
                        int k = 8-j;//4
                        int p = 8-i;//3
                        for (int l = 1; l <= p ; l++) {//左下搜索
                            if (base[i+l][j-l]==0 || base[i+l][j-l]==-2 || base[i+l][j-l]==2)
                                break;
                            if (base[i+l][j-l]==-1&&(base[i+l+1][j-l-1]==0 || base[i+l+1][j-l-1]==-2 || base[i+l+1][j-l-1]==2))
                            {
                                base[i+l+1][j-l-1]=2;
                                num++;
                            }
                        }
                        for (int l = 1; l <= k ; l++) {//右上搜索
                            if (base[i-l][j+l]==0 || base[i-l][j+l]==-2 || base[i-l][j+l]==2)
                                break;
                            if (base[i-l][j+l]==-1&&(base[i-l-1][j+l+1]==0 || base[i-l-1][j+l+1]==-2 || base[i-l-1][j+l+1]==2))
                            {
                                base[i-l-1][j+l+1]=2;
                                num++;
                            }
                        }
                    }
                    if (i+j>8&&i<=j)
                    {
                        int k = 8-i;
                        int p = 8-j;
                        for (int l = 1; l <= p ; l++) {//右上搜索
                            if (base[i-l][j+l]==0 || base[i-l][j+l]==-2 || base[i-l][j+l]==2)
                                break;
                            if (base[i-l][j+l]==-1&&(base[i-l-1][j+l+1]==0 || base[i-l-1][j+l+1]==-2 || base[i-l-1][j+l+1]==2))
                            {
                                base[i-l-1][j+l+1]=2;
                                num++;
                            }
                        }
                        for (int l = 1; l <= k ; l++) {//左下搜索
                            if (base[i+l][j-l]==0 || base[i+l][j-l]==-2 || base[i+l][j-l]==2)
                                break;
                            if (base[i+l][j-l]==-1&&(base[i+l+1][j-l-1]==0 || base[i+l+1][j-l-1]==-2 || base[i+l+1][j-l-1]==2))
                            {
                                base[i+l+1][j-l-1]=2;
                                num++;
                            }
                        }
                    }
                }
            }
        }
        //最外圈不落子
        for (int i = 0; i < 10 ; i++) {
            base[i][0] = 0;
            base[i][9] = 0;
            base[0][i] = 0;
            base[9][i] = 0;
        }
        if(num>0){
            return true;
        }else{
            return false;
        }
    }
    public boolean blackcandown(int[][] base){
        int num = 0;
        for (int i = 1; i < 9 ; i++) {
            for (int j = 1; j < 9 ; j++) {
                if(base[i][j]==-1)
                {
                    int L = j-1;
                    int R = 8-j;
                    int U = i-1;
                    int D = 8-i;
                    //左右搜索
                    for (int k = 1; k < L  ; k++) {//向左
                        if (base[i][j-k] == 0 || base[i][j-k] == 2 || base[i][j-k] == -2)
                            break;
                        if (base[i][j-k] == 1 && (base[i][j-k-1] == 0 || base[i][j-k-1] == -2 || base[i][j-k-1] == 2))
                        {
                            base[i][j-k-1] = -2;
                            num++;
                        }
                    }
                    for (int k = 1; k < R; k++) {//向右
                        if (base[i][j+k] == 0 || base[i][j+k] == -2 || base[i][j+k] == 2)
                            break;
                        if (base[i][j+k] == 1 && (base[i][j+k+1] == 0 || base[i][j+k+1] == -2 || base[i][j+k+1] == 2))
                        {
                            base[i][j+k+1] = -2;
                            num++;
                        }
                    }
                    //上下搜索
                    for (int k = 1; k < U ; k++) {//向上
                        if (base[i-k][j] == 0 || base[i-k][j] == -2 || base[i-k][j] == 2)
                            break;
                        if (base[i-k][j] == 1 && (base[i-k-1][j] == 0 || base[i-k-1][j] == -2 || base[i-k-1][j] == 2))
                        {
                            base[i-k-1][j] = -2;
                            num++;
                        }
                    }
                    for (int k = 1; k < D ; k++) {//向下
                        if (base[i+k][j] == 0 || base[i+k][j] == 2 || base[i+k][j] == -2)
                            break;
                        if (base[i+k][j] == 1 && (base[i+k+1][j] == 0 || base[i+k+1][j] == -2 || base[i+k+1][j] == 2))
                        {
                            base[i+k+1][j] = -2;
                            num++;
                        }
                    }
//                    for (int k = 1; k < 9 ; k++) {
//                        if(base[i][k]==1&&(base[i][k-1]==0||base[i][k+1]==0))
//                        {
//                            if(k<j)
//                            {
//                                base[i][k-1] = -2;
//                                num++;
//                            }
//                            if (k>j)
//                            {
//                                base[i][k+1] = -2;
//                                num++;
//                            }
//                        }
//                        if(base[k][j]==1&&(base[k-1][j]==0||base[k+1][j]==0))
//                        {
//                            if (k<i)
//                            {
//                                base[k-1][j] = -2;
//                                num++;
//                            }
//                            if (k>i)
//                            {
//                                base[k+1][j] = -2;
//                                num++;
//                            }
//                        }
//                    }
                    //右斜搜索
                    if(i>j)
                    {
                        int k = j-1;
                        int p = 8-i;
                        for (int l = 1; l <= k ; l++) {
                            if (base[i-l][j-l]==0 || base[i-l][j-l]==-2 || base[i-l][j-l]==2)
                                break;
                            if (base[i-l][j-l]==1&&(base[i-l-1][j-l-1]==0 || base[i-l-1][j-l-1]==2 || base[i-l-1][j-l-1]==-2))
                            {
                                base[i-l-1][j-l-1] = -2;
                                num++;
                            }
                        }
                        for (int l = 1; l <= p ; l++) {
                            if (base[i+l][j+l]==0 || base[i+l][j+l]==-2 || base[i+l][j+l]==2)
                                break;
                            if (base[i+l][j+l]==1&&(base[i+l+1][j+l+1]==0 || base[i+l+1][j+l+1]==2 || base[i+l+1][j+l+1]==-2))
                            {
                                base[i+l+1][j+l+1] = -2;
                                num++;
                            }
                        }
                    }
                    if (i<=j)//5,5
                    {
                        int k = i-1;//4
                        int p = 8-j;//3
                        for (int l = 1; l <= k ; l++) {
                            if (base[i-l][j-l]==0 || base[i-l][j-l]==-2 || base[i-l][j-l]==2)
                                break;
                            if (base[i-l][j-l]==1&&(base[i-l-1][j-l-1]==0 || base[i-l-1][j-l-1]==2 || base[i-l-1][j-l-1]==-2))
                            {
                                base[i-l-1][j-l-1] = -2;
                                num++;
                            }
                        }
                        for (int l = 1; l <= p ; l++) {
                            if (base[i+l][j+l]==0 || base[i+l][j+l]==-2 || base[i+l][j+l]==2)
                                break;
                            if (base[i+l][j+l]==1&&(base[i+l+1][j+l+1]==0 || base[i+l+1][j+l+1]==2 || base[i+l+1][j+l+1]==-2))
                            {
                                base[i+l+1][j+l+1] = -2;
                                num++;
                            }
                        }
                    }
                    //左斜搜索
                    if (i+j<=8&&i>j)
                    {
                        int k = i-1;
                        int p = j-1;
                        for (int l = 1; l <= p; l++) {
                            if (base[i+l][j-l]==0 || base[i+l][j-l]==-2 || base[i+l][j-l]==2)
                                break;
                            if (base[i+l][j-l]==1&&(base[i+l+1][j-l-1]==0 || base[i+l+1][j-l-1]==2 || base[i+l+1][j-l-1]==-2))
                            {
                                base[i+l+1][j-l-1]=-2;
                                num++;
                            }
                        }
                        for (int l = 1; l <= k; l++) {
                            if (base[i-l][j+l]==0 || base[i-l][j+l]==-2 || base[i-l][j+l]==2)
                                break;
                            if (base[i-l][j+l]==1&&(base[i-l-1][j+l+1]==0 || base[i-l-1][j+l+1]==2 || base[i-l-1][j+l+1]==-2))
                            {
                                base[i-l-1][j+l+1]=-2;
                                num++;
                            }
                        }
                    }
                    if(i+j<=8&&i<=j)//3,5
                    {
                        int k = j-1;//4
                        int p = i-1;//2
                        for (int l = 1; l <= p ; l++) {
                            if (base[i-l][j+l]==0 || base[i-l][j+l]==-2 || base[i-l][j+l]==2)
                                break;
                            if(base[i-l][j+l]==1&&(base[i-l-1][j+l+1]==0 || base[i-l-1][j+l+1]==2 || base[i-l-1][j+l+1]==-2))
                            {
                                base[i-l-1][j+l+1]=-2;
                                num++;
                            }
                        }
                        for (int l = 1; l <= k ; l++) {
                            if (base[i+l][j-l]==0 || base[i+l][j-l]==-2 || base[i+l][j-l]==2)
                                break;
                            if(base[i+l][j-l]==1&&(base[i+l+1][j-l-1]==0 || base[i+l+1][j-l-1]==2 || base[i+l+1][j-l-1]==-2))
                            {
                                base[i+l+1][j-l-1]=-2;
                                num++;
                            }
                        }
                    }
                    if (i+j>8&&i>j)
                    {
                        int k = 8-j;
                        int p = 8-i;
                        for (int l = 1; l <= p ; l++) {
                            if (base[i+l][j-l]==0 || base[i+l][j-l]==-2 || base[i+l][j-l]==2)
                                break;
                            if (base[i+l][j-l]==1&&(base[i+l+1][j-l-1]==0 || base[i+l+1][j-l-1]==2 || base[i+l+1][j-l-1]==-2))
                            {
                                base[i+l+1][j-l-1]=-2;
                                num++;
                            }
                        }
                        for (int l = 1; l <= k ; l++) {
                            if (base[i-l][j+l]==0 || base[i-l][j+l]==-2 || base[i-l][j+l]==2)
                                break;
                            if (base[i-l][j+l]==1&&(base[i-l-1][j+l+1]==0 || base[i-l-1][j+l+1]==2 || base[i-l-1][j+l+1]==-2))
                            {
                                base[i-l-1][j+l+1]=-2;
                                num++;
                            }
                        }
                    }
                    if (i+j>8&&i<=j)
                    {
                        int k = 8-i;
                        int p = 8-j;
                        for (int l = 1; l <= p ; l++) {
                            if (base[i-l][j+l]==0 || base[i-l][j+l]==-2 || base[i-l][j+l]==2)
                                break;
                            if (base[i-l][j+l]==1&&(base[i-l-1][j+l+1]==0 || base[i-l-1][j+l+1]==2 || base[i-l-1][j+l+1]==-2))
                            {
                                base[i-l-1][j+l+1]=-2;
                                num++;
                            }
                        }
                        for (int l = 1; l <= k ; l++) {
                            if (base[i+l][j-l]==0 || base[i+l][j-l]==-2 || base[i+l][j-l]==2)
                                break;
                            if (base[i+l][j-l]==1&&(base[i+l+1][j-l-1]==0 || base[i+l+1][j-l-1]==2 || base[i+l+1][j-l-1]==-2))
                            {
                                base[i+l+1][j-l-1]=-2;
                                num++;
                            }
                        }
                    }
                }
            }
        }
        //最外圈不落子
        for (int i = 0; i < 10 ; i++) {
            base[i][0] = 0;
            base[i][9] = 0;
            base[0][i] = 0;
            base[9][i] = 0;
        }
        if(num>0){
            return true;
        }else{
            return false;
        }
    }
    public void changechess(int[][] base,int x,int y,int round){
        int flag1 = 0;//1横向有子，2纵向有子，3右侧向有子，4左侧向有子
        int flag2 = 0;//value为1代表有子
        int flag3 = 0;
        int flag4 = 0;
        int x1,x2,y1,y2;
        x1 = x2 = y1 = y2 = -1;
        //横向判断
        int l = x-1;
        int r = 8-x;
        for (int i = 1; i < l ; i++) {//向左探测
            if (base[y][x-1] == round)
                break;
            if (base[y][x-i] == 0 || base[y][x-i] == 2 || base[y][x-i] == -2)
                break;
            if (base[y][x-i] == -round && base[y][x-i-1] == round)
            {
                x1 = x-i-1;
                flag1 = 1;
                break;
            }
        }
        for (int i = 1; i < r ; i++) {//向右探测
            if (base[y][x+1] == round)
                break;
            if (base[y][x+i] == 0 || base[y][x+i] == 2 || base[y][x+i] == -2)
                break;
            if (base[y][x+i] == -round && base[y][x+i+1] == round)
            {
                x2 = x+i+1;
                flag1 = 1;
                break;
            }
        }
        //翻子
        if (flag1 == 1 && (x1!=-1&&x2!=-1))
        {
            for (int i = x1+1; i < x2 ; i++) {
                base[y][i] = round;
            }
        }
        else if(flag1 == 1 && x1 != -1 && x2 == -1)
        {
            for (int i = x1+1; i < x ; i++) {
                base[y][i] = round;
            }
        }
        else if(flag1 == 1 && x2 != -1 && x1 == -1)
        {
            for (int i = x+1; i < x2 ; i++) {
                base[y][i] = round;
            }
        }
        //纵向判断
        int u = y-1;
        int d = 8-y;
        for (int i = 1; i < u ; i++) {//向上探测
            if (base[y-1][x] == round)
                break;
            if (base[y-i][x] == 0 || base[y-i][x] == 2 || base[y-i][x] == -2)
                break;
            if (base[y-i][x] == -round && base[y-i-1][x] == round)
            {
                y1 = y-i-1;
                flag2 = 1;
                break;
            }
        }
        for (int i = 1; i < d ; i++) {//向下探测
            if (base[y+1][x] == round)
                break;
            if (base[y+i][x] == 0 || base[y+i][x] == 2 || base[y+i][x] == -2)
                break;
            if (base[y+i][x] == -round && base[y+i+1][x] == round)
            {
                y2 = y+i+1;
                flag2 = 1;
                break;
            }
        }
        //翻子
        if (flag2 == 1 && (y1!=-1&&y2!=-1))
        {
            for (int i = y1+1; i < y2 ; i++) {
                base[i][x] = round;
            }
        }
        else if (flag2 == 1 && y1 != -1 && y2 == -1)
        {
            for (int i = y1; i < y ; i++) {
                base[i][x] = round;
            }
        }
        else if (flag2 == 1 && y2 != -1 && y1 == -1)
        {
            for (int i = y+1; i < y2 ; i++) {
                base[i][x] = round;
            }
        }
        //右斜向判断
        x1 = x2 = y1 = y2 = -1;
        if (y>x)//7,4
        {
            int k = x-1;//3
            int p = 8-y;//1
            for (int i = 1; i <= k ; i++) {//左上探索
                if (base[y-1][x-1] == round)
                    break;
                if (base[y-i][x-i] == 0 || base[y-i][x-i] == -2 || base[y-i][x-i] == 2 )
                    break;
                if (base[y-i][x-i] == round)
                {
                    y1 = y-i;
                    x1 = x-i;
                    flag3 = 1;
                    break;
                }
            }
            for (int i = 1; i <= p ; i++) {//右下探索
                if (base[y+1][x+1] == round)
                    break;
                if (base[y+i][x+i] == 0 || base[y+i][x+i] == -2 || base[y+i][x+i] == 2)
                    break;
                if (base[y+i][x+i] == round)
                {
                    y2 = y+i;
                    x2 = x+i;
                    flag3 = 1;
                    break;
                }
            }
        }
        else if (x>=y)//3,5
        {
            int k = y-1;//2
            int p = 8-x;//3
            for (int i = 1; i <= k ; i++) {//左上探索
                if (base[y-1][x-1] == round)
                    break;
                if (base[y-i][x-i] == 0 || base[y-i][x-i] == -2 || base[y-i][x-i] == 2)
                    break;
                if (base[y-i][x-i] == round)
                {
                    y1 = y-i;
                    x1 = x-i;
                    flag3 = 1;
                    break;
                }
            }
            for (int i = 1; i <= p ; i++) {//右下探索
                if (base[y+1][x+1] == round)
                    break;
                if (base[y+i][x+i] == 0 || base[y+i][x+i] == 2 || base[y+i][x+i] == -2)
                    break;
                if (base[y+i][x+i] == round)
                {
                    y2 = y+i;
                    x2 = x+i;
                    flag3 = 1;
                    break;
                }
            }
        }
        //翻子
        if (flag3 == 1 && (x1!=-1 && x2!=-1))
        {
            while(x1<x2&&y1<y2)
            {
                base[y1][x1] = round;
                x1++;
                y1++;
            }
        }
        else if (flag3 == 1 && x1!=-1 && x2==-1)
        {
            while(x1<x&&y1<y)
            {
                base[y1][x1] = round;
                x1++;
                y1++;
            }
        }
        else if (flag3 == 1 && x2!=-1 && x1==-1)
        {
            int ix = x;
            int iy = y;
            while(ix<x2&&iy<y2)
            {
                base[iy][ix] = round;
                ix++;
                iy++;
            }
        }
        //左斜判断
        x1 = x2 = y1 = y2 = -1;
        if (x+y<=8 && x>=y)//2,4
        {
            int k = x-1;//3
            int p = y-1;//1
            for (int i = 1; i <= p ; i++) {//右上探索
                if (base[y-1][x+1] == round)
                    break;
                if (base[y-i][x+i] == 0 || base[y-i][x+i] == -2 || base[y-i][x+i] == 2)
                    break;
                if (base[y-i][x+i] == round)//1,5
                {
                    y2 = y-i;
                    x2 = x+i;
                    flag4 = 1;
                    break;
                }
            }
            for (int i = 1; i < k ; i++) {//左下探索
                if (base[y+1][x-1] == round)
                    break;
                if (base[y+i][x-i] == 0 || base[y+i][x-i] == -2 || base[y+i][x-i] == 2)
                    break;
                if (base[y+i][x-i] == round)
                {
                    y1 = y+i;
                    x1 = x-i;
                    flag4 = 1;
                    break;
                }
            }
        }
        if (x+y<=8 && x<y)//5，3
        {
            int k = y-1;//4
            int p = x-1;//2
            for (int i = 1; i <= p ; i++) {//左下探索
                if (base[y+1][x-1] == round)
                    break;
                if (base[y+i][x-i] == 0 || base[y+i][x-i] == 2 || base[y+i][x-i] == -2)
                    break;
                if (base[y+i][x-i] == round)
                {
                    y1 = y+i;
                    x1 = x-i;
                    flag4 = 1;
                    break;
                }
            }
            for (int i = 1; i <= k ; i++) {//右上探索
                if (base[y-1][x+1] == round)
                    break;
                if (base[y-i][x+i] == 0 || base[y-i][x+i] == 2 || base[y-i][x+i] == -2)
                    break;
                if (base[y-i][x+i] == round)
                {
                    y2 = y-i;
                    x2 = x+i;
                    flag4 = 1;
                    break;
                }
            }
        }
        if (x+y>8 && x>=y)//4,7
        {
            int k = 8-x;//1
            int p = 8-y;//4
            for (int i = 1; i <= p ; i++) {//左下探索
                if (base[y+1][x-1] == round)
                    break;
                if (base[y+i][x-i] == 0 || base[y+i][x-i] == -2 || base[y+i][x-i] == 2)
                    break;
                if (base[y+i][x-i] == round)
                {
                    y1 = y+i;
                    x1 = x-i;
                    flag4 = 1;
                    break;
                }
            }
            for (int i = 1; i <= k ; i++) {//右上探索
                if (base[y-1][x+1] == round)
                    break;
                if (base[y-i][x+i] == 0 || base[y-i][x+i] == 2 || base[y-i][x+i] == -2)
                    break;
                if (base[y-i][x+i] == round)
                {
                    y2 = y-i;
                    x2 = x+i;
                    flag4 = 1;
                    break;
                }
            }
        }
        if (x+y>8 && x<y)//6,5
        {
            int k = 8-y;//2
            int p = 8-x;//3
            for (int i = 1; i <= p ; i++) {//右上探索
                if (base[y-1][x+1] == round)
                    break;
                if (base[y-i][x+i] == 0 || base[y-i][x+i] == 2 || base[y-i][x+i] == -2)
                    break;
                if (base[y-i][x+i] == round)
                {
                    y2 = y-i;
                    x2 = x+i;
                    flag4 = 1;
                    break;
                }
            }
            for (int i = 1; i <= k ; i++) {//左下探索
                if (base[y+1][x-1] == round)
                    break;
                if (base[y+i][x-i] == 0 || base[y+i][x-i] == 2 || base[y+i][x-i] == -2)
                    break;
                if (base[y+i][x-i] == round)
                {
                    y1 = y+i;
                    x1 = x-i;
                    flag4 = 1;
                    break;
                }
            }
        }
        //翻子
        if (flag4 == 1 && (x1!=-1 && x2!=-1))
        {
            while(x1<x2&&y1>y2)
            {
                base[y1][x1] = round;
                x1++;
                y1--;
            }
        }
        else if (flag4 == 1 && x1!=-1 && x2==-1)
        {
            while(x1<x&&y1>y)
            {
                base[y1][x1] = round;
                x1++;
                y1--;
            }
        }
        else if (flag4 == 1 && x2!=-1 && x1==-1)
        {
            int ix = x;
            int iy = y;
            while(ix<x2&&iy>y2)
            {
                base[iy][ix] = round;
                ix++;
                iy--;
            }
        }
        //最外圈不落子
        for (int i = 0; i < 10 ; i++) {
            base[i][0] = 0;
            base[i][9] = 0;
            base[0][i] = 0;
            base[9][i] = 0;
        }
    }
    public int changechesssum(int[][] base,int x,int y,int round){
        int sum = 0;
        int flag1 = 0;//1横向有子，2纵向有子，3右侧向有子，4左侧向有子
        int flag2 = 0;//value为1代表有子
        int flag3 = 0;
        int flag4 = 0;
        int x1,x2,y1,y2;
        x1 = x2 = y1 = y2 = -1;
        //横向判断
        int l = x-1;
        int r = 8-x;
        for (int i = 1; i < l ; i++) {//向左探测
            if (base[y][x-1] == round)
                break;
            if (base[y][x-i] == 0 || base[y][x-i] == 2 || base[y][x-i] == -2)
                break;
            if (base[y][x-i] == -round && base[y][x-i-1] == round)
            {
                x1 = x-i-1;
                flag1 = 1;
                break;
            }
        }
        for (int i = 1; i < r ; i++) {//向右探测
            if (base[y][x+1] == round)
                break;
            if (base[y][x+i] == 0 || base[y][x+i] == 2 || base[y][x+i] == -2)
                break;
            if (base[y][x+i] == -round && base[y][x+i+1] == round)
            {
                x2 = x+i+1;
                flag1 = 1;
                break;
            }
        }
        //翻子
        if (flag1 == 1 && (x1!=-1&&x2!=-1))
        {
            for (int i = x1+1; i < x2 ; i++) {
                if (i == x)
                    continue;
                sum++;
            }
        }
        else if(flag1 == 1 && x1 != -1 && x2 == -1)
        {
            for (int i = x1+1; i < x ; i++) {
                sum++;
            }
        }
        else if(flag1 == 1 && x2 != -1 && x1 == -1)
        {
            for (int i = x+1; i < x2 ; i++) {
                sum++;
            }
        }
        //纵向判断
        int u = y-1;
        int d = 8-y;
        for (int i = 1; i < u ; i++) {//向上探测
            if (base[y-1][x] == round)
                break;
            if (base[y-i][x] == 0 || base[y-i][x] == 2 || base[y-i][x] == -2)
                break;
            if (base[y-i][x] == -round && base[y-i-1][x] == round)
            {
                y1 = y-i-1;
                flag2 = 1;
                break;
            }
        }
        for (int i = 1; i < d ; i++) {//向下探测
            if (base[y+1][x] == round)
                break;
            if (base[y+i][x] == 0 || base[y+i][x] == 2 || base[y+i][x] == -2)
                break;
            if (base[y+i][x] == -round && base[y+i+1][x] == round)
            {
                y2 = y+i+1;
                flag2 = 1;
                break;
            }
        }
        //翻子
        if (flag2 == 1 && (y1!=-1&&y2!=-1))
        {
            for (int i = y1+1; i < y2 ; i++) {
                if (i == y)
                    continue;
                sum++;
            }
        }
        else if (flag2 == 1 && y1 != -1 && y2 == -1)
        {
            for (int i = y1+1; i < y ; i++) {
                sum++;
            }
        }
        else if (flag2 == 1 && y2 != -1 && y1 == -1)
        {
            for (int i = y+1; i < y2 ; i++) {
                sum++;
            }
        }
        //右斜向判断
        x1 = x2 = y1 = y2 = -1;
        if (y>x)//7,4
        {
            int k = x-1;//3
            int p = 8-y;//1
            for (int i = 1; i <= k ; i++) {//左上探索
                if (base[y-1][x-1] == round)
                    break;
                if (base[y-i][x-i] == 0 || base[y-i][x-i] == -2 || base[y-i][x-i] == 2 )
                    break;
                if (base[y-i][x-i] == round)
                {
                    y1 = y-i;
                    x1 = x-i;
                    flag3 = 1;
                    break;
                }
            }
            for (int i = 1; i <= p ; i++) {//右下探索
                if (base[y+1][x+1] == round)
                    break;
                if (base[y+i][x+i] == 0 || base[y+i][x+i] == -2 || base[y+i][x+i] == 2)
                    break;
                if (base[y+i][x+i] == round)
                {
                    y2 = y+i;
                    x2 = x+i;
                    flag3 = 1;
                    break;
                }
            }
        }
        else if (x>=y)//3,5
        {
            int k = y-1;//2
            int p = 8-x;//3
            for (int i = 1; i <= k ; i++) {//左上探索
                if (base[y-1][x-1] == round)
                    break;
                if (base[y-i][x-i] == 0 || base[y-i][x-i] == -2 || base[y-i][x-i] == 2)
                    break;
                if (base[y-i][x-i] == round)
                {
                    y1 = y-i;
                    x1 = x-i;
                    flag3 = 1;
                    break;
                }
            }
            for (int i = 1; i <= p ; i++) {//右下探索
                if (base[y+1][x+1] == round)
                    break;
                if (base[y+i][x+i] == 0 || base[y+i][x+i] == 2 || base[y+i][x+i] == -2)
                    break;
                if (base[y+i][x+i] == round)
                {
                    y2 = y+i;
                    x2 = x+i;
                    flag3 = 1;
                    break;
                }
            }
        }
        //翻子
        if (flag3 == 1 && (x1!=-1 && x2!=-1))
        {
            while(x1<x2&&y1<y2)
            {
                if (y1 == y && x1 == x)
                    continue;
                x1++;
                y1++;
            }
            sum = sum+(x2-x1-2);
        }
        else if (flag3 == 1 && x1!=-1 && x2==-1)
        {
            while(x1<x&&y1<y)
            {
                x1++;
                y1++;
            }
            sum = sum+Math.abs(x-x1-1);
        }
        else if (flag3 == 1 && x2!=-1 && x1==-1)
        {
            int ix = x;
            int iy = y;
            while(ix<x2&&iy<y2)
            {
                ix++;
                iy++;
            }
            sum = sum+Math.abs(x2-x-1);
        }
        //左斜判断
        x1 = x2 = y1 = y2 = -1;
        if (x+y<=8 && x>=y)//2,4
        {
            int k = x-1;//3
            int p = y-1;//1
            for (int i = 1; i <= p ; i++) {//右上探索
                if (base[y-1][x+1] == round)
                    break;
                if (base[y-i][x+i] == 0 || base[y-i][x+i] == -2 || base[y-i][x+i] == 2)
                    break;
                if (base[y-i][x+i] == round)//1,5
                {
                    y2 = y-i;
                    x2 = x+i;
                    flag4 = 1;
                    break;
                }
            }
            for (int i = 1; i < k ; i++) {//左下探索
                if (base[y+1][x-1] == round)
                    break;
                if (base[y+i][x-i] == 0 || base[y+i][x-i] == -2 || base[y+i][x-i] == 2)
                    break;
                if (base[y+i][x-i] == round)
                {
                    y1 = y+i;
                    x1 = x-i;
                    flag4 = 1;
                    break;
                }
            }
        }
        if (x+y<=8 && x<y)//4,3
        {
            int k = y-1;//3
            int p = x-1;//2
            for (int i = 1; i <= p ; i++) {//左下探索
                if (base[y+1][x-1] == round)
                    break;
                if (base[y+i][x-i] == 0 || base[y+i][x-i] == 2 || base[y+i][x-i] == -2)
                    break;
                if (base[y+i][x-i] == round)
                {
                    y1 = y+i;
                    x1 = x-i;
                    flag4 = 1;
                    break;
                }
            }
            for (int i = 1; i <= k ; i++) {//右上探索
                if (base[y-1][x+1] == round)
                    break;
                if (base[y-i][x+i] == 0 || base[y-i][x+i] == 2 || base[y-i][x+i] == -2)
                    break;
                if (base[y-i][x+i] == round)
                {
                    y2 = y-i;
                    x2 = x+i;
                    flag4 = 1;
                    break;
                }
            }
        }
        if (x+y>8 && x>=y)//4,7
        {
            int k = 8-x;//1
            int p = 8-y;//4
            for (int i = 1; i <= p ; i++) {//左下探索
                if (base[y+1][x-1] == round)
                    break;
                if (base[y+i][x-i] == 0 || base[y+i][x-i] == -2 || base[y+i][x-i] == 2)
                    break;
                if (base[y+i][x-i] == round)
                {
                    y1 = y+i;
                    x1 = x-i;
                    flag4 = 1;
                    break;
                }
            }
            for (int i = 1; i <= k ; i++) {//右上探索
                if (base[y-1][x+1] == round)
                    break;
                if (base[y-i][x+i] == 0 || base[y-i][x+i] == 2 || base[y-i][x+i] == -2)
                    break;
                if (base[y-i][x+i] == round)
                {
                    y2 = y-i;
                    x2 = x+i;
                    flag4 = 1;
                    break;
                }
            }
        }
        if (x+y>8 && x<y)//6,5
        {
            int k = 8-y;//2
            int p = 8-x;//3
            for (int i = 1; i <= p ; i++) {//右上探索
                if (base[y-1][x+1] == round)
                    break;
                if (base[y-i][x+i] == 0 || base[y-i][x+i] == 2 || base[y-i][x+i] == -2)
                    break;
                if (base[y-i][x+i] == round)
                {
                    y2 = y-i;
                    x2 = x+i;
                    flag4 = 1;
                    break;
                }
            }
            for (int i = 1; i <= k ; i++) {//左下探索
                if (base[y+1][x-1] == round)
                    break;
                if (base[y+i][x-i] == 0 || base[y+i][x-i] == 2 || base[y+i][x-i] == -2)
                    break;
                if (base[y+i][x-i] == round)
                {
                    y1 = y+i;
                    x1 = x-i;
                    flag4 = 1;
                    break;
                }
            }
        }
        //翻子
        if (flag4 == 1 && (x1!=-1 && x2!=-1))
        {
            while(x1<x2&&y1>y2)
            {
                x1++;
                y1--;
            }
            sum = sum +(x2-x1-2);
        }
        else if (flag4 == 1 && x1!=-1 && x2==-1)
        {
            while(x1<x&&y1>y)
            {
                x1++;
                y1--;
            }
            sum = sum +Math.abs(x-x1-1);
        }
        else if (flag4 == 1 && x2!=-1 && x1==-1)
        {
            int ix = x;
            int iy = y;
            while(ix<x2&&iy>y2)
            {
                ix++;
                iy--;
            }
            sum = sum +Math.abs(x2-x-1);
        }
        //最外圈不落子
        for (int i = 0; i < 10 ; i++) {
            base[i][0] = 0;
            base[i][9] = 0;
            base[0][i] = 0;
            base[9][i] = 0;
        }
        return sum;
    }
}
