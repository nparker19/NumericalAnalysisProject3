import java.util.*;
import java.lang.*;
import java.math.*;
//Tester for Project 3
public class P3Tester{
	
	public static void main(String[] args){
		 
		double x0=0;//Integral interval min
		double x1=1;//Integral interval max
		double wanted_error=Math.pow(10,-13);//The error we want to achieve in QUESTION4
		double n_values[]={2,4,8};			 //n values to run composite method with QUESTION2
		
		//Function object is created
		Function fx= new Function(1);		 	//int value 1 corresponds to the function we are using for Project3
		//ErrorClass object is created 
		ErrorClass fx1=new ErrorClass(x0,x1,fx);//Takes in function and interval 
		//A SimpsonComposite object is created 
		SimpsonComposite simp_fx=new SimpsonComposite(x0,x1,fx);//Takes in function and interval
		
		System.out.println("n\th\tIntegral Approximation\t\tError\t\t\t\tUpperBound on error");
		System.out.println("-----------------------------------------------------------------------------------------------------");
		//For loop to run program for each n QUESTION 2
		for(int i=0;i<n_values.length;i++){
		    
			double simp_sum=simp_fx.simpsonComp(n_values[i]);
			if(simp_sum!=-1){//If no odd n values are inputted 
			    //The following error methods are called and the data is printed 
				double error=fx1.errorCalc(simp_sum,fx.actualAns());
				double errBound=fx1.errorUBSimpComp(n_values[i]);
				System.out.println(n_values[i]+"\t"+simp_fx.getH()+"\t"+simp_sum+"\t\t"+error+"\t\t"+errBound);
				System.out.println("-----------------------------------------------------------------------------------------------------");
			}
		}
		double check=simp_fx.simpsonComp(932);
		double err=fx1.errorCalc(check,fx.actualAns());
		System.out.println(check+" "+err);
		//Answer for QUESTION4 is printed 
		System.out.println("n should be greater than or equal to "+fx1.getNforError(wanted_error)+" in order to guarantee an error less than "+wanted_error);
	}
}
