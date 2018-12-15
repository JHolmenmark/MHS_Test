
package MoneyHandling;

public class MHS_Test {
    
    private static MHS_Bank bankInfo = new MHS_Bank();
    private static MHS_BankAccount bankAccount = new MHS_BankAccount();
    private static String ACCOUNT_NR = "9951612229";
    private static double BALANCE = 15.56;
    private static String BANK_NAME = "Nordea";
    private static double PRICE = 18.89;
    private static int substringStartPosition = 0;
    private static int susbstringEndPosition1 = 4;
    private static int susbstringEndPosition2 = 5;
    
    public static final String ANSI_RED    = "\u001B[31m";
    public static final String ANSI_GREEN  = "\u001B[32m";
    public static final String ANSI_RESET  = "\u001B[0m";
    
    public static boolean test_requestHandler(){
        return  bankInfo.requestHandler(ACCOUNT_NR, PRICE);
    }
    public static boolean test_substringAccountNr(String acc){
       return "1234".equals(bankInfo.substringAccountNr(substringStartPosition, 
                                            susbstringEndPosition1));
     }
    public static boolean test_getBankName(int start, int end){
       return BANK_NAME.equals(bankInfo.getBankName());
    }
    public static boolean test_getBalance(){
        return (BALANCE
                ==bankAccount.getBalance(Double.parseDouble(ACCOUNT_NR)));
    }
    public static boolean test_SetBalance(String accNr, double price){
        ACCOUNT_NR = accNr;
        PRICE = price;
        bankAccount.getBalance(Double.parseDouble(accNr));
        bankAccount.setBalance(price);
        if (bankAccount.bankInfo[0][1]==(BALANCE - PRICE)){
        return true;
        }
        return false;
    }
    private static void printResultMethod(){
      int totalAmountOfErros = 0;
      String [] resultNameArray = {"RequestHandler Method", 
                                    "substringAccountNr Method",
                                    "getBankName Method", "getBalance",
                                    "getSetBalance Method"};
      boolean [] resultArray = {test_requestHandler(), 
                                test_substringAccountNr(ACCOUNT_NR), 
                                test_getBankName(substringStartPosition, 
                                        susbstringEndPosition1),
                                test_getBalance(), test_SetBalance(ACCOUNT_NR, PRICE)};
      for (int i = 0; i < resultArray.length; i++){
          if(resultArray[i] == true){
      System.out.printf("%-30s"+ANSI_GREEN+"%s%n"+ANSI_RESET,
                            resultNameArray[i], "PASSED");
    } else {
      System.out.printf("%-30s"+ANSI_RED+"%s%n"+ANSI_RESET,
                            resultNameArray[i], "FAILED");
      totalAmountOfErros++;
    }
          
      }
       System.out.println("Total amount of errors: "+totalAmountOfErros);
    }
  
    public static void main(String[]args){
        
        MHS_Test tests = new MHS_Test();
        
        tests.printResultMethod();
        
    }
}
