import java.util.Scanner;

public class Alphabet_Cipher {

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Input String -> Keyword Message");
        String[] input = scan.nextLine().split(" "); //Splits the string into 2 strings
        String keyword = input[0]; //keyword
        String message = input[1]; //message
        System.out.println("Would you like Encrypt(E) or Decrypt(D) the message");
        scan = new Scanner(System.in);
        char action = Character.toUpperCase(scan.next().charAt(0));
        int i, j = 0;
        for(i = 0; i < message.length(); i++){
            if(j == keyword.length()){j = 0;}
            switch(action){
                case 'E': encryption(keyword.charAt(j), message.charAt(i));
                          break;
                case 'D': decryption(keyword.charAt(j), message.charAt(i));
                          break;
            }
            j++;
        }
    }

    //Uses a formula that calcultes the correct char through ascii values
    //a = 0 -> z = 25
    public static void encryption(char one, char two){
        int a = one, b = two;
        int answer = ((a+b)-194); //Obtains a value from 0 - 25
        if(answer > 25){answer -= 26;} //If value is over the range, substracts 26 to obtain the value (Due to repeating)
        answer += 97; //Adds 97 ro get back to the ascii value
        System.out.print((char)answer);
    }

    public static void decryption(char one, char two){  //Bonus -> works backwards
        int a = one, b = two;
        int answer = (b - 97) + (194 - a);
        if(answer < 97){answer += 26;}
        System.out.print((char)answer);
    }
}
