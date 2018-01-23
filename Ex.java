import java.util.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
public class Ex extends Frame implements Runnable,KeyListener,ActionListener
{	
MenuBar mb;
Menu m1,m2;
MenuItem mi1,mi2,mj1;	
String st = "";
int
y=0,x1=210,x2=470,x3=300,x4=150,x5=500,x6=750,x7=150,x8=550,x9=600,x10=350,score=0,chance=3,t=1,pau=1,fd=0;
String cat="!!!!!!";
Dialog d = new Dialog(this,"BALL SURVIVAL",true);	
Dialog x = new Dialog(this,"CONTROLES",true);	
Button button1 = new Button("NEW GAME");
Button button2 = new Button("EXIT");
Button button3 = new Button("PAUSE");
Button button4 = new Button("OK");
TextField t1 = new TextField(20);
TextField t2 = new TextField(20);
Label label1 = new Label("KEYBOARD KEYS");
Label label2 = new Label("TO MOVE LEFT-A");
Label label3 = new Label("TO MOVE RIGHT-D");
Label label4 = new Label("TO PAUSE THE GAME-S");
public Ex()
{
		
		super("Ball Survival");
		setSize(900,900);
		setVisible(true);
		x.setLocation(400,400);
                x.setSize(300,300);
		d.setLocation(400,400);
                d.setSize(300,300);
		x.setLayout(new GridLayout(5,1));
		d.setLayout(new GridLayout(4,1));
		d.add(t1);
		x.add(label1);
		x.add(label2);
		x.add(label3);
		x.add(label4);
		d.add(button1);
		d.add(button3);
		d.add(button2);
		x.add(button4);
		button1.addActionListener(this); 
		button2.addActionListener(this); 
		button3.addActionListener(this); 
		button4.addActionListener(this);
		d.pack();
		x.pack();
		addKeyListener(this);
  		mb = new MenuBar();
     		m1  = new Menu("File");
     		m2  =new Menu("Help");
		mi1 = new MenuItem("New Game");
                mi2 = new MenuItem("Exit");
		mj1 = new MenuItem("Controles");
		setMenuBar(mb);
		mb.add(m1);
		mb.add(m2);
     		m1.add(mi2);
		m2.add(mj1);
		mj1.addActionListener(this);
		mi1.addActionListener(this);
        	mi2.addActionListener(this);
addWindowListener(new WindowAdapter()
     {
      public void windowClosing(WindowEvent we)
            {
                  closeAll();
            }
      });

}// end of constructor	d	





public void actionPerformed(ActionEvent ae)
{
 st = ae.getActionCommand();
 if(st.equals("New Game"))
       { 
              this.setVisible(false);
              Frame ng = new Ex();
              ng.setVisible(true);
       }
else if(st.equals("Exit"))
       {
              closeAll();
       }
else if(st.equals("Controles"))
	{
	pau=0;
	repaint();
	x.setVisible(true);
	}

char c=st.charAt(0);
{
if(c=='N')
{
if(y==0&&fd==0)
chance=3;
if(y==0&&fd==1)
chance=4;
else 
chance=3;
y=1;        
x1=210;
	x2=470;
	x3=300;
	x4=150;
	x5=500;
	x6=750;
	x7=150;
	x8=550;
	x9=600;
	x10=350;
score=0;
pau=1;
t1.setText("");
d.setVisible(false);
repaint();
}
if(c=='E')
closeAll();
if(c=='P')
{
if(y==0)
{
t1.setText("SELECT NEW GAME!!!!!!!");
fd=0;
repaint();
}
else 
t1.setText("");
pau=1;
d.setVisible(false);
repaint();
}
if(c=='O')
{
pau=1;
x.setVisible(false);
repaint();

}

}

}//end of action event





public void closeAll()
      {
         System.exit(0);

      }//closing windows



public void run()
{

	try
	{
	if(t==1)
	{
	Thread.sleep(10);
	
	}
	else
	{
	Thread.sleep(3000);
	t=1;
	score=0;
	chance=4;
	fd=1;
	y=0;
	d.setVisible(true);
	} 
	}
	catch ( InterruptedException e ) {}
}		

public void pause()
{
x4=x4;
x6=x6;
x8=x8;
x10=x10;
run();
repaint();
}

public void check()
{
x4=x4-3;
x6=x6-3;
x8=x8-3;
x10=x10-3;
run();
repaint();
}
public void old()
{
x2=x2-3;
run();
repaint();
}

public void cold()
{
x2=x2+3;
run();
repaint();
}
public void bold()
{
x2=x2+4;
run();
repaint();
}
public void keyTyped(KeyEvent ke)
{
	int ch=ke.getKeyChar();
	if(ch=='d')
	{
	if(x1==820)
	x1=x1;
	else
	{
	x1=x1+7;
	x2=x2;
	if(x1==465)
	{
	x1=465;
	x2=x2+5;
	run();
	}	
	}
	}
	if(ch=='s')
	{
	if(pau==0)
	{
	pau=1;
	repaint();
	}
	pau=0;
	t1.setText("GAME IS PAUSED");
	d.setVisible(true);
	}
	if(ch=='a')	
	{
	if(x1==0)
	x1=x1;
	else
	{
	x1=x1-7;
	x2=x2;
	if(x1==255)
	{
	x1=255;
	x2=x2+5;
	}
	}
	}
	/*if(ch=='w')
	{
	x1=x1;
	x2=x2-5;
	repaint();
	}
	if(ch=='s')
	{
	x1=x1;
	x2=x2+5;
	repaint();
	}*/

repaint();
}
	
	public void keyPressed(KeyEvent ke)
	{
	}
	public void keyReleased(KeyEvent ke)
	{
	}
	
	
	public void paint(Graphics g)
	{
	if(y==0)
	{
	d.setVisible(true);
	}
	else if(pau==1)
	{
	g.setColor(Color.red);
	g.fillOval(x1,x2,80,80);	
	g.setColor(Color.green);
	g.fillRect(x3,x4,200,50);
	g.setColor(Color.green);
	g.fillRect(x5,x6,200,50);
	g.setColor(Color.green);
	g.fillRect(x7,x8,200,50);
	g.setColor(Color.green);
	g.fillRect(x9,x10,200,50);
	score=score+1;
	g.drawString("Score :"+score,780,65);
	setBackground(Color.black);
	g.drawString("Chances :"+chance,780,80);
	if(x2<=-5||x2>=900)
	{
	if(chance==1)
	{
	t=0;
	g.drawString("GAME OVER"+cat,450,450);
	g.drawString("Score :"+score,450,465);
	run();
	}
	chance=chance-1;
	x1=210;
	x2=470;
	x3=300;
	x4=150;
	x5=500;
	x6=750;
	x7=150;
	x8=550;
	x9=600;
	x10=350;
	repaint();
	}
	else
        {
	if(x4<=1)	
	{        	
	x3= (int)(Math.random()*701);
	x4=800;
	check();
	}		
	else if(x6<=1)
	{
	x5= (int)(Math.random()*701);
	x6=800;
	check();
	}
	else if(x8<=1)
	{
	x7= (int)(Math.random()*701);
	x8=800;
	check();
	}
	else if(x10<=1)
	{
	x9= (int)(Math.random()*701);
	x10=800;
	check();
	}
	else
	{
	check();
	}
	}





if((((x3-40)<x1)&&(x1<(x3+160)))&&((x2>=(x4-80))&&(x2<=(x4-70)))||
         (((x5-40)<x1)&&(x1<(x5+160)))&&((x2>=(x6-80))&&(x2<=(x6-70)))||					(((x7-40)<x1)&&(x1<(x7+160)))&&((x2>=(x8-80))&&(x2<=(x8-70)))||
				(((x9-40)<x1)&&(x1<(x9+160)))&&((x2>=(x10-80))&&(x2<=(x10-70))))
	old();
	else if(score>2000)
	bold();
	else
	cold();	
	}
else
{
	g.setColor(Color.red);
	g.fillOval(x1,x2,80,80);	
	g.setColor(Color.green);
	g.fillRect(x3,x4,200,50);
	g.setColor(Color.green);
	g.fillRect(x5,x6,200,50);
	g.setColor(Color.green);
	g.fillRect(x7,x8,200,50);
	g.setColor(Color.green);
	g.fillRect(x9,x10,200,50);
	g.drawString("Score :"+score,780,65);
	setBackground(Color.black);
	g.drawString("Chances :"+chance,780,80);
	pause();
}

}



	public static void main( String args[] )
	{
		Ex x= new Ex();
		Thread t = new Thread(x);
		t.start();	
	}
}
