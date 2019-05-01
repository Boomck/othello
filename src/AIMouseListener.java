import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AIMouseListener implements MouseListener {
    public test pd;
    public int nullnum = 0;
    private normal_ai normalAI = new normal_ai();
    private hard_ai hardAi = new hard_ai(Chess.base);
    public void mouseClicked(MouseEvent e) {
        pd = new test();
        for (int i = 0; i < 10 ; i++) {
            for (int j = 0; j < 10 ; j++) {
                Chess.back[i][j] = Chess.base[i][j];
            }
        }
        Chess.X = (e.getX())/50;
        Chess.Y = (e.getY())/50;
        if (Chess.round == -1 && Chess.base[Chess.Y][Chess.X]==-2)
        {
            R1:
            Chess.base[Chess.Y][Chess.X]=-1;
            pd.changechess(Chess.base,Chess.X,Chess.Y,Chess.round);
            if(pd.whitecandown(Chess.base)== true)
            {
                Chess.round = 1;
            }
            //棋盘最外圈不落子
            outermost();
            //清理己方可落子点
            for (int i = 0; i <10 ; i++) {
                for (int j = 0; j <10 ; j++) {
                    if (Chess.base[i][j] == -2)
                        Chess.base[i][j] = 0;
                }
            }
            Chess.backgound.repaint();//画棋子
            //打印棋盘及下棋方
            System.out.println("黑子完毕棋盘");
            printchess();
        }
        if (Chess.round == 1)
        {
            R2:
            if (Chess.hardAI == 1)
            {
                hardAi.startAi(Chess.round);
                System.out.println("困难人机");
            }
            else
            {
                normalAI.local_solution(Chess.base,1);
                System.out.println("普通人机");
            }
            if(pd.blackcandown(Chess.base))//判断对方是否有可落子点  若有转为对方回合
            {
                Chess.round = -1;
            }
            //棋盘最外圈不落子
            outermost();
            //清理对方可落子点
            for (int i = 0; i <10 ; i++) {
                for (int j = 0; j <10 ; j++) {
                    if (Chess.base[i][j] == 2)
                        Chess.base[i][j] = 0;
                }
            }
            Chess.backgound.repaint();
            //打印棋盘及下棋方
            System.out.println("白子完毕棋盘");
            printchess();
        }//黑白落子执行完毕
        //修改连子情况bug
        statisticspiecenum(0,0);
        banbug();
        if (Chess.round == 1)//修改提示
        {
            Chess.roundjf.setText("请下白子");
        }
        else if (Chess.round == -1)
        {
            Chess.roundjf.setText("请下黑子");
        }
        //////////////////////////以下判断胜利
        nullnum = 0;//空子数量清零
        for (int i = 1; i <9 ; i++) {//遍历棋盘
            for (int j = 1; j <9 ; j++) {
                if (Chess.base[i][j]==0||Chess.base[i][j]==-2||Chess.base[i][j]==2)
                {
                    nullnum++;
                }
            }
        }
        //重新统计棋盘中黑白子数量
        Chess.whitenum = Chess.blacknum = 0;
        for (int i = 0; i <10 ; i++) {//遍历棋盘
            for (int j = 0; j <10 ; j++) {
                if(Chess.base[i][j] == 1)
                {
                    Chess.whitenum++;
                }
                if (Chess.base[i][j] == -1)
                {
                    Chess.blacknum++;
                }
            }
        }
        if (nullnum == 0)//没有空子，判断胜利
        {
            if (Chess.whitenum>Chess.blacknum)
            {
                JOptionPane.showMessageDialog(null,"白方获胜");
            }
            else if (Chess.blacknum>Chess.whitenum)
            {
                JOptionPane.showMessageDialog(null,"黑方获胜");
            }
            else if (Chess.blacknum == Chess.whitenum)
            {
                JOptionPane.showMessageDialog(null,"平局");
            }
        }
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
    public void printchess(){
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j <10 ; j++) {
                System.out.print(Chess.base[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public void outermost(){
        for (int i = 0; i < 10 ; i++) {
            Chess.base[i][0] = 0;
            Chess.base[i][9] = 0;
            Chess.base[0][i] = 0;
            Chess.base[9][i] = 0;
        }
    }
    public void statisticspiecenum(int whitenum,int blacknum){
        for (int i = 0; i <10 ; i++) {//遍历棋盘
            for (int j = 0; j <10 ; j++) {
                if(Chess.base[i][j] == 1)
                {
                    whitenum++;
                }
                if (Chess.base[i][j] == -1)
                {
                    blacknum++;
                }
            }
        }
        if (whitenum == 0 && blacknum!=0)
        {
            JOptionPane.showMessageDialog(null,"黑方获胜");
        }
        else if(blacknum == 0 && whitenum!=0)
        {
            JOptionPane.showMessageDialog(null,"白方获胜");
        }
        Chess.wscorejf.setText("白子数量："+whitenum);
        Chess.bscorejf.setText("黑子数量："+blacknum);
    }
    public void banbug(){
        int whitecandownnum = 0;
        int blackcandownnum = 0;
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j <10 ; j++) {
                if (Chess.base[i][j] == 2)
                {
                    whitecandownnum++;
                }
                if (Chess.base[i][j] == -2)
                {
                    blackcandownnum++;
                }
            }
        }
        if (whitecandownnum == 0 && blackcandownnum == 0)
        {
            JOptionPane.showMessageDialog(null,"请点击一下棋盘");
            if (pd.whitecandown(Chess.base))
            {
                Chess.round = 1;
                Chess.backgound.repaint();
                System.out.println("chufa修改白字可下");
                return;
            }
            if (pd.blackcandown(Chess.base))
            {
                Chess.round = -1;
                Chess.backgound.repaint();
                System.out.println("chufa修改黑字可下");
                return;
            }
        }
    }
}
