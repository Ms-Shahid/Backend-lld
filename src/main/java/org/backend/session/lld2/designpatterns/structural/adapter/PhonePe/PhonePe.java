public class PhonePe{

  private static BankAPI bankAPI = new YesBankAdapter();

  public static void mains(String[] args){
    
    bankAPI.transfer("ICICI", "YesBank", 1000);
  }
}