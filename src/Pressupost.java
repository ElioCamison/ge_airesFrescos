import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pressupost {
    private JTextField textField1;
    private JTextField textField2;
    private JButton SEARCHButton;
    private JButton NEWButton;

    public JPanel getMainPanel() {
        return MainPanel;
    }

    private JButton SEARCHButton1;
    private JPanel MainPanel;
    private JButton NEWButton1;
    private JTable table1;
    private JButton ADDITEMButton;
    private JButton DELETEITEMButton;
    private JTextArea textArea1;
    private JButton SAVEButton;
    private JButton CANCELButton;
    private JPanel PamelButtonSaveCancel;

    public Pressupost() {
        NEWButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        NEWButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                NewCustomerDialog customerDialog = new NewCustomerDialog();
                customerDialog.setModal(true);
                customerDialog.pack();
                customerDialog.setVisible( true );

                // Dades d'un client nou
                String userName = customerDialog.getFieldName().getText();
                String adress   = customerDialog.getFieldAdress().getText();
            }
        });
    }
}
