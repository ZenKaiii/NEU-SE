package sqat.swc.neu;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sqat.swc.neu.shop.Basket;
import sqat.swc.neu.shop.Discount;
import sqat.swc.neu.shop.PaymentResult;
import sqat.swc.neu.shop.Product;

import static org.junit.jupiter.api.Assertions.*;

public class TestBasket {

    private Basket basket = null;

    @BeforeEach
    public void setup(){
        System.out.println("Running the setup...");
        basket = new Basket();
    }

    @Test
    public void testAddProductBeforePayment(){
       assertTrue(basket.addProduct(new Product("A",12),3));
       assertEquals(1,basket.getNumberOfItems());
    }

    @Test
    public void testAddProductAfterPayment(){
        basket.addProduct(new Product("A",12),3);
        basket.pay(200); //pay success
        assertFalse(basket.addProduct(new Product("A",12),3));
    }

    @Test
    public void testAddSameProduct(){
        basket.addProduct(new Product("A",12),1);
        basket.addProduct(new Product("A",12),1);
        assertEquals(1,basket.getNumberOfItems());
        assertEquals(2,basket.findBasketItemWithProduct(new Product("A",12)).getQuantity());
    }

    @Test
    public void testAddDifferentProduct(){
        basket.addProduct(new Product("A",12),1);
        basket.addProduct(new Product("B",12),1);
        assertEquals(2,basket.getNumberOfItems());
    }

    @Test
    public void testAddNegativeProduct(){
        Throwable exception = assertThrows(IllegalArgumentException.class,()->{
            basket.addProduct(new Product("A",12),-3);
        });
    }

    @Test
    public void testAddNullProduct(){
        Throwable exception = assertThrows(NullPointerException.class,()->{
            basket.addProduct(null,12);
        });
    }

    @Test
    public void testRemoveAllProductItems(){
        basket.addProduct(new Product("A",12),1);
        assertTrue(basket.removeAllProductItems(new Product("A",12)));
        assertEquals(0,basket.getNumberOfItems());
    }

    @Test
    public void testRemoveAllProductItemsThatDoNotExist(){
        assertFalse(basket.removeAllProductItems(new Product("a",1)));
    }

    @Test
    public void testRemoveAllNull(){
        assertFalse(basket.removeAllProductItems(null));
    }

    @Test
    public void testRemoveAllProductItemsAfterPayment(){
        basket.addProduct(new Product("A",12),2);
        basket.pay(2000);
        assertFalse(basket.removeAllProductItems(new Product("A",12)));
    }

    @Test
    public void testRemoveSomeProductItems(){
        basket.addProduct(new Product("A",12),2);
        assertTrue(basket.removeSomeProductItems(new Product("A",12),1));
        assertEquals(1,basket.getNumberOfItems());
    }

    @Test
    public void testRemoveSomeProductItemsThatDoNotExist(){
        assertFalse(basket.removeSomeProductItems(new Product("A",12),1));
    }

    @Test
    public void testRemoveSomeProductThatExceedAmount(){
        basket.addProduct(new Product("A",12),2);
        assertFalse(basket.removeSomeProductItems(new Product("A",12),12));
        assertEquals(1, basket.getNumberOfItems());
    }

    @Test
    public void testRemoveSomeProductItemsAfterPayment(){
        basket.addProduct(new Product("A",12),2);
        basket.pay(2000);
        assertFalse(basket.removeSomeProductItems(new Product("A",12),1));
    }

    @Test
    public void testFindBasketItemWithProduct(){
        basket.addProduct(new Product("A",12),2);
        basket.addProduct(new Product("B",11),2);
        assertNotNull(basket.findBasketItemWithProduct(new Product("A",12)));
        assertNotNull(basket.findBasketItemWithProduct(new Product("B",11)));
    }

    @Test
    public void testFindBasketItemWithProductThatDoNotExist(){
        assertNull(basket.findBasketItemWithProduct(new Product("C",13)));
    }

    @Test
    public void testAddDiscount(){
        basket.addDiscount(new Discount("a",new Product("A",12),0,1));
        assertEquals(1,basket.getNumberOfDiscounts());
    }

    @Test
    public void testAddDiscountWithNull(){
        Throwable exception = assertThrows(NullPointerException.class,()->{
            basket.addDiscount(null);
        });
        assertEquals("Discount must not be null",exception.getMessage());
    }

    @Test
    public void testGetTotalWithNoItems(){
        assertEquals(0,basket.getTotal());
    }

    @Test
    public void testGetTotalWithSomeItems(){
        basket.addProduct(new Product("A",12),1);
        basket.addProduct(new Product("B",13),1);
        basket.addProduct(new Product("C",15),1);
        assertEquals(40,basket.getTotal());
    }

    @Test
    public void testGetTotalWithDiscounts(){
        basket.addProduct(new Product("A",10),3);
        basket.addDiscount(new Discount("Adis",new Product("A",10),1,1));
        assertEquals(20,basket.getTotal());
    }

    @Test
    public void testGetTotalWhenPriceDiscountBiggerThanTotal(){
        basket.addProduct(new Product("A",10),3);
        basket.addDiscount(new Discount("Adis",new Product("A",10),1,4));
        assertEquals(30,basket.getTotal());
    }

    @Test
    public void testPay(){
        basket.addProduct(new Product("A",10),3);
        PaymentResult result = basket.pay(40);
        assertEquals("Thank you",result.getMessage());
    }

    @Test
    public void testPayAfterPayment(){
        basket.addProduct(new Product("A",10),3);
        basket.pay(40);
        PaymentResult result = basket.pay(40);
        assertEquals("Payment already complete",result.getMessage());
    }

    @Test
    public void testPayNotEnoughCash(){
        basket.addProduct(new Product("A",10),3);
        PaymentResult result = basket.pay(20);
        assertEquals("Insufficient amount.",result.getMessage());
    }


}
