import java.util.Scanner;
public class complexVecRunner { 
		
	public static void main(String[] args) {
					Scanner input = new Scanner(System.in);
					int size = getDimension();
					int secondSz;
					String[] firstVec = scanVector(size);
					int loop = 0;
					
					
					// Requesting First Vector Input
 					System.out.println("Let's Build a Vector of " + size + " Dimensions!");
					complexVec firstObj = new complexVec(firstVec, size);
					firstObj.printVector();
					String[] Vector1 = firstObj.parseVector();

					// User chooses between scalar or 2nd Vector 
					System.out.print("\nWould You Like To Use A Scalar Complex Number Or Build A Second Vector?\n1.Scalar Complex Number\n2.Second Vector\nChoice: ");
					int choice = input.nextInt();
					
					// Scan 2nd Input, scalar/vector
			if(choice == 1) {	// scalar
					secondSz = 1;
					System.out.println("\nLet's Build your Scalar input of 1 Dimension!");
					// Scan 2nd Vector Input, Call Obj
			} else /*if(choice == 2) */{ 
					secondSz = size;
					System.out.println("\nLet's Build your 2nd Vector of " + size + " Dimensions!");
			}
						String[] secondVec = scanVector(secondSz);
						complexVec secondObj = new complexVec(secondVec, secondSz);
						secondObj.printVector();
						String[] Vector2 = secondObj.parseVector(); 
			
			while(loop == 0)  {
				System.out.print("\nWhich operator would you like to utilize?\n1.Addition\n2.Subtraction\n3.Multiplication\n4.End Program\nChoice: ");
				int operator = input.nextInt();
				switch(operator) {
					case 1: //   ADDITION
						add(Vector1, Vector2, firstVec, secondVec);
						break;
					case 2: // SUBTRACTION
						subtract(Vector1, Vector2, firstVec, secondVec);
						break;
					case 3: // MULTIPLICATION
						multiply(Vector1, Vector2, firstVec, secondVec);
						break;
					case 4: // End Program
						System.out.println("\nProgram Ended. Thank you!");
						loop++;
						break;
				
				}
				
						
			} 
			
	}
	
	public static int getDimension() { 	// Finding size of Vector
			Scanner sizeEntry = new Scanner(System.in);
			System.out.print("What is the Dimension Size of your Vector? ");
			int dimension = sizeEntry.nextInt();
			return dimension;
	}
	
	public static String[] scanVector(int length) { // Scan input Vector 
				Scanner scan = new Scanner(System.in);
				int index = -1;
				String[] vector = new String[length];
			while (index < length - 1 ) {
				if ( length == 1 ) {
					System.out.print("Enter scalar complex number :: ");
				} else {
				System.out.print("Enter complex number :: ");
				}
					String num1 = scan.next();
					index++;
					vector[index] = num1;	
			} 
			return vector; 
	}
	
	public static void add(String[] vec1, String[] vec2, String[] initialVec1, String[] initialVec2) { // addition operator
			Scanner work = new Scanner(System.in);
			String[] firstVec = initialVec1;
			String[] secondVec = initialVec2;
			String[] complexNum = new String[vec1.length];
			System.out.println("\nYour Sum\n=========");
			int firstReal, secondReal, firstImag, secondImag, realSum, imagSum;
		for (int i = 0; i < vec1.length; i++) {
			if( vec2.length == 1) {
				firstReal = Integer.parseInt(vec1[i].substring(0,vec1[i].indexOf(",")));
				secondReal = Integer.parseInt(vec2[0].substring(0,vec2[0].indexOf(",")));
				firstImag = Integer.parseInt(vec1[i].substring(vec1[i].indexOf(",")+1));
				secondImag = Integer.parseInt(vec2[0].substring(vec2[0].indexOf(",")+1));
				realSum = firstReal + secondReal;
				imagSum = firstImag + secondImag;
			} else {
				firstReal = Integer.parseInt(vec1[i].substring(0,vec1[i].indexOf(",")));
				secondReal = Integer.parseInt(vec2[i].substring(0,vec2[i].indexOf(",")));
				firstImag = Integer.parseInt(vec1[i].substring(vec1[i].indexOf(",")+1));
				secondImag = Integer.parseInt(vec2[i].substring(vec2[i].indexOf(",")+1));
				realSum = firstReal + secondReal;
				imagSum = firstImag + secondImag;
			}
			if (imagSum == 0) { 
					complexNum[i] = Integer.toString(realSum);
					System.out.println(complexNum[i]);
			} else if (realSum == 0) { 
					complexNum[i] = Integer.toString(imagSum) + "i"; 
					System.out.println(complexNum[i]);
			} else {
					if (imagSum > 0) {
						if (imagSum == 1) { 
							complexNum[i] = Integer.toString(realSum) + "+" + "i";
							System.out.println(complexNum[i]);
						} else { 
							complexNum[i] = Integer.toString(realSum) + "+" + Integer.toString(imagSum) + "i"; 
							System.out.println(complexNum[i]);
						}
					} else { 
						if (imagSum == 1) { 
							complexNum[i] = Integer.toString(realSum) + "i"; 
							System.out.println(complexNum[i]);
						} else { 
							complexNum[i] = Integer.toString(realSum) + Integer.toString(imagSum) + "i"; 
							System.out.println(complexNum[i]);
						}
					} 
			} 
		}
					System.out.print("\nShow Work?\n1.Yes\n2.No\nChoice: ");
					int additionWork = work.nextInt();
					switch(additionWork){
						case 1:
							for (int i = 0; i < complexNum.length; i++) {
										int vecSpace = i + 1;
										String real1 = vec1[i].substring(0,vec1[i].indexOf(","));
										String imag1 = vec1[i].substring(vec1[i].indexOf(",")+1);
									if (vec2.length == 1) {
										String real2 = vec2[0].substring(0,vec2[0].indexOf(","));
										String imag2 = vec2[0].substring(vec2[0].indexOf(",")+1);
										System.out.println("\nVector Space " + vecSpace + " = " + complexNum[i]);
										System.out.println("Equation :: (" + firstVec[vecSpace-1] + ") + (" + secondVec[0] + ")");
										System.out.println("Real Part of Vector Space " + vecSpace + "      :: (" + real1 + ") + (" + real2 + ")");
										System.out.println("Imaginary Part of Vector Space " + vecSpace + " :: (" + imag1 + ") + (" + imag2 + ")\n");
									} else {
										String real2 = vec2[i].substring(0,vec2[i].indexOf(","));
										String imag2 = vec2[i].substring(vec2[i].indexOf(",")+1);
										System.out.println("\nVector Space " + vecSpace + " = " + complexNum[i]);
										System.out.println("Equation :: (" + firstVec[vecSpace-1] + ") + (" + secondVec[vecSpace-1] + ")");
										System.out.println("Real Part of Vector Space " + vecSpace + "      :: (" + real1 + ") + (" + real2 + ")");
										System.out.println("Imaginary Part of Vector Space " + vecSpace + " :: (" + imag1 + ") + (" + imag2 + ")\n");
									}
							} 
							break;
						case 2: break;
					}
	}
	
	public static void subtract(String[] vec1, String[] vec2, String[] initialVec1, String[] initialVec2) { // subtraction operator
			Scanner work = new Scanner(System.in);
			String[] firstVec = initialVec1;
			String[] secondVec = initialVec2;
			String[] complexNum = new String[vec1.length];
			System.out.println("\nYour Difference");
			System.out.println("=========");	
			int firstReal, secondReal, firstImag, secondImag, realSum, imagSum;
		for (int i = 0; i < vec1.length; i++) {
			if( vec2.length == 1) {
				firstReal = Integer.parseInt(vec1[i].substring(0,vec1[i].indexOf(",")));
				secondReal = Integer.parseInt(vec2[0].substring(0,vec2[0].indexOf(",")));
				firstImag = Integer.parseInt(vec1[i].substring(vec1[i].indexOf(",")+1));
				secondImag = Integer.parseInt(vec2[0].substring(vec2[0].indexOf(",")+1));
				realSum = firstReal - secondReal;
				imagSum = firstImag - secondImag;
			} else {
				firstReal = Integer.parseInt(vec1[i].substring(0,vec1[i].indexOf(",")));
				secondReal = Integer.parseInt(vec2[i].substring(0,vec2[i].indexOf(",")));
				firstImag = Integer.parseInt(vec1[i].substring(vec1[i].indexOf(",")+1));
				secondImag = Integer.parseInt(vec2[i].substring(vec2[i].indexOf(",")+1));
				realSum = firstReal - secondReal;
				imagSum = firstImag - secondImag;
			}
			if (imagSum == 0) { 
					complexNum[i] = Integer.toString(realSum);
					System.out.println(complexNum[i]);
			} else if (realSum == 0) { 
					complexNum[i] = Integer.toString(imagSum) + "i"; 
					System.out.println(complexNum[i]);
			} else {
					if (imagSum > 0) {
						if (imagSum == 1) { 
							complexNum[i] = Integer.toString(realSum) + "+" + "i";
							System.out.println(complexNum[i]);
						} else { 
							complexNum[i] = Integer.toString(realSum) + "+" + Integer.toString(imagSum) + "i"; 
							System.out.println(complexNum[i]);
						}
					} else { 
						if (imagSum == 1) { 
							complexNum[i] = Integer.toString(realSum) + "i"; 
							System.out.println(complexNum[i]);
						} else { 
							complexNum[i] = Integer.toString(realSum) + Integer.toString(imagSum) + "i"; 
							System.out.println(complexNum[i]);
						}
					} 
			} 
		}
					System.out.print("\nShow Work?\n1.Yes\n2.No\nChoice: ");
					int subtractionWork = work.nextInt();
					switch(subtractionWork){
						case 1:
							for (int i = 0; i < complexNum.length; i++) {
										int vecSpace = i + 1;
										String real1 = vec1[i].substring(0,vec1[i].indexOf(","));
										String imag1 = vec1[i].substring(vec1[i].indexOf(",")+1);
									if (vec2.length == 1) {
										String real2 = vec2[0].substring(0,vec2[0].indexOf(","));
										String imag2 = vec2[0].substring(vec2[0].indexOf(",")+1);
										System.out.println("\nVector Space " + vecSpace + " = " + complexNum[i]);
										System.out.println("Equation :: (" + firstVec[vecSpace-1] + ") - (" + secondVec[0] + ")");
										System.out.println("Real Part of Vector Space " + vecSpace + "      :: (" + real1 + ") - (" + real2 + ")");
										System.out.println("Imaginary Part of Vector Space " + vecSpace + " :: (" + imag1 + ") - (" + imag2 + ")\n");
									} else {
										String real2 = vec2[i].substring(0,vec2[i].indexOf(","));
										String imag2 = vec2[i].substring(vec2[i].indexOf(",")+1);
										System.out.println("\nVector Space " + vecSpace + " = " + complexNum[i]);
										System.out.println("Equation :: (" + firstVec[vecSpace-1] + ") - (" + secondVec[vecSpace-1] + ")");
										System.out.println("Real Part of Vector Space " + vecSpace + "      :: (" + real1 + ") - (" + real2 + ")");
										System.out.println("Imaginary Part of Vector Space " + vecSpace + " :: (" + imag1 + ") - (" + imag2 + ")\n");
									}
							} 
							break;
					}
	}
	
	public static void multiply(String[] vec1, String[] vec2, String[] initialVec1, String[] initialVec2) { // subtraction operator
			Scanner work = new Scanner(System.in);
			String[] firstVec = initialVec1;
			String[] secondVec = initialVec2;
			String[] complexNum = new String[vec1.length];
			System.out.println("\nYour Product");
			System.out.println("=========");	
			int firstReal, secondReal, firstImag, secondImag, realSum, imagSum;
		for (int i = 0; i < vec1.length; i++) {
			if( vec2.length == 1) {
				firstReal = Integer.parseInt(vec1[i].substring(0,vec1[i].indexOf(",")));
				secondReal = Integer.parseInt(vec2[0].substring(0,vec2[0].indexOf(",")));
				firstImag = Integer.parseInt(vec1[i].substring(vec1[i].indexOf(",")+1));
				secondImag = Integer.parseInt(vec2[0].substring(vec2[0].indexOf(",")+1));
				realSum = (firstReal * secondReal) - (firstImag * secondImag);
				imagSum = (firstReal * secondImag) + (firstImag * secondImag);
			} else {
				firstReal = Integer.parseInt(vec1[i].substring(0,vec1[i].indexOf(",")));
				secondReal = Integer.parseInt(vec2[i].substring(0,vec2[i].indexOf(",")));
				firstImag = Integer.parseInt(vec1[i].substring(vec1[i].indexOf(",")+1));
				secondImag = Integer.parseInt(vec2[i].substring(vec2[i].indexOf(",")+1));
				realSum = (firstReal * secondReal) - (firstImag * secondImag);
				imagSum = (firstReal * secondImag) + (firstImag * secondImag);
			}
			if (imagSum == 0) { 
					complexNum[i] = Integer.toString(realSum);
					System.out.println(complexNum[i]);
			} else if (realSum == 0) { 
					complexNum[i] = Integer.toString(imagSum) + "i"; 
					System.out.println(complexNum[i]);
			} else {
					if (imagSum > 0) {
						if (imagSum == 1) { 
							complexNum[i] = Integer.toString(realSum) + "+" + "i";
							System.out.println(complexNum[i]);
						} else { 
							complexNum[i] = Integer.toString(realSum) + "+" + Integer.toString(imagSum) + "i"; 
							System.out.println(complexNum[i]);
						}
					} else { 
						if (imagSum == 1) { 
							complexNum[i] = Integer.toString(realSum) + "i"; 
							System.out.println(complexNum[i]);
						} else { 
							complexNum[i] = Integer.toString(realSum) + Integer.toString(imagSum) + "i"; 
							System.out.println(complexNum[i]);
						}
					} 
			} 
		}
					System.out.print("\nShow Work?\n1.Yes\n2.No\nChoice: ");
					int subtractionWork = work.nextInt();
					switch(subtractionWork){
						case 1:
							for (int i = 0; i < complexNum.length; i++) {
										int vecSpace = i + 1;
										String real1 = vec1[i].substring(0,vec1[i].indexOf(","));
										String imag1 = vec1[i].substring(vec1[i].indexOf(",")+1);
									if (vec2.length == 1) {
										String real2 = vec2[0].substring(0,vec2[0].indexOf(","));
										String imag2 = vec2[0].substring(vec2[0].indexOf(",")+1);
										System.out.println("\nVector Space " + vecSpace + " = " + complexNum[i]);
										System.out.println("Equation :: (" + firstVec[vecSpace-1] + ") * (" + secondVec[0] + ")");
										System.out.println("Real Part of Vector Space " + vecSpace + "      :: (" + real1 + ") * (" + real2 + ") - (" + imag1 + ") * (" + imag2 + ")");
										System.out.println("Imaginary Part of Vector Space " + vecSpace + " :: (" + real1 + ") * (" + imag2 + ") + (" + imag1 + ") * (" + real2 + ")\n");
									} else {
										String real2 = vec2[i].substring(0,vec2[i].indexOf(","));
										String imag2 = vec2[i].substring(vec2[i].indexOf(",")+1);
										System.out.println("\nVector Space " + vecSpace + " = " + complexNum[i]);
										System.out.println("Equation :: (" + firstVec[vecSpace-1] + ") * (" + secondVec[vecSpace-1] + ")");
										System.out.println("Real Part of Vector Space " + vecSpace + "      :: (" + real1 + ") * (" + real2 + ") - (" + imag1 + ") * (" + imag2 + ")");
										System.out.println("Imaginary Part of Vector Space " + vecSpace + " :: (" + real1 + ") * (" + imag2 + ") + (" + imag1 + ") * (" + real2 + ")\n");
									}
							} 
							break;
					}
	}
}
