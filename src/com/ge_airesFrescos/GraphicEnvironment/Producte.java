package com.ge_airesFrescos.GraphicEnvironment;

import com.ge_airesFrescos.Exceptions.MySQLException;
import com.ge_airesFrescos.ImplementsDAO.ProductImpDAO;
import com.ge_airesFrescos.Model.Product;
import com.ge_airesFrescos.dbb.Conexio;

import javax.swing.*;
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

    Conexio con = new Conexio();
    public List<Product> listProduc    = new ArrayList();
    public Producte() {

        ProductImpDAO productImpDAO = new ProductImpDAO(con);
        try {
            listProduc = productImpDAO.getAll();
        } catch (MySQLException e) {
            e.printStackTrace();
        }


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    public JPanel getProductePanel() {
        return productePanel;
    }
}
