/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import connexion.Connexion; // Assure-toi que ta classe Connexion est correcte
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Affiche un Bar Chart du nombre de cours par professeur
 */
/**
 *
 * @author User
 */
public class BarChartForm extends javax.swing.JInternalFrame {

    private static BarChartForm instance;

    // Constructeur
    public BarChartForm() {
        super("Nombre de cours par professeur", true, true, true, true);
        initComponents();
        setSize(1000, 800);
        setLocation(100, 100);

        // Créer et afficher le graphique
        DefaultCategoryDataset dataset = recupererDonnees();
        JFreeChart chart = creerBarChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);

        // Ajout du graphique au JInternalFrame
        this.setLayout(new BorderLayout());
        this.add(chartPanel, BorderLayout.CENTER);

        // Forcer l'affichage
        this.revalidate();
        this.repaint();

        System.out.println("Graphique chargé avec succès !");
    }

    // Singleton : Obtenir l'instance unique
    public static BarChartForm getInstance() {
        if (instance == null || instance.isClosed()) {
            instance = new BarChartForm();
        }
        return instance;
    }

    /**
     * Récupère les données de la base de données
     */
    private DefaultCategoryDataset recupererDonnees() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Connection cn = Connexion.getInstance().getCn();
        
        String query = "SELECT CONCAT(p.nom, ' ', p.prenom) AS nom_complet, COUNT(a.cours_id) AS total_cours "
                + "FROM AffectationCours a "
                + "INNER JOIN Professeur p ON a.professeur_id = p.id "
                + "GROUP BY nom_complet";

        try (PreparedStatement ps = cn.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String nomComplet = rs.getString("nom_complet");
                int nombreCours = rs.getInt("total_cours");
                dataset.addValue(nombreCours, "Cours", nomComplet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur lors de la récupération des données : " + e.getMessage());
        }

        return dataset;
    }

    /**
     * Crée et personnalise le Bar Chart
     */
    private JFreeChart creerBarChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Nombre de cours par professeur", // Titre
                "Professeurs", // Axe X
                "Nombre de cours", // Axe Y
                dataset,
                PlotOrientation.VERTICAL, // Orientation
                false, true, false // (Légende, Tooltips, URL)
        );

        // Personnalisation du plot
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);    // Fond blanc
        plot.setRangeGridlinePaint(Color.BLACK); // Grille noire

        // Récupérer l'axe Y (axe de la plage numérique)
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();

        // Forcer l'affichage des entiers
        yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // Personnalisation des barres
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        // Couleurs personnalisées pour les barres
        Color[] couleurs = {
            new Color(66, 135, 245), // Bleu vif
            new Color(52, 152, 219), // Bleu clair
            new Color(41, 128, 185), // Bleu foncé
            new Color(142, 68, 173), // Violet
            new Color(39, 174, 96), // Vert émeraude
            new Color(241, 196, 15), // Jaune
            new Color(230, 126, 34), // Orange
            new Color(231, 76, 60) // Rouge
        };

        for (int i = 0; i < dataset.getColumnCount(); i++) {
            renderer.setSeriesPaint(i, couleurs[i % couleurs.length]);
        }

        // Affichage des valeurs sur les barres
        renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setItemLabelsVisible(true);

        return chart;
    }

    /**
     * Méthode auto-générée pour initialiser les composants
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 723, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
