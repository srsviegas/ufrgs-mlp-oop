package com.mlp;

import javax.swing.SwingUtilities;

import com.mlp.controller.AlunoController;
import com.mlp.model.AlunoModel;
import com.mlp.view.AlunoView;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AlunoModel model = new AlunoModel();
                AlunoView view = new AlunoView();
                AlunoController controller = new AlunoController(model, view);
                controller.iniciar();
            }
        });
    }
}
