
package RMI;

import java.io.Serializable;

public class Book implements Serializable{
    private static final long serialVersionUID = 20241123L;
    private String id, title, author, code;
    private int yearPublished, pageCount;

    public Book() {
    }

    public Book(String id, String title, String author, int yearPublished, int pageCount, String code) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.pageCount = pageCount;
    }
    public void setCode(String code){
        this.code = code;
    }

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

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    
    
}
