public class complexVec {

	String complex, real, imag;
	int index, size;
	int realNegation = 0;
	String[] vector, vecParts;
	
	// Constructor
	// receiving vector 
	public complexVec(String[] arr, int sz) {  
				size = sz;
				vector = arr;
				vecParts = new String[size];
	}
	
	public void printVector() {
		if(size == 1) {
			 System.out.println("\nYour Scalar\n===========");
		} else {
			System.out.println("\nYour Vector\n===========");
		}
		for (int i = 0; i < size; i++){
				System.out.println(vector[i]);
		}
	}

	public String[] parseVector() {
		for (int x = 0; x < size; x++) {
				try {
					if(vector[x].substring(0,1).equals("-")) 	  { //real part negative sign identifier
							vector[x] = vector[x].substring(1);
							realNegation = 1;
					} else { realNegation = 0; }
					 
						// parse complex Number , convert to integers
					if (vector[x].contains("i")) { // does it contain an imaginary part?
							
						if(vector[x].equals("i")) {   // ex. i  
								real = "0";
							if (realNegation == 1) {
								imag = "-1";
							} else if (realNegation == 0) { 
								imag = "1";
							}	
						} else if(vector[x].contains("+") || vector[x].contains("-")) {		 // ex. 2 + 2i, -2 - 2i, -2 + 2i	
								if(vector[x].contains("+i") || vector[x].contains("-i")) {  // ex. 2 + i, 2 - i 
											complex = vector[x].replaceAll("i", "1");
								} else { complex = vector[x].replaceAll("i", ""); }
								
							
								 if (complex.contains("+")) {
										if (realNegation == 1) {                   
												index = complex.indexOf("+");
												real = "-" + complex.substring(0,index);
												imag = complex.substring(index+1);
											 } else if(realNegation == 0) { 
												index = complex.indexOf("+");
												real = complex.substring(0,index);
												imag = complex.substring(index+1);
											 }
								 }
								 if (complex.contains("-")) {
											 if (realNegation == 1) {                   
												index = complex.indexOf("-");
												real = "-" + complex.substring(0,index);
												imag = "-" + complex.substring(index+1);
											 } else if(realNegation == 0) { 
												index = complex.indexOf("-");
												real = complex.substring(0,index);
												imag = "-" + complex.substring(index+1);
											 }
								 }
							} else {
										real = "0";
									if (realNegation == 1) {        //  2i, -2i  
										imag = "-" + vector[x].substring(0,vector[x].length()-1);
									} else if(realNegation == 0) { 
										imag = vector[x].substring(0,vector[x].length()-1);
									}
							}	
					} else {   // all real numbers
							imag = "0";
						if (realNegation == 1) { 
							real = "-" + vector[x];
						} else { real = vector[x]; }			 
					} 
				} catch (NullPointerException e) {}

				vecParts[x] = real + "," + imag;
				
		} return vecParts;
	}

}  
