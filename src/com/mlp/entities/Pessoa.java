package com.mlp.entities;
import java.util.Date;

import com.mlp.enums.Genero;
import com.mlp.exceptions.InvalidDateException;
import com.mlp.exceptions.InvalidNameException;


public class Pessoa {    

    private String nome;
    private Date dataNascimento;
    private Genero genero;

    public Pessoa() {
        try {
            setNome("Nome Indefinido");
            setDataNascimento(new Date());
            setGenero(Genero.INDEFINIDO);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public Pessoa(String nome, Date dataNascimento, Genero genero) 
        throws InvalidNameException, InvalidDateException
    {
        setNome(nome);
        setDataNascimento(dataNascimento);
        setGenero(genero);
    }


    public String getNome() {
        return this.nome;
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    }

    public Genero getGenero() {
        return this.genero;
    }


    public void setNome(String nome) throws InvalidNameException {
        if (nome != null && nome.split(" ").length < 2) {
            throw new InvalidNameException("Obrigatório nome e sobrenome.");
        } else if (nome.matches(".*\\d.*")) {
            throw new InvalidNameException("Nome não pode conter números.");
        }
        this.nome = nome;
    }

    public void setDataNascimento(Date dataNascimento) throws InvalidDateException {
        if (dataNascimento.after(new Date())) {
            throw new InvalidDateException("Data de nascimento não pode ser maior que a data atual.");
        }
        this.dataNascimento = dataNascimento;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }


    @Override
    public String toString() {
        return String.format(
            "Pessoa(%s, %s, %s)",
            this.getNome(),
            this.getDataNascimento() != null
                ? this.getDataNascimento().toString()
                : null,
            this.getGenero() != null 
                ? this.getGenero().name()
                : null
        );
    }
}
