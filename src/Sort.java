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
	Font ft = new Font("����",Font.BOLD,15);
	
	JLabel lb1 = new JLabel("ѡ������ʽ");
	JLabel lb2 = new JLabel("����Ԫ�ظ���");
	//JLabel lb3 = new JLabel("��������ʱ��");
	static JComboBox cb = new JComboBox(new String[]{"������","ϣ������","ð������","��������","��������","��ѡ������"});
	static JTextField tf2 = new JTextField();
	//static JTextField tf3 = new JTextField();
	JButton jb0 = new JButton("����");
	JButton jb1 = new JButton("����");
	JButton jb2 = new JButton("��ʱ");
	JButton jb3 = new JButton("�Ա�");
	
	
    static String res;   //�����Ľ�����ַ�������ʽ����
	static String randomStr;   //���ɵ�����ַ���
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
		this.setTitle("��������");
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		
		
		/*���Ӱ�ť����*/
		
		
		jb0.addActionListener(new ActionListener(){
			//��ʾ������ɵ�����
			public void actionPerformed(ActionEvent e){
				int n = Integer.parseInt(tf2.getText());
				//randomAry(n);
				String st = randomAry(n);
				randomStr = st;
				result aryPanel = new result(st);
			}
			
		});
		
		jb1.addActionListener(new ActionListener(){
			//��ʾ����������
			public void actionPerformed(ActionEvent e){
	    		/*Object[]  options = {"ȷ��"};
				  UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("����", Font.BOLD, 15)));
				  System.out.println("2");				
				  JLabel jl = new JLabel(res);
				  jl.setFont(ft);
	    		  JOptionPane.showOptionDialog(null, jl, "������", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,null, options, options[0]);
				*/
				Mainpart();
	    		result resPanel = new result(res);	    		
			}
		});
		
		jb2.addActionListener(new ActionListener(){
			//���򻨷�ʱ�����
			public void actionPerformed(ActionEvent e){
				/*���Ӽ�ʱ��*/
				//String meanofSort = cb.getSelectedItem().toString();
				Object[] options = {"ȷ��"};
				UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("����",Font.BOLD,15)));	
				//���뼶��ʱ���� 
				long st = System.nanoTime();
				Mainpart();
				long en = System.nanoTime();
				//�����ʱ����,�е㲻׼
				long start = Calendar.getInstance().getTimeInMillis();
				Mainpart();
				long end = Calendar.getInstance().getTimeInMillis();
				double spendTime = (double)(en-st)/1000000;
				String time = "�����򻨷�ʱ��Ϊ:"+String.format("%.3f", spendTime)+"ms";
				JLabel jl = new JLabel(time);
				jl.setFont(ft);
	    		JOptionPane.showOptionDialog(null, jl, "��ʱ", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,null, options, options[0]);

			}
		});
		
		jb3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//�ԱȰ�ť
				TimeChart tc = new TimeChart();
				tc.main(null);
				//System.out.println(12);
			}
			
		});
	}
	
	
	static void Mainpart(){
		String meanOfSort;//�õ�ѡ�������ʽ
		int n = Integer.parseInt(tf2.getText()); //String to int ǿ������ת��;
		int[] ary = new int[n];
		
		//final String res;
		meanOfSort = cb.getSelectedItem().toString();
		//System.out.println(meanOfSort);
		switch(meanOfSort){
		case "������":
			HpSort Hps = new HpSort();
			ReadAry(ary);
			Hps.sort(ary);
			res = Readstr(ary);
			break;
		case "ϣ������": 
			ShelSot ssot = new ShelSot();
			ReadAry(ary);
			ssot.shellSort(ary);
			res = Readstr(ary);
			break;
		case "ð������":
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
		case "��������": 
			Sort1 st = new Sort1();
			ReadAry(ary);
			st.quicksork(ary);
			res = Readstr(ary);
			break;
		case "��������": 
			ReadAry(ary);
			RadxSort RS = new RadxSort();
			RS.RSort(ary);
			res = Readstr(ary);
			break;
		case "��ѡ������": 
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
		/*������������ַ�������һ��������*/
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
		/*����������������ַ�����ʾ����Ļ�ϣ������յ�������*/
		String res ="����������Ϊ:";
		for(int i=0;i<ary.length;i++){
			res = res+ary[i]+",";
		}
		return res;
		
	}
	//�����������
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
	JScrollPane jsp = new JScrollPane(jta);//���ӹ�����
	Font ft = new Font("����",Font.BOLD,15);
	result(String res){	
		jta.setLineWrap(true); //�Զ�����
		jta.setWrapStyleWord(false);  //���е�������
		jta.setText(res);
		jta.setFont(ft);
		jta.setEditable(false);
		jta.setOpaque(false);
		jta.setAutoscrolls(true);
			
		this.setTitle("�ۺ��������");
		this.setSize(500,300);
		
		this.getContentPane().add(jsp,BorderLayout.CENTER);
		//this.getContentPane().add(jsp, BorderLayout.EAST);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}

