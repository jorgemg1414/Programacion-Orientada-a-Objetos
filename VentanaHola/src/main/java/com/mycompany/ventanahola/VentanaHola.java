
package com.mycompany.ventanahola;
import javax.swing.*;
import java.awt.*;


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
        setVisible(true);
        this.getContentPane().setBackground(Color.GREEN);
        
        //Creando un panel
        Panel X=new Panel();
        
        
        
        JLabel etiqueta1 = new JLabel("Ingresa tu numero de pajitas: ");
        etiqueta1.setForeground(Color.RED);
        etiqueta1.setFont(new Font("Arial", Font.BOLD,14));
        add(etiqueta1);
        
        //Crear una entrada de texto
        
        JTextField entradaT=new JTextField(20);
        entradaT.setBounds(50,200,200,50);
        
        X.add(etiqueta1);
        X.add(etiqueta1);
        add (X);
    }

    
    
    
    public static void main(String[] args) {
        new VentanaHola();
    }
}
