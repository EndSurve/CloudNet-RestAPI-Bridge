package api.endsurve.restapi.auth;

import org.jetbrains.annotations.NotNull;

public interface BridgeAuth {

    @NotNull
    String getURL();

    @NotNull
    String getUser();

    @NotNull
    String getToken();

}
