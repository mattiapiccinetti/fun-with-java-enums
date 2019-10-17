package fun_with_java_enums.services;

import java.util.UUID;

public class TokenService {

    public String getToken() {
        return UUID.randomUUID().toString();
    }
}
