package org.eclipse.jakarta.hello.adapters;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.DAO.DaoContoCorrente;
import org.example.DAO.DaoException;
import org.example.DTO.ContoCorrente;

import java.util.List;

@Path("contocorrente")
public class ContoCorrenteResource {

    static DaoContoCorrente dao = new DaoContoCorrente();
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void createContoCorrente(ContoCorrente nuovoContoCorrente) throws DaoException {
        dao.create(nuovoContoCorrente);
    }

    @GET
    @Path("/{cognome}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ContoCorrente> getContoCorrenteByCognome(@PathParam("cognome") String cognome) throws DaoException {
        List<ContoCorrente> contoCorrente = dao.findByCognome(cognome);
        if(contoCorrente == null){
            throw new NotFoundException("Cognome sul conto corrente non trovato");
        }
        return contoCorrente;
    }

    @GET
    @Path("/{codiceFiscale}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ContoCorrente> getContoCorrenteByCodiceFiscale(@PathParam("codiceFiscale") String codiceFiscale) throws DaoException {
        List<ContoCorrente> contoCorrente = dao.findByCodiceFiscale(codiceFiscale);
        if(contoCorrente == null){
            throw new NotFoundException("Codice fiscale sul conto corrente non trovato");
        }
        return contoCorrente;
    }
}
