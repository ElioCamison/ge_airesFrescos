package com.ge_airesFrescos.GraphicEnvironment;

import com.ge_airesFrescos.Exceptions.MySQLException;
import com.ge_airesFrescos.ImplementsDAO.ProductImpDAO;
import com.ge_airesFrescos.Model.Product;

import javax.swing.*;
import java.awt.event.*;

public class ModifyProductDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    public JTextField nameField;
    public JTextField priceField;
    public JSpinner stockSpinner;
    public JTextArea descriptionArea;

    public ModifyProductDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                onOK();
                /*Product product = listProduc.get(selected);
                ProductImpDAO productImpDAO1 = new ProductImpDAO(con);


                modifyProductDialog.setVisible(true);
                try {
                    productImpDAO1.update(product);
                    loadTable();
                } catch (MySQLException e1) {
                    e1.printStackTrace();
                }*/

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

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JTextField getPriceField() {
        return priceField;
    }

    public void setPriceField(JTextField priceField) {
        this.priceField = priceField;
    }

    public JSpinner getStockSpinner() {
        return stockSpinner;
    }

    public void setStockSpinner(JSpinner stockSpinner) {
        this.stockSpinner = stockSpinner;
    }

    public JTextArea getDescriptionArea() {
        return descriptionArea;
    }

    public void setDescriptionArea(JTextArea descriptionArea) {
        this.descriptionArea = descriptionArea;
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
        ModifyProductDialog dialog = new ModifyProductDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
