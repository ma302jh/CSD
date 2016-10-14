/*
 *
 * This class contains each cryptographic function and supporting functions
 * to be used by the rest of the program.
 * It will also contain a random number generator.
 *
*/


public class Cryptography{

    ///USE A BETTER SHIFT FUNCTION MUST BE CIRCULAR!!!!

    //this function simply shifts the alphabet by the given amount
    //in args and is also known as the Ceasar cipher
     String shiftcipherEncrypt( String _plaintext, int _shiftkey){

	int shiftval = _shiftkey % 26;
	char[] cipherText = _plaintext.toCharArray();

	for(int i=0; i < cipherText.length ;i++) {

	    //the 65 is there to ajust for ascii text value
	    cipherText[i] = (char)(((int) cipherText[i] + shiftval - 65) + 65);
	}
	
	return String.valueOf( cipherText);
    }

    //this function reverses the above code - I could have
    //the above function work with a minus value to undo the change
    //also - I may implement that later if there is time
    String shiftcipherDecrypt( String _plaintext, int _shiftkey){

	int shiftval = _shiftkey % 26;
	
	char[] cipherText = _plaintext.toCharArray();

	for(int i=0; i < cipherText.length ;i++) {

	    //the 65 is there to ajust for ascii text value
	    cipherText[i] = (char)(((int) cipherText[i] - shiftval + 65) -65);
	}
	
	return String.valueOf( cipherText);
    }
}






//http://stackoverflow.com/questions/21412148/simple-caesar-cipher-in-java for help realising about ascii ofset value
