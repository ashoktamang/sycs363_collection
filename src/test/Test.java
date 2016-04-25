package test;
import Polynomial.Polynomial;
import java.io.*;

/**
 * Test cases for Polynomial and Terms class
 * 
 * @author Ashok Tamang @0271056
 *
 */
public class Test {
	public static void main(String[] args){
		int count = 0;
		Polynomial polynomialObject = new Polynomial();
		String line = null, exponent_string = "", coefficient_string = "";
		int exponent = 0, coefficient = 0;
		File fileName = new File("Input.txt");
		try{
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			int length = bufferedReader.read();
			
			// Validating the file read. 
			if(length==-1){
				System.out.println("Error!! The file is empty");
			}
			else{
				while((line=bufferedReader.readLine())!=null){
					String[] spiltter=line.split(";");
					for(int i=1;i<spiltter.length;i++){
						if(i%2!=0){
							coefficient_string=spiltter[i];
							coefficient=Integer.parseInt(coefficient_string);
						}
						else{
							exponent_string=spiltter[i];
							exponent=Integer.parseInt(exponent_string);
							polynomialObject.Insert(coefficient,exponent);
						}
						
						
					}
					
					System.out.println("P(" + count+")"+" : "+polynomialObject.returnAscendingPolynomial());
					
					// Product
					System.out.println("The product : "+polynomialObject.Product());
					polynomialObject.Delete(8, 7);
					
					// Deleting
					System.out.println("The polynomial after deletion: ");
					System.out.println("P(" + count+")"+" : "+polynomialObject.returnAscendingPolynomial());
					
					//Reverse
					System.out.println("Reversal");
					System.out.println("P(" + count+")"+" : "+polynomialObject.Reverse());
					System.out.println("The product : "+polynomialObject.Product());
					count++;
					
					// Flush PolynomialArray
					polynomialObject.flushPolynomialArray();
					
					
					System.out.println("__________________________________________________________________\n");
					
				}
			}
			bufferedReader.close();
			
			
		}
		catch(FileNotFoundException ex){
			System.out.println("Unable to open file");
		}
		catch(IOException ex){
			System.out.println("ERROR : "+ex);
		}
	}

}
