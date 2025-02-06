/*
Luca Bisognin e Diego Ferventi - inizio 6/2/2025
Classe UIManager per gestire la grafica della rubrica
*/

import java.awt.EventQueue;

import javax.swing.JFrame;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UIManager {

    private JFrame frame;
    private JTextField txtNomeIns;
    private JTextField txtCognomeIns;
    private JTextField txtTelefono;
    private JTextField txtEmail;
    private JTextField txtCitta;
    private JTextField txtCdf;
    private JTextField txtCdfMod;
    private JTextField txtCittaMod;
    private JTextField txtEmailMod;
    private JTextField txtTelefonoMod;
    private JTextField txtCognomeMod;
    private JTextField txtNomeMod;
    private JTextField txtCdfCer;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager window = new UIManager();
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
    public UIManager() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 920, 555);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 10, 864, 480);
        frame.getContentPane().add(tabbedPane);

        JPanel panelInserimento = new JPanel();
        tabbedPane.addTab("Inserisci Studente", null, panelInserimento, null);
        panelInserimento.setLayout(null);

        JLabel lblNomeIns = new JLabel("Nome");
        lblNomeIns.setBounds(10, 10, 45, 13);
        panelInserimento.add(lblNomeIns);

        txtNomeIns = new JTextField();
        txtNomeIns.setBounds(128, 10, 96, 19);
        panelInserimento.add(txtNomeIns);
        txtNomeIns.setColumns(10);

        txtCognomeIns = new JTextField();
        txtCognomeIns.setColumns(10);
        txtCognomeIns.setBounds(128, 36, 96, 19);
        panelInserimento.add(txtCognomeIns);

        JLabel lblCognomeIns = new JLabel("Cognome");
        lblCognomeIns.setBounds(10, 36, 65, 13);
        panelInserimento.add(lblCognomeIns);

        JLabel lblTelefonoIns = new JLabel("Telefono");
        lblTelefonoIns.setBounds(10, 68, 65, 13);
        panelInserimento.add(lblTelefonoIns);

        txtTelefono = new JTextField();
        txtTelefono.setColumns(10);
        txtTelefono.setBounds(128, 65, 96, 19);
        panelInserimento.add(txtTelefono);

        JLabel lblEmailIns = new JLabel("Email");
        lblEmailIns.setBounds(10, 94, 45, 13);
        panelInserimento.add(lblEmailIns);

        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        txtEmail.setBounds(128, 94, 96, 19);
        panelInserimento.add(txtEmail);

        JLabel lblCittaIns = new JLabel("Città Di Residenza");
        lblCittaIns.setBounds(10, 125, 108, 13);
        panelInserimento.add(lblCittaIns);

        txtCitta = new JTextField();
        txtCitta.setColumns(10);
        txtCitta.setBounds(128, 122, 96, 19);
        panelInserimento.add(txtCitta);

        JLabel lblCdfIns = new JLabel("Codice Fiscale");
        lblCdfIns.setBounds(10, 157, 96, 13);
        panelInserimento.add(lblCdfIns);

        txtCdf = new JTextField();
        txtCdf.setColumns(10);
        txtCdf.setBounds(128, 151, 96, 19);
        panelInserimento.add(txtCdf);

        JButton btnConfermaIns = new JButton("Conferma");
        btnConfermaIns.setBounds(10, 204, 85, 21);
        panelInserimento.add(btnConfermaIns);

        JButton btnAnnullaIns = new JButton("Annulla");
        btnAnnullaIns.setBounds(139, 204, 85, 21);
        panelInserimento.add(btnAnnullaIns);

        JPanel panelModifica = new JPanel();
        tabbedPane.addTab("Modifica Studente", null, panelModifica, null);
        panelModifica.setLayout(null);

        JButton btnAnnullaIns_1 = new JButton("Annulla");
        btnAnnullaIns_1.setBounds(139, 204, 85, 21);
        panelModifica.add(btnAnnullaIns_1);

        JButton btnConfermaIns_1 = new JButton("Conferma");
        btnConfermaIns_1.setBounds(10, 204, 85, 21);
        panelModifica.add(btnConfermaIns_1);

        txtCdfMod = new JTextField();
        txtCdfMod.setColumns(10);
        txtCdfMod.setBounds(128, 151, 96, 19);
        panelModifica.add(txtCdfMod);

        JLabel lblCdfMod = new JLabel("Codice Fiscale");
        lblCdfMod.setBounds(10, 157, 96, 13);
        panelModifica.add(lblCdfMod);

        JLabel lblCittaMod = new JLabel("Città Di Residenza");
        lblCittaMod.setBounds(10, 125, 108, 13);
        panelModifica.add(lblCittaMod);

        txtCittaMod = new JTextField();
        txtCittaMod.setColumns(10);
        txtCittaMod.setBounds(128, 122, 96, 19);
        panelModifica.add(txtCittaMod);

        txtEmailMod = new JTextField();
        txtEmailMod.setColumns(10);
        txtEmailMod.setBounds(128, 94, 96, 19);
        panelModifica.add(txtEmailMod);

        JLabel lblEmailMod = new JLabel("Email");
        lblEmailMod.setBounds(10, 94, 45, 13);
        panelModifica.add(lblEmailMod);

        JLabel lblTelefonoMod = new JLabel("Telefono");
        lblTelefonoMod.setBounds(10, 68, 61, 13);
        panelModifica.add(lblTelefonoMod);

        txtTelefonoMod = new JTextField();
        txtTelefonoMod.setColumns(10);
        txtTelefonoMod.setBounds(128, 65, 96, 19);
        panelModifica.add(txtTelefonoMod);

        txtCognomeMod = new JTextField();
        txtCognomeMod.setColumns(10);
        txtCognomeMod.setBounds(128, 36, 96, 19);
        panelModifica.add(txtCognomeMod);

        JLabel lblCognomeMod = new JLabel("Cognome");
        lblCognomeMod.setBounds(10, 36, 61, 13);
        panelModifica.add(lblCognomeMod);

        JLabel lblNomeMod = new JLabel("Nome");
        lblNomeMod.setBounds(10, 10, 45, 13);
        panelModifica.add(lblNomeMod);

        txtNomeMod = new JTextField();
        txtNomeMod.setColumns(10);
        txtNomeMod.setBounds(128, 10, 96, 19);
        panelModifica.add(txtNomeMod);

        JPanel panelCerca = new JPanel();
        tabbedPane.addTab("Cerca Studente", null, panelCerca, null);
        panelCerca.setLayout(null);

        txtCdfCer = new JTextField();
        txtCdfCer.setColumns(10);
        txtCdfCer.setBounds(128, 10, 96, 19);
        panelCerca.add(txtCdfCer);

        JLabel lblCdfCer = new JLabel("Codice Fiscale");
        lblCdfCer.setBounds(10, 16, 96, 13);
        panelCerca.add(lblCdfCer);

        JButton btnNewButton = new JButton("Cerca");
        btnNewButton.setBounds(10, 39, 85, 21);
        panelCerca.add(btnNewButton);

        JLabel lblNomeCer = new JLabel("Nome");
        lblNomeCer.setBounds(10, 70, 69, 13);
        panelCerca.add(lblNomeCer);

        JLabel lblCognomeCer = new JLabel("Cognome");
        lblCognomeCer.setBounds(10, 96, 85, 13);
        panelCerca.add(lblCognomeCer);

        JLabel lblTelefonoCer = new JLabel("Telefono");
        lblTelefonoCer.setBounds(10, 128, 69, 13);
        panelCerca.add(lblTelefonoCer);

        JLabel lblEmailCer = new JLabel("Email");
        lblEmailCer.setBounds(10, 154, 69, 13);
        panelCerca.add(lblEmailCer);

        JLabel lblCittaCer = new JLabel("Città Di Residenza");
        lblCittaCer.setBounds(10, 185, 110, 13);
        panelCerca.add(lblCittaCer);

        JLabel lblNomeOut = new JLabel("");
        lblNomeOut.setBounds(128, 70, 139, 13);
        panelCerca.add(lblNomeOut);

        JLabel lblCognomeOut = new JLabel("");
        lblCognomeOut.setBounds(128, 96, 96, 13);
        panelCerca.add(lblCognomeOut);

        JLabel lblTelefonoOut = new JLabel("");
        lblTelefonoOut.setBounds(128, 128, 96, 13);
        panelCerca.add(lblTelefonoOut);

        JLabel lblEmailOut = new JLabel("");
        lblEmailOut.setBounds(128, 154, 96, 13);
        panelCerca.add(lblEmailOut);

        JLabel lblCittaOut = new JLabel("");
        lblCittaOut.setBounds(128, 185, 96, 13);
        panelCerca.add(lblCittaOut);
    }
}
