package Polynomial;
import Terms.Terms;
import java.util.*;

/**
 * Polynomial is a representative class for polynomials in algebraic form.
 * 
 * Member variables include:
 * a. polynomialArrayList = an ArrayList that holds the Polynomial objects
 * 
 * Member methods include:
 * a. Polynomial() = constructor method to initialize the Polynomial
 * b. Insert(int exp, int coef) 
 * c. Product()
 * d. Delete(int exp, int coef)
 * e. returnAscendingPolynomial()
 * f. Reverse()
 * g. flushPolynomialArray()
 * 
 * 
 * @author Ashok Tamang @02721056
 *
 */
public class Polynomial {
	
	private ArrayList<Terms> polynomialArray;
	Terms testObject;
	
	/**
	 * Creates an empty list
	 */
	
	public Polynomial(){
		 polynomialArray= new ArrayList<Terms>();
	}
	
	/**
	 * PreCondition: The exps and coefs are passed in as arguments.
	 * PostCondition: The values are added to the polynomial in ascending order.
	 * 
	 * @param exp
	 * @param coef
	 */
	public void Insert(int exp, int coef){
		/**
		 * In this Insert function, we are going to sort the values and add it into our ArrayList.
		 */
		testObject = new Terms(exp, coef);
		
		if(polynomialArray.size() == 0){
			polynomialArray.add(testObject);
		}
		else{
			
			for(int i = 0; i < polynomialArray.size(); i++){
				Terms index = polynomialArray.get(i);
				int temp_exp = index.getExp();
				if(coef >= temp_exp){
					polynomialArray.add(i,testObject);
					return;
				}
			}
			polynomialArray.add(testObject);
		}
		
	}
	/**
	 * This function returns the polynomial in ascending order.
	 */
	
	public String returnAscendingPolynomial(){
		int temp_count = 0;
		String polynomial = "";
		for(Terms iter: polynomialArray){
			if(temp_count == 0){
				polynomial+=iter.toString();
			}
			else if(iter.getCoef()<0){
				polynomial += iter.toString();
			}
			else{
				polynomial += " + "+iter.toString();
			}
			temp_count++;
			}
			return polynomial;
		
	}
	
	/**
	 * PreCondition: The exps and coefs are passed in as arguments.
	 * PostCondition: The values with the exp and coef is deleted from the Polynomial.
	 * @param exp
	 * @param coef
	 */
	
	public void Delete(int exp, int coef){
		for(Terms iter : polynomialArray){
			if((iter.getCoef() == exp)&&(iter.getExp() == coef)){
				polynomialArray.remove(iter);
				System.out.println("The values are deleted. coef : "+exp + ". exp : "+coef);
				return;
			}
			
		}
		System.out.println("Oops! The term " + coef + "x^" + exp + " is not found!");
	}
	
	/**
	 * This will return the product
	 */
	public String Product(){
		String product="";
		int coef = 1, exps = 0;
		for(Terms iter : polynomialArray){
			int iter_coef=iter.getCoef();
			int iter_exps=iter.getExp();
			exps+=iter_exps;
			coef*=iter_coef;
		}
		if(exps == 0){
			product+=Integer.toString(coef);
		}
		else if(coef == 1){
			product+="x^"+Integer.toString(exps);
		}
		else if(coef == 0){
			
		}
		else{
			product+=coef+"x^"+exps;
		}
		return product;
		
		
		
	}
	/**
	 * This function will reverse the polynomial.
	 */
	public StringBuffer Reverse(){
		int tempCount = 0;
		String temp = "";
		StringBuffer reverse_string = new StringBuffer("");
		for(Terms iter : polynomialArray){
			if(tempCount == polynomialArray.size() - 1){
				temp+=iter.toString();
			}
			else if(iter.getCoef() < 0){
				temp += iter.toString();
			}
			else{
				temp += " + " + iter.toString();
			}
			
			reverse_string.insert(0, temp);
			temp = "";
			tempCount++;
			
			
		}
		return reverse_string;
	}
	
	/**
	 * Flushes array list every time a line is read from the file.
	 * 
	 */
	public void flushPolynomialArray(){
		polynomialArray.clear();
	}
	
}