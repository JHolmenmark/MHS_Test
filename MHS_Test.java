public class MHS_Test {
  public static MHS_Bank testBank = new MHS_Bank();
  public static final String ANSI_GREEN  = "\u001B[32m";
  public static final String ANSI_RED  = "\u001B[31m";
  public static final String ANSI_RESET = "\u001B[0m";

  public static void setupAddAccountsForTesting() {
    testBank.addAccount("Handelsbanken", "1423567890", 200.25);
    testBank.addAccount("SEB", "5531567890", -50.12);
    testBank.addAccount("Swedbank", "9951612349", 4200.48);
  }

  public static boolean test_MainAddAccount() {
    return testBank.addAccount("Nordea", "1234567890", 5000.30);
  }

  public static boolean test_MainCantAddAccountTwice() {
    return !testBank.addAccount("Nordea", "1234567890", 5000.30);
  }

  public static boolean test_MainAddBadAccountNordea() {
    return !testBank.addAccount("Nordea", "14534567890", 5000.30);
  }

  public static boolean test_MainAddBadAccountHandelsbanken() {
    return !testBank.addAccount("Handelsbanken", "344534567890", 5000.30);
  }

  public static boolean test_MainAddBadAccountSEB() {
    return !testBank.addAccount("SEB", "14534567890", 5000.30);
  }

  public static boolean test_MainAddBadAccountSwedbank() {
    return !testBank.addAccount("Swedbank", "145341567890", 5000.30);
  }

  public static boolean test_MainAccountExist() {
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
    printTestResultText("test_MainAddAccount: ",
                        test_MainAddAccount());
    setupAddAccountsForTesting();
    printTestResultText("test_MainCantAddAccountTwice: ",
                        test_MainCantAddAccountTwice());
    printTestResultText("test_MainAddBadAccountNordea: ",
                        test_MainAddBadAccountNordea());
    printTestResultText("test_MainAddBadAccountHandelsbanken: ",
                        test_MainAddBadAccountHandelsbanken());
    printTestResultText("test_MainAddBadAccountSEB: ",
                        test_MainAddBadAccountSEB());
    printTestResultText("test_MainAddBadAccountSwedbank: ",
                        test_MainAddBadAccountSwedbank());
    printTestResultText("test_MainAccountExist: ",
                        test_MainAccountExist());
  }
}
