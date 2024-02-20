import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Matriculacion extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton subirFotoButton;
    private JButton ingresarButton;
    private JPanel panelote;

    public Matriculacion(){
        super("Ingreso de datos");
        setContentPane(panelote);
    }

}
