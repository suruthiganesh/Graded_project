package problem1.dsa.gl;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BuildingConstruction {
	public Integer totalFloors;
	public Integer[] totalFloorSize;
	public Integer[] tempvalue;
	public Integer[] daysinfo;
	public Integer Possibledays = 0;
	public Integer Possiblearray = 0;
	public Integer SearchMax = 0;
	Integer maxday = 0;
	boolean poploop;
	Stack<Integer> myStack = new Stack<Integer>();

	// Get the Inputs using below method.
	public void getInputs() {
		System.out.println("Enter the total no. of floors in the building: ");
		Scanner sc = new Scanner(System.in);
		totalFloors = sc.nextInt();
		totalFloorSize = new Integer[totalFloors];
	
		for (int i = 1; i <= totalFloors; i++) {
			daysinfo = new Integer[i];
			System.out.println("Enter the floor size given on day: " + i);
			totalFloorSize[i - 1] = sc.nextInt();
			daysinfo[i - 1] = i;
		}
		sc.close();
		
		
	}
	
	public void SortpushStack()
	{
		Integer[] FloorSizeSorted = totalFloorSize.clone();
		Arrays.sort(FloorSizeSorted);
		for (int i = 0; i < totalFloorSize.length; i++)
		{
			myStack.push(FloorSizeSorted[i]);
		}
	}
	
	int DetremineBigfloorDay() 
	{
		Integer[] tempvalue = totalFloorSize.clone();
		
		for ( int i = 1; i < tempvalue. length; i++ )
		{
			if ( tempvalue[i] > tempvalue[maxday] )
			{
				maxday = i;
			}
		}
		PopStackbigfloorday(maxday);
		return maxday;
				
		// position of the first largest found.
	}
	
	public void PopStackbigfloorday(int maxday) 
	{
		Integer Possibledays = maxday + 1; 		
		
	}

	// Calculate and print order of construction and totalFloorSize
	public void checkSearchStack()
	{
		Integer[] tempvalue = totalFloorSize.clone();
		Integer Possibledays = maxday + 1;
		for(Integer k=1; k <= Possibledays-1; k++)
		{
			System.out.println("Day " + k + ": ");
		}
		System.out.println("Day " + Possibledays + ": " + tempvalue[maxday]);
		myStack.pop();
		Possiblearray = maxday;
		tempvalue[Possiblearray] = 0;
		for (int s=Possiblearray ;s<totalFloorSize.length;s++)
		{
			poploop=true;
			while(poploop)		
			{
				SearchMax(tempvalue);
				if((SearchMax > s) && (tempvalue[s] < tempvalue[SearchMax]))
				{
					poploop = false;
					System.out.println("Day " + (s + 1) + ": ");
				}
				else if((SearchMax < s) && (tempvalue[s] < tempvalue[SearchMax]))
				{
					System.out.println("Day " + (s + 1) + ": " + tempvalue[SearchMax]);
					myStack.pop();
					tempvalue[SearchMax] = 0;
					poploop = true;
				}
				else if((SearchMax == s) && tempvalue[SearchMax]!=0)
				{
					System.out.println("Day " + (s + 1) + ": " + tempvalue[SearchMax]);
					myStack.pop();
					tempvalue[SearchMax] = 0;
					poploop = true;
				}
				else 
				{
					poploop = false;
				
				}
				
			}
			
			
		 }	
		
	}
	

	int SearchMax(Integer [] tempvalue) 
	{	
		SearchMax = 0;
		for ( int i = 1; i < tempvalue. length; i++ )
		{
		if ( tempvalue[i] > tempvalue[SearchMax] ) SearchMax = i;
		}
		return SearchMax;
	}
}




