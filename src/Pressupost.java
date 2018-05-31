import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pressupost {
    private JTextField textField1;
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

    public Pressupost() {
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
                if (i == 0) return "Quantitat";
                if (i == 1) return "Producte";
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

        JMenuBar jmb = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem openOption = new JMenuItem("Open");
        JMenuItem saveOption = new JMenuItem("Save");
        JMenuItem exitOption = new JMenuItem("Exit");
        menu.add(openOption);
        menu.add(saveOption);
        menu.add(exitOption);
        jmb.add(menu);
        this.setJMenuBar(jmb);

        ADDITEMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void setJMenuBar(JMenuBar JMenuBar) {
        this.JMenuBar = JMenuBar;
    }
}
