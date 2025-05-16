package com.example.agendinaBE.service.userDetails;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.agendinaBE.model.UtenteEntity;
import com.example.agendinaBE.repository.UtenteRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UtenteEntity utente = utenteRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato: " + username));
        String ruolo = utente.getTipo_utenti().getTipo();
        List<GrantedAuthority> autorithies = List.of(new SimpleGrantedAuthority("ROLE_"+ ruolo));

        return new User(utente.getUsername(), utente.getPassword(), autorithies);
    }
}

