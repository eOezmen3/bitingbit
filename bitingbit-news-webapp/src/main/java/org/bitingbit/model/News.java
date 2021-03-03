package org.bitingbit.model;

import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = "News.findAll", query = "SELECT c FROM News c ORDER BY c.id")
public class News {

    private Long id;
    private String headline;
    private String content;

    @Id
    @SequenceGenerator(name = "giftSeq", sequenceName = "gift_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "giftSeq")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }
}
