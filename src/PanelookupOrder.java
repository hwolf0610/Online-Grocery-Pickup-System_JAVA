
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import online.grade.order.order;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class PanelookupOrder extends javax.swing.JPanel {

    order ordervalue = new order();

    /**
     * Creates new form PanelookupOrder
     */
    public PanelookupOrder() {
        initComponents();

        String filename = "src/orderlist.txt";
        String orderlist = ordervalue.filereadin(filename);

        String[] totolly = orderlist.split("/");
        String html = "";
        for (int i = 0; i < totolly.length; i++) {
            String[] list = totolly[i].split("~");
            String fact = "<div>Customer ID:" + list[0] + "<br>Customer Name:" + list[1]  + "<br>order time:" + list[2] + "<br>pickup time:" + list[3]+ "<br>Order items:" + list[4] + "<br>quantality:" + list[5] + "</div><br>";
            html = html + fact;
            System.out.println(fact);
        }
        jEditorPane1.setEditable(false);
        HTMLEditorKit kit = new HTMLEditorKit();
        jEditorPane1.setEditorKit(kit);
        StyleSheet styleSheet = kit.getStyleSheet();
        styleSheet.addRule("body {color:#000; font-family:times; margin: 4px; }");
        styleSheet.addRule("h1 {color: blue;}");
        styleSheet.addRule("h2 {color: #ff0000;}");
        styleSheet.addRule("pre {font : 10px monaco; color : black; background-color : #fafafa; }");
        String htmlString = "<html>\n"
                + "<body>\n"
                + "<h1>The first order information:</h1>\n"
                + html
                + "</body>\n";
        Document doc = kit.createDefaultDocument();
        jEditorPane1.setDocument(doc);
        jEditorPane1.setText(htmlString);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();

        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setViewportView(jEditorPane1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
