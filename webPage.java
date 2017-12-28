package edu.nccu.misds.stu105306064.hw6;

import java.io.IOException;
import java.util.ArrayList;

public class webPage 

{
	public double ownScore=0;
	public String name;
	private wordCounter count_1;
	
	public webPage(String url, String name)
	{
		this.name = name;
		count_1 = new wordCounter(url);
	}
	
	//每個頁面先計算自己的分數
	public void setOwnScore(ArrayList<keyword> inputs) throws IOException
	{
		for(keyword input:inputs)
		{	
			double score = 0;
			score = count_1.calculateNum(input.key)*input.weight;
			ownScore = ownScore + score;
		}
	}
}