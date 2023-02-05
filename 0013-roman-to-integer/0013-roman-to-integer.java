import java.util.Scanner;
class Solution {
    public static int romanToInt(String s) {
        int result = 0;
        char[] arr = new char[15];
        arr = s.toCharArray();
        for(int i = 0; i < s.length(); i++)
        {
            char ch = arr[i];
            switch(ch){
                case 'I':
                    if(i+1<s.length())
                    {
                        if(arr[i+1] == 'V'){
                            result = result + 4;
                            i++;
                        }
                        else if(arr[i+1] == 'X'){
                            result = result + 9;
                            i++;
                        }
                        else
                        result = result + 1;
                    }
                    else
                        result = result + 1;
                    break;
                    
                    case 'X':
                    if(i+1<s.length())
                    {
                        if(arr[i+1] == 'L'){
                            result = result + 40;
                            i++;
                        }
                        else if(arr[i+1] == 'C'){
                            result = result + 90;
                            i++;
                        }
                        else
                        result = result + 10;
                    }
                    else
                        result = result + 10;
                    break;
                    
                    case 'C':
                    if(i+1<s.length())
                    {
                        if(arr[i+1] == 'D'){
                            result = result + 400;
                            i++;
                        }
                        else if(arr[i+1] == 'M'){
                            result = result + 900;
                            i++;
                        }
                        else
                        result = result + 100;
                    }
                    else
                        result = result + 100;
                    break;
                    
                    case 'V':
                        result = result + 5;
                        break;
                    
                    case 'L':
                        result = result + 50;
                        break;
                    
                    case 'D':
                        result = result + 500;
                        break;
                    
                    case 'M':
                        result = result + 1000;
                        break;
            }
        }
        return result;
    }
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Roman numeral");
        String input = sc.nextLine();
        System.out.printf("the integer value corrwsponding to %s roman is %d : ",input,romanToInt(input));
    }
}