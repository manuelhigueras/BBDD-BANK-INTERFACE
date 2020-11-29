/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.dominio;

import com.bank.excepciones.BankException;
import com.bank.servicios.GestionCuentasBancariasInterface;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author user
 */
public class CuentaBancaria{
    private String Iban;
    private int idCuenta, idCliente;
    private double saldo;

    public CuentaBancaria(String Iban, int idCuenta, int idCliente, double saldo) {
        this.Iban = Iban;
        this.idCuenta = idCuenta;
        this.idCliente = idCliente;
        this.saldo = saldo;
    }

    public CuentaBancaria() {
        this.Iban = "";
        this.idCuenta = 0;
        this.idCliente = 0;
        this.saldo = 0;
    }

    public String getIban() {
        return Iban;
    }

    public void setIban(String Iban) {
        this.Iban = Iban;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.Iban);
        hash = 97 * hash + this.idCuenta;
        hash = 97 * hash + this.idCliente;
        hash = (int) (97 * hash + this.saldo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CuentaBancaria other = (CuentaBancaria) obj;
        if (this.idCuenta != other.idCuenta) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (this.saldo != other.saldo) {
            return false;
        }
        if (!Objects.equals(this.Iban, other.Iban)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cuentasBancarias{" + "Iban=" + Iban + ", idCuenta=" + idCuenta + ", idCliente=" + idCliente + ", saldo=" + saldo + '}';
    }
    
}
