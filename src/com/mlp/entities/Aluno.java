package com.mlp.entities;

import java.util.Date;

import com.mlp.enums.Genero;
import com.mlp.enums.NivelMatricula;
import com.mlp.exceptions.InvalidDateException;
import com.mlp.exceptions.InvalidEnrollmentException;
import com.mlp.exceptions.InvalidNameException;

public class Aluno extends Pessoa {

    private String matricula;
    private Date dataMatricula;
    private NivelMatricula nivelMatricula;


    public Aluno() {
        try {
            setMatricula("00000000");
            setDataMatricula(new Date());
            setNivelMatricula(NivelMatricula.INDEFINIDO);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public Aluno(
        String nome, Date dataNascimento, Genero genero, 
        String matricula, Date dataMatricula, NivelMatricula nivelMatricula
    ) throws InvalidNameException, InvalidDateException, InvalidEnrollmentException {
        super(nome, dataNascimento, genero);
        setMatricula(matricula);
        setDataMatricula(dataMatricula);
        setNivelMatricula(nivelMatricula);
    }
    
    
    public String getMatricula() {
        return matricula;
    }
    
    public Date getDataMatricula() {
        return dataMatricula;
    }

    public NivelMatricula getNivelMatricula() {
        return nivelMatricula;
    }

    
    public void setMatricula(String matricula) throws InvalidEnrollmentException {
        if (!matricula.matches("^\\d{8}$")) {
            throw new InvalidEnrollmentException("Matricula deve possuir 8 caractéres numéricos.");
        }
        this.matricula = matricula;
    }

    public void setDataMatricula(Date dataMatricula) throws InvalidDateException {
        if (dataMatricula.after(new Date())) {
            throw new InvalidDateException("Data de matrícula não pode ser maior que a data atual.");
        } else if (dataMatricula.before(this.getDataNascimento())) {
            throw new InvalidDateException("Data de matrícula não pode ser menor que a data de nascimento.");
        }
        this.dataMatricula = dataMatricula;
    }
    
    public void setNivelMatricula(NivelMatricula nivelMatricula) {
        this.nivelMatricula = nivelMatricula;
    }


    @Override
    public String toString() {
        return String.format(
            "Aluno(%s, %s, %s, %s, %s, %s)",
            this.getNome(),
            this.getDataNascimento().toString(),
            this.getGenero().name(),
            this.getMatricula(),
            this.getDataMatricula().toString(),
            this.getNivelMatricula().name()
        );
    }
}
