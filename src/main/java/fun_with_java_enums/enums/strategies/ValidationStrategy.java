package fun_with_java_enums.enums.strategies;

import fun_with_java_enums.enums.CustomerTypeEnum;

import java.util.function.Function;

public class ValidationStrategy implements CustomerTypeEnum.CustomerStrategy<Function<String, Boolean>> {

    @Override
    public Function<String, Boolean> onConsumer() {
        return name -> name.startsWith("C_");
    }

    @Override
    public Function<String, Boolean> onMerchant() {
        return name -> name.startsWith("M_");
    }

    @Override
    public Function<String, Boolean> onShop() {
        return name -> name.startsWith("S_");
    }
}
