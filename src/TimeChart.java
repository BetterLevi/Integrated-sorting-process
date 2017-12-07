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
	//"堆排序","希尔排序","冒泡排序","快速排序","基数排序","简单选择排序"所用时间
    static double btime_Heap,btime_Shell,btime_Bubble,btime_Quick,btime_Radix,btime_Simple; //各种排序的最好情况下的时间
	static double wtime_Heap,wtime_Shell,wtime_Bubble,wtime_Quick,wtime_Radix,wtime_Simple; //最坏情况下的排序
	@SuppressWarnings("static-access")
	TimeChat(){
		for(int i=0;i<1000;i++){
			best[i] = i;
		}
		for(int i=999;i>=0;i--){
			worst[i] = i;
		}
		//System.out.println(1);
		//堆排序
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
		//希尔排序
		ShelSot ssot = new ShelSot();
		long stbestShell = System.nanoTime();
		ssot.shellSort(best);
		long endbestShell = System.nanoTime();
		long stworstShell = System.nanoTime();
		ssot.shellSort(worst);
		long endworstShell = System.nanoTime();
		
		btime_Shell = (double)(endbestShell-stbestShell)/1000000;
		wtime_Shell = (double)(endworstShell - stworstShell)/1000000;
		
		//冒泡排序
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
		
		//快速排序
		Sort1 st = new Sort1();
		long stbestQuick = System.nanoTime();
		st.quicksork(best);
		long endbestQuick = System.nanoTime();
		
		long stworstQuick = System.nanoTime();
		st.quicksork(worst);
		long endworstQuick = System.nanoTime();
		
		btime_Quick = (double)(endbestQuick - stbestQuick)/1000000;
		wtime_Quick = (double)(endworstQuick - stworstQuick)/1000000;
		
		//基数排序
		RadxSort RS = new RadxSort();
		long stbestRadix = System.nanoTime();
		RS.RSort(best);
		long endbestRadix = System.nanoTime();
		
		long stworstRadix = System.nanoTime();
		RS.RSort(worst);
		long endworstRadix = System.nanoTime();
		
		btime_Radix = (double)(endbestRadix - stbestRadix)/1000000;
		btime_Radix = (double)(endworstRadix - stworstRadix)/1000000;
				
		
		//简单选择排序
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
	 * 画折线图*/
	
	// 步骤1：创建CategoryDataset对象（准备数据）  
    CategoryDataset dataset = createDataset();  
    CategoryDataset dataset1 = createDataset1();
    // 步骤2：根据Dataset 生成JFreeChart对象，以及做相应的设置  
    JFreeChart freeChart = createChart(dataset); 
    JFreeChart freeChart1 = createChart1(dataset1); 
	
    
    //根据CategoryDataset创建JFreeChart对象
	public static JFreeChart createChart(CategoryDataset categoryDateset){
		
		// 创建JFreeChart对象：ChartFactory.createLineChart  
        JFreeChart jfreechart = ChartFactory.createLineChart("The Confrontation Of Sorts In Best Case", /* 标题  */
                "Sort By", /*categoryAxisLabel （category轴，横轴，X轴标签）  */
                "Spent Time", /* valueAxisLabel（value轴，纵轴，Y轴的标签）  */
                categoryDateset, /* Dataset */ 
                PlotOrientation.VERTICAL, false, /* legend */ 
                false, /*Tooltips  */
                false); /* URLs  */
        
        // 使用CategoryPlot设置各种参数。  
        CategoryPlot plot = (CategoryPlot)jfreechart.getPlot();  
        
        // 背景色 透明度  
        plot.setBackgroundAlpha(0.5f);  
        
        // 前景色 透明度  
        plot.setForegroundAlpha(1.0f);  
        
        // 其他设置 参考 CategoryPlot类  
        LineAndShapeRenderer renderer = (LineAndShapeRenderer)plot.getRenderer();  
        renderer.setBaseShapesVisible(true); // series 点（即数据点）可见  
        renderer.setBaseLinesVisible(true); // series 点（即数据点）间有连线可见  
        renderer.setUseSeriesOffset(true); // 设置偏移量  
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
	
	//最坏情况下
     public static JFreeChart createChart1(CategoryDataset categoryDateset){
		
		// 创建JFreeChart对象：ChartFactory.createLineChart  
        JFreeChart jfreechart = ChartFactory.createLineChart("The Confrontation Of Sorts In Worst Case", /* 标题  */
                "Sort By", /*categoryAxisLabel （category轴，横轴，X轴标签）  */
                "Spent Time", /* valueAxisLabel（value轴，纵轴，Y轴的标签）  */
                categoryDateset, /* Dataset */ 
                PlotOrientation.VERTICAL, false, /* legend */ 
                false, /*Tooltips  */
                false); /* URLs  */
        
  
        CategoryPlot plot = (CategoryPlot)jfreechart.getPlot();  
        plot.setBackgroundAlpha(0.5f);    
        plot.setForegroundAlpha(1.0f); 
        LineAndShapeRenderer renderer = (LineAndShapeRenderer)plot.getRenderer();  
        renderer.setBaseShapesVisible(true); // series 点（即数据点）可见  
        renderer.setBaseLinesVisible(true); // series 点（即数据点）间有连线可见  
        renderer.setUseSeriesOffset(true); // 设置偏移量  
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