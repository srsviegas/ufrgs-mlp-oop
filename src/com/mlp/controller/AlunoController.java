package com.mlp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mlp.entities.Aluno;
import com.mlp.enums.Genero;
import com.mlp.enums.NivelMatricula;
import com.mlp.exceptions.InvalidDateException;
import com.mlp.exceptions.InvalidEnrollmentException;
import com.mlp.exceptions.InvalidNameException;
import com.mlp.model.AlunoModel;
import com.mlp.view.AlunoView;

public class AlunoController {

    private AlunoModel model;
    private AlunoView view;
    private SimpleDateFormat dateFormat;

    public AlunoController(AlunoModel model, AlunoView view) {
        this.model = model;
        this.view = view;
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.dateFormat.setLenient(false);

        inicializarEventos();
    }

    private void inicializarEventos() {
        view.adicionarListenerCadastrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarAluno();
            }
        });

        view.adicionarListenerLimpar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.limparCampos();
            }
        });

        view.setOnClose(new Runnable() {
            @Override
            public void run() {
                finalizarAplicacao();
            }
        });
    }

    private void cadastrarAluno() {
        try {
            String nome = view.getNome();
            String dataNascimentoStr = view.getDataNascimento();
            Genero genero = view.getGenero();
            String matricula = view.getMatricula();
            String dataMatriculaStr = view.getDataMatricula();
            NivelMatricula nivelMatricula = view.getNivelMatricula();

            if (nome.isEmpty() || dataNascimentoStr.isEmpty() || 
                matricula.isEmpty() || dataMatriculaStr.isEmpty()) {
                view.exibirMensagemErro("Todos os campos devem ser preenchidos.");
                return;
            }

            Date dataNascimento;
            Date dataMatricula;

            try {
                dataNascimento = dateFormat.parse(dataNascimentoStr);
            } catch (ParseException e) {
                view.exibirMensagemErro("Data de nascimento inválida. Use o formato dd/MM/yyyy.");
                return;
            }

            try {
                dataMatricula = dateFormat.parse(dataMatriculaStr);
            } catch (ParseException e) {
                view.exibirMensagemErro("Data de matrícula inválida. Use o formato dd/MM/yyyy.");
                return;
            }

            Aluno aluno = new Aluno(nome, dataNascimento, genero, 
                                   matricula, dataMatricula, nivelMatricula);

            model.adicionarAluno(aluno);
            view.exibirMensagemSucesso("Aluno cadastrado com sucesso!\nTotal de alunos: " + 
                                      model.getTotalAlunos());
            view.limparCampos();

        } catch (InvalidNameException e) {
            view.exibirMensagemErro("Erro no nome: " + e.getMessage());
        } catch (InvalidDateException e) {
            view.exibirMensagemErro("Erro na data: " + e.getMessage());
        } catch (InvalidEnrollmentException e) {
            view.exibirMensagemErro("Erro na matrícula: " + e.getMessage());
        } catch (Exception e) {
            view.exibirMensagemErro("Erro inesperado: " + e.getMessage());
        }
    }

    private void finalizarAplicacao() {
        model.listarAlunos();
    }

    public void iniciar() {
        view.setVisible(true);
    }
}
