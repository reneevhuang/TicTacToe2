import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
class MouseInfo implements MouseMotionListener
{
    private int 
    x,y,clickedX,clickedY;
    boolean click = false;

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getClickedX()
    {
        return clickedX;
    }

    public int getClickedY()
    {
        return clickedY;
    }

    public void mouseClicked(MouseEvent e) {
        clickedX=e.getX();
        clickedY=e.getY();
    }

    public void mouseEntered(MouseEvent e) {
        x=e.getX();
        y=e.getY();
    }

    public void mouseExited(MouseEvent e) {
        x = 0;
        y = 0;
        click=false;
    }

    public void mousePressed(MouseEvent e) {
        clickedX=e.getX();
        clickedY=e.getY();
        click=true;
    }

    public void mouseReleased(MouseEvent e) {
        click=false;
    }

    public void mouseMoved(MouseEvent e)
    {
        x=e.getX();
        y=e.getY();
        click=false;
    }

    public void mouseDragged(MouseEvent e)
    {
        x=e.getX();
        y=e.getY();
        clickedX=e.getX();
        clickedY=e.getY();
        click=true;
    }
}