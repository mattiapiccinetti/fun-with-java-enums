package fun_with_java_enums.enums.strategies;

import fun_with_java_enums.beans.Discount;
import fun_with_java_enums.enums.CustomerTypeEnum;

public class DiscountStrategy implements CustomerTypeEnum.CustomerStrategy<Discount> {

    @Override
    public Discount onConsumer() {
        return new Discount(10);
    }

    @Override
    public Discount onMerchant() {
        return new Discount(20);
    }

    @Override
    public Discount onShop() {
        return new Discount(30);
    }
}
