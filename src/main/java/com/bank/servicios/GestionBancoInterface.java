
package com.bank.servicios;

import com.bank.dominio.Banco;
import com.bank.excepciones.BankException;
import java.sql.SQLException;


public interface GestionBancoInterface {
    
    public Banco getBancoPorId(int idBanco) throws BankException, SQLException;
    
}
