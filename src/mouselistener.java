import java.awt.event.*; //载入MouseAdapter所在的包
import javax.swing.*;   
public class mouselistener extends MouseAdapter{
    JFrame f;
    public mouselistener() {   
        f.addMouseListener(this);
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
     public void mouseClicked(MouseEvent e){ 
         f.setTitle("点击坐标为 ("+e.getX()+", "+e.getY()+")");
     }
}
