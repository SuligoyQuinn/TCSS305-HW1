
package edu.uw.tcss.model;

import java.math.BigDecimal;


public final class StoreItem implements Item {

    private String myName;
    private BigDecimal myPrice;
    private int myBulkQuantity;
    private BigDecimal myBulkPrice;
    private boolean myIsBulk;

    public StoreItem(final String theName, final BigDecimal thePrice) {
        if (null == theName || null == thePrice) {
            throw new NullPointerException();
        } else if (theName.isEmpty() || 0 > thePrice.compareTo(BigDecimal.ZERO)) {
            throw new IllegalArgumentException();
        }

        myName = theName;
        myPrice = thePrice;
    }

    public StoreItem(final String theName, final BigDecimal thePrice, final int theBulkQuantity, final BigDecimal theBulkPrice) {
        if (null == theName || null == thePrice || null == theBulkPrice) {
            throw new NullPointerException();
        } else if (theName.isEmpty() || 0 > thePrice.compareTo(BigDecimal.ZERO) || 0 >  theBulkQuantity || 0 > theBulkPrice.compareTo(BigDecimal.ZERO)) {
            throw new IllegalArgumentException();
        }
    }


    public String getName() {
        return null;
    }


    public BigDecimal getPrice() {
        return null;
    }


    public int getBulkQuantity() {
        return 0;
    }


    public BigDecimal getBulkPrice() {
        return null;
    }


    public boolean isBulk() {
        return false;
    }

    public String toString() {
        return null;
    }

}
