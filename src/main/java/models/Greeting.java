package models;

import javax.persistence.*;

@Entity
@Table(name = "greeting")
public class Greeting {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String content;

    public Greeting(){

    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }
    public void setId(Long id) { this.id = id; }

    public String getContent() {
        return content;
    }
}
