import javax.swing.SwingUtilities;
import views.BookEditor;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
        {
            new BookEditor();
        });
    }
}