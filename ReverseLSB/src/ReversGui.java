import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReversGui {

	private JFrame frame;
	private JTextField path;
	private JTextField key;
	private JTextField message;
	private JTextField binary;
	private JLabel label;
	private JTextField sha256;
	private static String shacoding;
	private static GFG Gfgobje;
	private static String binarytext;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Main main=new Main();
		Gfgobje=new GFG();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReversGui window = new ReversGui();
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
	public ReversGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 950, 556);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 label = new JLabel();
		label.setBounds(139, 11, 448, 271);
		frame.getContentPane().add(label);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("File Path");
		textPane.setBounds(96, 323, 60, 20);
		frame.getContentPane().add(textPane);
		
		path = new JTextField();
		path.setColumns(10);
		path.setBounds(153, 323, 263, 20);
		frame.getContentPane().add(path);
		
		JButton button = new JButton("Upload");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  JFileChooser chooser = new JFileChooser();
			        FileNameExtensionFilter filter = new FileNameExtensionFilter(
			                "BITMAP", "BMP"); 
			        chooser.setFileFilter(filter);
			        int returnVal = chooser.showOpenDialog(null);
			        if(returnVal == JFileChooser.APPROVE_OPTION) {
			        File file=	showpng(chooser.getSelectedFile().toString());
			      
					
			        label.setIcon(new ImageIcon(file.toString()));
			        	
			        path.setText(chooser.getSelectedFile().toString())	;
			       
			    
			        button.enable();
			        
			        }
				
			}
		});
		button.setBounds(417, 322, 89, 23);
		frame.getContentPane().add(button);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("KEY");
		textPane_1.setBounds(96, 354, 60, 20);
		frame.getContentPane().add(textPane_1);
		
		key = new JTextField();
		key.setColumns(10);
		key.setBounds(163, 354, 352, 20);
		frame.getContentPane().add(key);
		
		Button button_1 = new Button("Process");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					shacoding= Gfgobje.toHexString(Gfgobje.getSHA(key.getText()));
					sha256.setText(shacoding);
					} catch (NoSuchAlgorithmException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
				
				binarytext=Main.basla(key.getText(), sha256.getText(), path.getText());
				binary.setText(binarytext);
				
				message.setText(btoString(binarytext));
				
			}
		});
		button_1.setBounds(521, 354, 70, 22);
		frame.getContentPane().add(button_1);
		
		message = new JTextField();
		message.setColumns(10);
		message.setBounds(185, 441, 352, 20);
		frame.getContentPane().add(message);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setText("Message");
		textPane_2.setBounds(125, 441, 60, 20);
		frame.getContentPane().add(textPane_2);
		
		JTextPane txtpnBinary = new JTextPane();
		txtpnBinary.setText("Binary");
		txtpnBinary.setBounds(125, 410, 60, 20);
		frame.getContentPane().add(txtpnBinary);
		
		binary = new JTextField();
		binary.setColumns(10);
		binary.setBounds(185, 410, 672, 20);
		frame.getContentPane().add(binary);
		
		sha256 = new JTextField();
		sha256.setColumns(10);
		sha256.setBounds(185, 385, 719, 20);
		frame.getContentPane().add(sha256);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setText("SHA256");
		textPane_3.setBounds(125, 385, 60, 20);
		frame.getContentPane().add(textPane_3);
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
	  public static String btoString(String binary) {
		    return Arrays.stream(binary.split("(?<=\\G.{8})"))/* regex to split the bits array by 8*/
		                 .parallel()
		                 .map(eightBits -> (char)Integer.parseInt(eightBits, 2))
		                 .collect(
		                                 StringBuilder::new,
		                                 StringBuilder::append,
		                                 StringBuilder::append
		                 ).toString();
		}
}
