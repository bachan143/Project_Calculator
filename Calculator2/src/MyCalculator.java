import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyCalculator extends JFrame implements ActionListener

{
	 
	    JTextField tf1;
		JButton add,sub,mul,div,mod,EQ,
		 one,two, three,four ,five, six,seven,eight,nine,zero,dot,clear,sqrt;
		

	    private boolean editable = true;
	public MyCalculator()
	{
		
        tf1 = new JTextField();
        one=new JButton("1");
		two=new JButton("2");
		three=new JButton("3");
		four=new JButton("4");
		five=new JButton("5");
		six=new JButton("6");
		seven=new JButton("7");
		eight=new JButton("8");
		nine=new JButton("9");
		zero=new JButton("0");
		dot=new JButton(".");
		add=new JButton("+");
		sub=new JButton("-");
		mul=new JButton("*");
		div=new JButton("/");
		mod=new JButton("%");
	
		EQ=new JButton("=");
		
		one.setBounds(50,65,100,30);
		two.setBounds(155,65,100,30);
		three.setBounds(260,65,100,30);
		four.setBounds(50,100,100,30);
		five.setBounds(155,100,100,30);
		six.setBounds(260,100,100,30);
		seven.setBounds(50,135,100,30);
		eight.setBounds(155,135,100,30);
		nine.setBounds(260,135,100,30);
		zero.setBounds(50,170,100,30);
		dot.setBounds(155,170,100,30);

		add.setBounds(260,170,100,30);
		sub.setBounds(50,205,100,30);
		mul.setBounds(155,205,100,30);
		div.setBounds(260,205,100,30);
		mod.setBounds(50,240,100,30);
		EQ.setBounds(155,240,105,30);
		tf1.setBounds(50,20,300,40);
		add(one);add(two);add(three);add(four);add(five);add(six);add(seven);add(eight);add(nine);add(zero);add(dot);
		add(sub);add(mul);add(div);add(EQ);add(add);add(tf1);add(mod);
		add(tf1);
		tf1.addActionListener(this);
         one.addActionListener(this);
         two.addActionListener(this);
         three.addActionListener(this);
         four.addActionListener(this);
         five.addActionListener(this);
         six.addActionListener(this);
         seven.addActionListener(this);
         eight.addActionListener(this);
         nine.addActionListener(this);
         zero.addActionListener(this);
         dot.addActionListener(this);
         
        
         add.addActionListener(this);
         sub.addActionListener(this);
         mul.addActionListener(this);
         div.addActionListener(this);
         mod.addActionListener(this);
         EQ.addActionListener(this);
        one.setBackground(Color.BLUE);
        two.setBackground(Color.BLUE);
        three.setBackground(Color.BLUE);
        four.setBackground(Color.BLUE);
        five.setBackground(Color.BLUE);
        six.setBackground(Color.BLUE);
        seven.setBackground(Color.BLUE);
        eight.setBackground(Color.BLUE);
        nine.setBackground(Color.BLUE);
        zero.setBackground(Color.BLUE);
        dot.setBackground(Color.BLUE);
        add.setBackground(Color.red);
        sub.setBackground(Color.red);
        mul.setBackground(Color.red);
        div.setBackground(Color.red);
        mod.setBackground(Color.red);
        
        
        EQ.setBackground(Color.GREEN);
       tf1.setBackground(Color.orange);  
        tf1.setForeground(Color.WHITE);  
        
		
		
		
      
		
		
	     setBackground(Color.cyan);
		

	
		setSize(400,400);
		setLayout(null);
		setVisible(true);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent event)
    {

        
        if (event.getSource() instanceof JButton)
        {
            JButton clickedButton = (JButton) event.getSource();
           
            if(clickedButton.getText().equals("="))
            {
                addOutput();
            }
           
            else
            {
                addInput(clickedButton.getText());
            }
        }
       
        else
        {
            addOutput();
        }
    }

    public void addInput(String line)
    {
        
        if(editable)
        {
            tf1.setText(tf1.getText()+line);
        }
        
        else
        {
            tf1.setText(line);
            editable = true;
        }
    }
    public void addOutput()
    {
        double output = 0;

        
        try
        {
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            tf1.setText(engine.eval(tf1.getText()).toString());
        }
        catch(ScriptException e)
        {
            tf1.setText("Syntax error");
        }
        editable = false;
		
    }
	
	public static void main(String[] args)
	{
		new MyCalculator();
		
		
	}

}
