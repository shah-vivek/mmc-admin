package com.mmc.entity;

import com.mmc.model.PresidentCorner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by SGaurav on 20/10/2017.
 */
@Entity(name = "com.mmc.entity.PresidentCornerEntity")
@Table(name = "president_corner")
public class PresidentCornerEntity implements Serializable {

    private static final long serialVersionUID = -539707323874505161L;

    @Id
    @Column(name = "president_corner_id")
    private String id;

    @Column(name = "president_corner_content")
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PresidentCornerEntity() {
    }

    public PresidentCornerEntity(PresidentCorner presidentCorner) {
        super();
        this.id = presidentCorner.getId();
        this.content = presidentCorner.getContent();
    }
}
