package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.Book;
import Models.Author;
import Models.Genre;

public class BookEditor extends JFrame {

    private JPanel contentPane;
    private JTextField NombreLibroField;
    private JTextField NombreAutorField;
    private JComboBox<Genre> GenerocomboBox1;
    private JCheckBox isTakencheckBox1;
    private JButton guardarButton;
    private JButton cancelarButton;

    public BookEditor() {

        setTitle("Editor de libros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();

        populateGenreComboBox();

        setLocationRelativeTo(null);

        // Evento del boton guardar
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveChanges();
            }
        });

        // Evento del boton cancelar
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelChanges();
            }
        });

        setVisible(true);
    }

    // Metodo para guardar los cambios
    private void saveChanges() {

        String nombreAutor = NombreAutorField.getText();
        String nombreLibro = NombreLibroField.getText();

        Genre genero = (Genre) GenerocomboBox1.getSelectedItem();

        boolean isTaken = isTakencheckBox1.isSelected();

        // Validar campos
        if (nombreAutor.isEmpty() || nombreLibro.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Debes ingresar el nombre del autor y del libro");
            return;
        }

        // Crear objeto Author
        Author author = new Author(nombreAutor);

        // Crear objeto Book
        Book book = new Book(author, genero, nombreLibro);

        book.setTaken(isTaken);

        // Mostrar confirmacion
        JOptionPane.showMessageDialog(this,
                "Libro registrado correctamente:\n" + book);

        // Limpiar campos
        NombreAutorField.setText("");
        NombreLibroField.setText("");
        GenerocomboBox1.setSelectedIndex(0);
        isTakencheckBox1.setSelected(false);
    }

    // Metodo para cancelar
    private void cancelChanges() {

        NombreAutorField.setText("");
        NombreLibroField.setText("");
        GenerocomboBox1.setSelectedIndex(0);
        isTakencheckBox1.setSelected(false);
    }

    // Metodo para llenar el ComboBox
    private void populateGenreComboBox() {

        DefaultComboBoxModel<Genre> comboBoxModel =
                (DefaultComboBoxModel<Genre>) GenerocomboBox1.getModel();

        comboBoxModel.removeAllElements();

        for (Genre genero : Genre.values()) {
            comboBoxModel.addElement(genero);
        }
    }
}
