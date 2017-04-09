import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.BoldAction;



class MemoryOccupant{
	Integer sizeInMemory; //Size of process or Hole
	String residesInMemory;// Process or Hole
	
	//constructor
	public MemoryOccupant(String inMemory,Integer size) {
	
		sizeInMemory= size; 
		residesInMemory=inMemory;
	}
	
}

public class LinkedListManagement {
	
	static Scanner inp = new Scanner(System.in);
	//for taking input from any method

	public static void main(String[] args) {
		
		//Total process
		startMemoryManagementProcess();
	

		

	}
	
	
	public static void startMemoryManagementProcess()
	{
		ArrayList<MemoryOccupant> allocatedMemorylist =new ArrayList<MemoryOccupant>();
		//list for storing in what is inside memory sequentially
		
		allocatedMemorylist=memoryAllocationChoice();
		//By this we get default what was or as user wished what will be initially in memory
		
		linkedListChoice(allocatedMemorylist);
		//Here we select which one of the Linked list management methods 
	}
	
	
	
	//this process gives user to select initial memory default or as users wish
	public static ArrayList<MemoryOccupant> memoryAllocationChoice()
	{
		
		int choice=0;
	
				while(choice<1 || choice >2 )//unless choice is valid loop continues
				{
					System.out.println("Want to use Default Memory Allocation?\n"
						+ "1.Yes\n"+"2.No");
					choice= inp.nextInt();
				    if(choice ==1 ||  choice==2) break;
					else System.out.println("Enter Correct Choice");
					
				}
		
		if(choice==1) return defaultAllocation();//returns list of default
		else return userAllocation();//returns users list
	}
	
	
	public static void linkedListChoice(ArrayList<MemoryOccupant> allocatedMemorylist)
	{
		
		int choice=-1;
		
			System.out.println("Which Method u want to use?"
					+ "\n1.First Fit"
					+ "\n2.Next Fit"
					+ "\n3.Best Fit"
					+ "\n4.Worst Fit"
					+ "\n5.Quick Fit"
					+"\n6.Exit");
		while(choice<1 || choice>6)//forces user to enter correct choice
		{
			choice=inp.nextInt();
				switch (choice) {
					case 1: choiceImplementation(choice,allocatedMemorylist);
					break;

					case 2: choiceImplementation(choice,allocatedMemorylist);
				
					break;
			

					case 3: choiceImplementation(choice,allocatedMemorylist);
					break;
			

					case 4: choiceImplementation(choice,allocatedMemorylist);
					break;
			

					case 5: 
						choiceImplementation(choice,allocatedMemorylist);
					break;
					
					case 6:
						break;
			
					default:System.out.println("Enter Correct Choice");
					break;
				}
			
			
		}
	
		
	}
	
	
	public static void choiceImplementation(int choice, ArrayList<MemoryOccupant> allocatedMemorylist)
	{
		int processSize,start=0;
		MemoryOccupant memoryOccupant;
		
		// since after testing 1 choice if user wants to test another then initial allocation is saved
		final ArrayList<MemoryOccupant> resetToPrevious =new ArrayList<MemoryOccupant>(allocatedMemorylist);
		
		//followings are for Quickfit 
		ArrayList<Integer> holeList20Kb = new ArrayList<Integer>();
		ArrayList<Integer> holeList16Kb = new ArrayList<Integer>();
		ArrayList<Integer> holeList12Kb= new ArrayList<Integer>();
		ArrayList<Integer> holeList8Kb = new ArrayList<Integer>();
		ArrayList<Integer> holeList4Kb = new ArrayList<Integer>();
		if(choice==5)holeManagement(allocatedMemorylist,holeList20Kb,holeList16Kb,holeList12Kb,holeList8Kb,holeList4Kb);
		
		//shows what is in initial allocation
		Iterator<MemoryOccupant> iterate =allocatedMemorylist.iterator();
		while (iterate.hasNext()) {
			 memoryOccupant = (MemoryOccupant) iterate.next();
			System.out.print(memoryOccupant.residesInMemory+" "+memoryOccupant.sizeInMemory +" ");
			
		}
		System.out.println();
	
		do
		{
			System.out.println("\nEnter a Process size and a negetive number to terminate");
			processSize=inp.nextInt();
			
			if(choice==1 && processSize>0) //process allocation with 1st fit
				{	
					firstFit(allocatedMemorylist, processSize);
					iterate =allocatedMemorylist.iterator();
					while (iterate.hasNext()) 
					{
						memoryOccupant = iterate.next();
						System.out.print(memoryOccupant.residesInMemory+" "+memoryOccupant.sizeInMemory +" ");
						
					}
				}
			if(choice==2 && processSize>0) //process allocation with nextfit
			{	
				start=nextFit(allocatedMemorylist, processSize,start);
				iterate =allocatedMemorylist.iterator();
				while (iterate.hasNext()) 
				{
					memoryOccupant = iterate.next();
					System.out.print(memoryOccupant.residesInMemory+" "+memoryOccupant.sizeInMemory +" ");
					
				}
			}
			if(choice==3 && processSize>0) //process allocation with bestfit
			{	
				bestFit(allocatedMemorylist, processSize);
				iterate =allocatedMemorylist.iterator();
				while (iterate.hasNext()) 
				{
				    memoryOccupant =iterate.next();
					System.out.print(memoryOccupant.residesInMemory+" "+memoryOccupant.sizeInMemory +" ");
					
				}
			}
			if(choice==4 && processSize>0) //process allocation with worstfit
			{	
				worstFit(allocatedMemorylist, processSize);
				iterate =allocatedMemorylist.iterator();
				while (iterate.hasNext()) 
				{
				    memoryOccupant =iterate.next();
					System.out.print(memoryOccupant.residesInMemory+" "+memoryOccupant.sizeInMemory +" ");
					
				}
			}
			
			if(choice==5 && processSize>0) //process allocation with quickfit
			{	
				
				
				quickFit(allocatedMemorylist,processSize,holeList20Kb,holeList16Kb,holeList12Kb,holeList8Kb,holeList4Kb);
				iterate =allocatedMemorylist.iterator();
				while (iterate.hasNext()) 
				{
				    memoryOccupant =iterate.next();
					System.out.print(memoryOccupant.residesInMemory+" "+memoryOccupant.sizeInMemory +" ");
					
				}
			}
		
			
			
			
		}while(processSize>0);
		
		linkedListChoice(resetToPrevious);
		
		
	}
	

//default memory allocation

	public static ArrayList<MemoryOccupant> defaultAllocation()
	{
		ArrayList<MemoryOccupant> defaultAllocatedMemory=new ArrayList<MemoryOccupant>();
		
		defaultAllocatedMemory.add(new MemoryOccupant("Process",100));
		defaultAllocatedMemory.add(new MemoryOccupant("Hole",164));
		defaultAllocatedMemory.add(new MemoryOccupant("Process",50));
		defaultAllocatedMemory.add(new MemoryOccupant("Hole",108));
		defaultAllocatedMemory.add(new MemoryOccupant("Process",150));
		defaultAllocatedMemory.add(new MemoryOccupant("Hole",172));
		defaultAllocatedMemory.add(new MemoryOccupant("Process",110));
		defaultAllocatedMemory.add(new MemoryOccupant("Hole",300));
		defaultAllocatedMemory.add(new MemoryOccupant("Process",250));
		defaultAllocatedMemory.add(new MemoryOccupant("Hole",96));
		
		
		return defaultAllocatedMemory;
	}
	
	
	//user allocation
	
	public static ArrayList<MemoryOccupant> userAllocation()
	{
		ArrayList<MemoryOccupant> userAllocatedMemory=new ArrayList<MemoryOccupant>();
		String choice;
		
		System.out.println("\nEnter for process \"Process Size\" for Hole \"Hole Size\" \n"
				+ "Enter \"quit\" to end input");
		
		while (inp.hasNext()) {
		 choice=inp.next();
		 if(choice.compareTo("quit")==0) break;//finished entering
		 if(choice.compareTo("Process")==0) userAllocatedMemory.add(new MemoryOccupant("Process",Integer.parseInt(inp.next())));
		 if(choice.compareTo("Hole")==0) userAllocatedMemory.add(new MemoryOccupant("Hole",Integer.parseInt(inp.next())));		
		}
		return userAllocatedMemory;
	}
	
	
	
	//First fit Implementation

	
	public static void firstFit(ArrayList<MemoryOccupant> allocated,Integer processSize)
	{
	
		int length= allocated.size(),holeSize;
		Boolean newProcessNotAdded=true;// to notify if process not added
		for(int i=0;i<length;i++)
		{
			if(allocated.get(i).residesInMemory.compareTo("Hole")==0 && allocated.get(i).sizeInMemory>=processSize && newProcessNotAdded)
			{
				//if in memory we get hole we save it's size
				holeSize=allocated.get(i).sizeInMemory;
				allocated.remove(i);
				//if after process allocation hole remains because of small process
				if(holeSize>processSize)allocated.add(i,new MemoryOccupant("Hole", holeSize-processSize));
				//allocation of hole
				allocated.add(i,new MemoryOccupant("Process", processSize));
				newProcessNotAdded=false;
				break;
			}
			
		}
		if(newProcessNotAdded)System.out.println("\nError Process Can't be added\n");
		
	}
	
	
	
	
	//nextFit Implementation
	
	
	
	public static int nextFit(ArrayList<MemoryOccupant> allocated,Integer processSize,Integer start)
	{
		Boolean newProcessNotAdded=true;
		int length=allocated.size(),holeSize,i,j = 0;
		//the value of j points next to hole
		
		//from previous position to last
		for(i= start;i<length;i++)
		{
			if(allocated.get(i).residesInMemory.compareTo("Hole")==0 && allocated.get(i).sizeInMemory>=processSize && newProcessNotAdded)
			{
				j=i;
				holeSize=allocated.get(i).sizeInMemory;
				allocated.remove(i);
				if(holeSize>processSize){allocated.add(i,new MemoryOccupant("Hole", holeSize-processSize));j++;}
				allocated.add(i,new MemoryOccupant("Process", processSize));
				j++;//the value of j points next to hole
				newProcessNotAdded=false;
				break;
			}
			
		}
		
		//if not found search from top to that place if there is that suitable place
		
		if(newProcessNotAdded)
		{
			for(i= 0;i<start;i++)
			{
				if(allocated.get(i).residesInMemory.compareTo("Hole")==0 && allocated.get(i).sizeInMemory>=processSize && newProcessNotAdded)
				{
					j=i;
					holeSize=allocated.get(i).sizeInMemory;
					allocated.remove(i);
					if(holeSize>processSize){allocated.add(i,new MemoryOccupant("Hole", holeSize-processSize));j++;}
					allocated.add(i,new MemoryOccupant("Process", processSize));
					j++;//the value of j points next to hole
					newProcessNotAdded=false;
					break;
				}
				
			}
			
		}
		
		if(newProcessNotAdded)
			{
			System.out.println("\nError Process Can't be added\n");
			return start;
			}
		
		
		if(j>=length) return 0;  //if pointer is at the last of list
		
		return j;// return position after last modified
	}
	
	
	//Best fit implementation
	
	
	public static void bestFit(ArrayList<MemoryOccupant> allocated,Integer processSize)
	{
		int length=allocated.size(),holeSize,bestLocation=-1;
		
		for(int i=0;i<length;i++)
		{
			if(allocated.get(i).residesInMemory.compareTo("Hole")==0 && allocated.get(i).sizeInMemory>=processSize)
			{
				if(bestLocation==-1) {bestLocation=i;continue;}//first location considered best
				if(allocated.get(i).sizeInMemory==allocated.get(bestLocation).sizeInMemory) continue;
				//if same size location avoid
				
				if(allocated.get(i).sizeInMemory<allocated.get(bestLocation).sizeInMemory)bestLocation=i;
				//if best location size greater than current
			}
			
		}
		
		if(bestLocation!=-1)//see if process was allocated
		{
		holeSize=allocated.get(bestLocation).sizeInMemory;
		allocated.remove(bestLocation);
		if(holeSize>processSize)allocated.add(bestLocation,new MemoryOccupant("Hole", holeSize-processSize));
		allocated.add(bestLocation,new MemoryOccupant("Process", processSize));
		}
		else 
		{
			System.out.println("\nError Process Can't be added\n");
		}
		
		
	}
	
	public static void worstFit(ArrayList<MemoryOccupant> allocated,Integer processSize)
	{
		int length=allocated.size(),holeSize,maxHoleLocation=-1;
		
		
		for(int i=0;i<length;i++)//loop to get max hole in the memory
		{
			if(allocated.get(i).residesInMemory.compareTo("Hole")==0 && allocated.get(i).sizeInMemory>=processSize)
			{
				if(maxHoleLocation==-1) {maxHoleLocation=i;continue;}//first location considered max
				if(allocated.get(i).sizeInMemory==allocated.get(maxHoleLocation).sizeInMemory) continue;
				//if same size location avoid
				
				if(allocated.get(i).sizeInMemory>allocated.get(maxHoleLocation).sizeInMemory)maxHoleLocation=i;
				//if maxHolelocation size smaller than current
			}
			
		}
		
		
		if(maxHoleLocation!=-1)//see if maxhole was found
		{
			holeSize=allocated.get(maxHoleLocation).sizeInMemory;
			allocated.remove(maxHoleLocation);
			if(holeSize>processSize)allocated.add(maxHoleLocation,new MemoryOccupant("Hole", holeSize-processSize));
			allocated.add(maxHoleLocation,new MemoryOccupant("Process", processSize));
		}
		else 
		{
			System.out.println("\nError Process Can't be added\n");
		}
		
		
	}
	
	


	private static void quickFit(ArrayList<MemoryOccupant> allocatedMemorylist,
			int processSize, ArrayList<Integer> holeList20Kb,
			ArrayList<Integer> holeList16Kb, ArrayList<Integer> holeList12Kb,
			ArrayList<Integer> holeList8Kb, ArrayList<Integer> holeList4Kb) {
		// TODO Auto-generated method stub
		
		


		int holelocation,temp;
		temp=processSize;

		//if there was not enough space so process could not be allocated
		if(processSize>(holeList20Kb.size()*20+holeList16Kb.size()*16 +holeList12Kb.size()*12+holeList8Kb.size()*8+holeList4Kb.size()*4)){ 
			System.out.println("\nError Process Can't be added\n");
		
			return;
		}
		
				
		
		//how many 20 kb hole can be allocated
		if(temp/20>=1 && !holeList20Kb.isEmpty())
		{
			int k=0;
			for(int i=0;i<temp/20 && !holeList20Kb.isEmpty();i++)
			{
				holelocation= holeList20Kb.get(0);
				holeList20Kb.remove(0);
				allocatedMemorylist.get(holelocation).residesInMemory="Process";
				k++;//counts number of allocation
			}
			temp=temp-k*20;
			
		}
		
		//how many 16 kb hole can be allocated
		if(temp/16>=1 && !holeList16Kb.isEmpty())
		{
			int k=0;
			for(int i=0;i<temp/16 && !holeList16Kb.isEmpty();i++)
			{
				holelocation= holeList16Kb.get(0);
				holeList16Kb.remove(0);
				allocatedMemorylist.get(holelocation).residesInMemory="Process";
				k++;
			}
			temp=temp-k*16;
			
		}
		
		//how many 12 kb hole can be allocated
		if(temp/12>=1 && !holeList12Kb.isEmpty())
		{
			int k=0;
			for(int i=0;i<temp/12 && !holeList12Kb.isEmpty();i++)
			{
				holelocation= holeList12Kb.get(0);
				holeList12Kb.remove(0);
				allocatedMemorylist.get(holelocation).residesInMemory="Process";
				k++;
			}
			temp=temp-k*12;
			
		}
		
		//how many 8 kb hole can be allocated
		if(temp/8>=1 && !holeList8Kb.isEmpty())
		{
			int k=0;
			for(int i=0;i<temp/8 && !holeList8Kb.isEmpty();i++)
			{
				holelocation= holeList8Kb.get(0);	
				holeList8Kb.remove(0);
				allocatedMemorylist.get(holelocation).residesInMemory="Process";
				k++;
			}
			temp=temp-k*8;
			
		}
		
		//how many 4 kb hole can be allocated
		if(temp/4>=1 && !holeList4Kb.isEmpty())
		{
			int k=0;
			for(int i=0;i<temp/4 && !holeList8Kb.isEmpty();i++)
			{
				holelocation= holeList4Kb.get(0);
				holeList4Kb.remove(0);
				allocatedMemorylist.get(holelocation).residesInMemory="Process";
				k++;
			}
			temp=temp-k*4;
			
		}
		
		
		//if there is still leftover as we divide the memory in chunks of 4,8,12,16,20 kb list
		if(temp!=0){
			if(!holeList4Kb.isEmpty())
			{
				
				holelocation= holeList4Kb.get(0);
				holeList4Kb.remove(0);
				allocatedMemorylist.get(holelocation).residesInMemory="Process";
				temp=temp-4;
			}
			else if(!holeList8Kb.isEmpty())
			{
				
				holelocation= holeList8Kb.get(0);
				holeList8Kb.remove(0);
				allocatedMemorylist.get(holelocation).residesInMemory="Process";
				temp=temp-8;
			}
			else if(!holeList12Kb.isEmpty())
			{
				
				holelocation= holeList12Kb.get(0);
				holeList12Kb.remove(0);
				allocatedMemorylist.get(holelocation).residesInMemory="Process";
				temp=temp-12;
			}
			else if(!holeList16Kb.isEmpty())
			{
				
				holelocation= holeList16Kb.get(0);
				holeList16Kb.remove(0);
				allocatedMemorylist.get(holelocation).residesInMemory="Process";
				temp=temp-16;
			}
			else if(!holeList20Kb.isEmpty())
			{
				
				holelocation= holeList20Kb.get(0);
				holeList4Kb.remove(0);
				allocatedMemorylist.get(holelocation).residesInMemory="Process";
				temp=temp-20;
			}
			
			
			
		}
		
	
	}//end of process quickfit


	
	
	
	
	
	
	
	private static void holeManagement(
			ArrayList<MemoryOccupant> allocatedMemorylist,
			ArrayList<Integer> holeList20Kb,
			ArrayList<Integer> holeList16Kb,
			ArrayList<Integer> holeList12Kb,
			ArrayList<Integer> holeList8Kb,
			ArrayList<Integer> holeList4Kb) {
		// TODO Auto-generated method stub

		int holesize;
		
		
		for(int i=0;i<allocatedMemorylist.size();i++)
		{
			if(allocatedMemorylist.get(i).residesInMemory.compareTo("Hole")==0)
			{
				
				//if we get hole we save it's size and remove hole from list and the allocate that size in 
				//that place as chunks of hole
				holesize=allocatedMemorylist.get(i).sizeInMemory;
				allocatedMemorylist.remove(i);
				
				if((holesize/20)>=1) 
					{
						for(int k=0;k<holesize/20;k++)
							{	
								holeList20Kb.add(i);
								allocatedMemorylist.add(i++,new MemoryOccupant("Hole", 20));
							}
					
					holesize=holesize-(holesize/20)*20;
					}
				
				
				if((holesize/16)>=1) 
				{
				for(int k=0;k<holesize/16;k++)
					{	
						holeList16Kb.add(i);
						allocatedMemorylist.add(i++,new MemoryOccupant("Hole", 16));
					}
					holesize=holesize-(holesize/16)*16;
				}
				
			
				if((holesize/12)>=1) 
				{
				for(int k=0;k<holesize/12;k++)
				{
					holeList12Kb.add(i);
					allocatedMemorylist.add(i++,new MemoryOccupant("Hole", 12));
				}
				
				holesize=holesize-(holesize/12)*12;
				}
				
				
				if((holesize/8)>=1) 
				{
				for(int k=0;k<holesize/8;k++)
				
					{
					 holeList8Kb.add(i);
					 allocatedMemorylist.add(i++,new MemoryOccupant("Hole", 8));
					}
				holesize=holesize-(holesize/8)*8;
				}
				
				if((holesize/4)>=1) 
				{
				for(int k=0;k<holesize/4;k++)
				holeList4Kb.add(i);
				allocatedMemorylist.add(i++,new MemoryOccupant("Hole", 4));
				
				holesize=holesize-(holesize/4)*4;
				}
				i=i-1;
				
			
			}//end of each Hole in memory
			
		}//end of for loop
		
		
	}//holeManagement process ends 
	
	
	
}


