import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class CharacterGUI implements ActionListener {

  JFrame frmCharacter = new JFrame("Character creation");
  JLabel lblHalsning = new JLabel("Hejsan, här skapas gubben");
  JLabel lblDummy = new JLabel("");
  JLabel lblDummyW = new JLabel("");
  JLabel lblDummyS = new JLabel("");
  JLabel lblName = new JLabel("Namn:");
  JLabel lblSkill = new JLabel("Skill:");
  JLabel lblVapen = new JLabel("Vapen:");
  JLabel lblSkold = new JLabel("Sköld:");
  JTextField txtName = new JTextField(25);
  JTextField txtSkill = new JTextField(8);
  ButtonGroup bgpWeapon = new ButtonGroup();
  ButtonGroup bgpShield = new ButtonGroup();
  JRadioButton rbnWDefault = new JRadioButton("Standard");
  JRadioButton rbnWNotDefault = new JRadioButton("Egen design");
  JRadioButton rbnSDefault = new JRadioButton("Ingen sköld");
  JRadioButton rbnSNotDefault = new JRadioButton("Egen design");
  JButton btnSkapa = new JButton("Skapa");
  JButton btnKor = new JButton("Kör"); 

  //denna metod aktiverar krysset i övre högra hörnet
  private WindowAdapter hornStang(){
    return new WindowAdapter(){
      public void windowClosing(WindowEvent e)
        {System.exit(0);}
      };
  }//hornStang

  public CharacterGUI(){
    frmCharacter.setSize(500, 700);
    frmCharacter.setLayout(new GridLayout(8, 2));
    frmCharacter.addWindowListener(hornStang());

    frmCharacter.add(lblHalsning);
    frmCharacter.add(lblDummy);
    frmCharacter.add(lblName);
    frmCharacter.add(txtName);
    frmCharacter.add(lblSkill);
    frmCharacter.add(txtSkill);
    frmCharacter.add(lblVapen);
    frmCharacter.add(rbnWDefault);
    frmCharacter.add(lblDummyW);
    frmCharacter.add(rbnWNotDefault);
    frmCharacter.add(lblSkold);
    frmCharacter.add(rbnSDefault);
    frmCharacter.add(lblDummyS);
    frmCharacter.add(rbnSNotDefault);
    frmCharacter.add(btnSkapa);
    frmCharacter.add(btnKor);

    frmCharacter.setVisible(true);

    bgpWeapon.add(rbnWDefault);
    bgpWeapon.add(rbnWNotDefault);
    bgpShield.add(rbnSDefault);
    bgpShield.add(rbnSNotDefault);

    btnSkapa.addActionListener(this);
    btnKor.addActionListener(this);
  }//konstruktor

  public void actionPerformed (ActionEvent a){
    String ae = a.getActionCommand();
    try{
      if(ae.equals("Skapa")){
        String inNamn = txtName.getText();
        int inSkill = Integer.parseInt(txtSkill.getText());
        Weapon inVapen = new Weapon();
        Shield inSkold = new Shield();
        Character nyGubbe = new Character(inNamn, inSkill, inVapen, inSkold);
        nyGubbe.saveCharacter();
      }
      else if (ae.equals("Kör")){
        Game hitit = new Game();
        hitit.go();
      }
    }catch(Exception e){
      System.out.println(""+e.getMessage());}
  }//actionPerformed

  public static void main(String[] args){
    CharacterGUI denna = new CharacterGUI();
  }

}//class