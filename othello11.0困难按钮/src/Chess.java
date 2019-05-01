import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 2018/4/11.
 */
public class Chess extends JFrame {
    public static FrameBackgound backgound;
    private JLabel backgoundjp;
    private JPanel leftjp, rightjp;
    private int pressnum = 0;//0代表人人，1代表人机
    public FrameMouseListener frameMouseListener;
    public AIMouseListener aiMouseListener;
    public static int hardAI = 0;//0代表未启动，1代表启动
    private JButton startButton, restartButton, backButton, AIButton,hardAIbutton, exitButton;
    public static JTextField wscorejf,bscorejf,roundjf;
    public static int X;//鼠标点击X坐标
    public static int Y;//鼠标点击Y坐标
    public static int[][] back =new int[10][10];
    public static int[][] base =
                    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};//0为无子，1为白子，-1为黑子，2为白子可落子，-2为黑子可落子
    public static int round = -1;//谁的回合，1白，-1黑
    public static int blacknum = 0,whitenum = 0;//棋盘中黑白子的数量
    public Chess() throws HeadlessException {
        init();
        addBackGound();
        addLeftChess();
        addRightOther();
        SetMuseListener();
        addActionListener();
        this.setVisible(true);
    }

    //窗口
    public void init() {
        this.setTitle("黑白棋");
        this.setLayout(null);
        this.setBounds(100, 100, 750, 545);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //添加背景图片
    public void addBackGound() {
        CardLayout layout = new CardLayout();
        backgoundjp = new JLabel();
        this.getLayeredPane().add(backgoundjp, new Integer(Integer.MIN_VALUE));
        ((JPanel) this.getContentPane()).setOpaque(false);
        backgoundjp.setBounds(0, 0, 750, 545);
        backgoundjp.setLayout(layout);
        backgound = new FrameBackgound();
        backgound.setBounds(0, 0, 750, 545);
        backgoundjp.add(backgound);
    }

    //左边棋盘
    public void addLeftChess() {
        leftjp = new JPanel();
        leftjp.setLayout(null);
        leftjp.setOpaque(false);
        leftjp.setBounds(-5, 5, 500, 500);
        this.add(leftjp);
    }

    //右边功能区
    public void addRightOther() {
        rightjp = new JPanel();
        rightjp.setBounds(490, 180, 240, 290);
        rightjp.setOpaque(false);
        wscorejf = new JTextField("白子数量：0",12);
        bscorejf = new JTextField("黑子数量：0",12);
        roundjf = new JTextField("请下黑子",12);
        wscorejf.setOpaque(false);
        wscorejf.setFont(new Font("宋体",Font.BOLD,20));
        wscorejf.setEditable(false);
        bscorejf.setOpaque(false);
        bscorejf.setFont(new Font("宋体",Font.BOLD,20));
        bscorejf.setEditable(false);
        roundjf.setOpaque(false);
        roundjf.setFont(new Font("宋体",Font.BOLD,20));
        roundjf.setEditable(false);
        startButton = new JButton("           开始           ");
        restartButton = new JButton("       重新开始       ");
        backButton = new JButton("           悔棋           ");
        AIButton = new JButton("           人机           ");
        hardAIbutton = new JButton("       困难人机       ");
        exitButton = new JButton("           退出           ");
        rightjp.add(wscorejf);
        rightjp.add(bscorejf);
        rightjp.add(roundjf);
        rightjp.add(startButton);
        rightjp.add(restartButton);
        rightjp.add(backButton);
        rightjp.add(hardAIbutton);
        rightjp.add(AIButton);
        rightjp.add(exitButton);
        this.add(rightjp);
    }

    //    设置鼠标监听
    public void SetMuseListener() {
        frameMouseListener = new FrameMouseListener();
        aiMouseListener = new AIMouseListener();
        leftjp.addMouseListener(frameMouseListener);
    }

    //设置按钮
    public void addActionListener() {
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("开始被点击");
                round = -1;
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        base[i][j] = 0;
                    }
                }
                test pd = new test();
                base[4][4] = 1;
                base[4][5] = -1;
                base[5][4] = -1;
                base[5][5] = 1;
                System.out.println("开始点击后可下子判断");
                if (round == -1)
                {
                    pd.blackcandown(base);
                }
                else
                {
                    pd.whitecandown(base);
                }
                backgound.repaint();
                whitenum = blacknum = 0;
                for (int i = 0; i <10 ; i++) {
                    for (int j = 0; j <10 ; j++) {
                        if(base[i][j] == 1)
                        {
                            whitenum++;
                        }
                        if (base[i][j] == -1)
                        {
                            blacknum++;
                        }
                    }
                }
                wscorejf.setText("白子数量："+whitenum);
                bscorejf.setText("黑子数量："+blacknum);
            }
        });
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        base[i][j] = 0;
                    }
                }
                backgound.repaint();
                whitenum = blacknum = 0;
                wscorejf.setText("白子数量："+whitenum);
                bscorejf.setText("黑子数量："+blacknum);
            }
        });
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 10 ; i++) {
                    for (int j = 0; j < 10 ; j++) {
                        base[i][j] = back[i][j];
                    }
                }
                round = -round;
                backgound.repaint();
                whitenum = blacknum = 0;
                for (int i = 0; i <10 ; i++) {
                    for (int j = 0; j <10 ; j++) {
                        if(base[i][j] == 1)
                        {
                            whitenum++;
                        }
                        if (base[i][j] == -1)
                        {
                            blacknum++;
                        }
                    }
                }
                wscorejf.setText("白子数量："+whitenum);
                bscorejf.setText("黑子数量："+blacknum);
            }
        });
        AIButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (pressnum == 0)
                {
                    pressnum = 1;
                }
                else
                {
                    pressnum = 0;
                }
                if (pressnum == 1)
                {
                    JOptionPane.showMessageDialog(null,"现在切换为人机模式");
                    leftjp.removeMouseListener(frameMouseListener);
                    leftjp.addMouseListener(aiMouseListener);
                }
                else if (pressnum == 0)
                {
                    JOptionPane.showMessageDialog(null,"现在切换为人人模式");
                    leftjp.removeMouseListener(aiMouseListener);
                    leftjp.addMouseListener(frameMouseListener);
                }
            }
        });
        hardAIbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (pressnum == 0)
                {
                    pressnum = 1;
                }
                else
                {
                    pressnum = 0;
                }
                if (pressnum == 1)
                {
                    hardAI = 1;
                    JOptionPane.showMessageDialog(null,"现在切换为困难人机模式");
                    leftjp.removeMouseListener(frameMouseListener);
                    leftjp.addMouseListener(aiMouseListener);
                }
                else if (pressnum == 0)
                {
                    hardAI = 0;
                    JOptionPane.showMessageDialog(null,"现在切换为人人模式");
                    leftjp.removeMouseListener(aiMouseListener);
                    leftjp.addMouseListener(frameMouseListener);
                }
            }
        });
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
