import java.util.*;
import java.lang.*;
import java.math.*;
//The error class holds all of methods regarding to error for Project3
public class ErrorClass{
	/*
		The interval bounds are created along with a Function object and a K value 
		which represents the max value on the interval of the fourth derivative.
	*/
	double x0;
	double x1;
	double K;
	Function fx=new Function();
	//This constructor takes in the interval and a function and initializes then 
	ErrorClass(double x0, double x1, Function fx){
		
		this.x0=x0;
		this.x1=x1;
		this.fx.id=fx.id;
	}
	//Simple error calc method 
	public double errorCalc(double approxAns, double actualAns){
		
		double error=Math.abs(approxAns-actualAns);
		return error;
		
	}
	//This method returns the upper bound on error in regards to n  
	public double errorUBSimpComp(double n){
		this.K=upperBoundSimpComp();
		double errorU_B=this.K*(Math.pow(x1-x0,5)/(180.0*Math.pow(n,4)));
		return errorU_B;
	}
	//This method returns the max fourth derivative value on the interval  
	public double upperBoundSimpComp(){
		 
		double aVal=fx.fx_fourthDeriv(x0);
		double bVal=fx.fx_fourthDeriv(x1);
		
		if(aVal>bVal){
			return aVal;
		}else{
			return bVal;
		}
	}
	//This method takes in a wanted error and returns the value the n must be greater than to achieve this error 
	public double getNforError(double wantedError){
		
		double temp=(this.K*Math.pow(x1-x0,4.0))/(wantedError*180.0);
		double n=Math.pow(temp,1.0/4.0);
		n=Math.ceil(n);//The actual n value will not be a whole integer so n is rounded up to the nearest whole 
	    //Since simpson's takes only even n values, if the n is odd a one is added 
		if(n%2!=0){
			n++;
		}
		return n;
	}
	
}
