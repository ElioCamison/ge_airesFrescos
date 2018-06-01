package com.ge_airesFrescos;

import com.ge_airesFrescos.Pressupost;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
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
