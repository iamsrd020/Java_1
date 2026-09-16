package interfaces;

/*
 * CreditCard is another payment method.
 *
 * It follows the same Payment contract, but its internal payment and refund
 * behavior is specific to credit cards.
 */
public class CreditCard implements Payment {

    @Override
    public void pay() {
        System.out.println("Payment made through Credit Card");
    }

    @Override
    public void refund() {
        System.out.println("Credit Card payment refunded");
    }
}
