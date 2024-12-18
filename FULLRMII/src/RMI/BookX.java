
package RMI;

import java.io.Serializable;

public class BookX implements Serializable{
    private static final long serialVersionUID = 20241124L;
    private String id, title, author;
    private int yearPublished ;
    private String genre, code;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPulished() {
        return yearPublished ;
    }

    public void setYearPulished(int yearPublished ) {
        this.yearPublished  = yearPublished ;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
}
