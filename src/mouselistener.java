import java.awt.event.*; //����MouseAdapter���ڵİ�
import javax.swing.*;   
public class mouselistener extends MouseAdapter{
    JFrame f;
    public mouselistener() {   
        f.addMouseListener(this);
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
     public void mouseClicked(MouseEvent e){ 
         f.setTitle("�������Ϊ ("+e.getX()+", "+e.getY()+")");
     }
}
