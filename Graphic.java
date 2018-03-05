import java.awt.*;
import java.io.Serializable;
import java.util.Vector;
import javax.swing.*;
import java.awt.image.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

class Surface extends JPanel implements ActionListener
{
    private Graphics2D g2d;
    private int[][] playerMoves = new int[3][3];
    private final int DELAY = 30;
    private final Color BACKGROUND = Color.white;
    private final Color FOREGROUND = Color.black;
    Timer timer;
    private int size = 100;
    Game game;
    private MouseInfo mouse;

    /**
     * TODO:
     * 1. Set the color of the foreground by calling "setForeground(Color.[enter color]);"
     * 2. Set the color of the background by calling "setBackground(Color.[enter color]);"
     * 3. Set the font that will appear in the window by calling "setFont(new Font("[font name]", Font.PLAIN, [font size]));"
     * 4. Start the timer by calling "initTimer();"
     */
    public Surface(Game ggame)
    {
        setForeground(FOREGROUND);
        setBackground(BACKGROUND);
        mouse = new MouseInfo();
        addMouseListener(mouse);
        game = ggame;
        //setFont(new Font("[font name]", Font.PLAIN, [font size]));
    }

    private void initTimer()
    {
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public Timer getTimer()
    {
        return timer;
    }

    public int getSizeVar()
    {
        return size;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 1000);
    }

    /**
     * TODO:
     * 1. Call super paint component constructor and pass in g as a parameter
     * 2. Create Graphics2D object by calling "g.create();" Cast the object into "Graphics2D" and set that to the class variable "g2d"
     * 3. Call "doDrawing(g);"
     */
    protected void paintComponent(Graphics g) {
        g2d = (Graphics2D) g;
        super.paintComponent(g);
        doDrawing();
    }

    /**
     * TODO:
     * 1. Cast the parameter Graphics variable to class variable "g2d" Make sure that the object is casted to Graphics2D
     * 2. Follow previous line by copying and pasting this code behind it:
     *         "RenderingHints rh = new RenderingHints(
    RenderingHints.KEY_ANTIALIASING,
    RenderingHints.VALUE_ANTIALIAS_ON);
    rh.put(RenderingHints.KEY_RENDERING,
    RenderingHints.VALUE_RENDER_QUALITY); 
    g2d.setRenderingHints(rh);"
     * 3. Call "drawBoard();" method
     */
    private void doDrawing() {
        //unfinished
        size = (getWidth()+getHeight())/15;
        drawBackground();
        drawBoard();
        int mX = mouse.getX();
        int mY = mouse.getY();
        int h = getHeight();
        int w = getWidth();
        if(mouse.click)
        {
            mX = (mX-(w/2-3*size))/(2*size);
            mY = (mY-(h/2-3*size))/(2*size);
            System.out.println("Click: " + mX + ", " + mY);
            game.player1Move(mX,mY);
            mouse.click = false;
        }
        for(int r=0;r<3;r++)
            for(int c=0;c<3;c++)
                if(game.getPlayerMoves()[r][c]==1)
                    drawO(r-1,c-1);
    }
    /**
     * TODO:
     * 1. Set paint color of the x that will be drawn "g2d.setPaint(Color.[enter color]);"
     * 2. Draw an O using Graphics line method that will create an X shape
     * 3. Use the parameter ints: x and y for reference where the x shape should be placed in the window
     */
    public void drawO(int x, int y)
    {
        int radius = size*3/4;  
        int h = getHeight();
        int w = getWidth();
        g2d.setColor(FOREGROUND);
        g2d.fillOval(w/2+(int)(x*size*2)-radius, h/2+(int)(y*size*2)-radius,radius*2,radius*2);
        g2d.setColor(BACKGROUND);
        radius-=5;
        g2d.fillOval(w/2+(int)(x*size*2)-radius, h/2+(int)(y*size*2)-radius,radius*2,radius*2);
    } 

    private void drawBackground()
    {
        g2d.setColor(BACKGROUND);
        g2d.fillRect(0,0,getWidth(),getHeight());
    }

    /**
     * TODO:
     * 1. Set paint color of the x that will be drawn "g2d.setPaint(Color.[enter color]);"
     * 2. Draw an x using Graphics line method that will create an X shape
     * 3. Use the parameter ints: x and y for reference where the x shape should be placed in the window
     */
    public void drawX(int x, int y)
    {
        g2d.setStroke(new BasicStroke(5));
        int radius = size*3/4;
        int h = getHeight();
        int w = getWidth();
        g2d.setColor(FOREGROUND);
        g2d.drawLine(w/2+(int)(x*size*2)-radius, h/2+(int)(y*size*2)-radius,w/2+(int)(x*size*2)+radius, h/2+(int)(y*size*2)+radius);
        g2d.drawLine(w/2+(int)(x*size*2)-radius, h/2+(int)(y*size*2)+radius,w/2+(int)(x*size*2)+radius, h/2+(int)(y*size*2)-radius);
    } 

    /**
     * TODO:
     * 1. Draw the 3x3 grid that will be displayed on the screen by outlining it with lines
     */
    public void drawBoard()
    {
        int h = getHeight();
        int w = getWidth();
        g2d.setColor(FOREGROUND);
        g2d.fillRect(w/2-size,h/2-3*size,5,6*size);
        g2d.fillRect(w/2+size,h/2-3*size,5,6*size);
        g2d.fillRect(w/2-3*size,h/2-size,6*size,5);
        g2d.fillRect(w/2-3*size,h/2+size,6*size,5);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}

public class Graphic extends JFrame {
    private Graphics2D g2d;

    /**
     * 1. Set background color by calling "setBackground(Color.[enter color]);"
     * 2. Set Foreground color by calling "setForeground(Color.[enter color]);"
     * 3. Set Font by calling "setFont(new Font("[enter font]", Font.PLAIN, [font size]));"
     * 4. Call "initUI();"
     */
    public Graphic() {
        initUI();
    }

    /**
     * 1. Call "add(new Surface());"
     * 2. Set the title of the window that will appear by calling "setTitle("[enter game name]");"
     * 3. Call "setLocationRelativeTo(null);"
     * 4. Make sure the window closes when the user clicks the top right x. (call "setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);")
     */
    private void initUI() {
        Game theGame = new Game();
        final Surface surface = new Surface(theGame);
        add(surface);

        addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    Timer timer = surface.getTimer();
                    timer.stop();
                }
            });

        setTitle("TicTacToe");
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    JFrame frame = new JFrame();
                    Graphic x = new Graphic();
                    x.setVisible(true);
                }
            });
    }

}