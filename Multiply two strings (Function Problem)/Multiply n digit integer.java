import java.io.*;
public class multiply
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String a = "/*Replace this with an integer value*/";
        int l1 = a.length();
        String b = "/*Replace this with an integer value*/";
        int l2 = b.length();  
        
        int max = Math.max(l1,l2);          
        
        if(max == l2)
        {
            for(int i = 0; i < max-l1; ++i)
                a = "0" + a;
        }
        else
        {
            for(int i = 0; i < max-l2; ++i)
                b = "0" + b;
        }        
        
        String result[] = new String[max];
        for(int i = 0; i < max; ++i)
            result[i] = "";
        int pos = 0;        
        int arr1[] = new int[max];
        int arr2[] = new int[max];
        
        for(int i = 0; i < max; ++i)
            arr1[i] = a.charAt(i) - 48;
        
        System.out.println("ARR1");
        for(int i = 0; i < max; ++i)
            System.out.print(arr1[i] + " ");
            
        
        for(int i = 0; i < max; ++i)
            arr2[i] = b.charAt(i) - 48;
        
        System.out.println("\nARR2");
        for(int i = 0; i < max; ++i)
            System.out.print(arr2[i] + " ");
        
        System.out.println();
        int carry , rem, p;    
            
        for(int i = max-1; i >= 0; --i)
        {
            carry = 0;
            rem = 0;
            for(int j = max-1; j >= 0; --j)
            {
                p = arr2[i] * arr1[j] + carry;
                if(j == 0)
                    result[pos] = p + result[pos]; 
                else
                {
                    rem = p % 10;
                    carry = p / 10;
                    result[pos] = rem + result[pos]; 
                }                
            }            
            
            if(i == 0)
                ;
            else
            {
                ++pos;
                for(int k = 0; k < pos; ++k)
                    result[pos] += "0";
            }
        }          
        System.out.println();                         
        int maxl = result[pos].length();
        
        for(int i = 0; i < pos; ++i)
        {
            int t = result[i].length();
            for(int j = 0; j < maxl - t; ++j)
                result[i] = "0" + result[i];
        }        
       
        for(int k = 0; k <= pos; ++k)
            System.out.println(result[k]);
        
        System.out.println();
        carry = 0;
        p = 0;
        String answer = "";
        for(int i = maxl-1; i >= 0; --i)
        {
            p = 0;            
            for(int j = 0; j < max; ++j)
            {
                String x = result[j];                                
                p += x.charAt(i) - 48;            
            }
            p += carry;            
            
            if(i == 0)
                    answer = p + answer;
            else
            {
                rem = p % 10;
                carry = p / 10;
                answer = rem + answer; 
            }                        
        }
        
        char t = answer.charAt(0);
        while(t == '0')
        {
            answer = answer.substring(1);
            t = answer.charAt(0);
        }
       
        System.out.println("The answer is : " + answer);            
    }
}
