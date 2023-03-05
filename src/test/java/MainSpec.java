import org.example.CheckOut;
import org.example.ICheckOut;
import org.example.IPriceRule;
import org.example.PriceRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Testable
public class MainSpec {

    private static final List<IPriceRule> PRICE_RULES = new ArrayList<>(
            Arrays.asList(
                    new PriceRule("A", 50, 3, 130),
                    new PriceRule("B", 30, 2, 45),
                    new PriceRule("C", 20),
                    new PriceRule("D", 15)
            )
    );

    @Test
    void kata_test() {
        Assertions.assertEquals(  0, getPrice(""));
        Assertions.assertEquals( 50, getPrice("A"));
        Assertions.assertEquals( 80, getPrice("AB"));
        Assertions.assertEquals(115, getPrice("CDBA"));

        Assertions.assertEquals(100, getPrice("AA"));
        Assertions.assertEquals(130, getPrice("AAA"));
        Assertions.assertEquals(180, getPrice("AAAA"));
        Assertions.assertEquals(230, getPrice("AAAAA"));
        Assertions.assertEquals(260, getPrice("AAAAAA"));

        Assertions.assertEquals(160, getPrice("AAAB"));
        Assertions.assertEquals(175, getPrice("AAABB"));
        Assertions.assertEquals(190, getPrice("AAABBD"));
        Assertions.assertEquals(190, getPrice("DABABA"));
    }

    @Test
    void test_incremental() {
        ICheckOut checkOut = new CheckOut(PRICE_RULES);
        Assertions.assertEquals(0, checkOut.getTotal());
        checkOut.scan("A");
        Assertions.assertEquals(50, checkOut.getTotal());
        checkOut.scan("B");
        Assertions.assertEquals(80, checkOut.getTotal());
        checkOut.scan("A");
        Assertions.assertEquals(130, checkOut.getTotal());
        checkOut.scan("A");
        Assertions.assertEquals(160, checkOut.getTotal());
        checkOut.scan("B");
        Assertions.assertEquals(175, checkOut.getTotal());
    }

    private int getPrice(String goods) {
        ICheckOut checkOut = new CheckOut(PRICE_RULES);
        String[] itemIdentifiers = goods.split("");
        for (String itemIdentifier : itemIdentifiers) {
            checkOut.scan(itemIdentifier);
        }
        return checkOut.getTotal();
    }
}
