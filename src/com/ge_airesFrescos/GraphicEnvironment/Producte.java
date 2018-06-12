package com.ge_airesFrescos.GraphicEnvironment;

import com.ge_airesFrescos.Exceptions.MySQLException;
import com.ge_airesFrescos.ImplementsDAO.ProductImpDAO;
import com.ge_airesFrescos.Model.Product;
import com.ge_airesFrescos.dbb.Conexio;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Producte {
    private JPanel productePanel;
    private JButton addButton;
    private JTextField fieldName;
    private JButton removeButton;
    private JLabel ProductTitle;
    private JLabel nameLabel;
    private JTextField fieldPrice;
    private JLabel priceLabel;
    private JLabel stockLabel;
    private JLabel descriptionLabel;
    private JTextArea descriptionTextArea;
    private JSpinner stockSpinner;
    private JButton searchButton;
    private JButton modifyButton;
    private JTable tableProducts;
    private JScrollPane PanelProduct;

    Conexio con = new Conexio();
    public List<Product> listProduc    = new ArrayList();
    public Producte() {

        ProductImpDAO productImpDAO = new ProductImpDAO(con);
        try {
            listProduc = productImpDAO.getAll();
        } catch (MySQLException e) {
            e.printStackTrace();
        }


        loadTable();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    private void loadTable() {
        ProductImpDAO productImpDAO = new ProductImpDAO(con);
        try {
            listProduc =  productImpDAO.getAll();
        } catch (MySQLException e) {
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
                        return "Name";
                    case 1:
                        return "Description";
                    case 2:
                        return "Price";
                    case 3:
                        return "Stock";

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


        tableProducts.setModel(tm);
    }

    public JPanel getProductePanel() {
        return productePanel;
    }
}
