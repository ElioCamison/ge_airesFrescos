package com.ge_airesFrescos.GraphicEnvironment;

import com.ge_airesFrescos.Exceptions.MySQLException;
import com.ge_airesFrescos.ImplementsDAO.*;
import com.ge_airesFrescos.Model.Person;
import com.ge_airesFrescos.dbb.Conexio;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Pressupost {

    private JTextField textField2;
    private JButton SEARCHButton;
    private JButton NEWCustomer;
    private javax.swing.JMenuBar JMenuBar;

    public JPanel getMainPanel() {
        return MainPanel;
    }

    private JButton SEARCHButton1;
    private JPanel MainPanel;
    private JButton NEWCompany;
    private JTable TaulaItems;
    private JButton ADDITEMButton;
    private JButton DELETEITEMButton;
    private JTextArea textArea1;
    private JButton SAVEButton;
    private JButton CANCELButton;
    private JPanel PamelButtonSaveCancel;
    private JPanel MenuBar;
    private JComboBox searchCustomer;

    public List<BudgetImpDAO>   listBudget    = new ArrayList();
    public List<CompanyImpDAO>  listCompany   = new ArrayList();
    public List<Person>   listPerson  = new ArrayList();
    public List<ProductImpDAO>  listProduc    = new ArrayList();

    public Pressupost() {
        Conexio con = new Conexio();
        PersonImpDAO personImpDAO = new PersonImpDAO(con);

        try {
            listPerson = personImpDAO.getAll();
        } catch (MySQLException e) {
            e.printStackTrace();
        }

        for(Person lp : listPerson){
            searchCustomer.addItem(lp.getName());
        }

        NEWCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        /* --------------------------------------------------------- */

        /* --------------------------------------------------------- */

        NEWCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                NewCustomerDialog customerDialog = new NewCustomerDialog();
                customerDialog.setModal(true);
                customerDialog.pack();
                customerDialog.setVisible(true);

                // Dades d'un client nou
                String userName = customerDialog.getFieldName().getText();
                String adress = customerDialog.getFieldAdress().getText();
            }
        });


        /* --------------------------------------------------------- */

        /* --------------------------------------------------------- */
        NEWCompany.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                NewCompanyDialog companyDialog = new NewCompanyDialog();
                companyDialog.setModal(true);
                companyDialog.pack();
                companyDialog.setVisible(true);

                // Dades d'una empresa nova
                String companyName = companyDialog.getFieldNameCompany().getText();
                String companyAdress = companyDialog.getFieldNameCompany().getText();
            }
        });

        /* --------------------------------------------------------- */

        /* --------------------------------------------------------- */

        TableModel tm = new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return 2;
            }

            @Override
            public String getColumnName(int i) {
                if (i == 0) return "Producte";
                if (i == 1) return "Quantitat";
                if (i == 2) return "Preu";
                if (i == 3) return "Total";
                return "";
            }

            @Override
            public int getColumnCount() {
                return 4;
            }

            @Override
            public Object getValueAt(int i, int i1) {

                return "a";
            }
        };

        TaulaItems.setModel(tm);
        ADDITEMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddItemDialog companyDialog = new AddItemDialog();
                companyDialog.setModal(true);
                companyDialog.pack();
                companyDialog.setVisible(true);
            }
        });

    }

    public void setJMenuBar(JMenuBar JMenuBar) {
        this.JMenuBar = JMenuBar;
    }
}
