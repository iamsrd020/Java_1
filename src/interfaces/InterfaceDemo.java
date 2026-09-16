package interfaces;

/*
 * This class runs the interface assignment.
 *
 * We use Payment references for both objects. This means the program depends
 * on the common Payment contract, not on one particular payment method.
 * Later, another class such as PayPal could implement Payment without
 * changing the code that uses pay() and refund().
 */
public class InterfaceDemo {

    public static void main(String[] args) {
        Payment upi = new UPI();
        upi.pay();
        upi.refund();

        Payment creditCard = new CreditCard();
        creditCard.pay();
        creditCard.refund();
    }
}
