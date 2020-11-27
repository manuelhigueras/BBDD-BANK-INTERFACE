
package com.bank.servicios;

import com.bank.dominio.Cliente;
import com.bank.excepciones.BankException;
import java.sql.SQLException;
import java.util.List;

public interface GestionClienteInterface {
    public List<Cliente> getClientesPorIdBanco(int idBanco) throws BankException, SQLException;;
}
