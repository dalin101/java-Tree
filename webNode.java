package edu.nccu.misds.stu105306064.hw6;

import java.io.IOException;
import java.util.ArrayList;

public class webNode 
{
	public webPage webPage;
	public webNode parent;
	public webNode children;
	public ArrayList<webNode> child;
	public double totalScore;
	
	public webNode(webPage webPage)
	{
		this.webPage = webPage;
		//有rootpage後創建小孩的arraylist
		child = new ArrayList<webNode>();
	}
	
	//加小孩---在arrayList裡面add，再指回parent
	public void addChild(webNode child)
	{
		this.child.add(child);
		this.children = child;
		child.parent = this;
	}
	
	//一個webNode和他的childrenNode的分數
	public void totalScore(ArrayList<keyword> inputs) throws IOException
	{
		webPage.setOwnScore(inputs);
		totalScore = webPage.ownScore;
		for(webNode childNode : this.child)
		{
			totalScore = totalScore + childNode.totalScore;
		}
	}
	
	public boolean isTheRoot()
	{
		if(this.parent==null) return true;
		return false;
	}
	
	public boolean hasChild()
	{
		if(this.children!=null) return true;
		return false;		
	}
	
	public int getDepth(webNode currentNode)
	{
		int depth = 1;
		while(currentNode.isTheRoot()==false)
		{
			depth++;
			currentNode = currentNode.parent;
		}
		return depth;
		
	}
	
}

