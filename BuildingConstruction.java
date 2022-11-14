package Stackexamples.com.gl;
import java.util.*;

public class BuildingConstruction {
	public Integer totalFloors;
	public Integer[] totalFloorSize;
	public Integer[] tempvalue;
	public Integer[] daysinfo;
	public Integer days = 0;
	boolean checkbig = true;
	boolean Upsearch;
	boolean Downsearch;
	Integer CheckSearch;
	Integer CheckSearch1 = 0;
	Integer FixSearch = 0;
	Integer maxday = 0;
	Stack<Integer> myStack = new Stack<Integer>();

	// Get the Inputs using below method.
	public void getInputs() {
		//days = 1;
		System.out.println("Enter the total no. of floors in the building: ");
		Scanner sc = new Scanner(System.in);
		totalFloors = sc.nextInt();
		totalFloorSize = new Integer[totalFloors];
		//daysinfo = new Integer[days];
		for (int i = 1; i <= totalFloors; i++) {
			daysinfo = new Integer[i];
			System.out.println("Enter the floor size given on day: " + i);
			totalFloorSize[i - 1] = sc.nextInt();
			daysinfo[i - 1] = i;
		}
		sc.close();
		
		//System.out.println("System taken Inputs");
	}
	
	public void SortpushStack()
	{
		Integer[] FloorSizeSorted = totalFloorSize.clone();
		Arrays.sort(FloorSizeSorted, Collections.reverseOrder());
		for (int i = 0; i < totalFloorSize.length; i++)
		{
			myStack.push(totalFloorSize[i]);
//			System.out.println("Stack push completed inside the check ");
		}
	//	System.out.println("Stack push completed");
		
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
		maxday = maxday + 1;
	//	System.out.println("The Max floor day is " + tempvalue[maxday-1] + "  Day is  : " + maxday);
		PopStackbigfloorday(maxday);
		return maxday;
				
		// position of the first largest found.
	}
	
	public void PopStackbigfloorday(int maxday) 
	{
				
		Integer Val = 0;
		Val = Val + 1;
		Integer maxdayArray = maxday - 1;
	//	System.out.println("inside opstack maxday value " + maxday);
		myStack.pop();
	//	System.out.println("Stack pop completed " + myStack.peek());
	}

	// Calculate and print order of construction and totalFloorSize
	public void checkSearchStack()
	{
		Integer[] tempvalue = totalFloorSize.clone();
		CheckSearch = maxday - 1;
		tempvalue[CheckSearch] = 0;
	//	System.out.println("inside The checkSearchStack");

		while(CheckSearch < totalFloorSize.length)
		{	
			SearchMax(tempvalue);
	//		System.out.println("The alomst Final values in up area- " + tempvalue[FixSearch]);
			FixSearch = CheckSearch1 + 1;
	//		System.out.println("Fixsearch value 1 " + FixSearch);
			if(FixSearch < maxday) 
			{
				Upsearch = true;
				Downsearch = false;
			}
			else
			{
				Downsearch = true;
				Upsearch = false;
			}
						
			while(Upsearch)
			{
				int k=0;
				SearchMax(tempvalue);
				FixSearch = CheckSearch1 + 1;
		//		System.out.println("Fixsearch value upsearch " +FixSearch);
				tempvalue[CheckSearch1] = 0;
			//	System.out.println("The alomst Final values - " + tempvalue[FixSearch]);
				if(FixSearch > maxday) 
				{
					Upsearch = false;
					Downsearch = true;
				}
				k++;
				if(k < totalFloorSize.length)
				{
					Upsearch = false;
					Downsearch = false;

				}

			}
			while(Downsearch)
			{
				int i=0;
				SearchMax(tempvalue);
				FixSearch = CheckSearch1 + 1;
				//System.out.println("Fixsearch value downsearch " +FixSearch);
				if(tempvalue[CheckSearch] < tempvalue[CheckSearch1])
				{
				
					System.out.println("Null");
				}
				else
				{
		//			System.out.println("The alomst Final values down - " + tempvalue[FixSearch]);
					tempvalue[CheckSearch1] = 0;
				}
			
				if(FixSearch > maxday) 
				{
					Upsearch = false;
					Downsearch = true;
				}
				i++;
				if(i < totalFloorSize.length)
				{
					Upsearch = false;
					Downsearch = false;

				}
					
			}
		
		}
		CheckSearch++;
	}
	

	int SearchMax(Integer [] tempvalue) 
	{	
		CheckSearch1 = 0;
		for ( int i = 1; i < tempvalue. length; i++ )
		{
		if ( tempvalue[i] > tempvalue[CheckSearch1] ) CheckSearch1 = i;
		}
		
	//	System.out.println("Latest value in SearchMax" + tempvalue[CheckSearch1]);
		return CheckSearch1;
		// position of the first largest found.
	}
}

