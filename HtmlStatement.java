import java.util.Enumeration;

public class HtmlStatement extends Statement {
   public String value(Customer aCustomer) {
      Enumeration rentals = aCustomer.getRentals();

      String result = getBeginningText(aCustomer);

      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();
         //show figures for each rental
         result += getContentText(each);
      }
      //add footer lines
      result += getEndText(aCustomer);
      return result;
   }

  private String getBeginningText(Customer aCustomer) {
    return "<H1>Rentals for <EM>" + aCustomer.getName() +
      "</EM></H1><P>\n";
  }

  private String getContentText(Rental aRental) {
    return aRental.getMovie().getTitle()+ ": " +
         String.valueOf(aRental.getCharge()) + "<BR>\n";
  }

  private String getEndText(Customer aCustomer) {
    String result = "<P>You owe <EM>" +
    String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n";
    result += "On this rental you earned <EM>" + 
    String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
    "</EM> frequent renter points<P>";
    return result;
  }
}