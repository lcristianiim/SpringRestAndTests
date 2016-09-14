package com.greeting;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "greetings")
@Getter
@Setter
public class Greeting {
    @Id
    @GeneratedValue
    private long id;

    private String content;

    public Greeting() {}

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
            return content;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Greeting)) return false;

        Greeting greeting = (Greeting) o;

        if (getId() != greeting.getId()) return false;
        return getContent() != null ? getContent().equals(greeting.getContent()) : greeting.getContent() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
        return result;
    }
}
