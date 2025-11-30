package com.mlp;

import java.util.Date;

import entities.Aluno;
import entities.Pessoa;
import enums.Genero;

public class Main {

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        Aluno aluno = new Aluno();

        System.out.println("\n======== CONSTRUTORES VAZIOS ========\n");

        System.out.println(pessoa.toString());
        System.out.println(aluno.toString());

        System.out.println("\n======== SETTERS ========\n");

        try { pessoa.setNome("Sandro Viégas"); } catch (Exception e) {}
        System.out.println("Após mudança -> " + pessoa.toString());

        try { pessoa.setDataNascimento(new Date("2003/05/16")); } catch (Exception e) {}
        System.out.println("Após mudança -> " + pessoa.toString());

        try { pessoa.setGenero(Genero.HOMEM_CIS); } catch (Exception e) {}
        System.out.println("Após mudança -> " + pessoa.toString());

        try { aluno.setNome("Sandro"); } catch (Exception e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

        try { aluno.setDataNascimento(new Date("2026/05/16")); } catch (Exception e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

        try { aluno.setDataMatricula(new Date("2026/05/16")); } catch (Exception e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

        try { 
            aluno.setDataNascimento(new Date("2003/05/16"));
            aluno.setDataMatricula(new Date("2002/05/16"));
        } catch (Exception e) {
            System.out.println("[ERRO] " + e.getMessage());
        }

        try { aluno.setMatricula("342978");; } catch (Exception e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
    }
}
