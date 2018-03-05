import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
class MouseInfo implements MouseListener
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
    
    @Override
    public void mouseClicked(MouseEvent e) {
        clickedX=e.getX();
        clickedY=e.getY();
        x=e.getX();
        y=e.getY();
        click = true;
    }

    public void mouseEntered(MouseEvent e) {
        x=e.getX();
        y=e.getY();
    }

    public void mouseExited(MouseEvent e) {
        x = 0;
        y = 0;
    }

    public void mousePressed(MouseEvent e) {
        clickedX=e.getX();
        clickedY=e.getY();
        x=e.getX();
        y=e.getY();
        click=true;
    }

    public void mouseReleased(MouseEvent e) {
        click=true;
        x=e.getX();
        y=e.getY();
    }
}