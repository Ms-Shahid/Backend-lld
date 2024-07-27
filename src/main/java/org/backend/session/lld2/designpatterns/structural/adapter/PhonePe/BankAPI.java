public interface BankAPI{

  void transfer(String from,String to, int amount);

  long getBalance(String accountNumber);

  void addMoney(String accountNumber, int amount);
  
}