package br.com.cwi.crescer.moviesign.Seguranca;

import br.com.cwi.crescer.moviesign.Servico.UsuarioServico;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Victor Bittencourt
 */
@Service
public class CrescerUserDetailsService implements UserDetailsService {

    private static final String CRESCER = "crescer";
    UsuarioServico usuario;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.isEmpty()) {
            throw new UsernameNotFoundException(String.format("User with username=%s was not found", username));
        }
        
        
        //return null;
        return new User(username, new BCryptPasswordEncoder().encode(CRESCER), Roles.valuesToList());
    }

}
