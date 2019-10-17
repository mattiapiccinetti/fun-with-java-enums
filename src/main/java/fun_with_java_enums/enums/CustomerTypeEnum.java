package fun_with_java_enums.enums;

public enum CustomerTypeEnum {
    CONSUMER {
        @Override
        public <T> T applyStrategy(CustomerStrategy<T> customerStrategy) {
            return customerStrategy.onConsumer();
        }
    },
    MERCHANT {
        @Override
        public <T> T applyStrategy(CustomerStrategy<T> customerStrategy) {
            return customerStrategy.onMerchant();
        }
    },
    SHOP {
        @Override
        public <T> T applyStrategy(CustomerStrategy<T> customerStrategy) {
            return customerStrategy.onShop();
        }
    };

    public String getCanonicalName(String name) {
        return this.name() + "_" + name;
    }

    public abstract <T> T applyStrategy(CustomerStrategy<T> customerStrategy);

    public interface CustomerStrategy<T> {
        T onConsumer();
        T onMerchant();
        T onShop();
    }
}
