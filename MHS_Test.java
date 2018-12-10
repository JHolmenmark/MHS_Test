public class MHS_Test {
  public static MHS_Bank testBank = new MHS_Bank();
  public static MHS_Main testMain = new MHS_Main();
  public static final String ANSI_GREEN  = "\u001B[32m";
  public static final String ANSI_RED  = "\u001B[31m";
  public static final String ANSI_RESET = "\u001B[0m";

  public static void setupAddAccountsForTesting() {
    testBank.addAccount("Nordea", "1234567890", 5000.30);
    testBank.addAccount("Handelsbanken", "1423567890", 200.25);
    testBank.addAccount("SEB", "5531567890", -50.12);
    testBank.addAccount("Swedbank", "9951612349", 4200.48);
  }

  public static boolean test_BankAddAccount() {
    return testBank.addAccount("Nordea", "1234588730", 5300.30);
  }

  public static boolean test_MainPurchaseTicket() {
    return testMain.purchaseTicket("1234588730", 22.50).equals("Nordea");
  }

  public static boolean test_BankCantAddAccountTwice() {
    return !testBank.addAccount("Nordea", "1234588730", 5000.30);
  }

  public static boolean test_BankAddBadAccountNordea() {
    return !testBank.addAccount("Nordea", "1354545645", 5000.30);
  }

  public static boolean test_BankAddBadAccountHandelsbanken() {
    return !testBank.addAccount("Handelsbanken", "3445345678", 5000.30);
  }

  public static boolean test_BankAddBadAccountSEB() {
    return !testBank.addAccount("SEB", "1453456789", 5000.30);
  }

  public static boolean test_BankAddBadAccountSwedbank() {
    return !testBank.addAccount("Swedbank", "1453415678", 5000.30);
  }

  public static boolean test_BankAddBadAccountTooLong() {
    return !testBank.addAccount("SEB", "553145678905544", 5000.30);
  }

  public static boolean test_BankAddBadAccountTooShort() {
    return !testBank.addAccount("SEB", "5531456", 5000.30);
  }

  public static boolean test_BankAccountExist() {
    return testBank.accountExists("1234567890");
  }



  private static void printTestResultText(String testName, boolean resultOfTest){
    String shuffle = "";
    for(int i = 0; i < (40 - testName.length()); i++){
      shuffle = shuffle + " ";
    }
    System.out.print(testName + shuffle);
    if(resultOfTest){
      System.out.println(ANSI_GREEN + "PASSED" + ANSI_RESET);
    } else {
      System.out.println(ANSI_RED + "FAILED" + ANSI_RESET);
    }
  }

  public static void main(String[] args){
    System.out.println("Test Results: ");
    printTestResultText("test_BankAddAccount: ",
                        test_BankAddAccount());
    printTestResultText("test_MainPurchaseTicket: ",
                        test_MainPurchaseTicket());
    setupAddAccountsForTesting();
    printTestResultText("test_BankCantAddAccountTwice: ",
                        test_BankCantAddAccountTwice());
    printTestResultText("test_BankAddBadAccountNordea: ",
                        test_BankAddBadAccountNordea());
    printTestResultText("test_BankAddBadAccountHandelsbanken: ",
                        test_BankAddBadAccountHandelsbanken());
    printTestResultText("test_BankAddBadAccountSEB: ",
                        test_BankAddBadAccountSEB());
    printTestResultText("test_BankAddBadAccountSwedbank: ",
                        test_BankAddBadAccountSwedbank());
    printTestResultText("test_BankAccountExist: ",
                        test_BankAccountExist());
    printTestResultText("test_BankAddBadAccountTooLong: ",
                        test_BankAddBadAccountTooLong());
    printTestResultText("test_BankAddBadAccountTooShort: ",
                        test_BankAddBadAccountTooShort());
  }
}
