package acm;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
public class Sort {
	public static void main(String[] args){
		Surf sf = new Surf();
	}

}
class Surf extends JFrame{
	JPanel jp = new JPanel();
	JPanel jp1 = new JPanel();
	Font ft = new Font("楷体",Font.BOLD,15);
	
	JLabel lb1 = new JLabel("选择排序方式");
	JLabel lb2 = new JLabel("输入元素个数");
	//JLabel lb3 = new JLabel("所用排序时间");
	static JComboBox cb = new JComboBox(new String[]{"堆排序","希尔排序","冒泡排序","快速排序","基数排序","简单选择排序"});
	static JTextField tf2 = new JTextField();
	//static JTextField tf3 = new JTextField();
	JButton jb0 = new JButton("数组");
	JButton jb1 = new JButton("排序");
	JButton jb2 = new JButton("计时");
	JButton jb3 = new JButton("对比");
	
	
    static String res;   //排序后的结果用字符串的形式返回
	static String randomStr;   //生成的随机字符串
	Surf(){
		lb1.setFont(ft);
		lb2.setFont(ft);
		//lb3.setFont(ft);
		jb0.setFont(ft);
		jb1.setFont(ft);
		jb2.setFont(ft);
		jb3.setFont(ft);
		
		cb.setFont(ft);
		
		jp.setLayout(new GridLayout(2,2));
		jp.add(lb1);
		jp.add(cb);
		jp.add(lb2);
		jp.add(tf2);
		//jp.add(lb3);
		//jp.add(tf3);
		
		jp1.setLayout(new GridLayout(1,4));
		jp1.add(jb0);
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		
		this.add(jp,BorderLayout.CENTER);
		this.add(jp1, BorderLayout.SOUTH);
		this.setSize(500,130);
		this.setTitle("数列排序");
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		
		
		/*增加按钮监听*/
		
		
		jb0.addActionListener(new ActionListener(){
			//显示随机生成的数组
			public void actionPerformed(ActionEvent e){
				int n = Integer.parseInt(tf2.getText());
				//randomAry(n);
				String st = randomAry(n);
				randomStr = st;
				result aryPanel = new result(st);
			}
			
		});
		
		jb1.addActionListener(new ActionListener(){
			//显示排序后的数组
			public void actionPerformed(ActionEvent e){
	    		/*Object[]  options = {"确定"};
				  UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("楷体", Font.BOLD, 15)));
				  System.out.println("2");				
				  JLabel jl = new JLabel(res);
				  jl.setFont(ft);
	    		  JOptionPane.showOptionDialog(null, jl, "排序结果", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,null, options, options[0]);
				*/
				Mainpart();
	    		result resPanel = new result(res);	    		
			}
		});
		
		jb2.addActionListener(new ActionListener(){
			//排序花费时间计算
			public void actionPerformed(ActionEvent e){
				/*增加计时器*/
				//String meanofSort = cb.getSelectedItem().toString();
				Object[] options = {"确定"};
				UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("楷体",Font.BOLD,15)));	
				//纳秒级计时方法 
				long st = System.nanoTime();
				Mainpart();
				long en = System.nanoTime();
				//毫秒计时方法,有点不准
				long start = Calendar.getInstance().getTimeInMillis();
				Mainpart();
				long end = Calendar.getInstance().getTimeInMillis();
				double spendTime = (double)(en-st)/1000000;
				String time = "该排序花费时间为:"+String.format("%.3f", spendTime)+"ms";
				JLabel jl = new JLabel(time);
				jl.setFont(ft);
	    		JOptionPane.showOptionDialog(null, jl, "耗时", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,null, options, options[0]);

			}
		});
		
		jb3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//对比按钮
				TimeChart tc = new TimeChart();
				tc.main(null);
				//System.out.println(12);
			}
			
		});
	}
	
	
	static void Mainpart(){
		String meanOfSort;//得到选择的排序方式
		int n = Integer.parseInt(tf2.getText()); //String to int 强制类型转换;
		int[] ary = new int[n];
		
		//final String res;
		meanOfSort = cb.getSelectedItem().toString();
		//System.out.println(meanOfSort);
		switch(meanOfSort){
		case "堆排序":
			HpSort Hps = new HpSort();
			ReadAry(ary);
			Hps.sort(ary);
			res = Readstr(ary);
			break;
		case "希尔排序": 
			ShelSot ssot = new ShelSot();
			ReadAry(ary);
			ssot.shellSort(ary);
			res = Readstr(ary);
			break;
		case "冒泡排序":
			ReadAry(ary);
			int temp;
			for(int i=0;i<ary.length;i++){
				for(int j=1;j<ary.length-i;j++){
					if(ary[j-1]>ary[j]){
						temp = ary[j];
						ary[j] = ary[j-1];
						ary[j-1] = temp;
					}
				}
			}
			//System.out.println("1");
			res = Readstr(ary);
			break;
		case "快速排序": 
			Sort1 st = new Sort1();
			ReadAry(ary);
			st.quicksork(ary);
			res = Readstr(ary);
			break;
		case "基数排序": 
			ReadAry(ary);
			RadxSort RS = new RadxSort();
			RS.RSort(ary);
			res = Readstr(ary);
			break;
		case "简单选择排序": 
			ReadAry(ary);
			for(int i=0;i<ary.length-1;i++){
				for(int j=i+1;j<ary.length;j++){
					if(ary[i]>ary[j]){
						temp = ary[i];
						ary[i] = ary[j];
						ary[j] = temp;
					}
				}
			}
			res = Readstr(ary);
			break;
		}
	}
	
	public static void ReadAry(int[] ary){
		/*将输入的数列字符串放在一个数组中*/
		//String st = tf3.getText();
		//int n = Integer.parseInt(tf2.getText());
		//String st = randomAry(n);
		//randomStr = st;
		//System.out.print(st);
		String[] strAry = randomStr.split(",");
		for(int i=0;i<ary.length;i++){
			ary[i] = Integer.parseInt(strAry[i]);
		}
	}
	
	public static String Readstr(int[] ary){
		/*将排序后的数组读成字符串显示在屏幕上，即最终的排序结果*/
		String res ="排序后的数列为:";
		for(int i=0;i<ary.length;i++){
			res = res+ary[i]+",";
		}
		return res;
		
	}
	//生成随机数组
	public static String randomAry(int n){
		int max = 10000;
		int min = 1;
		String strAry;
		Random rm = new Random();
		strAry = rm.nextInt(max)+",";
		for(int i=0;i<n-1;i++){
			strAry +=((rm.nextInt(max)%(max-min+1)+min)+",");
		}
		return strAry;
	}
}

class result extends JDialog{
	
	JTextArea  jta = new JTextArea();
	JScrollPane jsp = new JScrollPane(jta);//增加滚动条
	Font ft = new Font("楷体",Font.BOLD,15);
	result(String res){	
		jta.setLineWrap(true); //自动换行
		jta.setWrapStyleWord(false);  //换行但不断字
		jta.setText(res);
		jta.setFont(ft);
		jta.setEditable(false);
		jta.setOpaque(false);
		jta.setAutoscrolls(true);
			
		this.setTitle("综合排序程序");
		this.setSize(500,300);
		
		this.getContentPane().add(jsp,BorderLayout.CENTER);
		//this.getContentPane().add(jsp, BorderLayout.EAST);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}

