package com.ge_airesFrescos.GraphicEnvironment;

import com.ge_airesFrescos.Exceptions.MySQLException;
import com.ge_airesFrescos.ImplementsDAO.ProductImpDAO;
import com.ge_airesFrescos.Model.Person;
import com.ge_airesFrescos.Model.Product;
import com.ge_airesFrescos.dbb.Conexio;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class AddItemDialog extends JDialog {
    private JPanel addItemPanel;
    private JButton buttonOK;
    private JButton buttonCancel;
    public JComboBox comboboxNameItem;
    private JSpinner QuantitatSpinner;
    private JLabel quantitatLabel;
    private JPanel nameLabel;
    public boolean ok = false;
    public static List<Product> productList = new ArrayList();

    Conexio con = new Conexio();
    public List<Product> listProduc    = new ArrayList();

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


        ProductImpDAO productImpDAO = new ProductImpDAO(con);
        try {
            listProduc =  productImpDAO.getAll();
        } catch (MySQLException e) {
            e.printStackTrace();
        }

        for(Product lp : listProduc){
            comboboxNameItem.addItem(lp.getName());
        }

    }





    private void onOK() {
        int valueItem = comboboxNameItem.getSelectedIndex()+1;
        ProductImpDAO productImpDAO = new ProductImpDAO(con);
        try {
            productList.add(productImpDAO.getOne(valueItem));
        } catch (MySQLException e) {
            e.printStackTrace();
        }

        ok = true;
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        ok = false;
        dispose();
    }

    public static void main(String[] args) {
        AddItemDialog dialog = new AddItemDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public List<Product> getProductList() {
        return productList;
    }
}
