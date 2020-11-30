
package com.bank.servicios;

import com.bank.dominio.CuentaBancaria;
import com.bank.excepciones.BankException;
import java.sql.SQLException;
import java.util.List;

public interface GestionCuentasBancariasInterface {
    
    public List<CuentaBancaria> getCuentasBancariasPorCliente(int idCliente) throws BankException, SQLException;
    public void altaNuevaCuenta(int idCliente, CuentaBancaria cuenta) throws BankException, SQLException;
    public void ingresar(String iban, double importe) throws BankException, SQLException;
    public void sacar(String iban, double importe) throws BankException, SQLException;
    public void hacerTransferencia(String ibanOrigen, String ibanDestino, double importe) throws BankException;
    
}
