package basic.test.pkgclass;

//Imports
import java.math.*;
import java.util.ArrayList;

/**
 * Basic test class that is used to just test simple code.
 * @author Devin
 */
public class BasicTestClass {
    
    //The number of rows to compute to
    static int nRows = 100;
    
    //The type of Summation Triangle to compute (nType=1 means: 1 new number per row, 2 numbers added together)
    static int nType = 1;
    
    //Whether to print every row
    static boolean printAll = false;
    
    public static void main(String[] args) {
        //Creating new and old row arrays
        BigDecimal[] NRow = new BigDecimal[1];
        BigDecimal[] LRow = new BigDecimal[1];
        LRow[0]=BigDecimal.ONE;
                
        //Looping through the rows
        for (int row=0; row<nRows; row++){
            
            //printAll condition
            if(printAll){
                printArray(LRow);
            }
            
            //Making the new row
            NRow = new BigDecimal[LRow.length+nType];
            
            //Looping through the new row
            for (int pos=0; pos<NRow.length; pos++){
                
                //Performing the addition
                BigDecimal sum = BigDecimal.ZERO;
                for (int j=nType; j>=0; j--){
                    if (pos-j>=0&&!(pos-j>=LRow.length)){
                        sum = sum.add(LRow[pos-j]);
                    }
                }
                
                //Updating new row value
                NRow[pos] = sum;
            }
            
            //Updating the old row
            LRow = NRow;
        }
        
        printArray(NRow);
        
    }
    
    public static void print(Object arg){
        System.out.print(arg);
    }
    
    public static void println(Object arg){
        System.out.println(arg);
    }
    
    public static void printArray(Object[] arr){
        for (int pos = 0; pos<arr.length;pos++) {
            print(arr[pos]);
            if (pos != arr.length-1){
                print(", ");
            }
        }
    println("");
    }
}
