package fenetres;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.Connection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Frame;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.ImageIcon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.Toolkit;
//import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Component;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableModel;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.JDesktopPane;
import java.awt.Rectangle;
import java.awt.SystemColor;

public class main<conn> extends JFrame {

	Connection conn = null;
	
	ResultSet rs = null;
	PreparedStatement pst = null;
	private JPanel Accueil;
	private JPanel Inscription;
	private JPanel Vehicule;
	private JPanel contentPane;
	private JTextField pseudoConnexion;
	private JTextField motDePasseConnexion;
	private JTextField pseudo;
	private JTextField repeterMotDePasse;
	private JTextField nom;
	private JTextField prenom;
	private JTextField naissance;
	private JTextField adresse;
	private JTextField telephone;
	private JTextField mail;
	private JTextField marque;
	private JTextField modele;
	private JTextField annee;
	private JTextField categorie;
	private JTextField motorisation;
	private JTextField puissance;
	private JTextField motDePasse;
	
	private JLabel labelUtilisateur;
	private String utilisateurCourant;
	private int vehiculeCourant;
	private JPanel Bienvenue;
	private JPanel MesVehicules;
	private JPanel MesTrajets;
	private JPanel MesInformations;
	private JTextField MesVehiculesMarque;
	private JTextField MesVehiculesModele;
	private JTextField MesVehiculesAnnee;
	private JTextField MesVehiculesCategorie;
	private JTextField MesVehiculesMotorisation;
	private JTextField MesVehiculesPuissance;
	private JTextField MesInfosPseudo;
	private JTextField MesInfosMdp;
	private JTextField MesInfosRepeterMdp;
	private JTextField MesInfosNom;
	private JTextField MesInfosPrenom;
	private JTextField MesInfosDateNaissance;
	private JTextField MesInfosAdresse;
	private JTextField MesInfosTelephone;
	private JTextField MesInfosMail;
	private JTextField cp;
	private JTextField ville;
	private JTextField MesInfosCP;
	private JTextField MesInfosVille;
	private JCheckBox permisA;
	private JCheckBox permisB;
	private JCheckBox permisC;
	private JCheckBox permisD;
	private JCheckBox MesPermisPermisD;
	private JCheckBox MesPermisPermisC;
	private JCheckBox MesPermisPermisB;
	private JCheckBox MesPermisPermisA;
	private JPanel MesPermis;
	private int compteurVehicule = 1;
	private int compteurTrajet = 1;
	private JTextField CPVilleDepart;
	private JTextField NomVilleDepart;
	private JTextField CPVilleArrivee;
	private JTextField NomVilleArrivee;
	private JTextField DateVoyage;
	private JTextField DistanceVoyage;
	private JTextField PlaceDispo;
	private JTextField Prix;
	private JPanel ProposerTrajet;
	private JPanel RechercherTrajet;
	private JButton MesTrajetsModifier;
	private JButton MesTrajetsAnnuler;
	private JButton MesTrajetsSupprimer;
	private JButton MesTrajetsPrecedent;
	private JComboBox comboBoxVehicule;
	private JComboBox comboBoxVehiculeTrajet;
	private JTextField MesTrajetsCPVilleDepart;
	private JTextField MesTrajetsNomVilleDepart;
	private JTextField MesTrajetsCPVilleArrivee;
	private JTextField MesTrajetsNomVilleArrivee;
	private JTextField MesTrajetsDateVoyage;
	private JTextField MesTrajetsDistanceVoyage;
	private JTextField MesTrajetsPlacesDispo;
	private JTextField MesTrajetsPrix;
	private JTextField rechercherCPVilleArrivee;
	private JTextField rechercherCPVilleDepart;
	private JTextField rechercherNomVilleDepart;
	private JTextField rechercherNomVilleArrivee;
	private JTextField rechercherDate;
	public int numVehicule;
    private JTable table_afficher_consult_cov;
	private int trajetChoisi;
	private	JScrollPane scrollPane = new JScrollPane();
	private String participantChoisi;
	private Integer covoiturageChoisi;

	private String identifiantParticipation;
	private Integer trajetParticiaption;

    MyTableModel model_table_afficher_cov = new MyTableModel();
    MyTableModelCheckbox model_table_trajet = new MyTableModelCheckbox();
    MyTableModelMesParticipations model_table_mesParticipations = new MyTableModelMesParticipations();

	private Integer trajetParticipation;
	private int trajetCourant;
	private JTable table;
	private JLabel infoUtilisateur;
	private JButton btnParticiper;
	private JTable table_mesTrajets;
	private JPanel MesParticipations;
	private JTable table_mesParticipations;
	private JLabel infoParticipation;
	private JButton boutonSupprimerListe;
	private JButton boutonSupprimer;
	private JScrollPane scrollPane_rechercherTrajet;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main() {
		setResizable(false);
		setVisible(true);

		conn = ConnectDb();
		
		/*Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0,screen.width,screen.height - 30);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		contentPane.setVisible(true);
		contentPane.setEnabled(false);
		

		
		Bienvenue = new JPanel();
		Bienvenue.setBounds(0, 0, 761, 488);
		contentPane.add(Bienvenue);
		
		this.labelUtilisateur = new JLabel("connecté en tant que " + utilisateurCourant);
		labelUtilisateur.setBounds(6, 5, 203, 16);
		
		//----------------------------------------------------DECONNEXION------------------------------------
		JButton deconnexion = new JButton("Déconnexion");
		deconnexion.setBounds(627, 5, 117, 29);
		deconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deconnexion();
			}
		});
		
		JToolBar toolBar = new JToolBar();
		toolBar.setEnabled(false);
		toolBar.setBounds(16, 33, 698, 20);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		menuBar.setBorderPainted(false);
		menuBar.setAutoscrolls(true);
		toolBar.add(menuBar);
		
		JMenu mnMonProfil = new JMenu("Mon profil                       ");
		mnMonProfil.setAutoscrolls(true);
		mnMonProfil.setHorizontalAlignment(SwingConstants.TRAILING);
		menuBar.add(mnMonProfil);
		
		JMenuItem mntmMesVhicules = new JMenuItem("Mes véhicules");
		mntmMesVhicules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficherVehicule(1);
				int nbVehicule = compterVehicule();
				/*MesPermis.setVisible(false);
				MesTrajets.setVisible(false);
				MesInformations.setVisible(false);
				MesVehicules.setVisible(true);*/
			}
		});
		mnMonProfil.add(mntmMesVhicules);
		
		JMenuItem mntmMesTrajets = new JMenuItem("Mes trajets");
		
		
		mntmMesTrajets.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				chargerTableMesTrajets();
				afficherVehicule(1);
				int nbVehicule = compterVehicule();
				
				
				afficherListeVehiculesTrajet();
				afficherTrajets(compteurTrajet);
				
				/*ProposerTrajet.setVisible(false);
				RechercherTrajet.setVisible(false);
				MesPermis.setVisible(false);
				MesVehicules.setVisible(false);
				MesInformations.setVisible(false);
				MesTrajets.setVisible(true);*/
				
			}
		});
		mnMonProfil.add(mntmMesTrajets);
		
		JMenuItem mntmMesPermis = new JMenuItem("Mes Permis");
		mntmMesPermis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficherPermis();
				ProposerTrajet.setVisible(false);
				RechercherTrajet.setVisible(false);
				MesTrajets.setVisible(false);
				MesVehicules.setVisible(false);
				MesInformations.setVisible(false);
				MesParticipations.setVisible(false);

				MesPermis.setVisible(true);
			}
		});
		mnMonProfil.add(mntmMesPermis);
		
		JMenuItem mntmMesInformations = new JMenuItem("Mes informations");
		mnMonProfil.add(mntmMesInformations);
		
		JMenuItem mntmMesParticipations = new JMenuItem("Mes participations");
		mnMonProfil.add(mntmMesParticipations);
		mntmMesParticipations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//afficherParticipations();
				chargerParticipations();
				ProposerTrajet.setVisible(false);
				RechercherTrajet.setVisible(false);
				MesTrajets.setVisible(false);
				MesVehicules.setVisible(false);
				MesPermis.setVisible(false);
				MesInformations.setVisible(false);
				MesParticipations.setVisible(true);
			}
		});
		mntmMesInformations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficherInformations();
				ProposerTrajet.setVisible(false);
				RechercherTrajet.setVisible(false);
				MesTrajets.setVisible(false);
				MesVehicules.setVisible(false);
				MesPermis.setVisible(false);
				MesParticipations.setVisible(false);

				MesInformations.setVisible(true);
			}
		});
		
		JMenuItem mntmProposerUnTrajet = new JMenuItem("Proposer un trajet");
		mntmProposerUnTrajet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nbVehicule = compterVehicule();
				if (nbVehicule > 0 && verifierPermis("A") || verifierPermis("B") || verifierPermis("C") || verifierPermis("D")  ){
				
					afficherListeVehicules();
					RechercherTrajet.setVisible(false);
					MesTrajets.setVisible(false);
					MesVehicules.setVisible(false);
					MesPermis.setVisible(false);
					MesInformations.setVisible(false);
					MesParticipations.setVisible(false);

					ProposerTrajet.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "Vous devez posséder un permis et au moins 1 véhicule.");
				}
				
			}
		});
		toolBar.add(mntmProposerUnTrajet);
		
		JMenuItem mntmRechercherUnTrajet = new JMenuItem("Rechercher un trajet");
		mntmRechercherUnTrajet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//rechercherTrajet();
				RechercherTrajet.setVisible(true);
				MesTrajets.setVisible(false);
				MesVehicules.setVisible(false);
				MesPermis.setVisible(false);
				MesInformations.setVisible(false);
				MesParticipations.setVisible(false);

				ProposerTrajet.setVisible(false);
			}
		});
		toolBar.add(mntmRechercherUnTrajet);
			Bienvenue.setLayout(null);
			Bienvenue.add(labelUtilisateur);
			Bienvenue.add(deconnexion);
			Bienvenue.add(toolBar);
					
					
					//_______________________________Panel MesVehicules--------------------------
						
					MesVehicules = new JPanel();
					MesVehicules.setBounds(6, 65, 749, 417);
					MesVehicules.setVisible(false);
					MesVehicules.setBackground(Color.WHITE);
					MesVehicules.setLayout(null);
					
					
					JLabel lblVehicules = new JLabel("Véhicule n°" +1);
					lblVehicules.setBounds(314, 6, 142, 16);
					MesVehicules.add(lblVehicules);
					
						JLabel lblMesVehiculeMarque = new JLabel("Marque");
						lblMesVehiculeMarque.setBounds(246, 55, 61, 16);
						MesVehicules.add(lblMesVehiculeMarque);
						
						MesVehiculesMarque = new JTextField();
						MesVehiculesMarque.setBounds(368, 49, 134, 28);
						MesVehicules.add(MesVehiculesMarque);
						MesVehiculesMarque.setColumns(10);
						
						JLabel lblMesVehiculeModele = new JLabel("Modele");
						lblMesVehiculeModele.setBounds(246, 95, 61, 16);
						MesVehicules.add(lblMesVehiculeModele);
						
						MesVehiculesModele = new JTextField();
						MesVehiculesModele.setBounds(368, 89, 134, 28);
						MesVehicules.add(MesVehiculesModele);
						MesVehiculesModele.setColumns(10);
						
						JLabel lblMesVehiculesAnnee = new JLabel("Année");
						lblMesVehiculesAnnee.setBounds(246, 135, 61, 16);
						MesVehicules.add(lblMesVehiculesAnnee);
						
						MesVehiculesAnnee = new JTextField();
						MesVehiculesAnnee.setBounds(368, 129, 134, 28);
						MesVehicules.add(MesVehiculesAnnee);
						MesVehiculesAnnee.setColumns(10);
						
						MesVehiculesCategorie = new JTextField();
						MesVehiculesCategorie.setBounds(368, 169, 134, 28);
						MesVehicules.add(MesVehiculesCategorie);
						MesVehiculesCategorie.setColumns(10);
						
						JLabel lblMesVehiculesCategorie = new JLabel("Categorie");
						lblMesVehiculesCategorie.setBounds(246, 175, 61, 16);
						MesVehicules.add(lblMesVehiculesCategorie);
						
						MesVehiculesMotorisation = new JTextField();
						MesVehiculesMotorisation.setBounds(368, 209, 134, 28);
						MesVehicules.add(MesVehiculesMotorisation);
						MesVehiculesMotorisation.setColumns(10);
						
						JLabel lblMotorisation_2 = new JLabel("Motorisation");
						lblMotorisation_2.setBounds(227, 215, 80, 16);
						MesVehicules.add(lblMotorisation_2);
						
						MesVehiculesPuissance = new JTextField();
						MesVehiculesPuissance.setBounds(368, 249, 134, 28);
						MesVehicules.add(MesVehiculesPuissance);
						MesVehiculesPuissance.setColumns(10);
						
						JLabel lblMesVehiculesPuissance = new JLabel("Puissance");
						lblMesVehiculesPuissance.setBounds(237, 255, 70, 16);
						MesVehicules.add(lblMesVehiculesPuissance);
						
						JButton btnAnnuler = new JButton("Annuler");
						btnAnnuler.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								afficherVehicule(1);
							}
						});
						btnAnnuler.setBounds(142, 314, 117, 29);
						MesVehicules.add(btnAnnuler);
						
						JButton MesVehiculesModifier = new JButton("Modifier");
						MesVehiculesModifier.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								modifierVehicule(vehiculeCourant);
							}
						});
						MesVehiculesModifier.setBounds(326, 314, 117, 29);
						MesVehicules.add(MesVehiculesModifier);
						
						JButton MesVehiculesSupprimer = new JButton("Supprimer");
						MesVehiculesSupprimer.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								supprimerVehicule(vehiculeCourant);
								MesVehicules.setVisible(false);
							}
						});
						MesVehiculesSupprimer.setBounds(503, 314, 117, 29);
						MesVehicules.add(MesVehiculesSupprimer);
						
						JButton MesVehiculesAjouter = new JButton("Ajouter un véhicule");
						MesVehiculesAjouter.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ajouterVehicule();
							}
						});
						MesVehiculesAjouter.setBounds(23, 6, 154, 29);
						MesVehicules.add(MesVehiculesAjouter);
						
						JButton btnSuivant = new JButton("");
						btnSuivant.setIcon(new ImageIcon(main.class.getResource("/fenetres/suivant.png")));
						btnSuivant.setBorder(null);
						btnSuivant.setBorderPainted(false);
						btnSuivant.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								//fonction qui compte les véhicules, ou alors arrayList de véhicule
								int nbVehicule = compterVehicule();
								compteurVehicule ++;
								if (compteurVehicule <= nbVehicule){
									afficherVehicule(compteurVehicule);	
									lblVehicules.setText("Véhicule n°" + compteurVehicule);
								}
								else {
									JOptionPane.showMessageDialog(null, "Il n'y a pas de véhicule suivant");
									//lblVehicules.setText("Véhicule n°" + compteurVehicule);
									compteurVehicule --;
								}
							}
						});
						btnSuivant.setBounds(556, 135, 117, 37);
						MesVehicules.add(btnSuivant);
						
						JButton btnPrcdent = new JButton("");
						btnPrcdent.setBorderPainted(false);
						btnPrcdent.setBorder(null);
						btnPrcdent.setIcon(new ImageIcon(main.class.getResource("/fenetres/precedent.png")));
						btnPrcdent.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								int nbVehicule = compterVehicule();
								compteurVehicule --;
								if (compteurVehicule > 0){
									lblVehicules.setText("Véhicule n°" + compteurVehicule);
									afficherVehicule(compteurVehicule);
								}
								else {
									JOptionPane.showMessageDialog(null, "Il n'y a pas de véhicule précédent");
									compteurVehicule ++;
									lblVehicules.setText("Véhicule n°" + compteurVehicule);
								}
							}
						});
							
							//-------------------------------Panel MesPermis-----------------------------------
							MesPermis = new JPanel();
							MesPermis.setBounds(6, 65, 749, 417);
							MesPermis.setVisible(false);
							MesPermis.setLayout(null);
							
							JLabel lblListeDeVos = new JLabel("Liste de vos permis avec leur définition");
							lblListeDeVos.setBounds(251, 5, 247, 16);
							MesPermis.add(lblListeDeVos);
							
							MesPermisPermisA = new JCheckBox("Permis A");
							MesPermisPermisA.setBounds(69, 57, 88, 23);
							MesPermis.add(MesPermisPermisA);
							
							MesPermisPermisB = new JCheckBox("Permis B");
							MesPermisPermisB.setBounds(69, 128, 88, 23);
							MesPermis.add(MesPermisPermisB);
							
							MesPermisPermisC = new JCheckBox("Permis C");
							MesPermisPermisC.setBounds(69, 204, 88, 23);
							MesPermis.add(MesPermisPermisC);
							
							MesPermisPermisD = new JCheckBox("Permis D");
							MesPermisPermisD.setBounds(69, 274, 88, 23);
							MesPermis.add(MesPermisPermisD);
							
							JLabel lblLePermisA = new JLabel("Le permis A permet de conduire toutes les motos avec ou sans side-car");
							lblLePermisA.setBounds(199, 57, 528, 23);
							MesPermis.add(lblLePermisA);
							
							JLabel lblNewLabel_1 = new JLabel("et tous les 3 roues à moteur quelle que soit leur puissance.");
							lblNewLabel_1.setBounds(199, 79, 419, 16);
							MesPermis.add(lblNewLabel_1);
							
							JLabel lblLePermisB = new JLabel("Le permis B permet la conduite des véhicules dont le PTAC \n");
							lblLePermisB.setBounds(199, 132, 528, 16);
							MesPermis.add(lblLePermisB);
							
							JLabel lblNewLabel_2 = new JLabel("(poids total autorisé en charge) est inférieur ou égal à 3,5 tonnes.");
							lblNewLabel_2.setBounds(199, 149, 430, 16);
							MesPermis.add(lblNewLabel_2);
							
							JLabel lblNewLabel_3 = new JLabel("Le permis C autorise la conduite des véhicules affectés au transport de ");
							lblNewLabel_3.setBounds(199, 204, 459, 16);
							MesPermis.add(lblNewLabel_3);
							
							JLabel lblMarchandisesOuDe = new JLabel("marchandises ou de matériel dont le PTAC est supérieur à 7,5 tonnes.");
							lblMarchandisesOuDe.setBounds(199, 221, 459, 16);
							MesPermis.add(lblMarchandisesOuDe);
							
							JLabel lblLePermisD = new JLabel("Le permis D autorise la conduite des véhicules affectés au transport de");
							lblLePermisD.setBounds(199, 278, 459, 16);
							MesPermis.add(lblLePermisD);
							
							JLabel lblComportantPlusDe = new JLabel("comportant plus de 8 places assises outre le siège du conducteur.");
							lblComportantPlusDe.setBounds(199, 295, 459, 16);
							MesPermis.add(lblComportantPlusDe);
							
							JButton btnActualiserPermis = new JButton("Actualiser");
							btnActualiserPermis.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									actualiserPermis();
								}
							});
							
							//______________________________Panel MesInformations-----------------------
							MesInformations = new JPanel();
							MesInformations.setBounds(6, 65, 749, 417);
							MesInformations.setBackground(new Color(0, 191, 255));
							MesInformations.setVisible(false);
							MesInformations.setLayout(null);
							
	
								JLabel lblMesInformations = new JLabel("Mes Informations");
								lblMesInformations.setBounds(319, 5, 110, 16);
								MesInformations.add(lblMesInformations);
								
								JLabel lblNewLabel = new JLabel("Pseudo :");
								lblNewLabel.setBounds(208, 50, 57, 14);
								MesInformations.add(lblNewLabel);
								
								MesInfosPseudo = new JTextField();
								MesInfosPseudo.setBounds(319, 47, 123, 20);
								MesInfosPseudo.setEnabled(false);
								MesInformations.add(MesInfosPseudo);
								MesInfosPseudo.setColumns(10);
								
								JLabel lblMotDePass = new JLabel("Mot de passe :");
								lblMotDePass.setBounds(171, 75, 94, 14);
								MesInformations.add(lblMotDePass);
								
								MesInfosMdp = new JTextField();
								MesInfosMdp.setBounds(319, 72, 123, 20);
								MesInformations.add(MesInfosMdp);
								MesInfosMdp.setColumns(10);
								
								JLabel lblRpterMotDe = new JLabel("Répéter mot de passe :");
								lblRpterMotDe.setBounds(120, 100, 145, 14);
								MesInformations.add(lblRpterMotDe);
								
								MesInfosRepeterMdp = new JTextField();
								MesInfosRepeterMdp.setBounds(319, 97, 123, 20);
								MesInformations.add(MesInfosRepeterMdp);
								MesInfosRepeterMdp.setColumns(10);
								
								JLabel lblNom = new JLabel("Nom :");
								lblNom.setBounds(208, 154, 46, 14);
								MesInformations.add(lblNom);
								
								MesInfosNom = new JTextField();
								MesInfosNom.setBounds(319, 151, 123, 20);
								MesInformations.add(MesInfosNom);
								MesInfosNom.setColumns(10);
								
								JLabel lblPrenom = new JLabel("Prenom :");
								lblPrenom.setBounds(197, 178, 68, 14);
								MesInformations.add(lblPrenom);
								
								MesInfosPrenom = new JTextField();
								MesInfosPrenom.setBounds(319, 175, 123, 20);
								MesInformations.add(MesInfosPrenom);
								MesInfosPrenom.setColumns(10);
								
								MesInfosDateNaissance = new JTextField();
								MesInfosDateNaissance.setBounds(319, 200, 123, 20);
								MesInformations.add(MesInfosDateNaissance);
								MesInfosDateNaissance.setColumns(10);
								
								JLabel lblDateDeNaissance = new JLabel("Date de naissance :");
								lblDateDeNaissance.setBounds(144, 203, 122, 14);
								MesInformations.add(lblDateDeNaissance);
								
								JLabel lblAdresse = new JLabel("Adresse :");
								lblAdresse.setBounds(17, 228, 68, 14);
								MesInformations.add(lblAdresse);
								
								MesInfosAdresse = new JTextField();
								MesInfosAdresse.setBounds(84, 225, 134, 20);
								MesInformations.add(MesInfosAdresse);
								MesInfosAdresse.setColumns(10);
								
								JLabel lblTlphone = new JLabel("T\u00E9l\u00E9phone :");
								lblTlphone.setBounds(182, 253, 83, 14);
								MesInformations.add(lblTlphone);
								
								MesInfosTelephone = new JTextField();
								MesInfosTelephone.setBounds(319, 250, 123, 20);
								MesInformations.add(MesInfosTelephone);
								MesInfosTelephone.setColumns(10);
								
								JLabel lblMail = new JLabel("Mail :");
								lblMail.setBounds(208, 278, 57, 14);
								MesInformations.add(lblMail);
								
								MesInfosMail = new JTextField();
								MesInfosMail.setBounds(318, 275, 124, 20);
								MesInformations.add(MesInfosMail);
								MesInfosMail.setColumns(10);
								
								JButton btnModifier_1 = new JButton("Modifier");
								btnModifier_1.setBounds(144, 326, 89, 23);
								btnModifier_1.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										modifierInformations();
									}
								});
								MesInformations.add(btnModifier_1);
								
								JButton btnAnnuler_1 = new JButton("Annuler");
								btnAnnuler_1.setBounds(290, 326, 89, 23);
								btnAnnuler_1.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										afficherInformations();
									}
								});
								MesInformations.add(btnAnnuler_1);
								
								JButton btnSuppimerLeCompte = new JButton("Suppimer le compte");
								btnSuppimerLeCompte.setBounds(428, 326, 145, 23);
								btnSuppimerLeCompte.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										supprimerInformations();
									}
								});
								
								RechercherTrajet = new JPanel();
								RechercherTrajet.setBounds(6, 65, 737, 417);
								RechercherTrajet.setVisible(false);
								RechercherTrajet.setLayout(null);
								
								JLabel lblCpVilleDe = new JLabel("CP ville de départ :");
								lblCpVilleDe.setBounds(68, 30, 117, 16);
								RechercherTrajet.add(lblCpVilleDe);
								
								rechercherCPVilleDepart = new JTextField();
								rechercherCPVilleDepart.setText("91890");
								rechercherCPVilleDepart.setBounds(197, 25, 130, 26);
								RechercherTrajet.add(rechercherCPVilleDepart);
								rechercherCPVilleDepart.setColumns(10);
								rechercherCPVilleDepart.addKeyListener(new KeyAdapter() {
									@Override
									public void keyReleased(KeyEvent arg0) {
										Rechercher_dynamique_ville_depart_nom(rechercherCPVilleDepart.getText()+"%");
									}
								});
								
								JLabel lblNewLabel_9 = new JLabel("CP ville d'arrivée :");
								lblNewLabel_9.setBounds(68, 78, 117, 16);
								RechercherTrajet.add(lblNewLabel_9);
								
								rechercherCPVilleArrivee = new JTextField();
								rechercherCPVilleArrivee.setText("91150");
								rechercherCPVilleArrivee.setBounds(197, 73, 130, 26);
								RechercherTrajet.add(rechercherCPVilleArrivee);
								rechercherCPVilleArrivee.setColumns(10);
								rechercherCPVilleArrivee.addKeyListener(new KeyAdapter() {
									@Override
									public void keyReleased(KeyEvent arg0) {
										Rechercher_dynamique_ville_arrivee_nom(rechercherCPVilleArrivee.getText()+"%");
									}
								});
								
								JLabel lblVilleDarrive = new JLabel("Ville de départ :");
								lblVilleDarrive.setBounds(376, 30, 101, 16);
								RechercherTrajet.add(lblVilleDarrive);
								
								JLabel lblNewLabel_10 = new JLabel("Ville d'arrivée :");
								lblNewLabel_10.setBounds(376, 78, 101, 16);
								RechercherTrajet.add(lblNewLabel_10);
								
								rechercherNomVilleDepart = new JTextField();
								rechercherNomVilleDepart.setBounds(489, 25, 130, 26);
								RechercherTrajet.add(rechercherNomVilleDepart);
								rechercherNomVilleDepart.setColumns(10);
								
								rechercherNomVilleDepart.addKeyListener(new KeyAdapter() {
									@Override
									public void keyReleased(KeyEvent arg0) {
										Rechercher_dynamique_ville_depart_cp(rechercherNomVilleDepart.getText()+"%");
									}
								});
								
								rechercherNomVilleArrivee = new JTextField();
								rechercherNomVilleArrivee.setBounds(489, 73, 130, 26);
								RechercherTrajet.add(rechercherNomVilleArrivee);
								rechercherNomVilleArrivee.setColumns(10);
								rechercherNomVilleArrivee.addKeyListener(new KeyAdapter() {
									@Override
									public void keyReleased(KeyEvent arg0) {
										Rechercher_dynamique_ville_arrivee_cp(rechercherNomVilleArrivee.getText()+"%");
									}
								});
								
								JLabel lblDate_1 = new JLabel("Date :");
								lblDate_1.setBounds(283, 125, 44, 16);
								RechercherTrajet.add(lblDate_1);
								
								rechercherDate = new JTextField();
								rechercherDate.setText("2012-12-12");
								rechercherDate.setBounds(336, 120, 130, 26);
								RechercherTrajet.add(rechercherDate);
								rechercherDate.setColumns(10);
								
								table_afficher_consult_cov = new JTable();
								table_afficher_consult_cov.setBorder(new LineBorder(new Color(0, 0, 0)));
								table_afficher_consult_cov.setModel(model_table_afficher_cov);
								//table_afficher_consult_cov.setBounds(6, 199, 725, 116);
								table_afficher_consult_cov.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent evt) {
										int row = table_afficher_consult_cov.getSelectedRow();
										if (SwingUtilities.isLeftMouseButton(evt)){
											//Afficher les information du conducteur sur le covoiturage sélectionné
											trajetChoisi = (Integer)table_afficher_consult_cov.getModel().getValueAt(row, 0);
											AfficherInfoConducteur((Integer) table_afficher_consult_cov.getModel().getValueAt(row, 0));
										}
									}
								});
								//RechercherTrajet.add(table_afficher_consult_cov);
								
								
								JButton btnRechercher = new JButton("Rechercher");
								btnRechercher.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										rechercherTrajet();
									}
								});
									
									
									ProposerTrajet = new JPanel();
									ProposerTrajet.setBounds(6, 65, 737, 433);
									ProposerTrajet.setVisible(false);
									ProposerTrajet.setLayout(null);
									
										JLabel lblCpVilleDpart = new JLabel("CP Ville Départ :");
										lblCpVilleDpart.setBounds(81, 94, 101, 16);
										ProposerTrajet.add(lblCpVilleDpart);
										
										CPVilleDepart = new JTextField();
										CPVilleDepart.setBounds(194, 89, 130, 26);
										ProposerTrajet.add(CPVilleDepart);
										CPVilleDepart.setColumns(10);
										CPVilleDepart.addKeyListener(new KeyAdapter() {
											@Override
											public void keyReleased(KeyEvent arg0) {
												Rechercher_dynamique_ville_depart_nom_proposer(CPVilleDepart.getText()+"%");
											}
										});
										
										JLabel lblNomVilleDpart = new JLabel("Nom Ville départ :");
										lblNomVilleDpart.setBounds(379, 140, 113, 16);
										ProposerTrajet.add(lblNomVilleDpart);
										
										NomVilleDepart = new JTextField();
										NomVilleDepart.setBounds(504, 135, 130, 26);
										ProposerTrajet.add(NomVilleDepart);
										NomVilleDepart.setColumns(10);
										NomVilleDepart.addKeyListener(new KeyAdapter() {
											@Override
											public void keyReleased(KeyEvent arg0) {
												Rechercher_dynamique_ville_depart_cp_proposer(NomVilleDepart.getText()+"%");
											}
										});
										
										JLabel lblNewLabel_7 = new JLabel("CP Ville Arrivee :");
										lblNewLabel_7.setBounds(389, 94, 103, 16);
										ProposerTrajet.add(lblNewLabel_7);
										
										CPVilleArrivee = new JTextField();
										CPVilleArrivee.setBounds(504, 89, 130, 26);
										ProposerTrajet.add(CPVilleArrivee);
										CPVilleArrivee.setColumns(10);
										CPVilleArrivee.addKeyListener(new KeyAdapter() {
											@Override
											public void keyReleased(KeyEvent arg0) {
												Rechercher_dynamique_ville_arrivee_nom_proposer(CPVilleArrivee.getText()+"%");
											}
										});
										
										JLabel lblNomVilleArrive = new JLabel("Nom Ville Arrivée :");
										lblNomVilleArrive.setBounds(65, 140, 117, 16);
										ProposerTrajet.add(lblNomVilleArrive);
										
										NomVilleArrivee = new JTextField();
										NomVilleArrivee.setBounds(194, 135, 130, 26);
										ProposerTrajet.add(NomVilleArrivee);
										NomVilleArrivee.setColumns(10);
										NomVilleArrivee.addKeyListener(new KeyAdapter() {
											@Override
											public void keyReleased(KeyEvent arg0) {
												Rechercher_dynamique_ville_arrivee_cp_proposer(NomVilleArrivee.getText()+"%");
											}
										});
										
										JLabel lblDate = new JLabel("Date :");
										lblDate.setBounds(145, 196, 37, 16);
										ProposerTrajet.add(lblDate);
										
										DateVoyage = new JTextField();
										DateVoyage.setBounds(194, 191, 130, 26);
										ProposerTrajet.add(DateVoyage);
										DateVoyage.setColumns(10);
										
										JLabel lblDistance = new JLabel("Distance :");
										lblDistance.setBounds(429, 196, 63, 16);
										ProposerTrajet.add(lblDistance);
										
										DistanceVoyage = new JTextField();
										DistanceVoyage.setBounds(504, 191, 130, 26);
										ProposerTrajet.add(DistanceVoyage);
										DistanceVoyage.setColumns(10);
										
										JLabel lblPlacesDisponibles = new JLabel("Places disponibles :");
										lblPlacesDisponibles.setBounds(58, 234, 124, 16);
										ProposerTrajet.add(lblPlacesDisponibles);
										
										PlaceDispo = new JTextField();
										PlaceDispo.setBounds(194, 229, 130, 26);
										ProposerTrajet.add(PlaceDispo);
										PlaceDispo.setColumns(10);
										
										JLabel lblPrix = new JLabel("Prix :");
										lblPrix.setBounds(460, 234, 32, 16);
										ProposerTrajet.add(lblPrix);
										
										Prix = new JTextField();
										Prix.setBounds(504, 229, 130, 26);
										ProposerTrajet.add(Prix);
										Prix.setColumns(10);
										
										JLabel lblVhicule = new JLabel("Véhicule");
										lblVhicule.setBounds(214, 282, 53, 16);
										ProposerTrajet.add(lblVhicule);
										
										JButton btnAjouterTrajet = new JButton("Ajouter");
										btnAjouterTrajet.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												insererCovoiturage();
											}
										});
										btnAjouterTrajet.setBounds(214, 341, 90, 29);
										ProposerTrajet.add(btnAjouterTrajet);
										
										JButton btnAnnuler_2 = new JButton("Annuler");
										btnAnnuler_2.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
											}
										});
										
										//------------------------------Panel MesInformations-----------------------
										MesTrajets = new JPanel();
										MesTrajets.setBounds(6, 65, 749, 417);
										MesTrajets.setBackground(Color.LIGHT_GRAY);
										MesTrajets.setVisible(false);
										MesTrajets.setLayout(null);
										
										JLabel lblMesTrajets = new JLabel("Trajet n°1");
										lblMesTrajets.setBounds(340, 5, 69, 16);
										MesTrajets.add(lblMesTrajets);
										
										JLabel lblCpVilleDpart_1 = new JLabel("CP ville départ :");
										lblCpVilleDpart_1.setBounds(121, 55, 98, 16);
										MesTrajets.add(lblCpVilleDpart_1);
										
										MesTrajetsCPVilleDepart = new JTextField();
										MesTrajetsCPVilleDepart.setBounds(231, 49, 98, 28);
										MesTrajets.add(MesTrajetsCPVilleDepart);
										MesTrajetsCPVilleDepart.setColumns(10);
										
										JLabel lblCpVilleArrive = new JLabel("CP ville arrivée :");
										lblCpVilleArrive.setBounds(113, 92, 106, 16);
										MesTrajets.add(lblCpVilleArrive);
										
										MesTrajetsNomVilleDepart = new JTextField();
										MesTrajetsNomVilleDepart.setBounds(466, 49, 134, 28);
										MesTrajets.add(MesTrajetsNomVilleDepart);
										MesTrajetsNomVilleDepart.setColumns(10);
										
										MesTrajetsCPVilleArrivee = new JTextField();
										MesTrajetsCPVilleArrivee.setBounds(231, 89, 98, 28);
										MesTrajets.add(MesTrajetsCPVilleArrivee);
										MesTrajetsCPVilleArrivee.setColumns(10);
										
										JLabel lblNomVilleDpart_1 = new JLabel("Nom ville départ :");
										lblNomVilleDpart_1.setBounds(348, 55, 121, 16);
										MesTrajets.add(lblNomVilleDpart_1);
										
										JLabel lblNomVilleArrive_1 = new JLabel("Nom ville arrivée :");
										lblNomVilleArrive_1.setBounds(348, 95, 121, 16);
										MesTrajets.add(lblNomVilleArrive_1);
										
										MesTrajetsNomVilleArrivee = new JTextField();
										MesTrajetsNomVilleArrivee.setBounds(466, 86, 134, 28);
										MesTrajets.add(MesTrajetsNomVilleArrivee);
										MesTrajetsNomVilleArrivee.setColumns(10);
										
										JLabel lblDateVoyae = new JLabel("Date voyage :");
										lblDateVoyae.setBounds(132, 142, 98, 16);
										MesTrajets.add(lblDateVoyae);
										
										MesTrajetsDateVoyage = new JTextField();
										MesTrajetsDateVoyage.setBounds(231, 136, 107, 28);
										MesTrajets.add(MesTrajetsDateVoyage);
										MesTrajetsDateVoyage.setColumns(10);
										
										JLabel lblDistanceVoyage = new JLabel("Distance voyage :");
										lblDistanceVoyage.setBounds(352, 142, 117, 16);
										MesTrajets.add(lblDistanceVoyage);
										
										MesTrajetsDistanceVoyage = new JTextField();
										MesTrajetsDistanceVoyage.setBounds(466, 136, 82, 28);
										MesTrajets.add(MesTrajetsDistanceVoyage);
										MesTrajetsDistanceVoyage.setColumns(10);
										
										JLabel lblNewLabel_8 = new JLabel("Places disponibles :");
										lblNewLabel_8.setBounds(125, 178, 124, 16);
										MesTrajets.add(lblNewLabel_8);
										
										MesTrajetsPlacesDispo = new JTextField();
										MesTrajetsPlacesDispo.setBounds(256, 170, 82, 28);
										MesTrajets.add(MesTrajetsPlacesDispo);
										MesTrajetsPlacesDispo.setColumns(10);
										
										JLabel lblPrix_1 = new JLabel("Prix :");
										lblPrix_1.setBounds(431, 178, 38, 16);
										MesTrajets.add(lblPrix_1);
										
										MesTrajetsPrix = new JTextField();
										MesTrajetsPrix.setBounds(466, 170, 74, 28);
										MesTrajets.add(MesTrajetsPrix);
										MesTrajetsPrix.setColumns(10);
										
										
										JLabel lblVhicule_1 = new JLabel("Véhicule :");
										lblVhicule_1.setBounds(180, 214, 69, 16);
										MesTrajets.add(lblVhicule_1);
										
										comboBoxVehiculeTrajet = new JComboBox();
										comboBoxVehiculeTrajet.setBounds(243, 210, 339, 27);
										MesTrajets.add(comboBoxVehiculeTrajet);
										
										MesTrajetsSupprimer = new JButton("Supprimer");
										MesTrajetsSupprimer.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												supprimerTrajet(trajetCourant);
											}
										});
										MesTrajetsSupprimer.setBounds(113, 249, 117, 29);
										MesTrajets.add(MesTrajetsSupprimer);
										
										MesTrajetsAnnuler = new JButton("Annuler");
										MesTrajetsAnnuler.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												afficherTrajets(compteurTrajet);
											}
										});
										MesTrajetsAnnuler.setBounds(276, 249, 117, 29);
										MesTrajets.add(MesTrajetsAnnuler);
										
										MesTrajetsModifier = new JButton("Modifier");
										MesTrajetsModifier.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												modifierTrajet(trajetCourant);
											}
										});
										MesTrajetsModifier.setBounds(423, 249, 117, 29);
										MesTrajets.add(MesTrajetsModifier);
										
										MesTrajetsPrecedent = new JButton("");
										MesTrajetsPrecedent.setBorder(null);
										MesTrajetsPrecedent.setBorderPainted(false);
										MesTrajetsPrecedent.setIcon(new ImageIcon(main.class.getResource("/fenetres/precedent.png")));
										MesTrajetsPrecedent.addActionListener(new ActionListener() {

											public void actionPerformed(ActionEvent e) {
												int nbTrajet = compterCovoiturage();
												compteurTrajet --;
												//lblVehicules.setText("Véhicule n°" + compteurVehicule);
												if (compteurTrajet > 0){
													lblMesTrajets.setText("Trajet n°"+compteurTrajet);
													afficherTrajets(compteurTrajet);
													chargerTableMesTrajets();
												}
												else {
													JOptionPane.showMessageDialog(null, "Il n'y a pas de trajet précédent");
													compteurTrajet ++;
													//lblVehicules.setText("Véhicule n°" + compteurVehicule);
												}
											}
										});
										MesTrajetsPrecedent.setBounds(16, 137, 117, 37);
										MesTrajets.add(MesTrajetsPrecedent);
										
										JButton MesTrajetsSuivant = new JButton("");
										MesTrajetsSuivant.setIcon(new ImageIcon(main.class.getResource("/fenetres/suivant.png")));
										MesTrajetsSuivant.setBorderPainted(false);
										MesTrajetsSuivant.setRolloverEnabled(true);
										MesTrajetsSuivant.addActionListener(new ActionListener() {

											public void actionPerformed(ActionEvent e) {
												int nbTrajet = compterCovoiturage();
												compteurTrajet ++;
												//lblVehicules.setText("Véhicule n°" + compteurVehicule);
												if (compteurTrajet <= nbTrajet){
													lblMesTrajets.setText("Trajet n°"+compteurTrajet);
													afficherTrajets(compteurTrajet);	
													chargerTableMesTrajets();
												}
												else {
													JOptionPane.showMessageDialog(null, "Il n'y a pas de trajet suivant");
													compteurTrajet --;
													//lblVehicules.setText("Véhicule n°" + compteurVehicule);
												}
											}
										});
										
										Bienvenue.add(MesTrajets);
										
										MesTrajetsSuivant.setBounds(582, 137, 117, 37);
										MesTrajets.add(MesTrajetsSuivant);
										
										
										JScrollPane scrollPane_2 = new JScrollPane();
										scrollPane_2.setBounds(6, 291, 725, 88);
										MesTrajets.add(scrollPane_2);
										
										table_mesTrajets = new JTable();
										table_mesTrajets.setBorder(new LineBorder(new Color(0, 0, 0)));
										table_mesTrajets.setModel(model_table_trajet);
										table_mesTrajets.setBounds(2, 288, 721, 104);
										table_mesTrajets.addMouseListener(new MouseAdapter() {
										

											@Override
											public void mouseClicked(MouseEvent evt) {
												int row = table_mesTrajets.getSelectedRow();
												int col = table_mesTrajets.getSelectedColumn();

												if (SwingUtilities.isLeftMouseButton(evt)){
													//Afficher les information du conducteur sur le covoiturage sélectionné
													boutonSupprimer.setVisible(true);
													covoiturageChoisi = (Integer) table_mesTrajets.getModel().getValueAt(row, 0);
													participantChoisi = (String)table_mesTrajets.getModel().getValueAt(row, 1);
													System.out.println("hello"+ participantChoisi +" "+covoiturageChoisi);
													if(col == 6){
														
														if (estAccepte(participantChoisi, covoiturageChoisi)){
															setAccepte(false,participantChoisi, covoiturageChoisi);
															ajouterPlace(covoiturageChoisi);
														}
														else{
															setAccepte(true,participantChoisi, covoiturageChoisi);
															retirerPlace(covoiturageChoisi);
														}
													}
												}
											}
										});
										scrollPane_2.setViewportView(table_mesTrajets);
										
										boutonSupprimer = new JButton("Supprimer");
										boutonSupprimer.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												supprimerParticipation(covoiturageChoisi, participantChoisi);
											}
										});
										boutonSupprimer.setBounds(313, 382, 117, 29);
										boutonSupprimer.setVisible(false);
										MesTrajets.add(boutonSupprimer);
										
										JLabel lblNewLabel_15 = new JLabel("");
										lblNewLabel_15.setIcon(new ImageIcon(main.class.getResource("/fenetres/fond_metal.jpg")));
										lblNewLabel_15.setBounds(0, 0, 749, 417);
										MesTrajets.add(lblNewLabel_15);
										btnAnnuler_2.setBounds(399, 341, 93, 29);
										ProposerTrajet.add(btnAnnuler_2);
										
										//MesTrajets.add(comboBoxVehicule);
										Bienvenue.add(ProposerTrajet);
										
										comboBoxVehicule = new JComboBox();
										comboBoxVehicule.setBounds(296, 278, 338, 27);
										ProposerTrajet.add(comboBoxVehicule);
										
										JLabel lblNewLabel_16 = new JLabel("");
										lblNewLabel_16.setIcon(new ImageIcon(main.class.getResource("/fenetres/fond_metal.jpg")));
										lblNewLabel_16.setBounds(0, 0, 748, 429);
										ProposerTrajet.add(lblNewLabel_16);
								
									
									btnRechercher.setBounds(293, 158, 117, 29);
									RechercherTrajet.add(btnRechercher);
									Bienvenue.add(RechercherTrajet);
									
									infoUtilisateur = new JLabel("infoUtilisateur.setText(\"<html>Ce trajet vous est proposé par \"+prenom+\" \"+nom+ \" à bord de sa \"+categorie+ \" \"+marque+\" \"+ modele+\".</html>\")\n");
									infoUtilisateur.setHorizontalAlignment(SwingConstants.CENTER);
									infoUtilisateur.setFont(new Font("Apple Braille", Font.PLAIN, 14));
									infoUtilisateur.setBounds(6, 327, 725, 46);
									infoUtilisateur.setVisible(false);
									RechercherTrajet.add(infoUtilisateur);
									
									btnParticiper = new JButton("Participer");
									btnParticiper.addActionListener(new ActionListener() {

										public void actionPerformed(ActionEvent e) {
											participer(trajetChoisi);
										}
									});
									btnParticiper.setBounds(293, 385, 117, 29);
									RechercherTrajet.add(btnParticiper);
									
									scrollPane_rechercherTrajet = new JScrollPane();
									scrollPane_rechercherTrajet.setBounds(6, 199, 725, 116);
									scrollPane_rechercherTrajet.setViewportView(table_afficher_consult_cov);
									RechercherTrajet.add(scrollPane_rechercherTrajet);
									
									JLabel label_16 = new JLabel("");
									label_16.setIcon(new ImageIcon(main.class.getResource("/fenetres/fond_metal.jpg")));
									label_16.setBounds(0, 0, 737, 428);
									RechercherTrajet.add(label_16);
								MesInformations.add(btnSuppimerLeCompte);
								
								JLabel lblCp_1 = new JLabel("CP :");
								lblCp_1.setBounds(230, 227, 28, 16);
								MesInformations.add(lblCp_1);
								
								MesInfosCP = new JTextField();
								MesInfosCP.setBounds(270, 221, 83, 28);
								MesInformations.add(MesInfosCP);
								MesInfosCP.setColumns(10);
								
								JLabel lblVille_1 = new JLabel("Ville :");
								lblVille_1.setBounds(381, 227, 35, 16);
								MesInformations.add(lblVille_1);
								
								MesInfosVille = new JTextField();
								MesInfosVille.setBounds(428, 221, 134, 28);
								MesInformations.add(MesInfosVille);
								MesInfosVille.setColumns(10);
								Bienvenue.add(MesInformations);
								
								JLabel lblNewLabel_18 = new JLabel("");
								lblNewLabel_18.setIcon(new ImageIcon(main.class.getResource("/fenetres/fond_metal.jpg")));
								lblNewLabel_18.setBounds(0, 0, 749, 417);
								MesInformations.add(lblNewLabel_18);
							btnActualiserPermis.setBounds(298, 341, 117, 29);
							MesPermis.add(btnActualiserPermis);
							Bienvenue.add(MesPermis);
							
							JLabel lblNewLabel_17 = new JLabel("");
							lblNewLabel_17.setIcon(new ImageIcon(main.class.getResource("/fenetres/fond_metal.jpg")));
							lblNewLabel_17.setBounds(0, 0, 749, 417);
							MesPermis.add(lblNewLabel_17);
							
							MesParticipations = new JPanel();
							MesParticipations.setBounds(6, 65, 749, 417);
							Bienvenue.add(MesParticipations);
							MesParticipations.setLayout(null);
							
							JScrollPane scrollPane_1 = new JScrollPane();
							scrollPane_1.setBackground(Color.GRAY);
							scrollPane_1.setBounds(6, 58, 723, 212);
							MesParticipations.add(scrollPane_1);
							
					table_mesParticipations = new JTable(model_table_mesParticipations);
					table_mesParticipations.setBounds(6, 58, 723, 212);
					scrollPane_1.setViewportView(table_mesParticipations);
					
					table_mesParticipations.addMouseListener(new MouseAdapter() {
						private String identifiantParticipation;
						private Integer trajetParticiaption;

						@Override
						public void mouseClicked(MouseEvent evt) {
							int row = table_mesParticipations.getSelectedRow();
							if (SwingUtilities.isLeftMouseButton(evt)){
								//Afficher les information du conducteur sur le covoiturage sélectionné
								identifiantParticipation = (String)table_mesParticipations.getModel().getValueAt(row, 1);
								trajetParticipation = (Integer)table_mesParticipations.getModel().getValueAt(row, 0);
								AfficherInfoParticipation((Integer) table_mesParticipations.getModel().getValueAt(row, 0));
								boutonSupprimerListe.setVisible(true);
							}
						}
					});
					
					JLabel lblNewLabel_11 = new JLabel("Liste des trajets auxquels vous participez");
					lblNewLabel_11.setBounds(231, 25, 279, 16);
					MesParticipations.add(lblNewLabel_11);
					
					infoParticipation = new JLabel("New label");
					infoParticipation.setVisible(false);
					infoParticipation.setBounds(99, 282, 602, 62);
					MesParticipations.add(infoParticipation);
					
					boutonSupprimerListe = new JButton("Supprimer de la liste");
					boutonSupprimerListe.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							supprimerParticipation(trajetParticipation, identifiantParticipation);
						}
					});
					boutonSupprimerListe.setBounds(280, 356, 173, 29);
					boutonSupprimerListe.setVisible(false);
					MesParticipations.add(boutonSupprimerListe);
					
					JLabel label_17 = new JLabel("");
					label_17.setIcon(new ImageIcon(main.class.getResource("/fenetres/fond_metal.jpg")));
					label_17.setBounds(0, 0, 749, 417);
					MesParticipations.add(label_17);
						btnPrcdent.setBounds(58, 135, 117, 37);
						MesVehicules.add(btnPrcdent);
						Bienvenue.add(MesVehicules);
						
						JLabel label_15 = new JLabel("");
						label_15.setIcon(new ImageIcon(main.class.getResource("/fenetres/fond_metal.jpg")));
						label_15.setBounds(0, 0, 749, 417);
						MesVehicules.add(label_15);
					
					JLabel label_14 = new JLabel("");
					label_14.setIcon(new ImageIcon(main.class.getResource("/fenetres/fond_metal.jpg")));
					label_14.setBounds(0, 0, 761, 498);
					Bienvenue.add(label_14);
		
		
		//________________________________________________________PANEL ACCUEIL________________________________________
		this.Accueil = new JPanel();
		Accueil.setBackground(Color.LIGHT_GRAY);
		Accueil.setForeground(Color.LIGHT_GRAY);
		Accueil.setBounds(0, 0, 761, 494);
		contentPane.add(Accueil);
		Accueil.setLayout(null);
		
				JLabel label_11 = new JLabel("iCovoit");
				label_11.setForeground(Color.DARK_GRAY);
				label_11.setBounds(277, -15, 351, 91);
				label_11.setFont(new Font("Impact", Font.PLAIN, 75));
				Accueil.add(label_11);
				
				pseudoConnexion = new JTextField();
				pseudoConnexion.setBounds(364, 232, 134, 28);
				pseudoConnexion.setColumns(10);
				Accueil.add(pseudoConnexion);
				
				motDePasseConnexion = new JTextField();
				motDePasseConnexion.setBounds(364, 283, 134, 28);
				motDePasseConnexion.setToolTipText("");
				Accueil.add(motDePasseConnexion);
				
				JButton button_2 = new JButton("");
				button_2.setBorderPainted(false);
				button_2.setBounds(new Rectangle(8, 7, 7, 7));
				button_2.setBorder(null);
				button_2.setIcon(new ImageIcon(main.class.getResource("/fenetres/rond.png")));
				button_2.setAlignmentX(Component.RIGHT_ALIGNMENT);
				button_2.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						deconnexion();
						connecterUtilisateur();	
					}
				});
				
				JLabel lblConnexion = new JLabel("Connexion");
				lblConnexion.setForeground(Color.WHITE);
				lblConnexion.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
				lblConnexion.setDisplayedMnemonicIndex(1);
				lblConnexion.setBounds(126, 272, 98, 47);
				Accueil.add(lblConnexion);
				
				JLabel lblNewLabel_13 = new JLabel("Inscription");
				lblNewLabel_13.setForeground(Color.WHITE);
				lblNewLabel_13.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
				lblNewLabel_13.setBounds(570, 284, 107, 22);
				Accueil.add(lblNewLabel_13);
				button_2.setBounds(98, 232, 151, 127);
				Accueil.add(button_2);
				
				JButton button_3 = new JButton("");
				button_3.setIcon(new ImageIcon(main.class.getResource("/fenetres/rond.png")));
				button_3.setBorder(null);
				button_3.setBorderPainted(false);
				button_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Accueil.setVisible(false);
						Inscription.setVisible(true);
						// TODO créer action listener 
					}
				});
				button_3.setBounds(548, 232, 134, 127);
				Accueil.add(button_3);
				
				JLabel label_12 = new JLabel("Pseudo :");
				label_12.setForeground(Color.WHITE);
				label_12.setBounds(299, 238, 53, 16);
				Accueil.add(label_12);
				
				JLabel label_13 = new JLabel("Mot de passe :");
				label_13.setForeground(Color.WHITE);
				label_13.setBounds(261, 289, 91, 16);
				Accueil.add(label_13);
				
				JLabel lblNewLabel_12 = new JLabel("");
				lblNewLabel_12.setIcon(new ImageIcon(main.class.getResource("/fenetres/voiturage.png")));
				lblNewLabel_12.setBounds(63, 0, 635, 494);
				Accueil.add(lblNewLabel_12);
				
				JLabel lblNewLabel_14 = new JLabel("");
				lblNewLabel_14.setIcon(new ImageIcon(main.class.getResource("/fenetres/fond_metal.jpg")));
				lblNewLabel_14.setBounds(0, 0, 761, 494);
				Accueil.add(lblNewLabel_14);
		
		// ________________________________________________________PANEL INSCRIPTION________________________________________
		
				//TODO Bouton précédent pour annuler l'inscription
		this.Inscription = new JPanel();
		Inscription.setBounds(0, 0, 761, 478);
		contentPane.add(Inscription);
		Inscription.setLayout(null);
		
		JLabel label = new JLabel("Vos informations de connexion");
		label.setBounds(301, 11, 197, 16);
		Inscription.add(label);
		
		JLabel label_1 = new JLabel("Pseudo :");
		label_1.setBounds(188, 59, 53, 16);
		Inscription.add(label_1);
		
		JLabel label_2 = new JLabel("Mot de passe :");
		label_2.setBounds(150, 87, 91, 16);
		Inscription.add(label_2);
		
		JLabel label_3 = new JLabel(" Répéter mot de passe :");
		label_3.setBounds(94, 115, 147, 16);
		Inscription.add(label_3);
		
		JLabel label_4 = new JLabel("Vos informations personnelles");
		label_4.setBounds(301, 160, 192, 16);
		Inscription.add(label_4);
		
		JLabel label_5 = new JLabel("Nom :");
		label_5.setBounds(171, 196, 38, 16);
		Inscription.add(label_5);
		
		JLabel label_6 = new JLabel("Prenom :");
		label_6.setBounds(156, 224, 55, 16);
		Inscription.add(label_6);
		
		JLabel label_7 = new JLabel("Date de naissance :");
		label_7.setBounds(94, 252, 122, 16);
		Inscription.add(label_7);
		
		JLabel label_8 = new JLabel("Adresse :");
		label_8.setBounds(23, 280, 58, 16);
		Inscription.add(label_8);
		
		JLabel label_9 = new JLabel("Téléphone :");
		label_9.setBounds(142, 310, 73, 16);
		Inscription.add(label_9);
		
		JLabel label_10 = new JLabel("Mail :");
		label_10.setBounds(182, 341, 34, 16);
		Inscription.add(label_10);
		
		//--------------------------------------------Inscription utilisateur-----------------------
		JButton button = new JButton("S'inscrire");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inscrire();
			}
		});
		button.setBounds(252, 430, 101, 29);
		Inscription.add(button);
		
			JButton referencerVehicule = new JButton("Référencer un véhicule");
			referencerVehicule.setEnabled(false);
			referencerVehicule.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (inscrire() == true){
						Inscription.setVisible(false);
						Vehicule.setVisible(true);
					}
				}
			});
			
		referencerVehicule.setBounds(447, 430, 186, 29);
		Inscription.add(referencerVehicule);
		
		pseudo = new JTextField();
		pseudo.setBounds(301, 53, 197, 28);
		Inscription.add(pseudo);
		pseudo.setColumns(10);
		
		repeterMotDePasse = new JTextField();
		repeterMotDePasse.setBounds(301, 109, 197, 28);
		Inscription.add(repeterMotDePasse);
		repeterMotDePasse.setColumns(10);
		
		nom = new JTextField();
		nom.setBounds(299, 188, 199, 28);
		Inscription.add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setBounds(301, 218, 199, 28);
		Inscription.add(prenom);
		prenom.setColumns(10);
		
		naissance = new JTextField();
		naissance.setText("1995-01-18");
		naissance.setBounds(301, 246, 199, 28);
		Inscription.add(naissance);
		naissance.setColumns(10);
		
		adresse = new JTextField();
		adresse.setBounds(82, 274, 197, 28);
		Inscription.add(adresse);
		adresse.setColumns(10);
		
		telephone = new JTextField();
		telephone.setBounds(299, 304, 199, 28);
		Inscription.add(telephone);
		telephone.setColumns(10);
		
		mail = new JTextField();
		mail.setBounds(301, 335, 197, 28);
		Inscription.add(mail);
		mail.setColumns(10);
		
		motDePasse = new JTextField();
		motDePasse.setBounds(301, 81, 197, 28);
		Inscription.add(motDePasse);
		motDePasse.setColumns(10);
		
		JLabel lblCp = new JLabel("CP :");
		lblCp.setBounds(292, 280, 24, 16);
		Inscription.add(lblCp);
		
		cp = new JTextField();
		cp.setBounds(328, 274, 91, 28);
		Inscription.add(cp);
		cp.setColumns(10);
		
		JLabel lblVille = new JLabel("Ville :");
		lblVille.setBounds(447, 280, 38, 16);
		Inscription.add(lblVille);
		
		ville = new JTextField();
		ville.setBounds(497, 274, 165, 28);
		Inscription.add(ville);
		ville.setColumns(10);
		
		permisA = new JCheckBox("A");
		permisA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					referencerVehicule.setEnabled(true);
					if(permisA.isSelected() == false){
						referencerVehicule.setEnabled(false);
					}
			}
		});
		permisA.setBounds(250, 395, 41, 23);
		Inscription.add(permisA);
		
		permisB = new JCheckBox("B");
		permisB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				referencerVehicule.setEnabled(true);
				if(permisB.isSelected() == false){
					referencerVehicule.setEnabled(false);
				}
			}
		});
		permisB.setBounds(303, 395, 41, 23);
		Inscription.add(permisB);
		
		permisC = new JCheckBox("C");
		permisC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				referencerVehicule.setEnabled(true);
				if(permisC.isSelected() == false){
					referencerVehicule.setEnabled(false);
				}
			}
		});
		permisC.setBounds(356, 395, 41, 23);
		Inscription.add(permisC);
		
		permisD = new JCheckBox("D");
		permisD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				referencerVehicule.setEnabled(true);
				if(permisD.isSelected() == false){
					referencerVehicule.setEnabled(false);
				}
			}
		});
		permisD.setBounds(406, 395, 128, 23);
		Inscription.add(permisD);
		
		JLabel lblSelectionnezLeOu = new JLabel("Selectionnez le ou les permis que vous possédez");
		lblSelectionnezLeOu.setBounds(209, 375, 325, 16);
		Inscription.add(lblSelectionnezLeOu);
		
		JButton btnPrecedent = new JButton("Précédent");
		btnPrecedent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retourHome();
			}
		});
		btnPrecedent.setBounds(22, 21, 117, 29);
		Inscription.add(btnPrecedent);
		Inscription.setVisible(false);
				
					
				
				//----------------------------------Panel Véhicule------------------------
				
				this.Vehicule = new JPanel();
				Vehicule.setBounds(0, 0, 753, 483);
				contentPane.add(Vehicule);
				Vehicule.setLayout(null);
				
				Vehicule.setVisible(false);
				
				JLabel lblVehicule = new JLabel("Vehicule");
				lblVehicule.setBounds(298, 126, 61, 16);
				Vehicule.add(lblVehicule);
				
				JLabel lblMarque = new JLabel("Marque");
				lblMarque.setBounds(173, 172, 61, 16);
				Vehicule.add(lblMarque);
				JLabel lblNewLabel_4 = new JLabel("Modele");
				lblNewLabel_4.setBounds(173, 203, 61, 16);
				Vehicule.add(lblNewLabel_4);
				JLabel lblAnnee_1 = new JLabel("Annee");
				lblAnnee_1.setBounds(173, 231, 61, 16);
				Vehicule.add(lblAnnee_1);
				JLabel lblNewLabel_5 = new JLabel("Categorie");
				lblNewLabel_5.setBounds(173, 259, 61, 16);
				Vehicule.add(lblNewLabel_5);
				JLabel lblMotorisation_1 = new JLabel("Motorisation");
				lblMotorisation_1.setBounds(151, 287, 91, 16);
				Vehicule.add(lblMotorisation_1);
				JLabel lblNewLabel_6 = new JLabel("Puissance");
				lblNewLabel_6.setBounds(173, 315, 83, 16);
				Vehicule.add(lblNewLabel_6);
				
				marque = new JTextField();
				marque.setText("renault");
				marque.setBounds(275, 166, 134, 28);
				Vehicule.add(marque);
				marque.setColumns(10);
				
				modele = new JTextField();
				modele.setText("megane");
				modele.setBounds(275, 197, 134, 28);
				Vehicule.add(modele);
				modele.setColumns(10);
				
				annee = new JTextField();
				annee.setText("1996");
				annee.setBounds(275, 225, 134, 28);
				Vehicule.add(annee);
				annee.setColumns(10);
				
				categorie = new JTextField();
				categorie.setText("berline");
				categorie.setBounds(275, 253, 134, 28);
				Vehicule.add(categorie);
				categorie.setColumns(10);
				
				motorisation = new JTextField();
				motorisation.setText("diesel");
				motorisation.setBounds(275, 281, 134, 28);
				Vehicule.add(motorisation);
				motorisation.setColumns(10);
				
				puissance = new JTextField();
				puissance.setText("65");
				puissance.setBounds(275, 309, 134, 28);
				Vehicule.add(puissance);
				puissance.setColumns(10);
				
				//-----------------------------------------------------Enregistrer Véhicule base de données-----------------------
				JButton enregistrer = new JButton("Enregistrer");
				enregistrer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						inscrireVehicule();
						Accueil.setVisible(false);
						Vehicule.setVisible(false);
						Inscription.setVisible(false);
						afficherVehicule(1);
						Bienvenue.setVisible(true);
						labelUtilisateur.setText("connecté en tant que " + utilisateurCourant);
					}
				});
				enregistrer.setBounds(204, 379, 117, 29);
				Vehicule.add(enregistrer);
				
				JButton annuler = new JButton("Annuler");
				annuler.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Accueil.setVisible(false);
						Vehicule.setVisible(false);
						Inscription.setVisible(false);
						afficherVehicule(1);
						Bienvenue.setVisible(true);
						labelUtilisateur.setText("connecté en tant que " + utilisateurCourant);
					}
				});
				annuler.setBounds(399, 379, 117, 29);
				Vehicule.add(annuler);
		
	}
	
	// --------------------------------------------------Fonctions base de données--------------------------------------------------
	
	//----------------------------------------------------------Connexions----------------------------------------------------------
	public static Connection ConnectDb(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:8889/covoiturages","root","");
            return conn;
        }
        catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
            System.exit(0);
            return null;
        }         
    }
	
	public void connecterUtilisateur(){
		
		String sql_verifId = ("SELECT Identifiant, MotDePasse FROM utilisateur WHERE Identifiant = ? AND MotDePasse = ? ;");
		
		try{
			pst = conn.prepareStatement(sql_verifId);
			pst.setString(1, pseudoConnexion.getText());
			pst.setString(2, motDePasseConnexion.getText());

			rs = pst.executeQuery();
			
			if(rs.next()){
					this.utilisateurCourant = pseudoConnexion.getText();
					Accueil.setVisible(false);
					Bienvenue.setVisible(true);	
					System.out.println("utilisateur courant modifié.");
					this.labelUtilisateur.setText("connecté en tant que " + utilisateurCourant);
			}
			else{
				JOptionPane.showMessageDialog(null, "Mot de passe ou pseudo incorrect !");
			}
		}
		catch (Exception e){
		}
	}
	
	public void deconnexion(){
		utilisateurCourant = null;
		Accueil.setVisible(true);
		Bienvenue.setVisible(false);
	}
	
	//----------------------------------------------------------INSERTIONS----------------------------------------------------------

	public void inscrireVehicule(){
		String sql_enregistrerVehicule = ("INSERT INTO vehicule VALUES (NULL,?, ?, ?, ?, ?, ?, ?);") ;
        
		if(marque.getText().equals("")==false && modele.getText().equals("")==false && annee.getText().equals("")==false && categorie.getText().equals("")==false &&
				motorisation.getText().equals("")==false && puissance.getText().equals("")==false){
			try {
				pst = conn.prepareStatement(sql_enregistrerVehicule);
				pst.setString(1,marque.getText());
	            pst.setString(2,modele.getText());
	            pst.setString(3,annee.getText());
	            pst.setString(4,categorie.getText());
	            pst.setString(6,puissance.getText());
	            pst.setString(5,motorisation.getText());
	            pst.setString(7,utilisateurCourant);
	            
	            System.out.println(pst);
	            
	            pst.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Véhicule enregistré");
			}
	    	catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("probleme");
				e1.printStackTrace();
				}
		} 	
	}
	
	public void ajouterVehicule(){
		Bienvenue.setVisible(false);
		Accueil.setVisible(false);
		Inscription.setVisible(false);
		Vehicule.setVisible(true);
	}

	public boolean inscrire(){
		
		String sql_verifPseudo = ("SELECT identifiant from utilisateur WHERE identifiant = ?;");

			try{
				pst = conn.prepareStatement(sql_verifPseudo);
				pst.setString(1,pseudo.getText());
				rs = pst.executeQuery();
				boolean exist = rs.next();
				
				if(exist == false){
					
		        	if(pseudo.getText().equals("") == false && motDePasse.getText().equals("") == false && nom.getText().equals("") == false && 
		        			prenom.getText().equals("") == false && naissance.getText().equals("") == false && 
		        			adresse.getText().equals("") == false && cp.getText().equals("") == false && ville.getText().equals("") == false && telephone.getText().equals("") == false && mail.getText().equals("") == false){
		        		
		        		if(motDePasse.getText().equals(repeterMotDePasse.getText())==true){
		        			inscription();
		        			JOptionPane.showMessageDialog(null, "Votre inscription a bien été prise en compte !");
		        			return true;
		        		}
		        		else{
		        			JOptionPane.showMessageDialog(null, "Les mots de passes sont différents !");
		        			return false;
		        		}
		        	}
		        	else{
		        		JOptionPane.showMessageDialog(null, "Veuillez saisir toutes les informations.");
		        		return false;
		       		}	
				}
		        else{
		        	JOptionPane.showMessageDialog(null, "Pseudo déjà utilisé.");
		        	return false;
		        }
			}
			catch(Exception e){
				e.printStackTrace();
				return false;
			}
		}
	
	public void inscription(){
		String sql_inscription = ("INSERT INTO utilisateur VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?);") ;	
		try{
			pst = conn.prepareStatement(sql_inscription);
			pst.setString(1,pseudo.getText());
	        pst.setString(2,nom.getText());
	        pst.setString(3,prenom.getText());
	        pst.setString(4,naissance.getText());
	        pst.setString(5,adresse.getText());
	        pst.setString(6,cp.getText());
	        pst.setString(7,ville.getText());
	        pst.setString(8,telephone.getText());
	        pst.setString(9,mail.getText());
	        pst.setString(10,motDePasse.getText());
	       
	        System.out.println(pst);
	        
	        pst.executeUpdate();
	        utilisateurCourant = pseudo.getText();
	        
	       // creation d une arrayList qui enregistrer les checkbox choisies, et pour chaque checkbox va inserer dans la bdd 
	        ArrayList<String> listePermis = new ArrayList<String>();
	        
	        if(permisA.isSelected()){
	        	listePermis.add(permisA.getText());
	        }
	        if(permisB.isSelected()){
	        	listePermis.add(permisB.getText());
	        }
	        if(permisC.isSelected()){
	        	listePermis.add(permisC.getText());
	        }
	        if(permisD.isSelected()){
	        	listePermis.add(permisD.getText());
	        }
	        
	        for(String permis: listePermis){
	        	insererPermis(permis);	        	
	        }       
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void insererPermis(String categorie){
		String sql_insererPermis = ("INSERT INTO permis VALUES (null,?,?);");
		
		try{
			pst = conn.prepareStatement(sql_insererPermis);
			pst.setString(1, categorie);
			pst.setString(2, utilisateurCourant);
			pst.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void insererCovoiturage(){
		String sql_insererCovoiturage = ("INSERT INTO covoiturage VALUES (null,?,?,?,?,?,?,?,?)");
		int numVehicule = getVehicule();
		try{
			pst = conn.prepareStatement(sql_insererCovoiturage);
			pst.setString(1, CPVilleDepart.getText());
			pst.setString(2, CPVilleArrivee.getText());
			pst.setString(3, DateVoyage.getText()); //getDate ?
			pst.setString(4, DistanceVoyage.getText());
			pst.setString(5, PlaceDispo.getText());
			pst.setString(6, Prix.getText());
			pst.setInt(7, numVehicule);
			pst.setString(8, utilisateurCourant);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Trajet ajouté avec succès !");
		}
		catch(SQLException e){
			System.out.println("oups");
			e.printStackTrace();
		}
	}
	
	public int getVehicule(){
		String sql_getVehicule  = ("Select numVehicule from vehicule where marque = ? and modele = ? and annee = ? and categorie = ? "
				+ "and motorisation = ? and puissance = ? and identifiant = ?");
		
		String vehicule = (String) comboBoxVehicule.getSelectedItem();
		String[] tableau = vehicule.split("/"); 
		try{
			pst = conn.prepareStatement(sql_getVehicule);
			pst.setString(1, tableau[0]);
			pst.setString(2, tableau[1]);
			pst.setString(3, tableau[2]);
			pst.setString(4, tableau[3]);
			pst.setString(5, tableau[4]);
			pst.setString(6, tableau[5]);
			pst.setString(7, utilisateurCourant);
			rs = pst.executeQuery();
			rs.next();
			System.out.println(tableau[0] + tableau[1] + tableau[2] + tableau[3] + tableau[4] );
			return rs.getInt(1);
		}
		catch(SQLException e){
			e.printStackTrace();
			return 111;
		}
	}
	
	public int getVehiculeTrajet(){
		String sql_getVehicule  = ("Select numVehicule from vehicule where marque = ? and modele = ? and annee = ? and categorie = ? "
				+ "and motorisation = ? and puissance = ? and identifiant = ?");
		
		String vehicule = (String) comboBoxVehiculeTrajet.getSelectedItem();
		String[] tableau = vehicule.split("/"); 
		try{
			pst = conn.prepareStatement(sql_getVehicule);
			pst.setString(1, tableau[0]);
			pst.setString(2, tableau[1]);
			pst.setString(3, tableau[2]);
			pst.setString(4, tableau[3]);
			pst.setString(5, tableau[4]);
			pst.setString(6, tableau[5]);
			pst.setString(7, utilisateurCourant);
			rs = pst.executeQuery();
			rs.next();
			System.out.println(tableau[0] + tableau[1] + tableau[2] + tableau[3] + tableau[4] );
			return rs.getInt(1);
		}
		catch(SQLException e){
			e.printStackTrace();
			return 111;
		}
	}
	
	
	//--------------------------------------------------------MODIFICATIONS-------------------------------------------------------------------
	
	public int getNumVehicule(){
		String sql_getNumVehicule = ("select NumVehicule from vehicule where marque = ?, modele = ?, annee = ?, categorie = ?, motorisation = ?, puissance = ? WHERE identifiant = ? ");

		try{
			pst = conn.prepareStatement(sql_getNumVehicule);
			pst.setString(7, utilisateurCourant);
			pst.setString(1, MesVehiculesMarque.getText());
			pst.setString(2, MesVehiculesModele.getText());
			pst.setString(3, MesVehiculesAnnee.getText());
			pst.setString(4, MesVehiculesCategorie.getText());
			pst.setString(5, MesVehiculesMotorisation.getText());
			pst.setString(6, MesVehiculesPuissance.getText());
			rs = pst.executeQuery();
			rs.next();
			System.out.println(rs.getInt(1));
			return rs.getInt(1);
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
		return 1;
	}
	
	public void modifierVehicule(int numVehicule){
		String sql_modifierVehicule = ("UPDATE vehicule set marque = ?, modele = ?, annee = ?, categorie = ?, motorisation = ?, puissance = ? WHERE identifiant = ? AND NumVehicule = ?");
		
		try{
			pst = conn.prepareStatement(sql_modifierVehicule);
			pst.setString(7,utilisateurCourant);
			pst.setString(1, MesVehiculesMarque.getText());
			pst.setString(2, MesVehiculesModele.getText());
			pst.setString(3, MesVehiculesAnnee.getText());
			pst.setString(4, MesVehiculesCategorie.getText());
			pst.setString(5, MesVehiculesMotorisation.getText());
			pst.setString(6, MesVehiculesPuissance.getText());
			pst.setInt(8, numVehicule);
			System.out.println(numVehicule);
			JOptionPane.showMessageDialog(null, "Véhicule modifié");
			pst.executeUpdate();
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
	}
	
	public void modifierInformations(){
		String sql_modifierInformations = ("UPDATE utilisateur set  MotDePasse = ?, Nom = ?, Prenom = ?, DateNaissance = ?, Adresse = ?,"
				+ " CP = ?,Ville = ?,Telephone = ?, Mail = ? WHERE identifiant = ? ");
		
		if(MesInfosMdp.getText().equals("") == false && MesInfosRepeterMdp.getText().equals("") == false && MesInfosNom.getText().equals("") == false 
				&& MesInfosPrenom.getText().equals("") == false && MesInfosDateNaissance.getText().equals("") == false && MesInfosAdresse.getText().equals("") == false 
				&& MesInfosCP.getText().equals("") == false && MesInfosVille.getText().equals("") == false && MesInfosTelephone.getText().equals("") == false 
				&& MesInfosMail.getText().equals("") == false){
			
			if(MesInfosMdp.getText().equals(MesInfosRepeterMdp.getText())==true){
				try{
					pst = conn.prepareStatement(sql_modifierInformations);
					pst.setString(10,utilisateurCourant);
					pst.setString(1, MesInfosMdp.getText());
					pst.setString(1, MesInfosRepeterMdp.getText());
					pst.setString(2, MesInfosNom.getText());
					pst.setString(3, MesInfosPrenom.getText());
					pst.setString(4, MesInfosDateNaissance.getText());
					pst.setString(5, MesInfosAdresse.getText());
					pst.setString(6, MesInfosCP.getText());
					pst.setString(7, MesInfosVille.getText());
					pst.setString(8, MesInfosTelephone.getText());
					pst.setString(9, MesInfosMail.getText());
					JOptionPane.showMessageDialog(null, "Informations modifiées");
					pst.executeUpdate();
				}
				catch(SQLException e1){
					e1.printStackTrace();
				}
			}
				else {
					JOptionPane.showMessageDialog(null, "Les mots de passes ne correspondent pas.");
				}
			}
		else{
			JOptionPane.showMessageDialog(null, "Veuillez saisir toutes les informations.");
		}
	}
	
	//-------------------------------------------------------SUPPRESSIONS------------------------------------------------------------------------
	
	public void supprimerVehicule(int numVehicule){
		String sql_supprimerVehicule = ("DELETE from vehicule where numVehicule = ?");

		try{
			pst = conn.prepareStatement(sql_supprimerVehicule);
			pst.setInt(1, numVehicule);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Véhicule supprimé !");
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
	}
	
	public void nombreVehicule(){
		String sql_nombreVehicule = ("SELECT count (*) from vehicule where identifiant = ?");
		
		try{
			pst = conn.prepareStatement(sql_nombreVehicule);
			pst.setString(1,utilisateurCourant);
			rs = pst.executeQuery();
			rs.next();
			System.out.println("le nombre de vehicule : " + rs.getString(1));
		}
		catch(Exception e){
			System.out.println("probleme comptage");
		}
	}
	
	public void supprimerInformations(){
		String sql_supprimerInformations = ("DELETE from utilisateur where identifiant = ?");
		int n = JOptionPane.showConfirmDialog(null, "Etes-vous sûr de vouloir supprimer votre compte ?");
		
		if (n == JOptionPane.YES_OPTION){
			supprimerTousLesVehicules();
			try{
				pst = conn.prepareStatement(sql_supprimerInformations);
				pst.setString(1, utilisateurCourant);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Compte supprimé !");
				deconnexion();
			}
			catch(SQLException e1){
				e1.printStackTrace();
			}
		}
	}
	
	public void supprimerTousLesVehicules(){
		String sql_supprimerVehicules = ("DELETE from vehicule where identifiant = ?");
		
		try{
			pst = conn.prepareStatement(sql_supprimerVehicules);
			pst.setString(1, utilisateurCourant);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Tous vos véhicules ont été supprimés.");
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
	}
	
	//-------------------------------------------------------AFFICHAGES--------------------------------------------------------------------

	public void afficherVehicule(int vehicule){
		
		String sql_afficherVehicule = ("SELECT marque, modele, annee, categorie, motorisation, puissance, numVehicule from vehicule  WHERE identifiant = ?;");
		
		try{
			pst = conn.prepareStatement(sql_afficherVehicule);
			pst.setString(1,utilisateurCourant);
			rs = pst.executeQuery();
			boolean exist = rs.next();
			
			if (exist){
				try{
					ProposerTrajet.setVisible(false);
					MesParticipations.setVisible(false);

					RechercherTrajet.setVisible(false);
					MesPermis.setVisible(false);
					MesTrajets.setVisible(false);
					MesInformations.setVisible(false);
					MesVehicules.setVisible(true);
					pst = conn.prepareStatement(sql_afficherVehicule);
					pst.setString(1,utilisateurCourant);
					rs = pst.executeQuery();
					rs.next();
					rs.absolute(vehicule);
					MesVehiculesMarque.setText(rs.getString(1));
					MesVehiculesModele.setText(rs.getString(2));
					MesVehiculesAnnee.setText(rs.getString(3));
					MesVehiculesCategorie.setText(rs.getString(4));
					MesVehiculesMotorisation.setText(rs.getString(5));
					MesVehiculesPuissance.setText(rs.getString(6));
					vehiculeCourant = rs.getInt(7);
				}
				catch(SQLException e1){
					System.out.println("pb affichage véhicule.");
					e1.printStackTrace();
				}
			}
			else{
				if(verifierPermis("A") || verifierPermis("B") || verifierPermis("C") || verifierPermis("D") ){
					int n = JOptionPane.showConfirmDialog(null, "Vous n'avez pas de véhicule, voulez vous en ajouter ?");
					if (n == JOptionPane.YES_OPTION){
						Vehicule.setVisible(true);
						Bienvenue.setVisible(false);
					}
				}
				else{
					int n = JOptionPane.showConfirmDialog(null, "Vous devez avoir un permis avant d'ajouter un véhicule, voulez-vous en ajouter");
					if (n == JOptionPane.YES_OPTION){
						MesPermis.setVisible(true);
						MesInformations.setVisible(false);
						MesTrajets.setVisible(false);
						MesVehicules.setVisible(false);
						ProposerTrajet.setVisible(false);
						RechercherTrajet.setVisible(false);
						MesParticipations.setVisible(false);

					}
				}
			}
		}
		catch(SQLException e1){
			System.out.println("pb requete .");
			e1.printStackTrace();
		}
	}
	
	public void afficherInformations(){
		
		String sql_afficherInfo = ("SELECT identifiant, MotDePasse, nom, prenom, DateNaissance, adresse, CP, Ville, telephone, mail FROM utilisateur WHERE identifiant = ?;");
		
		try{
			pst = conn.prepareStatement(sql_afficherInfo);
			pst.setString(1, utilisateurCourant);
			
			rs = pst.executeQuery();
			rs.next();
			
			MesInfosPseudo.setText(rs.getString(1));
			MesInfosMdp.setText(rs.getString(2));
			MesInfosRepeterMdp.setText(rs.getString(2));
			MesInfosNom.setText(rs.getString(3));
			MesInfosPrenom.setText(rs.getString(4));
			MesInfosDateNaissance.setText(rs.getString(5));
			MesInfosAdresse.setText(rs.getString(6));
			MesInfosCP.setText(rs.getString(7));
			MesInfosVille.setText(rs.getString(8));
			MesInfosTelephone.setText(rs.getString(9));
			MesInfosMail.setText(rs.getString(10));
		}
		catch(SQLException e1){
			System.out.println("pb affichage Infos");
			e1.printStackTrace();
		}
	}
	
	public void afficherPermis(){
		String sql_afficherPermis = ("SELECT categorie FROM permis, utilisateur WHERE permis.identifiant = utilisateur.identifiant AND utilisateur.identifiant = ?;");
		
		try{
			pst = conn.prepareStatement(sql_afficherPermis);
			pst.setString(1, utilisateurCourant);
			rs = pst.executeQuery();
			rs.next();
			rs.last(); //on se place sur la derniere ligne 
			int nombreLignes = rs.getRow(); // pour récupérer la longueur du résultat
			rs.first();		
			int i = 0;
			while (i < nombreLignes){
				i++;
				switch (rs.getString(1)){
					case "A" : MesPermisPermisA.setSelected(true);
					break;
					case "B" : MesPermisPermisB.setSelected(true);
					break;
					case "C" : MesPermisPermisC.setSelected(true);
					break;
					case "D" : MesPermisPermisD.setSelected(true);
					break;
				}
				rs.next();
			}
		}
		catch(SQLException e1){
			System.out.println("pb affichage Permis");
			e1.printStackTrace();
		}
	}
	
	public boolean verifierPermis(String unPermis){
		String sql_permis = ("SELECT * FROM permis, utilisateur WHERE permis.identifiant = utilisateur.identifiant AND utilisateur.identifiant = ? AND permis.categorie = ?;");
		
		try{
			pst = conn.prepareStatement(sql_permis);
			pst.setString(1, utilisateurCourant);
			pst.setString(2, unPermis);
			rs = pst.executeQuery();
			if (rs.next()){
				return true;
			}
			else {
				return false; 
			}
		}
		catch(SQLException e1){
			System.out.println("erreur permis");
			return false;
		}
	}
	public void actualiserPermis(){
		//-------------------------permis A------------------------------
		if(MesPermisPermisA.isSelected() && verifierPermis("A") == false){
			insererPermis("A");
		}
		else if (MesPermisPermisA.isSelected() == false && verifierPermis("A") == true){
			supprimerPermis("A");
		}
		//-------------------------permis B------------------------------
		if(MesPermisPermisB.isSelected() && verifierPermis("B") == false){
			insererPermis("B");
		}
		else if (MesPermisPermisB.isSelected() == false && verifierPermis("B") == true){
			supprimerPermis("B");
		}
		//-------------------------permis C------------------------------
		if(MesPermisPermisC.isSelected() && verifierPermis("C") == false){
			insererPermis("C");
		}
		else if (MesPermisPermisC.isSelected() == false && verifierPermis("C") == true){
			supprimerPermis("C");
		}
		//-------------------------permis D------------------------------
		if(MesPermisPermisD.isSelected() && verifierPermis("D") == false){
			insererPermis("D");
		}
		else if (MesPermisPermisD.isSelected() == false && verifierPermis("D") == true){
			supprimerPermis("D");
		}
		// Si aucun permis alors suppression des véhicules
		if (MesPermisPermisA.isSelected() == false && MesPermisPermisB.isSelected() == false && 
			MesPermisPermisC.isSelected() == false && MesPermisPermisD.isSelected() == false)
		{
			int n = JOptionPane.showConfirmDialog(null, "Si vous n'avez pas de permis, tous les véhicules doivent être supprimés, voulez-vous supprimer tous vos véhicules ?");
			
			if (n == JOptionPane.YES_OPTION){
				supprimerTousLesVehicules();
			}
		}
	}
	public void supprimerPermis(String unPermis){
		String sql_supprimerPermis = ("DELETE from permis where identifiant = ? AND permis.categorie = ?;");
		
		try{
			pst = conn.prepareStatement(sql_supprimerPermis);
			pst.setString(1, utilisateurCourant);
			pst.setString(2, unPermis);
			pst.executeUpdate();
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
	}
	
	public int compterVehicule(){
		String sql_compterVehicule = ("Select count(*) from vehicule where identifiant = ?;");
		
		try{
			pst = conn.prepareStatement(sql_compterVehicule);
			pst.setString(1, utilisateurCourant);
			rs = pst.executeQuery();
			rs.next();
			int nbVehicule = rs.getInt(1);
			return nbVehicule;
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
		return 0;
	}
	
	public int compterCovoiturage(){
		String sql_compterCovoiturage = ("Select count(*) from covoiturage where identifiant = ?");
		
		try{
			pst = conn.prepareStatement(sql_compterCovoiturage);
			pst.setString(1, utilisateurCourant);
			rs = pst.executeQuery();
			rs.next();
			int nbCovoiturage = rs.getInt(1);
			return nbCovoiturage;
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
		return 0;
	}
	
	public void afficherListeVehicules(){
		String sql_afficherListeVehicules = ("Select * from vehicule where identifiant = ?");
		comboBoxVehicule.removeAllItems();
		try{
			pst = conn.prepareStatement(sql_afficherListeVehicules);
			pst.setString(1, utilisateurCourant);
			rs = pst.executeQuery();
			while(rs.next()){
				comboBoxVehicule.addItem(rs.getString(2) + "/" + rs.getString(3) + "/" + rs.getString(4) + "/" + rs.getString(5)+ "/" + rs.getString(6) + "/" + rs.getInt(7));
			}
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
	}
	
	public void afficherListeVehiculesTrajet(){
		String sql_afficherListeVehicules = ("Select * from vehicule where identifiant = ?");
		comboBoxVehiculeTrajet.removeAllItems();
		try{
			pst = conn.prepareStatement(sql_afficherListeVehicules);
			pst.setString(1, utilisateurCourant);
			rs = pst.executeQuery();
			while(rs.next()){
				comboBoxVehiculeTrajet.addItem(rs.getString(2) + "/" + rs.getString(3) + "/" + rs.getString(4) + "/" + rs.getString(5)+ "/" + rs.getString(6) + "/" + rs.getInt(7));
			}
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
	}
	
	public void rechercherTrajet(){
		model_table_afficher_cov.setColumnCount(0);
		model_table_afficher_cov.setRowCount(0);
		model_table_afficher_cov.addColumn("N° cov");
		model_table_afficher_cov.addColumn("CP ville départ");
		model_table_afficher_cov.addColumn("CP ville arrivée");
		model_table_afficher_cov.addColumn("Date");
		model_table_afficher_cov.addColumn("Distance");
		model_table_afficher_cov.addColumn("Nombre places");
		model_table_afficher_cov.addColumn("Prix");
		//model_table_afficher_cov.
		
		table_afficher_consult_cov.setModel(model_table_afficher_cov);
		try{
			String sql_recherche_covoiturage = ("SELECT * FROM covoiturage, participant WHERE participant.num_Participant = Covoiturage.identifiant AND covoiturage.identifiant != ? AND CPVilleDepart = ? AND CPVilleArrivee = ? AND DateVoyage = ? AND placesDispo > 0  ");
			pst = conn.prepareStatement(sql_recherche_covoiturage);
			pst.setString(1, utilisateurCourant);
			pst.setString(2, rechercherCPVilleDepart.getText());
			pst.setString(3, rechercherCPVilleArrivee.getText());
			pst.setString(4, rechercherDate.getText());
			
			rs=pst.executeQuery();
			
			
			boolean result = false;
			while(rs.next()){
				result = true;
				String arrivee = convertirCP(rs.getString("CPVilleArrivee"));
				String depart =  convertirCP(rs.getString("CPVilleDepart"));
				
	        	model_table_afficher_cov.addRow(new Object[] {rs.getInt("NumCovoiturage"), "Départ : " + depart, "Arrivé : " + arrivee,
	        			"Date : " + rs.getString("dateVoyage"), rs.getFloat("distance") + " km", rs.getInt("PlacesDispo") + " place(s)", rs.getFloat("prix") + "€"});
	        	
	        }
			if (result == false){
				JOptionPane.showMessageDialog(null, "Aucun résultat");
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		table_afficher_consult_cov.setModel(model_table_afficher_cov);
	}
	
	public void modifierTrajet(int numTrajet){
	
		String sql_modifierTrajet = ("UPDATE covoiturage set CPVilleDepart = ?, CPVilleArrivee = ?, DateVoyage = ?, Distance = ?, placesDispo = ?, Prix = ?, Vehicule = ? WHERE numCovoiturage = ? ");
		
		int numVehicule = getVehiculeTrajet();
		try{
			pst = conn.prepareStatement(sql_modifierTrajet);
			pst.setString(1, MesTrajetsCPVilleDepart.getText());
			pst.setString(2, MesTrajetsCPVilleArrivee.getText());
			pst.setString(3, MesTrajetsDateVoyage.getText());
			pst.setString(4, MesTrajetsDistanceVoyage.getText());
			pst.setString(5, MesTrajetsPlacesDispo.getText());
			pst.setString(6, MesTrajetsPrix.getText());
			pst.setInt(7, numVehicule);
			pst.setInt(8, numTrajet);
			JOptionPane.showMessageDialog(null, "Trajet modifié");
			pst.executeUpdate();
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
	}
	
	public void retourHome(){
		Inscription.setVisible(false);
		Accueil.setVisible(true);
	}
	
	
	public void afficherTrajets(int nbTrajet){
		
		String sql_afficherTrajet = ("SELECT numCovoiturage, CPVilleDepart, CPVilleArrivee, DateVoyage, Distance, PlacesDispo, Prix, Vehicule from covoiturage  WHERE identifiant = ?;");
		
		try{
			pst = conn.prepareStatement(sql_afficherTrajet);
			pst.setString(1,utilisateurCourant);
			rs = pst.executeQuery();
			boolean exist = rs.next();
			
			if (exist){
				try{
					ProposerTrajet.setVisible(false);
					MesParticipations.setVisible(false);

					RechercherTrajet.setVisible(false);
					MesPermis.setVisible(false);
					MesTrajets.setVisible(true);
					MesInformations.setVisible(false);
					MesVehicules.setVisible(false);
					pst = conn.prepareStatement(sql_afficherTrajet);
					pst.setString(1,utilisateurCourant);
					rs = pst.executeQuery();
					rs.next();
					rs.absolute(nbTrajet);
					
					trajetCourant = rs.getInt(1);
					MesTrajetsCPVilleDepart.setText(rs.getString(2));
					MesTrajetsCPVilleArrivee.setText(rs.getString(3));
					MesTrajetsDateVoyage.setText(rs.getString(4));
					MesTrajetsDistanceVoyage.setText(rs.getString(5));
					MesTrajetsPlacesDispo.setText(rs.getString(6));
					MesTrajetsPrix.setText(rs.getString(7));
					afficherVehiculeTrajet(rs.getInt(8));
				 
				}
				catch(SQLException e1){
					System.out.println("pb affichage véhicule.");
					e1.printStackTrace();
				}
			}
			else{
				ProposerTrajet.setVisible(true);
				MesParticipations.setVisible(false);

				RechercherTrajet.setVisible(false);
				MesPermis.setVisible(false);
				MesVehicules.setVisible(false);
				MesInformations.setVisible(false);
				MesTrajets.setVisible(false);
				afficherListeVehicules();
				JOptionPane.showMessageDialog(null, "Vous n'avez pas encore proposé de trajet");
			}
		}
		catch(Exception e){
			
		}
	}
	
	public void afficherVehiculeTrajet(int numVehicule){
		String sql_afficherVehicule = ("SELECT marque, modele, annee, categorie, motorisation, puissance from vehicule  WHERE identifiant = ? and numvehicule = ?");
		
		try{
			pst = conn.prepareStatement(sql_afficherVehicule);
			pst.setString(1,utilisateurCourant);
			pst.setInt(2,numVehicule);
			
			rs = pst.executeQuery();
			rs.next();
			comboBoxVehiculeTrajet.setSelectedItem(rs.getString(1)+"/"+rs.getString(2)+"/"+rs.getString(3)+"/"+rs.getString(4)+"/"+rs.getString(5)+"/"+rs.getInt(6));
			
			}
			catch(Exception e ){
				e.printStackTrace();
		}
	}
	
	public void supprimerTrajet(int unTrajet){
		String sql_supprimerPermis = ("DELETE from covoiturage where identifiant = ? AND numCovoiturage = ?;");
		
		try{
			pst = conn.prepareStatement(sql_supprimerPermis);
			pst.setString(1, utilisateurCourant);
			pst.setInt(2, unTrajet);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Trajet supprimé");
			//rediriger ailleur
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
	}
	
	public String convertirCP(String unCP){
		String sql_afficherVille = ("SELECT NomVille from ville WHERE CPVille = ? ");

		try{
			pst = conn.prepareStatement(sql_afficherVille);
			pst.setString(1,unCP);
			ResultSet res = pst.executeQuery();
			res.next();
			String ville = res.getString(1);
			
			return ville;
		}
		catch(Exception e ){
			e.printStackTrace();
			return null;
		}
	}
	
	public String convertirVille(String uneVille){
		String sql_afficherCPVille = ("SELECT CPVille from ville  WHERE NomVille = ? ");

		try{
			pst = conn.prepareStatement(sql_afficherCPVille);
			pst.setString(1,uneVille);
			
			rs = pst.executeQuery();
			rs.next();
			return rs.getString(1);
		}
		catch(Exception e ){
			e.printStackTrace();
			return null;
		}
	}
	
	private void Rechercher_dynamique_ville_depart_cp(String uneVille) {
		if (!"%".equals(uneVille)){
			
			try{
				String sql_recherche_ville = ("SELECT CPVille FROM ville WHERE NomVille LIKE '"+uneVille+"';");
				
				pst = conn.prepareStatement(sql_recherche_ville);
	            rs = pst.executeQuery();
	            rs.next();
	            rechercherCPVilleDepart.setText(rs.getString(1));	            
			}
			catch(Exception e){
				//JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	
	private void Rechercher_dynamique_ville_arrivee_cp(String uneVille) {
		if (!"%".equals(uneVille)){
			
			try{
				String sql_recherche_ville = ("SELECT CPVille FROM ville WHERE NomVille LIKE '"+uneVille+"';");
				
				pst = conn.prepareStatement(sql_recherche_ville);
	            rs = pst.executeQuery();
	            rs.next();
	            rechercherCPVilleArrivee.setText(rs.getString(1)); 
			}
			catch(Exception e){
				//JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	
	private void Rechercher_dynamique_ville_arrivee_nom(String unCP) {
		if (!"%".equals(unCP)){
			
			try{
				String sql_recherche_ville = ("SELECT NomVille FROM ville WHERE CPVille LIKE '"+unCP+"';");
				
				pst = conn.prepareStatement(sql_recherche_ville);
	            rs = pst.executeQuery();
	            rs.next();
	            rechercherNomVilleArrivee.setText(rs.getString(1));
			}
			catch(Exception e){
				//JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	
	private void Rechercher_dynamique_ville_depart_nom(String unCP) {
		if (!"%".equals(unCP)){
			
			try{
				String sql_recherche_ville = ("SELECT NomVille FROM ville WHERE CPVille LIKE '"+unCP+"';");
				
				pst = conn.prepareStatement(sql_recherche_ville);
	            rs = pst.executeQuery();
	            rs.next();
	            rechercherNomVilleDepart.setText(rs.getString(1));  
			}
			catch(Exception e){
				//JOptionPane.showMessageDialog(null, e);
			}
			
		}
	}
	
	
	
	private void Rechercher_dynamique_ville_depart_cp_proposer(String uneVille) {
		if (!"%".equals(uneVille)){
			
			try{
				String sql_recherche_ville = ("SELECT CPVille FROM ville WHERE NomVille LIKE '"+uneVille+"';");
				
				pst = conn.prepareStatement(sql_recherche_ville);
	            rs = pst.executeQuery();
	            rs.next();
	            CPVilleDepart.setText(rs.getString(1));
	            
			}
			catch(Exception e){
				//JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	
	private void Rechercher_dynamique_ville_arrivee_cp_proposer(String uneVille) {
		if (!"%".equals(uneVille)){
			
			try{
				String sql_recherche_ville = ("SELECT CPVille FROM ville WHERE NomVille LIKE '"+uneVille+"';");
				
				pst = conn.prepareStatement(sql_recherche_ville);
	            rs = pst.executeQuery();
	            rs.next();
	            CPVilleArrivee.setText(rs.getString(1));
	            
			}
			catch(Exception e){
				//JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	
	private void Rechercher_dynamique_ville_arrivee_nom_proposer(String unCP) {
		if (!"%".equals(unCP)){
			
			try{
				String sql_recherche_ville = ("SELECT NomVille FROM ville WHERE CPVille LIKE '"+unCP+"';");
				
				pst = conn.prepareStatement(sql_recherche_ville);
	            rs = pst.executeQuery();
	            rs.next();
	            NomVilleArrivee.setText(rs.getString(1));
			}
			catch(Exception e){
				//JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	
	private void Rechercher_dynamique_ville_depart_nom_proposer(String unCP) {
		if (!"%".equals(unCP)){
			
			try{
				String sql_recherche_ville = ("SELECT NomVille FROM ville WHERE CPVille LIKE '"+unCP+"';");
				
				pst = conn.prepareStatement(sql_recherche_ville);
	            rs = pst.executeQuery();
	            rs.next();
	            NomVilleDepart.setText(rs.getString(1)); 
			}
			catch(Exception e){
				//JOptionPane.showMessageDialog(null, e);
			}
			
		}
	}
	
	
	
	private void AfficherInfoConducteur(int numTrajet) {
		// TODO Auto-generated method stub	
		String sql_afficherInfoConducteur = ("Select prenom, nom, cpvilledepart, cpvillearrivee, marque, modele, placesdispo, categorie, prix FROM covoiturage, vehicule, utilisateur,ville where covoiturage.identifiant = utilisateur.identifiant and vehicule.identifiant = utilisateur.identifiant and numCovoiturage = ? ");
		System.out.println(numTrajet);
		try{
			pst = conn.prepareStatement(sql_afficherInfoConducteur);
			pst.setInt(1,numTrajet);
			ResultSet rs = pst.executeQuery();
			rs.next();
			String prenom = rs.getString(1);
			String nom = rs.getString(2);
			String marque = rs.getString(5);
			String modele = rs.getString(6);
			String categorie = rs.getString(8);
			
			infoUtilisateur.setText("Ce trajet vous est proposé par "+prenom+" "+nom+ " à bord de sa "+categorie+ " "+marque+" "+ modele+".");
			infoUtilisateur.setVisible(true);	
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void participer(int numTrajet){
		String sql_participer = ("INSERT INTO participant VALUES (?,?,'invalide')") ;
        
		 int n = JOptionPane.showConfirmDialog(null, "Etes-vous sûr de vouloir participer à ce covoiturage ? ");

 		if (n == 0){
 			try {
 				pst = conn.prepareStatement(sql_participer);
 				pst.setString(1,utilisateurCourant);
 	            pst.setInt(2,numTrajet);
 	            System.out.println(pst);
	            pst.executeUpdate();
	            retirerPlace(numTrajet);
	            JOptionPane.showMessageDialog(null, "Votre participation a bien été prise en compte");
	            rechercherTrajet();
 			}
 			catch (SQLException e1) {
 				JOptionPane.showConfirmDialog(null, "Vous participez déjà à ce trajet !");
 				e1.printStackTrace();
 			}
 		}
 		else 
 			System.out.println("else");
		
    	
	} 	
	
	private void retirerPlace(int numTrajet){
		String sql_retirerPlace = ("UPDATE covoiturage SET placesdispo = placesdispo - 1 WHERE numcovoiturage = ?");
		
		try{
			pst = conn.prepareStatement(sql_retirerPlace);
			pst.setInt(1,numTrajet);            
            pst.executeUpdate();
		}
		catch(Exception e){
			
		}
	}
	private void ajouterPlace(int numTrajet){
		String sql_ajouterPlace = ("UPDATE covoiturage SET placesdispo = placesdispo + 1 WHERE numcovoiturage = ?");
		
		try{
			pst = conn.prepareStatement(sql_ajouterPlace);
			pst.setInt(1,numTrajet);            
            pst.executeUpdate();
		}
		catch(Exception e){
			
		}
	}
	
	private void retirerParticipation(){
		
	}
	
	private void chargerTableMesTrajets(){
		model_table_trajet.setColumnCount(0);
		model_table_trajet.setRowCount(0);
		model_table_trajet.addColumn("N°");
		model_table_trajet.addColumn("Login");
		model_table_trajet.addColumn("Nom");
		model_table_trajet.addColumn("Prenom");
		model_table_trajet.addColumn("Téléphone");
		model_table_trajet.addColumn("Mail");
		model_table_trajet.addColumn("Accepté");
				
		table_mesTrajets.setModel(model_table_trajet);
		

		JCheckBox checkbox = new JCheckBox("oui");

		try{
			String sql_participant = ("SELECT nom,prenom,Adresse, CP, ville, telephone,mail, num_participant, num_covoiturage FROM utilisateur, participant WHERE participant.num_Participant = utilisateur.identifiant and participant.num_covoiturage = ?");
			pst = conn.prepareStatement(sql_participant);
			pst.setInt(1, this.trajetCourant);
			/*pst.setString(2, rechercherCPVilleDepart.getText());
			pst.setString(3, rechercherCPVilleArrivee.getText());
			pst.setString(4, rechercherDate.getText());*/
			
			rs = pst.executeQuery();
			
			boolean result = false;
			while(rs.next()){
				result = true;
				boolean accepte = estAccepte(rs.getString("num_participant"), rs.getInt("num_covoiturage"));
	        	model_table_trajet.addRow(new Object[] {rs.getInt("num_covoiturage"),rs.getString("num_participant"),rs.getString("nom"), rs.getString("prenom"), rs.getString("telephone"), rs.getString("mail"), accepte });
	        	
	        }	
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		table_mesTrajets.setModel(model_table_trajet);
	}
	
	private boolean estAccepte(String numParticipant, int numCovoiturage){
		String sql_accepte = ("Select accepte from participant where num_participant = ? and num_covoiturage = ?");
		
		try{
			pst = conn.prepareStatement(sql_accepte);
			pst.setString(1,numParticipant);    
			pst.setInt(2,numCovoiturage);            
			ResultSet res = pst.executeQuery();
			res.next();
			System.out.println(res.getString(1));
			if(res.getString("accepte").equals("invalide")){
				return false;
			}
			else{
				return true;
			}
		}
		catch(SQLException e){
			System.out.println("erreur");
			e.printStackTrace();
		}
		return true;
	}
	
	public void setAccepte(boolean estAccepte, String numParticipant, int numCovoiturage){
		String sql_setAccepte;
		if(estAccepte){
			sql_setAccepte = ("update participant set accepte = 'valide' where num_participant = ? and num_covoiturage = ?");
		}
		else{
			sql_setAccepte = ("update participant set accepte = 'invalide' where num_participant = ? and num_covoiturage = ?");
		}
		
		try{
			pst = conn.prepareStatement(sql_setAccepte);
			pst.setString(1,numParticipant);    
			pst.setInt(2,numCovoiturage);  
            pst.executeUpdate();
		}
		catch(Exception e){
			
		}
	}
	
	public void chargerParticipations(){
		model_table_mesParticipations.setColumnCount(0);
		model_table_mesParticipations.setRowCount(0);
		model_table_mesParticipations.addColumn("n° Trajet");
		model_table_mesParticipations.addColumn("Conducteur");
		model_table_mesParticipations.addColumn("Départ");
		model_table_mesParticipations.addColumn("Arrivée");
		model_table_mesParticipations.addColumn("Date");
		model_table_mesParticipations.addColumn("Prix");
		model_table_mesParticipations.addColumn("Accepté");
		
		table_mesParticipations.setModel(model_table_mesParticipations);
		
		try{
			String sql_participations = ("SELECT num_covoiturage, utilisateur.identifiant,cpvilledepart,cpvillearrivee, datevoyage, prix, accepte FROM utilisateur, covoiturage, participant WHERE participant.num_Participant = ? and participant.num_covoiturage = covoiturage.NumCovoiturage and covoiturage.identifiant = utilisateur.identifiant");
			pst = conn.prepareStatement(sql_participations);
			pst.setString(1, this.utilisateurCourant);
			
			rs = pst.executeQuery();
			
			boolean result = false;
			while(rs.next()){
				result = true;
	        	model_table_mesParticipations.addRow(new Object[] {rs.getInt("num_covoiturage"),rs.getString("identifiant"),rs.getString("cpvilledepart"),rs.getString("cpvillearrivee"), rs.getString("dateVoyage"), rs.getInt("prix"), rs.getString("accepte")});
	        }	
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
	private void AfficherInfoParticipation(int numTrajet){
		
		String sql_afficherInfo = ("Select prenom, nom, cpvilledepart, cpvillearrivee, marque, modele, placesdispo, categorie, prix FROM covoiturage, vehicule, utilisateur,ville where covoiturage.identifiant = utilisateur.identifiant and vehicule.identifiant = utilisateur.identifiant and numCovoiturage = ? ");
		System.out.println(numTrajet);
		try{
			pst = conn.prepareStatement(sql_afficherInfo);
			pst.setInt(1,numTrajet);
			ResultSet rs = pst.executeQuery();
			rs.next();
			String prenom = rs.getString(1);
			String nom = rs.getString(2);
			String marque = rs.getString(5);
			String modele = rs.getString(6);
			String categorie = rs.getString(8);
			
			infoParticipation.setText("Ce trajet vous est proposé par "+prenom+" "+nom+ " à bord de sa "+categorie+ " "+marque+" "+ modele+".");
			infoParticipation.setVisible(true);	
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void supprimerParticipation(int numCovoiturage, String identifiant){
		
		String sql_supprimerParticipation = ("DELETE from participant where num_covoiturage = ? AND num_participant = ?;");
		try{
			pst = conn.prepareStatement(sql_supprimerParticipation);
			pst.setInt(1, numCovoiturage);
			pst.setString(2, identifiant);
			pst.executeUpdate();
			//On libère la place si le participant était accepté
			if(estAccepte (numCovoiturage, identifiant)){
				retirerPlace(numCovoiturage);
			}
			JOptionPane.showMessageDialog(null, "Participation supprimée");
			try{
				chargerParticipations();
				infoParticipation.setVisible(false);
			}
			catch(Exception e){
				System.out.println("catch");
			}
			try{
				chargerTableMesTrajets();
			}
			catch(Exception e){
				
			}
		}
		catch(SQLException e1){
			System.out.println("hi");
			e1.printStackTrace();
		}
	}
	
	private boolean estAccepte(int numCovoiturage, String identifiant){
		String sql_Participation = ("Select accepte from participant where num_covoiturage = ? AND num_participant = ?;");
		try{
			pst = conn.prepareStatement(sql_Participation);
			pst.setInt(1, numCovoiturage);
			pst.setString(2, identifiant);
			pst.executeQuery();
			ResultSet res = pst.executeQuery();
			res.next();
			String accepte = res.getString("accepte");
			if(accepte.equals("valide")){
				return true;
			}
			else{
				return false;
			}
		}
		catch(Exception e){
			
		}
		return false;

	}
}