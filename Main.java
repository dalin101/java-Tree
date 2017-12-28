package edu.nccu.misds.stu105306064.hw6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException 
	
	{         
		//產生一個rootpage
		webTree tree = new webTree(new webPage("http://www3.nccu.edu.tw/~yuf","Fang Yu"));
		
		tree.root.addChild(new webNode(new webPage("http://soslab.nccu.edu.tw/Publications.html","Publication")));
        
		tree.root.addChild(new webNode(new webPage("http://www3.nccu.edu.tw/~yuf/research_projects_and_tools.htm","Project")));
		tree.root.child.get(1).addChild(new webNode(new webPage("http://www.cs.ucsb.edu/~vlab/stranger/","Stranger")));
		tree.root.child.get(1).addChild(new webNode(new webPage("http://nccusoslab.com:280/data-structure/little-boat.html","Little Boat")));

		tree.root.addChild(new webNode(new webPage("http://www3.nccu.edu.tw/~yuf/short_biography.htm","Biography")));
		tree.root.child.get(2).addChild(new webNode(new webPage("http://www.cs.ucsb.edu/~vlab","Vlab")));

		tree.root.addChild(new webNode(new webPage("http://www3.nccu.edu.tw/~yuf/course.htm","Course")));
        
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
    	ArrayList<keyword> inputs = new ArrayList<keyword>();
        for(int i=0;i<number;i++)
        {
        	String key = in.next();
          	double weight = in.nextDouble();
          	keyword k = new keyword(key, weight);
          	inputs.add(k);
        }
      	
        tree.postOrderScore(inputs);
        tree.eularPrint();		
   
	}

}
