package com.ge_airesFrescos.GraphicEnvironment;

import javax.swing.*;
import java.awt.event.*;

public class NewCompanyDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel PanelNewCompany;
    private JButton NameCompany;
    private JButton AdressCompany;

    public JTextField getFieldNameCompany() {
        return FieldNameCompany;
    }

    public JTextField getFieldAdressCompany() {
        return FieldAdressCompany;
    }

    private JTextField FieldNameCompany;
    private JTextField FieldAdressCompany;

    public NewCompanyDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        NewCompanyDialog dialog = new NewCompanyDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
