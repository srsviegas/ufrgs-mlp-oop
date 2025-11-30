package com.mlp.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mlp.enums.Genero;
import com.mlp.enums.NivelMatricula;

public class AlunoView extends JFrame {

    private JTextField txtNome;
    private JTextField txtDataNascimento;
    private JComboBox<Genero> cmbGenero;
    private JTextField txtMatricula;
    private JTextField txtDataMatricula;
    private JComboBox<NivelMatricula> cmbNivelMatricula;
    private JButton btnCadastrar;
    private JButton btnLimpar;

    private Runnable onClose;

    public AlunoView() {
        configurarJanela();
        inicializarComponentes();
        posicionarComponentes();
    }

    private void configurarJanela() {
        setTitle("Cadastro de Alunos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (onClose != null) {
                    onClose.run();
                }
                dispose();
            }
        });
    }

    private void inicializarComponentes() {
        txtNome = new JTextField(20);
        txtDataNascimento = new JTextField(20);
        cmbGenero = new JComboBox<>(Genero.values());
        txtMatricula = new JTextField(20);
        txtDataMatricula = new JTextField(20);
        cmbNivelMatricula = new JComboBox<>(NivelMatricula.values());
        btnCadastrar = new JButton("Cadastrar Aluno");
        btnLimpar = new JButton("Limpar Campos");
    }

    private void posicionarComponentes() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nome Completo:"), gbc);

        gbc.gridx = 1;
        add(txtNome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Data Nascimento (dd/MM/yyyy):"), gbc);

        gbc.gridx = 1;
        add(txtDataNascimento, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Gênero:"), gbc);

        gbc.gridx = 1;
        add(cmbGenero, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Matrícula (8 dígitos):"), gbc);

        gbc.gridx = 1;
        add(txtMatricula, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Data Matrícula (dd/MM/yyyy):"), gbc);

        gbc.gridx = 1;
        add(txtDataMatricula, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Nível Matrícula:"), gbc);

        gbc.gridx = 1;
        add(cmbNivelMatricula, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        add(btnCadastrar, gbc);

        gbc.gridx = 1;
        add(btnLimpar, gbc);
    }

    public String getNome() {
        return txtNome.getText().trim();
    }

    public String getDataNascimento() {
        return txtDataNascimento.getText().trim();
    }

    public Genero getGenero() {
        return (Genero) cmbGenero.getSelectedItem();
    }

    public String getMatricula() {
        return txtMatricula.getText().trim();
    }

    public String getDataMatricula() {
        return txtDataMatricula.getText().trim();
    }

    public NivelMatricula getNivelMatricula() {
        return (NivelMatricula) cmbNivelMatricula.getSelectedItem();
    }

    public void limparCampos() {
        txtNome.setText("");
        txtDataNascimento.setText("");
        cmbGenero.setSelectedIndex(0);
        txtMatricula.setText("");
        txtDataMatricula.setText("");
        cmbNivelMatricula.setSelectedIndex(0);
        txtNome.requestFocus();
    }

    public void exibirMensagemSucesso(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    public void exibirMensagemErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public void adicionarListenerCadastrar(java.awt.event.ActionListener listener) {
        btnCadastrar.addActionListener(listener);
    }

    public void adicionarListenerLimpar(java.awt.event.ActionListener listener) {
        btnLimpar.addActionListener(listener);
    }

    public void setOnClose(Runnable onClose) {
        this.onClose = onClose;
    }
}
