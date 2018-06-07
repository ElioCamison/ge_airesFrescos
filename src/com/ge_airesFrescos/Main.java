package com.ge_airesFrescos;

import com.ge_airesFrescos.DAO.BudgetDAO;
import com.ge_airesFrescos.Exceptions.MySQLException;
import com.ge_airesFrescos.GraphicEnvironment.Pressupost;
import com.ge_airesFrescos.GraphicEnvironment.Producte;
import com.ge_airesFrescos.ImplementsDAO.BudgetImpDAO;
import com.ge_airesFrescos.Model.Budget;
import com.ge_airesFrescos.Model.Product;
import com.ge_airesFrescos.dbb.Conexio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Main {

    private static CardLayout cl;
    private static JPanel jp;

    public static void main(String[] args) throws MySQLException, SQLException {
        JFrame jf = new JFrame(  );
        jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        jf.setJMenuBar(doMenu());
        Pressupost pf = new Pressupost();
        Producte producte = new Producte();
        cl = new CardLayout(  );
        jp = new JPanel(  );
        jp.setLayout( cl );

        jp.add( pf.getMainPanel(),"PRESSUPOST" );
        jp.add( producte.getProductePanel(),"PRODUCTE" );


        jf.setContentPane( jp );

        jf.pack();
        cl.show(jp, "PRESSUPOST");
        jf.setVisible( true );

    }

    static JMenuBar doMenu(){
        JMenuBar jmb = new JMenuBar();
        JMenu menuFile = new JMenu("Menu");
        JMenuItem presup = new JMenuItem("Pressupost");
        JMenuItem productos = new JMenuItem("New Producte");
        menuFile.add(presup);
        menuFile.add(productos);
        jmb.add(menuFile);

        presup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cl.show(jp, "PRESSUPOST");
            }
        });

        productos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cl.show(jp, "PRODUCTE");
            }
        });        return jmb;
    }

}
