package hlm.com;

import java.util.Scanner;
import java.util.Stack;

/**
 *  public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 int n = sc.nextInt();
 int ans = 0, x;
 for(int i = 0; i < n; i++){
 for(int j = 0; j < n; j++){
 x = sc.nextInt();
 ans += x;
 }
 }
 System.out.println(ans);
 }
 */

public class Test {

    static Stack<Character> chr = new  Stack<Character>();

    static Stack<Integer> result = new  Stack<Integer>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        chr.add('(');
        char str[] =(sc.next()+")").toCharArray();
        sc.close();
        int number = 0;

        for(int i = 0; i < str.length ; i++){
            if('0'<= str[i] && str[i]<'9'){
                number = str[i] - '0';
                for(i= i+1; i<str.length ; i++){
                    if('0'<= str[i] && str[i] <= '9'){
                        number = number *10 + (str[i] - '0') ;
                    }else{
                        i--;
                        break ;
                    }

                }
                result.add(number);
                continue;
            }
            if(str[i] == '('){
                chr.add(str[i]);
                continue;
            }
            //运算符
            if(str[i] == '+' || str[i] == '-' || str[i] == '*'|| str[i] == '/'){

                while(checkpd(chr.peek(),str[i])){
                    calculate();
                }
                chr.add(str[i]);
                continue;
            }
            if(str[i] == ')'){
                while(chr.peek() != '('){
                    calculate();
                }
                chr.pop();
            }
        }
        System.out.println(result.get(0));
    }



    private static boolean checkpd(char a , char b){
        if(a == '*' || b == '/'){
            return true ;
        }
        if(b == '*' || b== '/' || a == '('){
            return false ;
        }
        return true ;
    }


    private static void calculate(){
        char fh = chr.pop();
        int num2 = result.pop();
        int num1 = result.pop();
        switch (fh){
            case '+' :
                result.add(num1+num2);
                break;
            case '-' :
                result.add(num1-num2);
                break;
            case '*' :
                result.add(num1*num2);
                break;
            case '/' :
                result.add(num1/num2);
                break;
            default:
                break ;
        }

    }
}
