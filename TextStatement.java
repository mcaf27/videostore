import java.util.Enumeration;

public class TextStatement extends Statement {
  public String value(Customer aCustomer) {
    Enumeration rentals = aCustomer.getRentals();
    
    String result = getBeginningText(aCustomer);

    while (rentals.hasMoreElements()) {
        Rental each = (Rental) rentals.nextElement();
        //show figures for this rental
        result += getContentText(each);
    }
    //add footer lines
    result += getEndText(aCustomer);
    return result;
  }

  private String getBeginningText(Customer aCustomer) {
    return "Rental Record for " + aCustomer.getName() +
    "\n";
  }

  private String getContentText(Rental aRental) {
    return "\t" + aRental.getMovie().getTitle()+ "\t" +
        String.valueOf(aRental.getCharge()) + "\n";
  }

  private String getEndText(Customer aCustomer) {
    String result = "Amount owed is " +
    String.valueOf(aCustomer.getTotalCharge()) + "\n";
    result += "You earned " +
    String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
    " frequent renter points";
    return result;
  }
}