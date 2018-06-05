package com.ge_airesFrescos.GraphicEnvironment;

import com.ge_airesFrescos.Exceptions.MySQLException;
import com.ge_airesFrescos.ImplementsDAO.CustomerImpDAO;
import com.ge_airesFrescos.Model.Customer;
import com.ge_airesFrescos.dbb.Conexio;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;

public class NewCustomerDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton nameButton;
    private JButton adressButton;

    public JTextField getFieldName() {
        return fieldName;
    }

    public JTextField getFieldAdress() {
        return fieldAdress;
    }

    private JTextField fieldName;
    private JTextField fieldAdress;

    public NewCustomerDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = fieldName.getText();
                String addres = fieldAdress.getText();
                onOK(name, addres);
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

    private void onOK(String name, String address){
        // add your code here
        //todo validar informacion
        Customer c = new Customer(-1,name,"",address,"","","","");
        if(true){
            Conexio con = new Conexio();
            try{
                CustomerImpDAO cuidao = new CustomerImpDAO(con);
                cuidao.insert(c);
            }catch (Exception ex){
                ex.printStackTrace();
            } finally {
                if(con != null){
                    try {
                        con.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        NewCustomerDialog dialog = new NewCustomerDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
