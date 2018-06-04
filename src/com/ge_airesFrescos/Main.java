package com.ge_airesFrescos;

import com.ge_airesFrescos.DAO.BudgetDAO;
import com.ge_airesFrescos.Exceptions.MySQLException;
import com.ge_airesFrescos.GraphicEnvironment.Pressupost;
import com.ge_airesFrescos.ImplementsDAO.BudgetImpDAO;
import com.ge_airesFrescos.Model.Budget;
import com.ge_airesFrescos.dbb.Conexio;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws MySQLException, SQLException {
        JFrame jf = new JFrame(  );
        jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Pressupost pf = new Pressupost();
        CardLayout cl = new CardLayout(  );        JPanel jp = new JPanel(  );
        jp.add( pf.getMainPanel(),"PRESSUPUESTOS" );
        jp.setLayout( cl );
        jf.setContentPane( jp );
        jf.pack();
        jf.setVisible( true );
    }
}
