package com.ge_airesFrescos.GraphicEnvironment;

import com.ge_airesFrescos.ImplementsDAO.PersonImpDAO;
import com.ge_airesFrescos.Model.Person;
import com.ge_airesFrescos.dbb.Conexio;

import javax.swing.*;
import java.awt.event.*;

public class NewCustomerDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;

    public JTextField getFieldName() {
        return fieldName;
    }

    public JTextField getFieldAdress() {
        return fieldAdress;
    }

    private JTextField fieldName;
    private JTextField fieldAdress;
    private JTextField fieldSurname;
    private JLabel labelAddress;
    private JPanel labelName;
    private JLabel surnameLabel;
    private JTextField fieldTelephone;
    private JTextField fieldEmail;
    private JTextField fieldPassword;
    private JLabel tlfLabel;
    private JLabel emailLabel;
    private JLabel PasswordLabel;
    private JTextField fieldUser;
    private JLabel userLabel;
    private JTextField fieldType;

    public NewCustomerDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name      = fieldName.getText();
                String surname   = fieldSurname.getText();
                String addres    = fieldAdress.getText();
                String telephone = fieldTelephone.getText();
                String email = fieldEmail.getText();
                String user = fieldUser.getText();
                String password = fieldPassword.getText();
                String type = fieldType.getText();
                onOK(name,surname, addres, telephone, email, user, password, type);
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

    private void onOK(String name, String surname, String address, String telephone, String email, String user, String password, String type){
        // add your code here
        //todo validar informacion
        Person person = new Person(name,surname,address,telephone,email,user,password,type);
        Conexio con = new Conexio();
        try {
            PersonImpDAO personImpDAO = new PersonImpDAO(con);
            personImpDAO.insert(person);
        } catch (Exception ex){
            ex.printStackTrace();
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
