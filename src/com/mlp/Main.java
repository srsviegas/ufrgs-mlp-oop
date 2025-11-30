package com.mlp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.mlp.entities.Aluno;
import com.mlp.entities.Funcionario;
import com.mlp.entities.Pessoa;
import com.mlp.enums.Cargo;
import com.mlp.enums.Genero;
import com.mlp.enums.NivelMatricula;

public class Main {

    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        Random random = new Random();

        String[] nomes = {
            "João Silva", "Maria Santos", "Pedro Costa", "Ana Oliveira",
            "Carlos Souza", "Juliana Lima", "Rafael Alves", "Fernanda Rocha",
            "Lucas Martins", "Camila Ferreira", "Bruno Cardoso", "Patricia Mendes"
        };

        Genero[] generos = {Genero.HOMEM_CIS, Genero.MULHER_CIS, Genero.NAO_BINARIO};
        NivelMatricula[] niveis = {
            NivelMatricula.GRADUACAO, NivelMatricula.ESPECIALIZACAO,
            NivelMatricula.MESTRADO, NivelMatricula.DOUTORADO
        };
        Cargo[] cargos = {
            Cargo.ESTAGIARIO, Cargo.PROGRAMADOR_JUNIOR, Cargo.PROGRAMADOR_PLENO,
            Cargo.ANALISTA, Cargo.COORDENADOR, Cargo.GERENTE
        };

        System.out.println("\n========== CRIANDO 10 INSTÂNCIAS ALEATÓRIAS ==========\n");

        for (int i = 0; i < 10; i++) {
            int tipo = random.nextInt(3);
            String nome = nomes[random.nextInt(nomes.length)];
            Genero genero = generos[random.nextInt(generos.length)];
            
            Calendar calNascimento = Calendar.getInstance();
            calNascimento.set(1990 + random.nextInt(15), random.nextInt(12), random.nextInt(28) + 1);
            Date dataNascimento = calNascimento.getTime();

            try {
                if (tipo == 0) {
                    Pessoa pessoa = new Pessoa(nome, dataNascimento, genero);
                    pessoas.add(pessoa);
                    System.out.println("Criado: Pessoa");
                } else if (tipo == 1) {
                    String matricula = String.format("%08d", random.nextInt(100000000));
                    Calendar calMatricula = Calendar.getInstance();
                    calMatricula.set(2010 + random.nextInt(15), random.nextInt(12), random.nextInt(28) + 1);
                    Date dataMatricula = calMatricula.getTime();
                    NivelMatricula nivel = niveis[random.nextInt(niveis.length)];
                    Aluno aluno = new Aluno(nome, dataNascimento, genero, matricula, dataMatricula, nivel);
                    pessoas.add(aluno);
                    System.out.println("Criado: Aluno");
                } else {
                    Calendar calIngresso = Calendar.getInstance();
                    calIngresso.set(2010 + random.nextInt(15), random.nextInt(12), random.nextInt(28) + 1);
                    Date dataIngresso = calIngresso.getTime();
                    Cargo cargo = cargos[random.nextInt(cargos.length)];
                    Funcionario funcionario = new Funcionario(nome, dataNascimento, genero, dataIngresso, cargo);
                    pessoas.add(funcionario);
                    System.out.println("Criado: Funcionario");
                }
            } catch (Exception e) {
                System.err.println("Erro ao criar instância: " + e.getMessage());
                i--;
            }
        }

        System.out.println("\n========== IMPRIMINDO COLEÇÃO DE PESSOAS ==========\n");

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.toString());
        }

        System.out.println("\n========== FIM DO PROGRAMA ==========\n");
    }
}
