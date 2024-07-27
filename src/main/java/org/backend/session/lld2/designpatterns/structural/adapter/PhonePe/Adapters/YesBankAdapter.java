public class YesBankAdapter implements BankAPI{

  // private YesBank yesBank;

  // public YesBankAdapter(YesBank yesBank){
  //   this.yesBank = yesBank;
  // }

  private YesBank yesBank = new YesBank();

  @Override
  public void transfer(String from,String to, int amount){
    yesBank.doPayment(from, to, amount);
  }

  @Override
  public long getBalance(String accountNumber){
    return 0;
  }

  @Override
  public void addMoney(String accountNumber, int amount){
    yesBank.doPayment(accountNumber, accountNumber, amount);
  }
  
}