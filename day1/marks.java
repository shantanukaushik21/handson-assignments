public class marks{
	public static void main(String[] args){
		int marks=Integer.parseInt(args[0]);
		if(marks>=70){
			System.out.println("Distinction");
		}
		else if(marks>=60&&marks<70){
			System.out.println("1st class");
		}
		else if(marks>=50&&marks<60){
			System.out.println("2st class");
		}
		else if(marks>=35&&marks<50){
			System.out.println("PASS");
		}
		else if(marks<35){
			System.out.println("Fail");
		}
}
}