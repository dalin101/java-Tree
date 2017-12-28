package edu.nccu.misds.stu105306064.hw6;

import java.io.IOException;
import java.util.ArrayList;

public class webTree 

{
	
	public webNode root;
	
	//建立一個為root的webNode物件(第一個page)
	public webTree(webPage rootPage)
	{
		this.root = new webNode(rootPage);
	}
	
	public void postOrderScore(ArrayList<keyword> inputs) throws IOException
	{
		postOrderScore(root, inputs);
	}

	private void postOrderScore(webNode startNode, ArrayList<keyword> inputs) throws IOException
	{
		for(webNode child:startNode.child)
		{
			postOrderScore(child, inputs);
		}
		startNode.totalScore(inputs);
	}
	
	public void eularPrint() throws IOException
	{
		eularPrintTree(root);
	}
	
	private void eularPrintTree(webNode startNode)
	{
		
		int depth = startNode.getDepth(startNode);
		if(depth>1)
		{
			System.out.print("\n"+repeat("\t", depth-1));
		}
		
		System.out.print("(");
		System.out.print(startNode.webPage.name+","+startNode.totalScore);
		
		for(webNode childNode:startNode.child)
		{
			eularPrintTree(childNode);
		}
		
		if(depth>1 && startNode.hasChild()==true)
		{
			System.out.print("\n"+repeat("\t", depth-1));
		}
		System.out.println(")");
		
	}
	
    private String repeat(String tab, int depth)
    {
    	String repeat = "";
    	for(int i= 0; i<depth; i++)
    	{
    		repeat = repeat+tab;
    	}
    	return repeat;
    }
	
	
	
}
