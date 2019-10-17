package fun_with_java_enums.enums.strategies;

import fun_with_java_enums.services.TokenService;
import fun_with_java_enums.beans.CustomerToken;
import fun_with_java_enums.enums.CustomerTypeEnum;

public class CustomerTokenStrategy implements CustomerTypeEnum.CustomerStrategy<CustomerToken> {

    private TokenService tokenService;

    public CustomerTokenStrategy(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public CustomerToken onConsumer() {
        return new CustomerToken("C-" + tokenService.getToken());
    }

    @Override
    public CustomerToken onMerchant() {
        return new CustomerToken("M-" + tokenService.getToken());
    }

    @Override
    public CustomerToken onShop() {
        return new CustomerToken("S-" + tokenService.getToken());
    }
}
