import java.awt.*;
import java.io.Serializable;
import java.awt.event.MouseEvent;
import static java.lang.Math.abs;
import static java.lang.StrictMath.max;
import static java.lang.StrictMath.min;

public class SqrTool extends DrawItem implements Serializable {
    
	private static final long serialVersionUID = 1L;

	public SqrTool(DrawScreen ds) {
        super(Configure.colr, Configure.Mode.SQR, ds);
    }
    
    public SqrTool(DrawItem item, boolean ID){ 
    	super(item, ID); 
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        begin = new Point(e.getX(), e.getY());
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        finish = new Point(e.getX(), e.getY());
    }
    
    public void draw(Graphics graphics){
       graphics.setColor(colrType);
        if(begin != null && finish != null){
            int hor = abs(finish.x - begin.x);
            int ver = abs(finish.y - begin.y);
            int xcord = min(begin.x, finish.x);
            int ycord = min(begin.y, finish.y);
            int sidecord = max(hor, ver);
            graphics.drawRect(xcord, ycord, sidecord, sidecord);
        }
    }
    
    public void drawOutline(Graphics graphics){
        int hor = abs(finish.x - begin.x);
        int ver = abs(finish.y - begin.y);
        int xcord = min(begin.x, finish.x);
        int ycord = min(begin.y, finish.y);
        int sidecord = max(hor, ver);
        Graphics2D graphics2 = (Graphics2D) graphics;
        Stroke oldStroke = graphics2.getStroke();
        graphics2.setStroke(new BasicStroke(5));
        graphics.setColor(Color.CYAN);
        graphics.drawRect(xcord,ycord,sidecord,sidecord);
        graphics2.setStroke(oldStroke);
    }
    
    public Rectangle getBounds() {
        int hor = abs(finish.x - begin.x);
        int ver = abs(finish.y - begin.y);
        int xcord = min(begin.x, finish.x);
        int ycord = min(begin.y, finish.y);
        int sidecord = max(hor, ver);
        return new Rectangle(xcord,ycord, sidecord, sidecord);
    }
}