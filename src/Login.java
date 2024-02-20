import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame{
    private JPanel panelMatriculador;
    private JButton button1;
    private JTextField usuarioTxt;
    private JPasswordField passwdField;

    public Login(){
        super("LOGIN");
        setContentPane(panelMatriculador);

    }

    public void validaciones(){
        String usuario = usuarioTxt.getText();
        String contrasena = new String(passwdField.getPassword());

        if(autenticarUsuario(usuario, contrasena)){
            JOptionPane.showMessageDialog(null, "Inicio de sesion exitoso");;
        }else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos. Inténtalo de nuevo.");
            usuarioTxt.setText("");
            passwdField.setText("");
        }

    }

    public boolean autenticarUsuario(String nombre, String contrasena){
        BaseDatos manejadorBD = new BaseDatos();
        Connection conexion = manejadorBD.conexionBase();

        if(conexion != null){
            try{
                String sql = "SELECT * FROM usuarioscajero WHERE nombre = ? AND contraseña = ?";
                try(PreparedStatement stmt = conexion.prepareStatement(sql)){
                    stmt.setString(1, nombre);
                    stmt.setString(2, contrasena);

                    System.out.println("Consulta sql " + stmt.toString());
                    ResultSet resultSet = stmt.executeQuery();
                    return resultSet.next();
                }
            }catch (SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta");
            }finally {
                try{
                    conexion.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
