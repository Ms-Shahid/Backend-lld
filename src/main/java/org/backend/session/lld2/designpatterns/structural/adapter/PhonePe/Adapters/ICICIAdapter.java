public class ICICIAdapter implements BankAPI{

  // private ICICIBank iciciBank;

  // public ICICIAdapter(ICICIBank iciciBank){
  //   this.iciciBank = iciciBank;
  // }

  private ICICIBank iciciBank = new ICICIBank();

  @Override
  public void transfer(String from, String to, int amount){
    iciciBank.makePayment(from, to, amount);
  }

  @Override
  public long getBalance(String accountNumber){
    return iciciBank.getBalance(accountNumber);
  }

  @Override
  public void addMoney(String accountNumber, int amount){
    iciciBank.addMoney(accountNumber, amount);
  }
}