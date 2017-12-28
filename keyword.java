package edu.nccu.misds.stu105306064.hw6;

public class keyword  //接收input關鍵字和權重

{
	public String key;
    public double weight;
	
    public keyword(String key, double weight)
    {
    	this.key = key;
    	this.weight = weight;
    }
    
	public String toString()
	{
		return "["+key+","+weight+"]";
	}

}
