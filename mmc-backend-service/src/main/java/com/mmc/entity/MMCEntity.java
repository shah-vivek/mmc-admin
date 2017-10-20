package com.mmc.entity;

import com.mmc.model.MMC;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by SGaurav on 20/10/2017.
 */
@Entity(name = "com.mmc.entity.MMCEntity")
@Table(name = "about_mmc")
public class MMCEntity implements Serializable{

    private static final long serialVersionUID = -539707323874505161L;

    @Id
    @Column(name = "about_mmc_id")
    private String id;

    @Column(name = "about_mmc_content")
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

    public MMCEntity() {
    }

    public MMCEntity(MMC mmc) {
        super();
        this.id = mmc.getId();
        this.content = mmc.getContent();
    }
}
