package com.mlp.model;

import java.util.ArrayList;
import java.util.List;

import com.mlp.entities.Aluno;

public class AlunoModel {
    
    private List<Aluno> alunos;

    public AlunoModel() {
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> getAlunos() {
        return new ArrayList<>(alunos);
    }

    public int getTotalAlunos() {
        return alunos.size();
    }

    public void listarAlunos() {
        System.out.println("\n========== ALUNOS CADASTRADOS ==========\n");
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println(aluno.toString());
            }
        }
        System.out.println("\nTotal: " + alunos.size() + " aluno(s)\n");
    }
}
