package com.mlp.entities;

import java.util.Date;

import com.mlp.enums.Cargo;
import com.mlp.enums.Genero;
import com.mlp.exceptions.InvalidDateException;
import com.mlp.exceptions.InvalidNameException;

public class Funcionario extends Pessoa {

    private Date dataIngresso;
    private Cargo cargo;


    public Funcionario() {
        try {
            setDataIngresso(new Date());
            setCargo(Cargo.INDEFINIDO);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public Funcionario(
        String nome, Date dataNascimento, Genero genero,
        Date dataIngresso, Cargo cargo
    ) throws InvalidNameException, InvalidDateException {
        super(nome, dataNascimento, genero);
        setDataIngresso(dataIngresso);
        setCargo(cargo);
    }


    public Date getDataIngresso() {
        return dataIngresso;
    }

    public Cargo getCargo() {
        return cargo;
    }


    public void setDataIngresso(Date dataIngresso) throws InvalidDateException {
        if (dataIngresso.after(new Date())) {
            throw new InvalidDateException("Data de ingresso não pode ser maior que a data atual.");
        } else if (dataIngresso.before(this.getDataNascimento())) {
            throw new InvalidDateException("Data de ingresso não pode ser menor que a data de nascimento.");
        }
        this.dataIngresso = dataIngresso;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }


    @Override
    public String toString() {
        return String.format(
            "Funcionario(%s, %s, %s, %s, %s)",
            this.getNome(),
            this.getDataNascimento().toString(),
            this.getGenero().name(),
            this.getDataIngresso().toString(),
            this.getCargo().name()
        );
    }
}
