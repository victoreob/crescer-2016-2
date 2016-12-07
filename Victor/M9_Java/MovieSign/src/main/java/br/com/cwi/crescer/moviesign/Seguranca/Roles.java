package br.com.cwi.crescer.moviesign.Seguranca;

import java.util.Arrays;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author Carlos H. Nonnemacher
 */
public enum Roles implements GrantedAuthority {

    USER, ADMIN;

    @Override
    public String getAuthority() {
        return toString();
    }

    public static List<Roles> valuesToList() {
        return Arrays.asList(Roles.values());
    }

}
