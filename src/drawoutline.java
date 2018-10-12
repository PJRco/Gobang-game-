import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.color.*;
import javax.swing.*;
public class drawoutline extends JFrame implements MouseListener{
	protected int touch=-1,temp=-1;
	protected float x,y;
	protected int[] xlist=new int[100];
	protected int[] ylist=new int[100];
	protected int[][] chessblock= new int[13][13];
	protected int result1=-1,result2=-1,result3=-1,result4=-1;
	
	Graphics g;
	public drawoutline() {    
	      super( "演示字体、颜色、绘图" );     //调用基类构造方法         
	      
	      setSize( 740, 740 );
	      getContentPane().setVisible(false);
	      setBackground( new Color(255,228,196));
	      setVisible( true ); 
	      
	      for(int i=0;i<13;i++)
	  		for(int j=0;j<13;j++)
	  		{
	  			chessblock[i][j]=-1;
	  		}
	      addMouseListener(this);
	}
	   public void paint( Graphics g )  {
	       super.paint( g );  // call superclass's paint method
	       setBackground(new Color(255,228,196));
	       Graphics2D g2=(Graphics2D) g;
	       g2.setStroke(new BasicStroke(3.0f));
	       for(int i=0;i<12;i++)
	    	   g.drawLine(60,60+60*i,720,60+60*i);  
	       for(int i=0;i<12;i++)
	    	   g.drawLine(60+60*i,60,60+60*i,720);  
	      
	       if(result1==0||result2==0||result3==0||result4==0)
	       {
	    	   setTitle("somebody win");
	    	   JOptionPane.showMessageDialog(null,"白棋胜","白棋胜",JOptionPane.INFORMATION_MESSAGE);
	       }
	       else if(result1==1||result2==1||result3==1||result4==1)
	       {
	       		setTitle("somebody win");
	       		JOptionPane.showMessageDialog(null,"黑棋胜","黑棋胜",JOptionPane.INFORMATION_MESSAGE);
	       }
	       result1=-1;
	       result2=-1;
	       result3=-1;
	       result4=-1;
	       
	       
	       if(temp != touch)
	       {
	    	   for(int i=0;i<=touch;i++)
	    	   {	if(i%2==0)
		    		   g.setColor(Color.black);
		    	   	else
		    		   g.setColor(Color.white);
	    		   g.fillOval(xlist[i]*60-20,ylist[i]*60-20,40,40);
	    	   }
	    	   temp=touch;
	       }   
	   }
	   
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		x=(float) (e.getX()/60.0);
		y=(float) (e.getY()/60.0);
		int temp1=touch;
		boolean flag=true;
		for(int j=0;j<=temp1;j++)
		{
			if(x==xlist[j]&&y==ylist[j])
			{
				flag=false;
			}
		}
		if(flag==true)
		{
			touch++;
			int xtemp=e.getX()/60;
			int ytemp=e.getY()/60;
			
			if(x>xtemp+0.5)
				xlist[touch]=xtemp+1;
			else xlist[touch]=xtemp;
			
			if(y>ytemp+0.5)
				ylist[touch]=ytemp+1;
			else ylist[touch]=ytemp;
			
			if(touch%2==0)
				chessblock[xlist[touch]][ylist[touch]]=1;
			else
				chessblock[xlist[touch]][ylist[touch]]=0;
			
			//System.out.println(xlist[touch]+"xyz"+ylist[touch]);
			
			result1=checkwin1(chessblock);
			result2=checkwin2(chessblock);
			result3=checkwin3(chessblock);
			result4=checkwin4(chessblock);
			repaint();
		}
		//setTitle("点击坐标为 ("+e.getX()+", "+e.getY()+")");
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}  
	
	public int checkwin1(int[][] a)
	{
		int win=0;
		int count0=0,count1=0;
		int keychess=-1;
		int tempchess=-1;
		
		for(int i=0;i<12;i++)
		{
			count0=0;
			count1=0;
			keychess=-1;
			tempchess=-1;
			
			for(int j=0;j<12;j++)
			{
				if(a[i][j]==-1)
				{
					count0=0;
					count1=0;
					keychess=-1;
					tempchess=-1;
					continue;
				}
					
				else if(a[i][j]==0)
					keychess=0;
				else if(a[i][j]==1)
					keychess=1;
				
				if(tempchess==-1)
					{
						if(keychess==0)
							count0++;
						else if(keychess==1)
							count1++;
					}
				
				else if(tempchess==keychess)
					{
						if(keychess==0)
							count0++;
						else if(keychess==1)
							count1++;
					}
						
				else if(tempchess!=keychess)
					{
						if(keychess==0)
						{
							count0=1;
							count1=0;
						}
						else if(keychess==1)
						{
							count1=1;
							count0=0;
						}
					}
				
				tempchess=keychess;
				
				System.out.println("x="+i+" "+"y="+j+"    "+"white="+count0+" "+"black="+count1);
				//System.out.print("white="+count0+" "+"black="+count1);
				
				if(count0==5)
					return 0;
				else if(count1==5)
					return 1;
			}
		}
		return -1;
	}


public int checkwin2(int[][] a)
{
	int win=0;
	int count0=0,count1=0;
	int keychess=-1;
	int tempchess=-1;
	
	for(int j=0;j<12;j++)
	{
		count0=0;
		count1=0;
		keychess=-1;
		tempchess=-1;
		
		for(int i=0;i<12;i++)
		{
			if(a[i][j]==-1)
			{
				count0=0;
				count1=0;
				keychess=-1;
				tempchess=-1;
				continue;
			}
				
			else if(a[i][j]==0)
				keychess=0;
			else if(a[i][j]==1)
				keychess=1;
			
			if(tempchess==-1)
				{
					if(keychess==0)
						count0++;
					else if(keychess==1)
						count1++;
				}
			
			else if(tempchess==keychess)
				{
					if(keychess==0)
						count0++;
					else if(keychess==1)
						count1++;
				}
					
			else if(tempchess!=keychess)
				{
					if(keychess==0)
					{
						count0=1;
						count1=0;
					}
					else if(keychess==1)
					{
						count1=1;
						count0=0;
					}
				}
			
			tempchess=keychess;
			
			System.out.println("x="+i+" "+"y="+j+"    "+"white="+count0+" "+"black="+count1);
			//System.out.print("white="+count0+" "+"black="+count1);
			
			if(count0==5)
				return 0;
			else if(count1==5)
				return 1;
		}
	}
	return -1;
}

public int checkwin3(int[][] a)
{
	int count0=0,count1=0;
	int keychess=-1;
	int tempchess=-1;
	int max;
	int startx,starty;
	for(int i=0;i<12+11;i++)
	{
		count0=0;
		count1=0;
		keychess=-1;
		tempchess=-1;
		if(i<12)
		{
			max=i+1;
			starty=12-i;
			startx=1;
		}
		else
		{
			max=12+11-i;
			startx=i-11+1;
			starty=1;
		}
		for(int j=0;j<max;j++)
		{
			int xpixl=startx+j;
			int ypixl=starty+j;
			
			if(a[xpixl][ypixl]==-1)
			{
				count0=0;
				count1=0;
				keychess=-1;
				tempchess=-1;
				continue;
			}
			
			else if(a[xpixl][ypixl]==0)
				keychess=0;
			else if(a[xpixl][ypixl]==1)
				keychess=1;
			
			if(tempchess==-1)
				{
					if(keychess==0)
						count0++;
					else if(keychess==1)
						count1++;
				}
			
			else if(tempchess==keychess)
				{
					if(keychess==0)
						count0++;
					else if(keychess==1)
						count1++;
				}
					
			else if(tempchess!=keychess)
				{
					if(keychess==0)
					{
						count0=1;
						count1=0;
					}
					else if(keychess==1)
					{
						count1=1;
						count0=0;
					}
				}
			
			tempchess=keychess;
			
			System.out.println("x="+i+" "+"y="+j+"    "+"white="+count0+" "+"black="+count1);
			//System.out.print("white="+count0+" "+"black="+count1);
			
			if(count0==5)
				return 0;
			else if(count1==5)
				return 1;
			
		}
	}
	return -1;
}

public int checkwin4(int[][] a)
{
	int count0=0,count1=0;
	int keychess=-1;
	int tempchess=-1;
	int max;
	int startx,starty;
	for(int i=0;i<12+11;i++)
	{
		count0=0;
		count1=0;
		keychess=-1;
		tempchess=-1;
		if(i<12)
		{
			max=i+1;
			starty=1;
			startx=i+1 ;
		}
		else
		{
			max=12+11-i;
			startx=12;
			starty=i-11+1;
		}
		for(int j=0;j<max;j++)
		{
			int xpixl=startx-j;
			int ypixl=starty+j;
			
			if(a[xpixl][ypixl]==-1)
			{
				count0=0;
				count1=0;
				keychess=-1;
				tempchess=-1;
				continue;
			}
			
			else if(a[xpixl][ypixl]==0)
				keychess=0;
			else if(a[xpixl][ypixl]==1)
				keychess=1;
			
			if(tempchess==-1)
				{
					if(keychess==0)
						count0++;
					else if(keychess==1)
						count1++;
				}
			
			else if(tempchess==keychess)
				{
					if(keychess==0)
						count0++;
					else if(keychess==1)
						count1++;
				}
					
			else if(tempchess!=keychess)
				{
					if(keychess==0)
					{
						count0=1;
						count1=0;
					}
					else if(keychess==1)
					{
						count1=1;
						count0=0;
					}
				}
			
			tempchess=keychess;
			
			System.out.println("x="+i+" "+"y="+j+"    "+"white="+count0+" "+"black="+count1);
			//System.out.print("white="+count0+" "+"black="+count1);
			
			if(count0==5)
				return 0;
			else if(count1==5)
				return 1;
			
		}
	}
	return -1;
}
}


