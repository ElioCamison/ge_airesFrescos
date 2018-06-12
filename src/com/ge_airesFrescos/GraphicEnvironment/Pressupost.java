package com.ge_airesFrescos.GraphicEnvironment;

import com.ge_airesFrescos.Exceptions.MySQLException;
import com.ge_airesFrescos.ImplementsDAO.*;
import com.ge_airesFrescos.Model.*;
import com.ge_airesFrescos.dbb.Conexio;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Pressupost {

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
    private JComboBox searchCompany;

    public List<Budget>   listBudget     = new ArrayList();
    public List<Company>  listCompany    = new ArrayList();
    public List<Person>   listPerson     = new ArrayList();
    public List<Product>  listProduc     = new ArrayList();
    public List<Product>  listAddItem    = new ArrayList();

    Conexio con = new Conexio();

    public Pressupost() {

        PersonImpDAO personImpDAO = new PersonImpDAO(con);

        try {
            listPerson = personImpDAO.getAll();
        } catch (MySQLException e) {
            e.printStackTrace();
        }

        for(Person lp : listPerson){
            searchCustomer.addItem(lp.getName());
        }

        CompanyImpDAO companyImpDAO = new CompanyImpDAO(con);
        try {
            listCompany = companyImpDAO.getAll();
        } catch (MySQLException e) {
            e.printStackTrace();
        }

        for(Company lc : listCompany){
            searchCompany.addItem(lc.getName());
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

        loadTable();


        ADDITEMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddItemDialog companyDialog = new AddItemDialog();
                companyDialog.setModal(true);
                companyDialog.pack();
                companyDialog.setVisible(true);
                if (companyDialog.ok) {
                    listProduc = companyDialog.getProductList();
                    loadTable();
                }

            }
        });

        SAVEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                BudgetImpDAO budgetImpDAO = new BudgetImpDAO(con);


                try {
                    listBudget = budgetImpDAO.getAll();
                } catch (MySQLException e) {
                    e.printStackTrace();
                }
            }
        });
        DELETEITEMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected = TaulaItems.getSelectedRow();
                Product pr = listProduc.get(selected);
                ProductImpDAO productImpDAO1 = new ProductImpDAO(con);
                try {
                    productImpDAO1.delete(pr);
                    loadTable();
                } catch (MySQLException e1) {
                    e1.printStackTrace();
                }

            }
        });


    }

    public void loadTable() {
        //ProductImpDAO productImpDAO = new ProductImpDAO(con);
        /*List<Product> listContentItemBudget;
        listContentItemBudget = AddItemDialog.productList;
        System.out.println(listContentItemBudget.toString());*/
        try {
            listProduc = AddItemDialog.productList;
            System.out.println(listProduc);
        } catch (Exception e) {
            e.printStackTrace();
        }

        TableModel tm = new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return listProduc.size();
            }

            @Override
            public String getColumnName(int i) {
                switch (i) {
                    case 0 :
                        return "Producte";
                    case 1:
                        return "Quantitat";
                    case 2:
                        return "Preu";
                    case 3:
                        return "Total";

                }
                return "";
            }

            @Override
            public int getColumnCount() {
                return 4;
            }

            @Override
            public Object getValueAt(int i, int i1) {
                Product prod = listProduc.get(i);
                switch (i1){
                    case 0:
                        return prod.getName();
                    case 1:
                        // Afegir a la taula un columna quantitat
                        return prod.getDescription();
                    case 2:
                        return prod.getPrice();
                    case 3:
                        return prod.getStock();
                }
                return null;
            }

        };


        TaulaItems.setModel(tm);
    }

    public void setJMenuBar(JMenuBar JMenuBar) {
        this.JMenuBar = JMenuBar;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
