package com.mycompany.ventanahola;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author jorge
 */

//El extends es por qeu es una clase de la libreria java swing, y por eso ponemos el JFrame
public class VentanaHola extends JFrame {

    public VentanaHola() {
        super ("Contador de pajitas");//Mandammos a llamar al constructor de JFrame
        setLocation(50,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250,200);

        //Creando un panel
        JPanel X=new JPanel();
        X.setBackground(Color.GREEN);



        JLabel etiqueta1 = new JLabel("Ingresa tu numero de pajitas: ");
        etiqueta1.setForeground(Color.RED);
        etiqueta1.setFont(new Font("Arial", Font.BOLD,14));

        //Crear una entrada de texto

        JTextField entradaT=new JTextField(20);

        //Boton
        JButton boton= new JButton ("Mensaje del boton");
        //Agregamos una accion a ese boton
        boton.addActionListener(new ActionListener(){
        @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, boton.getText());
                }
                });
        X.add(etiqueta1);
        X.add(entradaT);
        X.add(boton);
        add (X);
        setVisible(true);
    }




    public static void main(String[] args) {
        new VentanaHola();
    }
}