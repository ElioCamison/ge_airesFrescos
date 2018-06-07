package com.ge_airesFrescos.GraphicEnvironment;

import javax.swing.*;
import java.awt.event.*;

public class AddItemDialog extends JDialog {
    private JPanel addItemPanel;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox comboboxNameItem;
    private JSpinner QuantitatSpinner;
    private JLabel quantitatLabel;
    private JPanel nameLabel;

    public AddItemDialog() {
        setContentPane(addItemPanel);
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
        addItemPanel.registerKeyboardAction(new ActionListener() {
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
        AddItemDialog dialog = new AddItemDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
