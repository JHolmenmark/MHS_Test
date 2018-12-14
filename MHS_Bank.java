import java.util.ArrayList;

public class MHS_Bank {
  public static ArrayList<MHS_BankAccount> bankList
  = new ArrayList<MHS_BankAccount>();

  public boolean addAccount(String bankName, String accountNr, double balance){
    if(accountGoodFormat(bankName, accountNr) && !accountExists(accountNr)) {
      MHS_BankAccount accnew = new MHS_BankAccount();
      accnew.setBankName(bankName);
      accnew.setAccountNumber(accountNr);
      accnew.setBalance(balance);
      bankList.add(accnew);
      return true;
    } else {
      return false;
    }
  }

  public boolean accountGoodFormat(String bankName, String accountNumber) {
    boolean good = false;
    if(!(accountNumber.length() == 10)) {
      return false;
    }
    switch(bankName){
      case "Nordea":
        if(accountNumber.substring(0, 4).contains("1234")) {
          good = true;
        }
        break;
      case "Handelsbanken":
        if(accountNumber.substring(0, 4).contains("1423")) {
          good = true;
        }
        break;
      case "SEB":
        if(accountNumber.substring(0, 4).contains("5531")) {
          good = true;
        }
        break;
      case "Swedbank":
        if(accountNumber.substring(0, 5).contains("99156")
        && accountNumber.substring(9).contains("9")) {
          good = true;
        }
        break;
      default:
        good = false;
        break;
    }
    return good;
  }

  public boolean accountExists(String accountNumber) {
    boolean found = false;
    for(int i = 0; i < bankList.size(); i++) {
      if(bankList.get(i).getAccountNumber().contains(accountNumber)) {
        found = true;
      }
    }
    return found;
  }
  public String makePurchase(String accountNumber, double ticketPrice) {
    String result = "";
    for(int i = 0; i < bankList.size(); i++) {
      if(bankList.get(i).getAccountNumber().contains(accountNumber)) {
        if(bankList.get(i).purchase(ticketPrice)) {
          result = bankList.get(i).getBankName();
          break;
        } else {
          result = "Insufficient Funds";
          break;
        }
      } else {
        result = "Wrong AccountNr";
      }
    }
    return result;
  }

}
