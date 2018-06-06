package com.ge_airesFrescos.GraphicEnvironment;

import com.ge_airesFrescos.ImplementsDAO.CompanyImpDAO;
import com.ge_airesFrescos.ImplementsDAO.PersonImpDAO;
import com.ge_airesFrescos.Model.Company;
import com.ge_airesFrescos.Model.Person;
import com.ge_airesFrescos.dbb.Conexio;

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
        return fieldNameCompany;
    }

    public JTextField getFieldAdressCompany() {
        return fieldAdressCompany;
    }

    private JTextField fieldNameCompany;
    private JTextField fieldAdressCompany;

    public NewCompanyDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name    = fieldNameCompany.getName();
                String address = fieldAdressCompany.getName();
                onOK(name,address);
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

    private void onOK(String name, String address) {
        // add your code here
        Company company = new Company(name,address);
        if(true){
            Conexio con = new Conexio();
            try {
                CompanyImpDAO companyImpDAO = new CompanyImpDAO(con);
                companyImpDAO.insert(company);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
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
