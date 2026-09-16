package interfaces;

/*
 * INTERFACE:
 *
 * An interface is a contract. It describes what a class must do, but the
 * implementing class decides how to do it.
 *
 * Why interfaces are useful:
 * - They provide a common set of methods for unrelated classes.
 * - They support loose coupling: code can work with Payment instead of
 *   depending on one specific payment type.
 * - A class can implement more than one interface.
 *
 * Any class that implements Payment must provide pay() and refund().
 */
public interface Payment {

    void pay();

    void refund();
}
