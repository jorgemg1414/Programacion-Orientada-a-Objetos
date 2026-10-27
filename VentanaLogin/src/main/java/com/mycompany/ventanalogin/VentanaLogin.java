package com.mycompany.ventanalogin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 *
 * @author jorge
 */
public class VentanaLogin extends JFrame {

    //Aqui se guardan todos los usuarios
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public VentanaLogin() {
        super("Login de usuario :)");
        setSize(350,230);
        setLocation(50,100);//50 desde la izquierda y 100 desde arriba
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Usuario de prueba para poder entrar desde el inicio
        usuarios.add(new Usuario("admin", "1234"));

        //Panel sin layout para acomodar todo con setBounds
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);

        JLabel lblUsuario = new JLabel("Usuario ");
        lblUsuario.setBounds(30,30,100,25);
        lblUsuario.setForeground(Color.BLACK);

        JTextField txtUsuario = new JTextField();
        txtUsuario.setBounds(130,30,170,25);

        JLabel lblContrasena = new JLabel("Contraeña ");
        lblContrasena.setBounds(30,70,100,25);
        lblContrasena.setForeground(Color.BLACK);

        JTextField txtContrasena = new JTextField();
        txtContrasena.setBounds(130,70,170,25);

        JButton btnIniciar = new JButton("Entrar");
        btnIniciar.setBounds(30,120,130,30);
        btnIniciar.setForeground(Color.BLACK);

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(170,120,130,30);
        btnRegistrar.setForeground(Color.BLACK);

        //Boton para iniciar sesion
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String contrasena = txtContrasena.getText();

                //Se busca en el ArrayList un usuario con esos datos
                boolean encontrado = false;
                for (Usuario u : usuarios) {
                    if (u.getUsuario().equalsIgnoreCase(usuario) && u.getContrasena().equals(contrasena)) {
                        encontrado = true;
                    }
                }

                if (encontrado) {
                    JOptionPane.showMessageDialog(null, "Bienvenido " + usuario);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuraio o contraeña incorrecto");
                }
            }
        });

        //Boton para guardar un usuario nuevo en el ArrayList
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String contrasena = txtContrasena.getText();

                if (usuario.isEmpty() || contrasena.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Llena el usuario y la contraeña");
                } else {
                    usuarios.add(new Usuario(usuario, contrasena));
                    JOptionPane.showMessageDialog(null, "Usuario registrado");
                    txtUsuario.setText("");
                    txtContrasena.setText("");
                }
            }
        });

        panel.add(lblUsuario);
        panel.add(txtUsuario);
        panel.add(lblContrasena);
        panel.add(txtContrasena);
        panel.add(btnIniciar);
        panel.add(btnRegistrar);
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new VentanaLogin();
    }
}