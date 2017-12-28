package edu.nccu.misds.stu105306064.hw6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class wordCounter  
{
	private String urlStr;          
    private String content;
    
	public wordCounter(String url) 
	{
		this.urlStr = url;
	}
	
    String text = "";

	//URL urlstr = new URL(url) 此行就是將url變數初始化並指定網址
	//openConnection 它表示到 URL 所參考的遠端物件的連接
	//getInputStream 讀出來的內容為ASCII編碼
	//InputStreamReader這個類別的用途就是將ASCII轉換成一般字元

	private String getText() throws IOException
	{
		URL urlstr = new URL(this.urlStr);  
		URLConnection open_u = urlstr.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(open_u.getInputStream()));
		
	    String line = null;
	    
		while((line = br.readLine())!=null)
		{
			text = text+line+" \n";
		}
		return text;
	}
	
	public int calculateNum(String k) throws IOException 
	{
		if(content == null)
		{
			content = getText();
		}
		
        content = content.toUpperCase();
        k = k.toUpperCase();
      
        int number = 0;
        int index = 0;
        int found = -1;
        while((found=content.indexOf(k, index))!=-1)
        {
        	number++;
        	index = found+k.length();
        }
        return number;
	}
	
}

	
	


