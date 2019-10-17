import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;
import java.awt.Button;
import javax.swing.JTextArea;
import java.awt.Canvas;
import javax.swing.JPanel;

public class Gui {

	private JFrame frame;
	private JTextField textField;
	private JTextField secretmessage;
	private JTextField binaryfield;
	private JTextPane binary;
	private ImageIcon icon;
	private JLabel panelresim;
	private static main main;
	private JTextField txtYenidosyaadi;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextPane txtpnSha;
	private String bitler,sifrenmis,key;
	private static String shacoding;
	private static GFG Gfgobje;
	private JTextPane keyvari;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		main=new main();
		Gfgobje=new GFG();
	
	
		
	
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
					
					
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1046, 571);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		 panelresim = new JLabel();
		
			panelresim.setBounds(92, 11, 448, 271);
			frame.getContentPane().add(panelresim);
		
			
		Button button = new Button("Process");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				binaryfield.setVisible(true);
				binary.setVisible(true);
				
			binaryfield.setText(AsciiToBinary(secretmessage.getText()));
			try {
				shacoding= Gfgobje.toHexString(Gfgobje.getSHA(textField_1.getText()));
				textField_2.setText(shacoding);
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		main.runm(textField.getText(),txtYenidosyaadi.getText(),textField_1.getText(), binaryfield.getText(),secretmessage.getText(),shacoding);
		
			}
		});
		button.disable();
		
		JLabel thumb = new JLabel();
		thumb.setIcon(icon);
		
		textField = new JTextField();
		textField.setBounds(181, 293, 263, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.disable();
		JButton btnYkle = new JButton("Upload");
		btnYkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  JFileChooser chooser = new JFileChooser();
			        FileNameExtensionFilter filter = new FileNameExtensionFilter(
			                "BITMAP", "BMP"); 
			        chooser.setFileFilter(filter);
			        int returnVal = chooser.showOpenDialog(null);
			        if(returnVal == JFileChooser.APPROVE_OPTION) {
			        File file=	showpng(chooser.getSelectedFile().toString());
			      
					
			        panelresim.setIcon(new ImageIcon(file.toString()));
			        	
			        textField.setText(chooser.getSelectedFile().toString())	;
			       
			    
			        btnYkle.enable();
			        button.enable();
			        
			        }
				
			}
		});
		btnYkle.setBounds(454, 293, 89, 23);
		frame.getContentPane().add(btnYkle);
		
		JTextPane txtpnFilePath = new JTextPane();
		txtpnFilePath.setText("File Path");
		txtpnFilePath.setBounds(122, 293, 60, 20);
		frame.getContentPane().add(txtpnFilePath);
		
		button.setBounds(470, 382, 70, 22);
		frame.getContentPane().add(button);
		
		JTextPane txtpnMessage = new JTextPane();
		txtpnMessage.setText("Message");
		txtpnMessage.setBounds(122, 324, 60, 20);
		frame.getContentPane().add(txtpnMessage);
		
		secretmessage = new JTextField();
		secretmessage.setBounds(188, 324, 352, 20);
		frame.getContentPane().add(secretmessage);
		secretmessage.setColumns(10);
		
		 binary = new JTextPane();
		binary.setText("Binary");
		binary.setBounds(10, 410, 60, 20);
		frame.getContentPane().add(binary);
		binary.setVisible(false);
		
		binaryfield = new JTextField();
		binaryfield.setColumns(10);
		binaryfield.setBounds(75, 410, 840, 20);
		frame.getContentPane().add(binaryfield);
		
		txtYenidosyaadi = new JTextField();
		txtYenidosyaadi.setText("YeniDosyaAdi");
		txtYenidosyaadi.setBounds(10, 319, 96, 20);
		frame.getContentPane().add(txtYenidosyaadi);
		txtYenidosyaadi.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(188, 355, 352, 20);
		frame.getContentPane().add(textField_1);
		
		 keyvari = new JTextPane();
		keyvari.setText("KEY");
		keyvari.setBounds(122, 355, 60, 20);
		frame.getContentPane().add(keyvari);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(75, 445, 840, 20);
		frame.getContentPane().add(textField_2);
		
		txtpnSha = new JTextPane();
		txtpnSha.setText("SHA256");
		txtpnSha.setBounds(10, 445, 60, 20);
		frame.getContentPane().add(txtpnSha);
		
		
	
		
		binaryfield.setVisible(false);
		txtpnFilePath.disable();
		
		
	}
	public File showpng(String path) {
    BufferedImage input_image = null; 
    try {
		input_image = ImageIO.read(new File(path));
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} //read bmp into input_image object
    File outputfile = new File("cache.png"); //create new outputfile object
    try {
		ImageIO.write(input_image, "PNG", outputfile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} //write PNG output to file 
   return outputfile;
}
	
	public static String AsciiToBinary(String asciiString){  

        byte[] bytes = asciiString.getBytes();  
        StringBuilder binary = new StringBuilder();  
        for (byte b : bytes)  
        {  
           int val = b;  
           for (int i = 0; i < 8; i++)  
           {  
              binary.append((val & 128) == 0 ? 0 : 1);  
              val <<= 1;  
           }  
          // binary.append(' ');  
        }  
        return binary.toString();  
  }  
}
