
package Models;

public class Book {

    private Author author;
    private Genre genre;
    private String name;
    private boolean taken;

    public Book(Author author, Genre genre, String name) {
        this.author = author;
        this.genre = genre;
        this.name = name;
        this.taken = false;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public Author getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getName() {
        return name;
    }

    public boolean isTaken() {
        return taken;
    }

    @Override
    public String toString() {
        return "Libro: " + name +
                "\nAutor: " + author +
                "\nGenero: " + genre +
                "\nPrestado: " + taken;
    }
}
