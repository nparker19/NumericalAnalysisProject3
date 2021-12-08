import java.util.*;
import java.lang.*;
import java.math.*;

/*
	This Function class holds functions with each one having a corresponding ID (ID#>0). 
	Whenever a new function is added this code must be adjusted. A description must be added
	and a case corresponding to the function's ID must be added to the appropriate switch case
	
	I created this function class so that I could create methods that could implement different
	functions instead of just one. Before, I would have to change the method code so that it would
	evaluate the correct function. Now I can just use the Function object as a parameter to my methods.
*/
public class Function{
	//Must add a function description to this array when adding a new function to the class 
	String functionArray[]={"Function is from Project 3 (ID1)","Function is from hw(4.4.3) (ID2)","Function is from Project 1 (ID3)", "Function is from Project 1 for NA2 (Eulers)"};
	int id;
	//Constructor 1 creates an a Function object in regards to an ID. 
	Function(int identifier){
		this.id=identifier;
	}
	//Constructor 2 creates an empty Function object which does not have a valid ID 
	Function(){
		this.id=0;
	}
	public double f(double t, double x){
		double y=0;
		switch(id){
			
			case 4:
			    y=-1.0*t*x;
				break;
				
			default:
			    System.out.println("The function with ID: "+id+" has not been created");
			    System.exit(0);
		}
		
		return y;
	}
	//Function evaluation
	public double fx(double x){
		double y=0;
		switch(id){
			case 1:
				y=((2.0/Math.sqrt(Math.PI))*Math.exp(-1.0*Math.pow(x,2)));
				break;
			case 2:
				y=(1/(1+(25*x*x)));
				break;
			case 3:
				y=((Math.pow((2.5/(7.0+x)), 2))+(Math.pow((1.5/(4.0+x)), 2))+(Math.pow((.1/(.3+x)), 2))-.01);
				break;
				
			case 5:
				y=Math.exp(-1.0*(Math.pow(x,2))/2);
				break;
				
			default:
			    System.out.println("The function with ID: "+id+" has not been created");
			    System.exit(0);
		}
		return y;
	}
	//Function first derivative evaluation
	public double fx_firstDeriv(double x){
		double y=0;
		switch(id){
			case 1:
				y=(-(12.5/(Math.pow((7.0+x), 3)))-(4.5/(Math.pow((4.0+x), 3)))-(.02/(Math.pow((.3+x), 3))));
				break;
			default:
			    System.out.println("The first derivative you are trying to access has not been created for functionID:"+id);
			    System.exit(0);
		}
		return y;
	}
	//Function fourth derivative evaluation	
	public double fx_fourthDeriv(double x){
		double y=0;
		switch(id){
			case 1:
				y=((8.0/Math.sqrt(Math.PI))*Math.exp(Math.pow(-x,2))*(4*Math.pow(x,4)-12*x*x+3));
				break;
			default:
			    System.out.println("The fourth derivative you are trying to access has not been created for functionID:"+id);
			    System.exit(0);
		}
		return y;
	}
	//Function's actual value we are trying to approximate 
	public double actualAns(){
		double actual=0;
		switch(id){
			case 1:
				actual=.842700792949715;
				break;
			default:
			    System.out.println("You have not created an actual solution for functionID:"+id);
			    System.exit(0);
		}
		return actual;
	}
	//Each Function in this class is printed along with their functionID
	public void printFunctions(){
		
		for(int i=0;i<functionArray.length;i++){
			System.out.println("ID "+(i+1)+": "+functionArray[i]);
		}
		
	}
}
