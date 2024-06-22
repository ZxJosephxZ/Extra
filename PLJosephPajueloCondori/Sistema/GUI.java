/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Sistema;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.swing.JTextField;

/**
 *
 * @author Joseph
 */
//COPIAR TODO
public class GUI extends javax.swing.JFrame {

    private Map<String, JTextField> horaFields;
    private Map<String, JTextField> matriculaFields;
    private Map<String, JTextField> tiempoFields;
    private String horaKey;
    private String matriculaKey;
    private String tiempoKey;
    /**
     * Creates new form GUI
     */
    public GUI() {
        horaFields = new HashMap<>();
        matriculaFields = new HashMap<>();
        tiempoFields = new HashMap<>();
        initComponents();
        //horaFields.put("H21", H21);
        horaFields.put("H12", H12);
        horaFields.put("H13", H13);
        horaFields.put("H14", H14);
        horaFields.put("H15", H15);
        matriculaFields.put("C11", C11);
        matriculaFields.put("C12", C12);
        matriculaFields.put("C13", C13);
        matriculaFields.put("C14", C14);
        matriculaFields.put("C15", C15);
        tiempoFields.put("T11", T11);
        tiempoFields.put("T12", T12);
        tiempoFields.put("T13", T13);
        tiempoFields.put("T14", T14);
        tiempoFields.put("T15", T15);
        
        horaFields.put("H21", H21);
        horaFields.put("H22", H22);
        horaFields.put("H23", H23);
        horaFields.put("H24", H24);
        horaFields.put("H25", H25);
        matriculaFields.put("C21", C21);
        matriculaFields.put("C22", C22);
        matriculaFields.put("C23", C23);
        matriculaFields.put("C24", C24);
        matriculaFields.put("C25", C25);
        tiempoFields.put("T21", T21);
        tiempoFields.put("T22", T22);
        tiempoFields.put("T23", T23);
        tiempoFields.put("T24", T24);
        tiempoFields.put("T25", T25);
        
        horaFields.put("H31", H31);
        horaFields.put("H32", H32);
        horaFields.put("H33", H33);
        horaFields.put("H34", H34);
        horaFields.put("H35", H35);
        matriculaFields.put("C31", C31);
        matriculaFields.put("C32", C32);
        matriculaFields.put("C33", C33);
        matriculaFields.put("C34", C34);
        matriculaFields.put("C35", C35);
        tiempoFields.put("T31", T31);
        tiempoFields.put("T32", T32);
        tiempoFields.put("T33", T33);
        tiempoFields.put("T34", T34);
        tiempoFields.put("T35", T35);
        
        horaFields.put("H41", H41);
        horaFields.put("H42", H42);
        horaFields.put("H43", H43);
        horaFields.put("H44", H44);
        horaFields.put("H45", H45);
        matriculaFields.put("C41", C41);
        matriculaFields.put("C42", C42);
        matriculaFields.put("C43", C43);
        matriculaFields.put("C44", C44);
        matriculaFields.put("C45", C45);
        tiempoFields.put("T41", T41);
        tiempoFields.put("T42", T42);
        tiempoFields.put("T43", T43);
        tiempoFields.put("T44", T44);
        tiempoFields.put("T45", T45);
        
        horaFields.put("H16", H16);
        horaFields.put("H26", H26);
        horaFields.put("H36",H36);
        horaFields.put("H46", H46);
        matriculaFields.put("C16", C16);
        matriculaFields.put("C26", C26);
        matriculaFields.put("C36", C36);
        matriculaFields.put("C46",C46);
        tiempoFields.put("T16", T16);
        tiempoFields.put("T26", T26);
        tiempoFields.put("T36", T36);
        tiempoFields.put("T46", T46);
        
        
        
    }
    
    public void actualizarMejoresTiempos(List<Resultado> mejoresTiempos) {
        // Actualiza la interfaz gráfica con los nuevos mejores tiempos
        //System.out.println("Actualizando GUI con mejores tiempos: " + mejoresTiempos);
         // Assuming tramo 2 for now, you can adapt accordingly
        int indexCounter = 1;  // Index within tramo
        for (Resultado resultado : mejoresTiempos) {
            horaKey = "H" + resultado.getTramoi() + indexCounter;
            matriculaKey = "C" + resultado.getTramoi() + indexCounter;
            tiempoKey = "T" + resultado.getTramoi() + indexCounter;
            
            if (horaFields.containsKey(horaKey)) {
                matriculaFields.get(horaKey).setText(resultado.getHoraFinalizacion().toString());
            }
            if (matriculaFields.containsKey(matriculaKey)) {
                matriculaFields.get(matriculaKey).setText(resultado.getMatricula());
            }
            if (tiempoFields.containsKey(tiempoKey)) {
                tiempoFields.get(tiempoKey).setText(String.valueOf(resultado.getTiempoTotal()));
            }

            
            indexCounter++;
            if (indexCounter > 5) {  
                Optional<Resultado> mejorTiempoOpt = mejorTiempo(mejoresTiempos);
                Resultado rest = mejorTiempoOpt.get();
                horaKey = "H" + resultado.getTramoi() + indexCounter;
                matriculaKey = "C" + resultado.getTramoi() + indexCounter;
                tiempoKey = "T" + resultado.getTramoi() + indexCounter;
                horaFields.get(horaKey).setText(rest.getHoraFinalizacion().toString());
                matriculaFields.get(matriculaKey).setText(rest.getMatricula());
                tiempoFields.get(tiempoKey).setText(String.valueOf(rest.getTiempoTotal()));
                indexCounter = 1;
                
                
            }
        }
        //p.setText(mejoresTiempos.toString());
        
    }
    
    public Optional<Resultado> mejorTiempo(List<Resultado> resultados)
    {
        return resultados.stream()
                .min((r1, r2) -> Long.compare(r1.getTiempoTotal(), r2.getTiempoTotal()));
    }
    /**
    public void actualizarMejoresTiempos(String mejoresTiempos) {
        // Actualiza la interfaz gráfica con los nuevos mejores tiempos
        System.out.println("Actualizando GUI con mejores tiempos: " + mejoresTiempos);
        p.setText(mejoresTiempos);
        // Aquí iría el código específico para actualizar la GUI
    }**/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        H11 = new javax.swing.JTextField();
        H22 = new javax.swing.JTextField();
        H23 = new javax.swing.JTextField();
        H24 = new javax.swing.JTextField();
        H25 = new javax.swing.JTextField();
        C22 = new javax.swing.JTextField();
        C23 = new javax.swing.JTextField();
        C24 = new javax.swing.JTextField();
        C25 = new javax.swing.JTextField();
        T21 = new javax.swing.JTextField();
        T22 = new javax.swing.JTextField();
        T23 = new javax.swing.JTextField();
        T24 = new javax.swing.JTextField();
        C21 = new javax.swing.JTextField();
        T25 = new javax.swing.JTextField();
        T41 = new javax.swing.JTextField();
        C41 = new javax.swing.JTextField();
        C42 = new javax.swing.JTextField();
        H42 = new javax.swing.JTextField();
        H43 = new javax.swing.JTextField();
        C43 = new javax.swing.JTextField();
        T42 = new javax.swing.JTextField();
        T43 = new javax.swing.JTextField();
        T44 = new javax.swing.JTextField();
        T45 = new javax.swing.JTextField();
        C45 = new javax.swing.JTextField();
        C44 = new javax.swing.JTextField();
        H44 = new javax.swing.JTextField();
        H45 = new javax.swing.JTextField();
        T11 = new javax.swing.JTextField();
        C11 = new javax.swing.JTextField();
        C12 = new javax.swing.JTextField();
        H12 = new javax.swing.JTextField();
        H13 = new javax.swing.JTextField();
        C13 = new javax.swing.JTextField();
        T12 = new javax.swing.JTextField();
        T13 = new javax.swing.JTextField();
        T14 = new javax.swing.JTextField();
        T16 = new javax.swing.JTextField();
        C16 = new javax.swing.JTextField();
        C14 = new javax.swing.JTextField();
        H14 = new javax.swing.JTextField();
        H16 = new javax.swing.JTextField();
        H21 = new javax.swing.JTextField();
        H41 = new javax.swing.JTextField();
        H26 = new javax.swing.JTextField();
        C26 = new javax.swing.JTextField();
        T26 = new javax.swing.JTextField();
        H46 = new javax.swing.JTextField();
        C46 = new javax.swing.JTextField();
        T46 = new javax.swing.JTextField();
        H15 = new javax.swing.JTextField();
        C15 = new javax.swing.JTextField();
        T15 = new javax.swing.JTextField();
        Titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        T31 = new javax.swing.JTextField();
        H31 = new javax.swing.JTextField();
        C31 = new javax.swing.JTextField();
        C32 = new javax.swing.JTextField();
        H32 = new javax.swing.JTextField();
        T32 = new javax.swing.JTextField();
        T33 = new javax.swing.JTextField();
        H33 = new javax.swing.JTextField();
        C33 = new javax.swing.JTextField();
        C34 = new javax.swing.JTextField();
        C35 = new javax.swing.JTextField();
        H35 = new javax.swing.JTextField();
        H34 = new javax.swing.JTextField();
        T34 = new javax.swing.JTextField();
        T35 = new javax.swing.JTextField();
        H36 = new javax.swing.JTextField();
        C36 = new javax.swing.JTextField();
        T36 = new javax.swing.JTextField();
        Soleado = new javax.swing.JButton();
        Lluvia = new javax.swing.JButton();
        Nieve = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(H11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 70, -1));
        getContentPane().add(H22, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 65, -1));

        H23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H23ActionPerformed(evt);
            }
        });
        getContentPane().add(H23, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 65, -1));
        getContentPane().add(H24, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 65, 20));
        getContentPane().add(H25, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 65, -1));
        getContentPane().add(C22, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 65, -1));
        getContentPane().add(C23, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 65, -1));
        getContentPane().add(C24, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 65, -1));
        getContentPane().add(C25, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 65, -1));
        getContentPane().add(T21, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 65, -1));
        getContentPane().add(T22, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 65, -1));
        getContentPane().add(T23, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 65, -1));
        getContentPane().add(T24, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 65, -1));
        getContentPane().add(C21, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 65, -1));
        getContentPane().add(T25, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 65, -1));
        getContentPane().add(T41, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 200, 30, -1));
        getContentPane().add(C41, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 200, 65, -1));
        getContentPane().add(C42, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 230, 65, -1));
        getContentPane().add(H42, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 230, 65, -1));
        getContentPane().add(H43, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 260, 65, -1));
        getContentPane().add(C43, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 260, 65, -1));
        getContentPane().add(T42, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 230, 30, -1));
        getContentPane().add(T43, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 260, 30, -1));
        getContentPane().add(T44, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 290, 30, -1));
        getContentPane().add(T45, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 320, 30, -1));
        getContentPane().add(C45, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 320, 65, -1));
        getContentPane().add(C44, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 290, 65, -1));
        getContentPane().add(H44, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 290, 65, 20));
        getContentPane().add(H45, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 320, 65, -1));
        getContentPane().add(T11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 65, -1));
        getContentPane().add(C11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 65, -1));
        getContentPane().add(C12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 65, -1));
        getContentPane().add(H12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 70, -1));
        getContentPane().add(H13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 70, -1));
        getContentPane().add(C13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 65, -1));
        getContentPane().add(T12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 65, -1));
        getContentPane().add(T13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 65, -1));
        getContentPane().add(T14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 65, -1));
        getContentPane().add(T16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 70, -1));
        getContentPane().add(C16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 70, -1));
        getContentPane().add(C14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 65, -1));
        getContentPane().add(H14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 70, 20));
        getContentPane().add(H16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 70, -1));
        getContentPane().add(H21, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 65, -1));
        getContentPane().add(H41, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 200, 65, -1));
        getContentPane().add(H26, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 70, -1));
        getContentPane().add(C26, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, 70, -1));
        getContentPane().add(T26, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 420, 70, -1));
        getContentPane().add(H46, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 420, 70, -1));
        getContentPane().add(C46, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 420, 70, -1));
        getContentPane().add(T46, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 420, 70, -1));
        getContentPane().add(H15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 70, -1));
        getContentPane().add(C15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 65, -1));
        getContentPane().add(T15, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 65, -1));

        Titulo.setText("Clima");
        getContentPane().add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, -1));

        jLabel1.setText("Tablas de Clasificacion");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, -1, -1));

        jLabel2.setText("Tramo1");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, -1, -1));

        jLabel4.setText("Tramo2");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, -1, -1));

        jLabel5.setText("Tramo4");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 130, -1, -1));

        jLabel6.setText("Ultimo tiempo registrado:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, -1, -1));

        jLabel7.setText("Ultimo tiempo registrado:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, -1, -1));

        jLabel8.setText("Ultimo tiempo registrado:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 380, -1, -1));

        jLabel9.setText("Ultimo tiempo registrado");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 380, -1, -1));

        jLabel10.setText("Hora");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        jLabel11.setText("Coche");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        jLabel12.setText("Tiempo");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, -1));

        jLabel16.setText("Hora");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, -1, -1));

        jLabel17.setText("Coche");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, -1, -1));

        jLabel18.setText("Tiempo");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, -1, -1));

        jLabel19.setText("Hora");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 170, -1, -1));

        jLabel20.setText("Coche");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 170, -1, -1));

        jLabel21.setText("Tiempo");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 170, -1, -1));

        jLabel22.setText("1º");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel23.setText("2º");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel24.setText("3º");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel25.setText("4º");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel26.setText("5º");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jLabel27.setText("5º");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 320, -1, -1));

        jLabel28.setText("3º");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 260, -1, -1));

        jLabel29.setText("2º");
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 230, -1, -1));

        jLabel30.setText("4º");
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 290, -1, -1));

        jLabel31.setText("5º");
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, -1, -1));

        jLabel32.setText("2º");
        getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, -1));

        jLabel33.setText("3º");
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, -1, -1));

        jLabel34.setText("4º");
        getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, -1, -1));

        jLabel36.setText("2º");
        getContentPane().add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, -1, -1));

        jLabel37.setText("1º");
        getContentPane().add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, -1, -1));

        jLabel38.setText("1º");
        getContentPane().add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, -1, -1));

        jLabel39.setText("3º");
        getContentPane().add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, -1, -1));

        jLabel40.setText("4º");
        getContentPane().add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, -1, -1));

        jLabel41.setText("5º");
        getContentPane().add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, -1, -1));

        jLabel42.setText("1º");
        getContentPane().add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 200, -1, -1));

        jLabel43.setText("Tramo3");
        getContentPane().add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, -1, -1));

        jLabel44.setText("Hora");
        getContentPane().add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, -1, -1));

        jLabel45.setText("Coche");
        getContentPane().add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 170, -1, -1));

        jLabel46.setText("Tiempo");
        getContentPane().add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 170, -1, -1));
        getContentPane().add(T31, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 200, 65, -1));
        getContentPane().add(H31, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 65, -1));
        getContentPane().add(C31, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 200, 65, -1));
        getContentPane().add(C32, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 230, 65, -1));
        getContentPane().add(H32, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 65, -1));
        getContentPane().add(T32, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, 65, -1));
        getContentPane().add(T33, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 260, 65, -1));
        getContentPane().add(H33, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, 65, -1));
        getContentPane().add(C33, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 260, 65, -1));
        getContentPane().add(C34, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 290, 65, 20));
        getContentPane().add(C35, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 320, 65, -1));
        getContentPane().add(H35, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, 65, -1));
        getContentPane().add(H34, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 290, 65, -1));
        getContentPane().add(T34, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 290, 65, -1));
        getContentPane().add(T35, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 320, 65, -1));
        getContentPane().add(H36, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 420, 70, -1));
        getContentPane().add(C36, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 420, 70, -1));
        getContentPane().add(T36, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 420, 70, -1));

        Soleado.setText("Soleado");
        getContentPane().add(Soleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, -1));

        Lluvia.setText("Lluvia");
        getContentPane().add(Lluvia, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, -1, -1));

        Nieve.setText("Nieve");
        getContentPane().add(Nieve, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, -1, -1));
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void H23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_H23ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
               new GUI().setVisible(true);
           }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JTextField C11;
    private javax.swing.JTextField C12;
    private javax.swing.JTextField C13;
    private javax.swing.JTextField C14;
    private javax.swing.JTextField C15;
    private javax.swing.JTextField C16;
    private javax.swing.JTextField C21;
    private javax.swing.JTextField C22;
    private javax.swing.JTextField C23;
    private javax.swing.JTextField C24;
    private javax.swing.JTextField C25;
    private javax.swing.JTextField C26;
    private javax.swing.JTextField C31;
    private javax.swing.JTextField C32;
    private javax.swing.JTextField C33;
    private javax.swing.JTextField C34;
    private javax.swing.JTextField C35;
    private javax.swing.JTextField C36;
    private javax.swing.JTextField C41;
    private javax.swing.JTextField C42;
    private javax.swing.JTextField C43;
    private javax.swing.JTextField C44;
    private javax.swing.JTextField C45;
    private javax.swing.JTextField C46;
    private javax.swing.JTextField H11;
    private javax.swing.JTextField H12;
    private javax.swing.JTextField H13;
    private javax.swing.JTextField H14;
    private javax.swing.JTextField H15;
    private javax.swing.JTextField H16;
    private javax.swing.JTextField H21;
    private javax.swing.JTextField H22;
    private javax.swing.JTextField H23;
    private javax.swing.JTextField H24;
    private javax.swing.JTextField H25;
    private javax.swing.JTextField H26;
    private javax.swing.JTextField H31;
    private javax.swing.JTextField H32;
    private javax.swing.JTextField H33;
    private javax.swing.JTextField H34;
    private javax.swing.JTextField H35;
    private javax.swing.JTextField H36;
    private javax.swing.JTextField H41;
    private javax.swing.JTextField H42;
    private javax.swing.JTextField H43;
    private javax.swing.JTextField H44;
    private javax.swing.JTextField H45;
    private javax.swing.JTextField H46;
    private javax.swing.JButton Lluvia;
    private javax.swing.JButton Nieve;
    private javax.swing.JButton Soleado;
    private javax.swing.JTextField T11;
    private javax.swing.JTextField T12;
    private javax.swing.JTextField T13;
    private javax.swing.JTextField T14;
    private javax.swing.JTextField T15;
    private javax.swing.JTextField T16;
    private javax.swing.JTextField T21;
    private javax.swing.JTextField T22;
    private javax.swing.JTextField T23;
    private javax.swing.JTextField T24;
    private javax.swing.JTextField T25;
    private javax.swing.JTextField T26;
    private javax.swing.JTextField T31;
    private javax.swing.JTextField T32;
    private javax.swing.JTextField T33;
    private javax.swing.JTextField T34;
    private javax.swing.JTextField T35;
    private javax.swing.JTextField T36;
    private javax.swing.JTextField T41;
    private javax.swing.JTextField T42;
    private javax.swing.JTextField T43;
    private javax.swing.JTextField T44;
    private javax.swing.JTextField T45;
    private javax.swing.JTextField T46;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
