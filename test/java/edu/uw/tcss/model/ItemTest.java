package edu.uw.tcss.model;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

/**
 * All tests should pass before project completion!
 *
 * @author Charles Bryan
 * @version 1.1
 */
final class ItemTest {

    /**
     * The name of the item used in testing.
     */
    private static final String ITEM_NAME = "Item";

    /**
     * The name of the bulk item used in testing.
     */
    private static final String BULK_ITEM_NAME = "Bulk Item";

    /**
     * The price of the item used in testing.
     */
    private static final String ITEM_PRICE = ".50";

    /**
     * The bulk price of the item used in testing.
     */
    private static final String BULK_PRICE = "4.00";

    /**
     * The negative price of the item used in testing.
     */
    private static final String NEGATIVE_PRICE = "-0.01";

    /**
     * The bulk quantity of the item used in testing.
     */
    private static final int BULK_QUANTITY = 10;

    /**
     * An object of class Item to use in testing.
     */
    private static final Item TEST_ITEM = new StoreItem(ITEM_NAME, new BigDecimal(ITEM_PRICE));

    /**
     * An object of class Item to use in testing.
     */
    private static final Item TEST_BULK_ITEM =
            new StoreItem(BULK_ITEM_NAME, new BigDecimal(ITEM_PRICE),
                    BULK_QUANTITY, new BigDecimal(BULK_PRICE));

    //Empty constructor to avoid instantiation.
    private ItemTest() {
        super();
    }

    @Test
    void testConstructorEmptyItemName() {
        assertAll("Item name as empty string to constructors.",
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new StoreItem("", new BigDecimal(ITEM_PRICE),
                                BULK_QUANTITY, new BigDecimal(BULK_PRICE)),
                        "Four arg constructor does not handle empty string as an "
                                + "argument to theName properly."),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new StoreItem("", new BigDecimal(ITEM_PRICE)),
                        "Two arg constructor does not handle empty string as an "
                                + "argument to theName properly."));

    }

    @Test
    void testConstructorNullItemName() {
        assertAll("Item name as null to constructors.",
                () -> assertThrows(NullPointerException.class,
                        () -> new StoreItem(null, new BigDecimal(ITEM_PRICE),
                                BULK_QUANTITY, new BigDecimal(BULK_PRICE)),
                        "Four arg constructor does not handle null as an argument "
                                + "to theName properly."),
                () -> assertThrows(NullPointerException.class,
                        () -> new StoreItem(null, new BigDecimal(ITEM_PRICE)),
                        "Two arg constructor does not handle null as an argument "
                                + "to theName properly."));

    }

    @Test
    void testConstructorNegativeItemPrice() {
        assertAll("Item price as negative value to constructors.",
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new StoreItem(BULK_ITEM_NAME, new BigDecimal(NEGATIVE_PRICE),
                                BULK_QUANTITY, new BigDecimal(BULK_PRICE)),
                        "Four arg constructor does not handle negative value as "
                                + "an argument to thePrice properly."),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new StoreItem(ITEM_NAME, new BigDecimal(NEGATIVE_PRICE)),
                        "Two arg constructor does not handle negative value as "
                                + "an argument to thePrice properly."));

    }

    @Test
    void testConstructorNullItemPrice() {
        assertAll("Item price as null value to constructors.",
                () -> assertThrows(NullPointerException.class,
                        () -> new StoreItem(BULK_ITEM_NAME, null,
                                BULK_QUANTITY, new BigDecimal(BULK_PRICE)),
                        "Four arg constructor does not handle null as an argument "
                                + "to thePrice properly."),
                () -> assertThrows(NullPointerException.class,
                        () -> new StoreItem(ITEM_NAME, null),
                        "Two arg constructor does not handle null as an argument "
                                + "to thePrice properly."));

    }

    @Test
    void testConstructorNegativeBulkItemQuantity() {
        assertThrows(IllegalArgumentException.class,
                () -> new StoreItem(BULK_ITEM_NAME, new BigDecimal(ITEM_PRICE),
                        -1, new BigDecimal(BULK_PRICE)),
                "Four arg constructor does not handle negative value as an argument "
                        + "to theBulkQuantity properly.");
    }

    @Test
    void testConstructorNullBulkItemPrice() {
        assertThrows(IllegalArgumentException.class,
                () -> new StoreItem(BULK_ITEM_NAME, new BigDecimal(ITEM_PRICE),
                        BULK_QUANTITY, new BigDecimal(NEGATIVE_PRICE)),
                "Four arg constructor does not handle negative value as an argument "
                        + "to theBulkPrice properly.");
    }

    @Test
    void testConstructorNegativeBulkItemPrice() {
        assertThrows(NullPointerException.class,
                () -> new StoreItem(BULK_ITEM_NAME, new BigDecimal(ITEM_PRICE),
                        BULK_QUANTITY, null),
                "Four arg constructor does not handle null as an argument to "
                        + "thePrice properly.");
    }

    @Test
    void testTwoArguemntConstructor() {
        assertAll("Two argument constructor test.",
                () -> assertEquals(ITEM_NAME,
                        TEST_ITEM.getName(),
                        "Item name should be: " + ITEM_NAME),
                () -> assertEquals(new BigDecimal(ITEM_PRICE),
                        TEST_ITEM.getPrice(),
                        "Item Price should be: " + ITEM_PRICE),
                () -> assertEquals(0,
                        TEST_ITEM.getBulkQuantity(),
                        "Bulk quantity should be: 0"),
                () -> assertEquals(BigDecimal.ZERO,
                        TEST_ITEM.getBulkPrice(),
                        "Bulk Price should be: 0"));
    }

    @Test
    void testFourArgumentConstructor() {
        assertAll("Four argument constructor test.",
                () -> assertEquals(BULK_ITEM_NAME,
                        TEST_BULK_ITEM.getName(),
                        "Item name should be: " + BULK_ITEM_NAME),
                () -> assertEquals(new BigDecimal(ITEM_PRICE),
                        TEST_BULK_ITEM.getPrice(),
                        "Item Price should be: " + ITEM_PRICE),
                () -> assertEquals(BULK_QUANTITY,
                        TEST_BULK_ITEM.getBulkQuantity(),
                        "Bulk quantity should be: " + BULK_QUANTITY),
                () -> assertEquals(new BigDecimal(BULK_PRICE),
                        TEST_BULK_ITEM.getBulkPrice(),
                        "Bulk Price should be: " + BULK_PRICE));
    }

    @Test
    void testGetName() {
        assertAll("getName test.",
                () -> assertEquals(ITEM_NAME,
                        TEST_ITEM.getName(),
                        "Item name should be: " + ITEM_NAME),
                () -> assertEquals(BULK_ITEM_NAME,
                        TEST_BULK_ITEM.getName(),
                        "Item name should be: " + BULK_ITEM_NAME));
    }

    @Test
    void testGetPrice() {
        assertAll("getPrice test.",
                () -> assertEquals(new BigDecimal(ITEM_PRICE),
                        TEST_BULK_ITEM.getPrice(),
                        "Item Price should be: " + ITEM_PRICE),
                () -> assertEquals(new BigDecimal(ITEM_PRICE),
                        TEST_ITEM.getPrice(),
                        "Item Price should be: " + ITEM_PRICE));
    }

    @Test
    void testGetBulkQuantity() {
        assertAll("getBulkQuantity test.",
                () -> assertEquals(0,
                        TEST_ITEM.getBulkQuantity(),
                        "Bulk quantity should be: 0"),
                () -> assertEquals(BULK_QUANTITY,
                        TEST_BULK_ITEM.getBulkQuantity(),
                        "Bulk quantity should be: " + BULK_QUANTITY));
    }

    @Test
    void testGetBulkPrice() {
        assertAll("getBulkPrice test.",
                () -> assertEquals(BigDecimal.ZERO,
                        TEST_ITEM.getBulkPrice(),
                        "Bulk Price should be: 0"),
                () -> assertEquals(new BigDecimal(BULK_PRICE),
                        TEST_BULK_ITEM.getBulkPrice(),
                        "Bulk Price should be: " + BULK_PRICE));
    }

    @Test
    void testIsBulk() {
        assertAll("isBulk test.",
                () -> assertFalse(TEST_ITEM.isBulk(),
                        "Item should NOT be bulk"),
                () -> assertTrue(TEST_BULK_ITEM.isBulk(),
                        "Item should be bulk"));
    }

}