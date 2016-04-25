package Terms;

/**
 * Term is a representation class for algebraic expressions.
 * It takes two parameters: exp and coefficient to return a term object.
 * Member variables include: (int) exponent as exp and (int) coefficient as coef.
 * Member methods include: getCoef() and getExp()
 * @author Ashok Tamang @02721056
 *
 */
public class Terms {
	private int exp,coef;
	
	/**
	 * Initializes the private member variables of the class.
	 * Precondition: Respective values are passed as an argument to the constructor.
	 * Postcondition: Member variables will be assigned.
	 * @param exp
	 * @param coef
	 */
	public Terms(int coef,int exp){
		this.exp=exp;
		this.coef=coef;
	}
	
	/**
	 * Returns the exponent of the class
	 * 
	 * Precondition: Value of the exponent is preassigned with the constructor method of the class
	 * Postcondition:  Returns the exponent
	 * 
	 * @return exponent of the class or -1 if the type is not int.
	 */
	
	public int getExp(){
		if(this.exp==(int)this.exp){
			return this.exp;
		}
		else{
			System.out.println("Error!! This number is not of type int");
			return -1;
		}
	}
	
	/**
	 * Returns the coefficient of the class
	 * 
	 * Precondition: Value of the coefficient is preassigned with the constructor method of the class
	 * Postcondition:  Returns the coefficient
	 * 
	 * @return coefficient of the class or -1 if the type is not int.
	 */
	public int getCoef(){
		if(this.coef==(int)this.coef){
			return this.coef;
		}
		else{
			System.out.println("Error!! This number is not of type int");
			return -1;
		}
	}
	
	
	/**
	 * Returns an algebraic term of the class in a formatted String type
	 
	 * Precondition: The values for coef and exp are preassigned.
	 * Postcondition: The string is formatted in the proper style and returned.
	 * 
	 * @return An algebraic term of the class
	 */
	public String toString(){
		String formatted_string="";
		if(this.exp==0){
			formatted_string+=Integer.toString(this.coef);
		}
		else if(this.exp==1){
			formatted_string+=Integer.toString(this.coef)+"x";
		}
		else if(this.coef==0){
			formatted_string+="x^"+Integer.toString(this.exp);
			
		}
		
		else{
			formatted_string+=Integer.toString(this.coef)+"x^"+Integer.toString(this.exp);
		}
		return formatted_string;
		
	}
}
