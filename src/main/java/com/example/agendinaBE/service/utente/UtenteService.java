package com.example.agendinaBE.service.utente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.agendinaBE.model.TipoUtenteEntity;
import com.example.agendinaBE.model.UtenteEntity;
import com.example.agendinaBE.repository.TipoUtenteRepository;
import com.example.agendinaBE.repository.UtenteRepository;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private TipoUtenteRepository tipoUtenteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UtenteEntity creaUtente(String username, String passwordChiara, Long tipo_utenti_id) {
        UtenteEntity utente = new UtenteEntity();
       // Cripta con BCrypt
        
        TipoUtenteEntity tipo = tipoUtenteRepository.findById(tipo_utenti_id)
        .orElseThrow(() -> new RuntimeException("Tipo Utente non trovato"));
        utente.setUsername(username);
        utente.setPassword(passwordEncoder.encode(passwordChiara));
        utente.setTipo_utenti(tipo);
        return utenteRepository.save(utente);
    }
}
