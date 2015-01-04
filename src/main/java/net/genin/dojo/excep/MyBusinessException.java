package net.genin.dojo.excep;

/**
 */
public class MyBusinessException extends Exception {

    public final String label;

    public MyBusinessException(String label) {
        super();
        this.label = label;
    }
}
