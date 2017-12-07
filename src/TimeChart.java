package acm;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import org.jfree.chart.*;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

class TimeChat {
	
	static int[] best = new int[1000];
	static int[] worst = new int[1000];
	//"������","ϣ������","ð������","��������","��������","��ѡ������"����ʱ��
    static double btime_Heap,btime_Shell,btime_Bubble,btime_Quick,btime_Radix,btime_Simple; //����������������µ�ʱ��
	static double wtime_Heap,wtime_Shell,wtime_Bubble,wtime_Quick,wtime_Radix,wtime_Simple; //�����µ�����
	@SuppressWarnings("static-access")
	TimeChat(){
		for(int i=0;i<1000;i++){
			best[i] = i;
		}
		for(int i=999;i>=0;i--){
			worst[i] = i;
		}
		//System.out.println(1);
		//������
		HpSort Hps = new HpSort();
		long stbestHeap = System.nanoTime();
		Hps.sort(best);
		long endbestHeap = System.nanoTime();
		long stworstHeap = System.nanoTime();
		Hps.sort(worst);
		long endworstHeap = System.nanoTime();
		btime_Heap = (double)(endbestHeap-stbestHeap)/1000000;
		wtime_Heap = (double)(endworstHeap-stworstHeap)/1000000;
		//System.out.println(btime_Heap);
		//ϣ������
		ShelSot ssot = new ShelSot();
		long stbestShell = System.nanoTime();
		ssot.shellSort(best);
		long endbestShell = System.nanoTime();
		long stworstShell = System.nanoTime();
		ssot.shellSort(worst);
		long endworstShell = System.nanoTime();
		
		btime_Shell = (double)(endbestShell-stbestShell)/1000000;
		wtime_Shell = (double)(endworstShell - stworstShell)/1000000;
		
		//ð������
		int temp;
		long stbestBubble = System.nanoTime();
		
		for(int i=0;i<best.length;i++){
			for(int j=1;j<best.length-i;j++){
				if(best[j-1]>best[j]){
					temp = best[j];
					best[j] = best[j-1];
					best[j-1] = temp;
				}
			}
		}
		long endbestBubble = System.nanoTime();
		
		long stworstBubble = System.nanoTime();
		for(int i=0;i<worst.length;i++){
			for(int j=1;j<worst.length-i;j++){
				if(worst[j-1]>worst[j]){
					temp = worst[j];
					worst[j] = worst[j-1];
					worst[j-1] = temp;
				}
			}
		}
		long endworstBubble = System.nanoTime();
		
		btime_Bubble = (double)(endbestBubble - stbestBubble)/1000000;
		wtime_Bubble = (double)(endworstBubble - stworstBubble)/1000000;
		
		//��������
		Sort1 st = new Sort1();
		long stbestQuick = System.nanoTime();
		st.quicksork(best);
		long endbestQuick = System.nanoTime();
		
		long stworstQuick = System.nanoTime();
		st.quicksork(worst);
		long endworstQuick = System.nanoTime();
		
		btime_Quick = (double)(endbestQuick - stbestQuick)/1000000;
		wtime_Quick = (double)(endworstQuick - stworstQuick)/1000000;
		
		//��������
		RadxSort RS = new RadxSort();
		long stbestRadix = System.nanoTime();
		RS.RSort(best);
		long endbestRadix = System.nanoTime();
		
		long stworstRadix = System.nanoTime();
		RS.RSort(worst);
		long endworstRadix = System.nanoTime();
		
		btime_Radix = (double)(endbestRadix - stbestRadix)/1000000;
		btime_Radix = (double)(endworstRadix - stworstRadix)/1000000;
				
		
		//��ѡ������
		long stbestSimple = System.nanoTime();
		for(int i=0;i<best.length-1;i++){
			for(int j=i+1;j<best.length;j++){
				if(best[i]>best[j]){
					temp = best[i];
					best[i] = best[j];
					best[j] = temp;
				}
			}
		}
		long endbestSimple = System.nanoTime();
		
		long stworstSimple = System.nanoTime();
		for(int i=0;i<worst.length-1;i++){
			for(int j=i+1;j<worst.length;j++){
				if(worst[i]>worst[j]){
					temp = worst[i];
					worst[i] = worst[j];
					worst[j] = temp;
				}
			}
		}
		long endworstSimple = System.nanoTime();
		
		btime_Simple = (double)(endbestSimple - stbestSimple)/1000000;
		wtime_Simple = (double)(endworstSimple - stworstSimple)/1000000;
	}
	
	
	
}
class chart{
	
	/*
	 * ������ͼ*/
	
	// ����1������CategoryDataset����׼�����ݣ�  
    CategoryDataset dataset = createDataset();  
    CategoryDataset dataset1 = createDataset1();
    // ����2������Dataset ����JFreeChart�����Լ�����Ӧ������  
    JFreeChart freeChart = createChart(dataset); 
    JFreeChart freeChart1 = createChart1(dataset1); 
	
    
    //����CategoryDataset����JFreeChart����
	public static JFreeChart createChart(CategoryDataset categoryDateset){
		
		// ����JFreeChart����ChartFactory.createLineChart  
        JFreeChart jfreechart = ChartFactory.createLineChart("The Confrontation Of Sorts In Best Case", /* ����  */
                "Sort By", /*categoryAxisLabel ��category�ᣬ���ᣬX���ǩ��  */
                "Spent Time", /* valueAxisLabel��value�ᣬ���ᣬY��ı�ǩ��  */
                categoryDateset, /* Dataset */ 
                PlotOrientation.VERTICAL, false, /* legend */ 
                false, /*Tooltips  */
                false); /* URLs  */
        
        // ʹ��CategoryPlot���ø��ֲ�����  
        CategoryPlot plot = (CategoryPlot)jfreechart.getPlot();  
        
        // ����ɫ ͸����  
        plot.setBackgroundAlpha(0.5f);  
        
        // ǰ��ɫ ͸����  
        plot.setForegroundAlpha(1.0f);  
        
        // �������� �ο� CategoryPlot��  
        LineAndShapeRenderer renderer = (LineAndShapeRenderer)plot.getRenderer();  
        renderer.setBaseShapesVisible(true); // series �㣨�����ݵ㣩�ɼ�  
        renderer.setBaseLinesVisible(true); // series �㣨�����ݵ㣩�������߿ɼ�  
        renderer.setUseSeriesOffset(true); // ����ƫ����  
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());  
        renderer.setBaseItemLabelsVisible(true);  
        return jfreechart;  
	}
	
	public static CategoryDataset createDataset() {  
        String[] rowKeys = {"Sort"};  
        String[] colKeys = {"HeapSort","ShellSort","BubbleSort","QuickSort","RadixSort","SimpleSort"};  
        
        double[][] data = {{TimeChat.btime_Heap,TimeChat.btime_Shell,TimeChat.btime_Bubble,TimeChat.btime_Quick,TimeChat.btime_Radix,TimeChat.btime_Simple},};   
        //System.out.println(TimeChat.btime_Heap);
        return DatasetUtilities.createCategoryDataset(rowKeys, colKeys, data);  
    }
	
	//������
     public static JFreeChart createChart1(CategoryDataset categoryDateset){
		
		// ����JFreeChart����ChartFactory.createLineChart  
        JFreeChart jfreechart = ChartFactory.createLineChart("The Confrontation Of Sorts In Worst Case", /* ����  */
                "Sort By", /*categoryAxisLabel ��category�ᣬ���ᣬX���ǩ��  */
                "Spent Time", /* valueAxisLabel��value�ᣬ���ᣬY��ı�ǩ��  */
                categoryDateset, /* Dataset */ 
                PlotOrientation.VERTICAL, false, /* legend */ 
                false, /*Tooltips  */
                false); /* URLs  */
        
  
        CategoryPlot plot = (CategoryPlot)jfreechart.getPlot();  
        plot.setBackgroundAlpha(0.5f);    
        plot.setForegroundAlpha(1.0f); 
        LineAndShapeRenderer renderer = (LineAndShapeRenderer)plot.getRenderer();  
        renderer.setBaseShapesVisible(true); // series �㣨�����ݵ㣩�ɼ�  
        renderer.setBaseLinesVisible(true); // series �㣨�����ݵ㣩�������߿ɼ�  
        renderer.setUseSeriesOffset(true); // ����ƫ����  
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());  
        renderer.setBaseItemLabelsVisible(true);  
        return jfreechart;  
	}
	
	public static CategoryDataset createDataset1() {  
        String[] rowKeys = {"Sort"};  
        String[] colKeys = {"HeapSort","ShellSort","BubbleSort","QuickSort","RadixSort","SimpleSort"};  
        
        double[][] data = {{TimeChat.wtime_Heap,TimeChat.wtime_Shell,TimeChat.wtime_Bubble,TimeChat.wtime_Quick,TimeChat.wtime_Radix,TimeChat.wtime_Simple},};   
        //System.out.println(TimeChat.btime_Heap);
        return DatasetUtilities.createCategoryDataset(rowKeys, colKeys, data);  
    }
	
}
public class TimeChart{
	public static void main(String[] strings){
		TimeChat tc = new TimeChat();
		chart ct = new chart();
		ChartPanel chartf = new ChartPanel(ct.freeChart,true);
		ChartPanel chartf1 = new ChartPanel(ct.freeChart1,true);
		JFrame jf = new JFrame();
		jf.add(chartf,BorderLayout.WEST);
		jf.add(chartf1,BorderLayout.EAST);
		jf.setVisible(true);
		jf.setSize(1400, 600);
		jf.setLocationRelativeTo(null);
	}
}