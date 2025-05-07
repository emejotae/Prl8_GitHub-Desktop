package view.gui;

import exceptions.InvalidDateFormatException;
import exceptions.InvalidNifException;
import javax.swing.JOptionPane;
import model.validations.UserDataValidations;

public class JFrameMain extends javax.swing.JFrame {

    public JFrameMain() {
        initComponents();
    }

    private void initComponents() {
        // Aquí iría el código autogenerado por NetBeans
    }

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {
        boolean isValid = true;

        jLabelErrorNombre.setText("");
        jLabelErrorNif.setText("");
        jLabelErrorFechaDeNacimiento.setText("");
        jLabelErrorCodigoPostal.setText("");
        jLabelErrorEmail.setText("");
        jLabelErrorEdadCalculada.setText("");

        String nombre = jTextFieldNombre.getText().trim();
        String nif = jTextFieldNif.getText().trim();
        String fecha = jTextFieldFechaDeNacimiento.getText().trim();
        String cp = jTextFieldCodigoPostal.getText().trim();
        String email = jTextFieldEmail.getText().trim();

        try {
            if (!UserDataValidations.checkName(nombre)) {
                jLabelErrorNombre.setText("Nombre inválido.");
                isValid = false;
            }

            try {
                UserDataValidations.checkId(1, nif);
            } catch (InvalidNifException ex) {
                jLabelErrorNif.setText(ex.getMessage());
                isValid = false;
            }

            try {
                UserDataValidations.checkFormatDate(fecha);
            } catch (InvalidDateFormatException ex) {
                jLabelErrorFechaDeNacimiento.setText(ex.getMessage());
                isValid = false;
            }

            if (!UserDataValidations.checkPostalCode(cp)) {
                jLabelErrorCodigoPostal.setText("CP inválido.");
                isValid = false;
            }

            if (!UserDataValidations.checkEmail(email)) {
                jLabelErrorEmail.setText("Email inválido.");
                isValid = false;
            }

            if (isValid) {
                int edad = UserDataValidations.calculateAge(fecha);
                jTextFieldEdadCalculada.setText(String.valueOf(edad));

                jTextFieldNombre.setEditable(false);
                jTextFieldEdadCalculada.setEditable(false);
                jTextFieldNif.setEditable(false);
                jTextFieldFechaDeNacimiento.setEditable(false);
                jTextFieldCodigoPostal.setEditable(false);
                jTextFieldEmail.setEditable(false);

                jButtonOk.setEnabled(false);
                jButtonCSV.setEnabled(true);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Declaraciones simuladas para que compile fuera de NetBeans
    private javax.swing.JLabel jLabelErrorNombre = new javax.swing.JLabel();
    private javax.swing.JLabel jLabelErrorNif = new javax.swing.JLabel();
    private javax.swing.JLabel jLabelErrorFechaDeNacimiento = new javax.swing.JLabel();
    private javax.swing.JLabel jLabelErrorCodigoPostal = new javax.swing.JLabel();
    private javax.swing.JLabel jLabelErrorEmail = new javax.swing.JLabel();
    private javax.swing.JLabel jLabelErrorEdadCalculada = new javax.swing.JLabel();
    private javax.swing.JTextField jTextFieldNombre = new javax.swing.JTextField();
    private javax.swing.JTextField jTextFieldNif = new javax.swing.JTextField();
    private javax.swing.JTextField jTextFieldFechaDeNacimiento = new javax.swing.JTextField();
    private javax.swing.JTextField jTextFieldCodigoPostal = new javax.swing.JTextField();
    private javax.swing.JTextField jTextFieldEmail = new javax.swing.JTextField();
    private javax.swing.JTextField jTextFieldEdadCalculada = new javax.swing.JTextField();
    private javax.swing.JButton jButtonOk = new javax.swing.JButton();
    private javax.swing.JButton jButtonCSV = new javax.swing.JButton();
}
