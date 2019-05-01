import javax.swing.*;
import java.awt.*;

public class FrameBackgound extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image backgound =new ImageIcon("src/bg.jpg").getImage();
        g.drawImage(backgound,0,0,750,545,null);
        Image leftchess =new ImageIcon("src/qp.jpg").getImage();
        g.drawImage(leftchess,20,30,450,450,null);
        Image bz = new ImageIcon("src/bz.png").getImage();
        Image hz = new ImageIcon("src/hz.png").getImage();
        Image add = new ImageIcon("src/add.png").getImage();
        for (int i = 0; i < 10 ; i++) {
            for (int j = 0; j < 10 ; j++) {
                if(Chess.base[i][j]==1)
                {
                    g.drawImage(bz,45+(j-1)*50,55+(i-1)*50,50,50,null);
                }
                if(Chess.base[i][j]==-1)
                {
                    g.drawImage(hz,45+(j-1)*50,55+(i-1)*50,50,50,null);
                }
                if(Chess.round == 1 && Chess.base[i][j] == 2)
                {
                    g.drawImage(add,45+(j-1)*50,55+(i-1)*50,50,50,null);
                }
                if(Chess.round == -1 && Chess.base[i][j] == -2)
                {
                    g.drawImage(add,45+(j-1)*50,55+(i-1)*50,50,50,null);
                }
            }
        }
    }
}
