import java.util.Enumeration;

public abstract class Statement {
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

  protected abstract String getBeginningText(Customer aCustomer);

  protected abstract String getContentText(Rental aRental);

  protected abstract String getEndText(Customer aCostumer);
}