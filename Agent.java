import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import javax.imageio.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.io.IOException;

public class Agent extends JPanel{

    String agentname;
    public int[] publicKey = new int[2];
    private int[] privateKey = new int[2]; 
    JTextArea agentField;
    TitledBorder label;
    ArrayList<String> agentlog = new ArrayList<String>();
    int arrayPos = 0;
    
    Agent( String _agentname){

	agentname = _agentname;
	
	setLayout(new BoxLayout( this, BoxLayout.PAGE_AXIS));
	agentname = _agentname;
	agentField = new JTextArea( 20, 20);
	agentField.setLineWrap(true);
	agentField.setWrapStyleWord(true);
	label = new TitledBorder( _agentname);
	agentField.setBorder( label);
	this.setBorder(BorderFactory
			.createEmptyBorder(10,10,10,10));
	JScrollPane scrollpane = new JScrollPane( agentField);
     	add( scrollpane);
        this.setBorder( this.getBorder());
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

	//generate a public and private key
	Cryptography cryptTemp = new Cryptography( _agentname, 10, 100);
	privateKey[0] = cryptTemp.getPrivateKey();
	privateKey[1] = cryptTemp.getN();
	publicKey[0] = cryptTemp.publicKey;
	publicKey[1] = cryptTemp.getN();

    }

    //add log entry to stack
    public void addLogEntry( String _ale){

	agentlog.add( _ale);
    }

    //show entry in log and iterate by one
    public void nextLog(){

	
	agentField.setText( agentField.getText() + agentlog.get(arrayPos) + "\r\n");

	if( arrayPos < agentlog.size() - 1)
	    arrayPos++;
    }

    //done like this to make demo purposes I bit simpler to code
     public int getPrivateKey(){

	return privateKey[0];
    }

    public int getPrivateKeyMod(){

	return privateKey[1];
    }

    public int getPublicKeyMod(){

	return publicKey[1];
    }

    public int getPublicKey(){

	return publicKey[0];
    }
}



