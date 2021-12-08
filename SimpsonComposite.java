import java.util.*;
import java.lang.*;
import java.math.*;
//The Simpson Composite class
public class SimpsonComposite{
	
	//Variables a and b represent the interval of the integral
	double a;
	double b;
	double h;
	Function fx= new Function();
	//The constructor takes in a Function object, and the interval the integral will be evaluated over 
    SimpsonComposite(double a, double b, Function fx){
		this.a=a;
		this.b=b;
		this.fx.id=fx.id;
	}
	/*
		The simpsonComp takes in an even n and uses the Composite Simpson's algorithm to evaluate integral using the 
		constructor's parameters.  
	*/
	public double simpsonComp(double n){
		//If n isn't even then the method stops and -1 is returned		
		if(n%2!=0){
			System.out.println("Invalid n input of "+n+" (An even n value must be entered)\n");
			return -1;
		}
        //h is is initialized
		this.h=(b-a)/n;
		double x_0=fx.fx(a)+fx.fx(b);//x_0 represent the sum of fx at the interval max and min 
		double x_1=0;				 //x_1 represents the summation of a function at its subinterval min values   
		double x_2=0;				 //x_2 represents the summation of a function at its subinterval max values 
		
		//For loop runs n-1 times and finds the summations of the subinterval max and mins 
		for(double j=1;j<n;j++){
			
			double x=a+(j*h);  
			//If the current j value is even (x is subinterval max)
			if(j%2==0){
				x_2+=fx.fx(x);//the current x is added to the x_2 sum
			}
			//If the current j value is odd (x is subinterval min)
			else{
				x_1+=fx.fx(x);//the current x is added to the x_1 sum
			}
		}
		//The integral approximation is set equal to the Composite Simpson's equation since we have all needed parts
		double simp_sum=(h/3)*(x_0+(2*x_2)+(4*x_1));
		return simp_sum;
	}
	//This method returns the current h value 
	public double getH(){
		return h;
	}
}
