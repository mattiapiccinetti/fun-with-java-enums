package fun_with_java_enums;

import fun_with_java_enums.beans.CustomerToken;
import fun_with_java_enums.beans.Discount;
import fun_with_java_enums.enums.CustomerTypeEnum;
import fun_with_java_enums.enums.strategies.CustomerTokenStrategy;
import fun_with_java_enums.enums.strategies.DiscountStrategy;
import fun_with_java_enums.enums.strategies.ValidationStrategy;
import fun_with_java_enums.services.TokenService;

import java.util.Random;

public class App {

    public static void main(String[] args) {
        scenario1();
        scenario2();
        scenario3();
        scenario4();
        scenario5();
    }

    private static void scenario1() {
        System.out.println("\n");
        System.out.println("# Scenario 1 - PUBLIC METHOD - with known customer type");

        System.out.println(CustomerTypeEnum.CONSUMER.getCanonicalName("foo"));
        System.out.println(CustomerTypeEnum.MERCHANT.getCanonicalName("bar"));
        System.out.println(CustomerTypeEnum.SHOP.getCanonicalName("baz"));
    }

    private static void scenario2() {
        System.out.println("\n");
        System.out.println("# Scenario 2 - PUBLIC METHOD - with random customer type");

        String canonicalName = randomCustomerType().getCanonicalName("the_quick_brown_fox");

        System.out.println(canonicalName);
    }

    private static void scenario3() {
        System.out.println("\n");
        System.out.println("# Scenario 3 - ABSTRACT METHOD - with DISCOUNT strategy");

        DiscountStrategy strategy = new DiscountStrategy();
        Discount discountToApply = randomCustomerType().applyStrategy(strategy);

        System.out.println("Discount to apply: " + discountToApply.getValue() + "%");
    }

    private static void scenario4() {
        System.out.println("\n");
        System.out.println("# Scenario 4 - ABSTRACT METHOD - with VALIDATION strategy, returning a validation function");

        ValidationStrategy strategy = new ValidationStrategy();
        String name = "C_John_Doe";
        Boolean isValid = randomCustomerType().applyStrategy(strategy).apply(name);

        System.out.println("Name: " + name + " valid: " + isValid);
    }

    private static void scenario5() {
        System.out.println("\n");
        System.out.println("# Scenario 5 - ABSTRACT METHOD - with TOKEN strategy with injection");

        CustomerTokenStrategy strategy = new CustomerTokenStrategy(new TokenService());
        CustomerToken token = randomCustomerType().applyStrategy(strategy);

        System.out.println("Token: " + token.getValue());
    }

    private static CustomerTypeEnum randomCustomerType() {
        CustomerTypeEnum[] values = CustomerTypeEnum.values();
        int length = values.length;
        int index = new Random().nextInt(length);
        CustomerTypeEnum type = values[index];

        System.out.println("CustomerType generated: " + type.name());
        return type;
    }
}
