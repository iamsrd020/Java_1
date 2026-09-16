package interfaces;

/*
 * UPI is one payment method.
 *
 * It implements the Payment contract, so it must provide both pay() and
 * refund(). Its implementation can be different from CreditCard's.
 */
public class UPI implements Payment {

    @Override
    public void pay() {
        System.out.println("Payment made through UPI");
    }

    @Override
    public void refund() {
        System.out.println("UPI payment refunded");
    }
}
