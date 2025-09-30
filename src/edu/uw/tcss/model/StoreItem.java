
package edu.uw.tcss.model;

import java.math.BigDecimal;

/**
 * Creates a StoreItem that has a name and price, as well as the option for bulk pricing.
 * @author QuinnSuligoy
 * @version 1.0
 */
public final class StoreItem implements Item {
    /**
     * Name of the store item
     */
    private final String myName;
    /**
     * Price of the store item
     */
    private final BigDecimal myPrice;
    /**
     * Quantity of the store item that can be bought in bulk, if it is a bulk item
     */
    private final int myBulkQuantity;
    /**
     * Price of the store item if bought in bulk
     */
    private final BigDecimal myBulkPrice;
    /**
     * Whether the store item is available in bulk or not
     */
    private final boolean myIsBulk;

    /**
     * Creates a store item using a name and price.
     * @param theName name of the store item
     * @param thePrice price of the store item
     */
    public StoreItem(final String theName, final BigDecimal thePrice) {
        super();
        if (null == theName || null == thePrice) {
            throw new NullPointerException();
        } else if (theName.isEmpty() || 0 > thePrice.compareTo(BigDecimal.ZERO)) {
            throw new IllegalArgumentException();
        }

        myName = theName;
        myPrice = thePrice;
        myBulkQuantity = 0;
        myBulkPrice = BigDecimal.ZERO;
        myIsBulk = false;
    }

    /**
     * Creates a store item available in bulk using a name, price, bulk quantity,
     * and bulk price.
     * @param theName name of the store item
     * @param thePrice price of the store item
     * @param theBulkQuantity quantity of store item when bought in bulk
     * @param theBulkPrice price of store item when bought in bulk
     */
    public StoreItem(final String theName, final BigDecimal thePrice,
                     final int theBulkQuantity, final BigDecimal theBulkPrice) {
        super();
        if (null == theName || null == thePrice || null == theBulkPrice) {
            throw new NullPointerException();
        } else if (theName.isEmpty() || 0 > thePrice.compareTo(BigDecimal.ZERO)
                || 0 > theBulkQuantity || 0 > theBulkPrice.compareTo(BigDecimal.ZERO)) {
            throw new IllegalArgumentException();
        }

        myName = theName;
        myPrice = thePrice;
        myBulkQuantity = theBulkQuantity;
        myBulkPrice = theBulkPrice;
        myIsBulk = true;
    }


    @Override
    public String getName() {
        return myName;
    }


    @Override
    public BigDecimal getPrice() {
        return myPrice;
    }


    @Override
    public int getBulkQuantity() {
        return myBulkQuantity;
    }


    @Override
    public BigDecimal getBulkPrice() {
        return myBulkPrice;
    }


    @Override
    public boolean isBulk() {
        return myIsBulk;
    }


    /**
     * Returns a string representation of the store item.
     * @return string representation of the store item
     */
    public String toString() {
        String toReturn = myName + " $" +  myPrice;
        if (myIsBulk) {
            toReturn += " Bulk: " +  myBulkQuantity + " for $" +   myBulkPrice;
        }
        return toReturn;
    }

}
