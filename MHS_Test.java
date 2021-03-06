public class MHS_Test {
  public static MHS_Main testMain = new MHS_Main();
  public static MHS_BankAccount dummyAccount = new MHS_BankAccount();
  public static int testsfailedcount = 0;
  public static final String ANSI_GREEN  = "\u001B[32m";
  public static final String ANSI_RED  = "\u001B[31m";
  public static final String ANSI_RESET = "\u001B[0m";

  public static void setupAccountsForTesting() {
    testMain.allBanks.addAccount("Nordea", "1234567890", 5000.30);
    testMain.allBanks.addAccount("SEB", "5531567890", 150.12);
    testMain.allBanks.addAccount("Swedbank", "9915612349", 4200.48);
    testMain.allBanks.addAccount("Handelsbanken", "1423567890", 200.25);
  }

  public static boolean test_MainPurchaseTicketNordea() {
    return testMain.purchaseTicket("1234567890", 22.50).equals("Nordea");
  }

  public static boolean test_MainPurchaseTicketHandelsBanken() {
    return testMain.purchaseTicket("1423567890", 22.50).equals("Handelsbanken");
  }

  public static boolean test_MainPurchaseTicketSEB() {
    return testMain.purchaseTicket("5531567890", 22.50).equals("SEB");
  }

  public static boolean test_MainPurchaseTicketSwedbank() {
    return testMain.purchaseTicket("9915612349", 22.50).equals("Swedbank");
  }

  public static boolean test_MainPurchaseTicketInsufficientFunds() {
    return testMain.purchaseTicket("1423567890", 220.50).equals("Insufficient Funds");
  }

  public static boolean test_MainPurchaseTicketWrongAccountNr() {
    return testMain.purchaseTicket("1435690", 22.50).equals("Wrong AccountNr");
  }


  public static boolean test_BankAddAccount() {
    return testMain.allBanks.addAccount("Nordea", "1234588730", -300.30);
  }

  public static boolean test_BankCantAddAccountTwice() {
    return !testMain.allBanks.addAccount("Nordea", "1234588730", 5000.30);
  }

  public static boolean test_BankAddBadAccountNordea() {
    return !testMain.allBanks.addAccount("Nordea", "1354545645", 5000.30);
  }

  public static boolean test_BankAddBadAccountHandelsbanken() {
    return !testMain.allBanks.addAccount("Handelsbanken", "3445345678", 5000.30);
  }

  public static boolean test_BankAddBadAccountSEB() {
    return !testMain.allBanks.addAccount("SEB", "1453456789", 5000.30);
  }

  public static boolean test_BankAddBadAccountSwedbank() {
    return !testMain.allBanks.addAccount("Swedbank", "1453415678", 5000.30);
  }

  public static boolean test_BankAddBadAccountTooLong() {
    return !testMain.allBanks.addAccount("SEB", "553145678905544", 5000.30);
  }

  public static boolean test_BankAddBadAccountTooShort() {
    return !testMain.allBanks.addAccount("SEB", "5531456", 5000.30);
  }

  public static boolean test_BankAccountExist() {
    return testMain.allBanks.accountExists("1234567890");
  }

  public static boolean test_BankPurchaseTicketNordea() {
    return testMain.allBanks.makePurchase("1234567890", 22.50).equals("Nordea");
  }

  public static boolean test_BankPurchaseTicketHandelsBanken() {
    return testMain.allBanks.makePurchase("1423567890",
                                           22.50).equals("Handelsbanken");
  }

  public static boolean test_BankPurchaseTicketSEB() {
    return testMain.allBanks.makePurchase("5531567890", 22.50).equals("SEB");
  }

  public static boolean test_BankPurchaseTicketSwedbank() {
    return testMain.allBanks.makePurchase("9915612349", 22.50).equals("Swedbank");
  }

  public static boolean test_BankPurchaseTicketInsufficientFunds() {
    return testMain.allBanks.makePurchase("1423567890",
                                           220.50).equals("Insufficient Funds");
  }

  public static boolean test_BankPurchaseTicketWrongAccountNr() {
    return testMain.allBanks.makePurchase("1435690", 22.50).equals("Wrong AccountNr");
  }


  public static boolean test_BankAccountStartValueOfBankName() {
    return dummyAccount.getBankName().equals("");
  }
  public static boolean test_BankAccountStartValueOfAccountNumber() {
    return dummyAccount.getAccountNumber().equals("");
  }
  public static boolean test_BankAccountStartValueOfBalance() {
    return dummyAccount.getBalance() == 0.0;
  }

  public static boolean test_BankAccountSetBankName() {
    dummyAccount.setBankName("Nordea");
    return dummyAccount.getBankName().equals("Nordea");
  }
  public static boolean test_BankAccountSetAccountNumber() {
    dummyAccount.setAccountNumber("1234098765");
    return dummyAccount.getAccountNumber().equals("1234098765");
  }
  public static boolean test_BankAccountSetBalance() {
    dummyAccount.setBalance(42.24);
    return dummyAccount.getBalance() == 42.24;
  }
  public static boolean test_BankAccountPurchase() {
    return dummyAccount.purchase(42.24);
  }
  public static boolean test_BankAccountPurchaseWithInsufficientFunds() {
    return !dummyAccount.purchase(42.24);
  }

  private static void printTestResultText(String testName, boolean resultOfTest
  ){
    String shuffle = "";
    for(int i = 0; i < (50 - testName.length()); i++){
      shuffle = shuffle + " ";
    }
    System.out.print(testName + shuffle);
    if(resultOfTest){
      System.out.println(ANSI_GREEN + "PASSED" + ANSI_RESET);
    } else {
      System.out.println(ANSI_RED + "FAILED" + ANSI_RESET);
      testsfailedcount += 1;
    }
  }

  public static void main(String[] args){
    setupAccountsForTesting();
    System.out.println("Test Results for MHS_Main: ");
    printTestResultText("test_BankAccountExist: ",
                        test_BankAccountExist());
    printTestResultText("test_MainPurchaseTicketNordea: ",
                        test_MainPurchaseTicketNordea());
    printTestResultText("test_MainPurchaseTicketHandelsBanken: ",
                        test_MainPurchaseTicketHandelsBanken());
    printTestResultText("test_MainPurchaseTicketSEB: ",
                        test_MainPurchaseTicketSEB());
    printTestResultText("test_MainPurchaseTicketSwedbank: ",
                        test_MainPurchaseTicketSwedbank());
    printTestResultText("test_MainPurchaseTicketInsufficientFunds: ",
                        test_MainPurchaseTicketInsufficientFunds());
    printTestResultText("test_MainPurchaseTicketWrongAccountNr: ",
                        test_MainPurchaseTicketWrongAccountNr());
    System.out.println("Total nr of tests failed so far: " + testsfailedcount);
    System.out.println("Test Results for MHS_Bank: ");
    printTestResultText("test_BankAddAccount: ",
                        test_BankAddAccount());
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
    printTestResultText("test_BankAccountExist: ",
                        test_BankAccountExist());
    printTestResultText("test_BankPurchaseTicketNordea: ",
                        test_BankPurchaseTicketNordea());
    printTestResultText("test_BankPurchaseTicketHandelsBanken: ",
                        test_BankPurchaseTicketHandelsBanken());
    printTestResultText("test_BankPurchaseTicketSEB: ",
                        test_BankPurchaseTicketSEB());
    printTestResultText("test_BankPurchaseTicketSwedbank: ",
                        test_BankPurchaseTicketSwedbank());
    printTestResultText("test_BankPurchaseTicketInsufficientFunds: ",
                        test_BankPurchaseTicketInsufficientFunds());
    printTestResultText("test_BankPurchaseTicketWrongAccountNr: ",
                        test_BankPurchaseTicketWrongAccountNr());
    System.out.println("Total nr of tests failed so far: " + testsfailedcount);
    System.out.println("Test Results for MHS_BankAccount: ");
    printTestResultText("test_BankAccountStartValueOfBankName: ",
                        test_BankAccountStartValueOfBankName());
    printTestResultText("test_BankAccountStartValueOfAccountNumber: ",
                        test_BankAccountStartValueOfAccountNumber());
    printTestResultText("test_BankAccountStartValueOfBalance: ",
                        test_BankAccountStartValueOfBalance());
    printTestResultText("test_BankAccountSetBankName: ",
                        test_BankAccountSetBankName());
    printTestResultText("test_BankAccountSetAccountNumber: ",
                        test_BankAccountSetAccountNumber());
    printTestResultText("test_BankAccountSetBalance: ",
                        test_BankAccountSetBalance());
    printTestResultText("test_BankAccountPurchase: ",
                        test_BankAccountPurchase());
    printTestResultText("test_BankAccountPurchaseWithInsufficientFunds: ",
                        test_BankAccountPurchaseWithInsufficientFunds());

    System.out.println("Total nr of tests failed so far: " + testsfailedcount);
  }
}
