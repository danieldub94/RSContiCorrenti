package org.eclipse.jakarta.hello.ports;

import jakarta.ws.rs.core.Configurable;
import jakarta.ws.rs.core.Response;
import org.example.DTO.ContoCorrente;

public interface IBusiness {
    Response getByCognome(String cognome);
    Response getByCodiceFiscale(String codiceFiscale);
    Response create(ContoCorrente conto);
}
