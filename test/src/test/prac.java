package test;

public class prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		
		for(int num = 2; num <= 100; num++)
		{
			boolean flag = true;
			for(int i = 2; i <= num/2; i++)
			{
				if((num%i) == 0)
				{
					flag = false;
					break;
				}
			}
			if(flag == true)
			{
				System.out.println(num);
			}
				
		}
	
	}

}
