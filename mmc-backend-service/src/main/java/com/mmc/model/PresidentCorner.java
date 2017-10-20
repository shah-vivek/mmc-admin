package com.mmc.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mmc.entity.PresidentCornerEntity;

/**
 * Created by SGaurav on 20/10/2017.
 */
@JsonSerialize
public class PresidentCorner {

    private static final long serialVersionUID = 1L;

    private String content;

    private String id;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PresidentCorner(String content, String id) {
        this.content = content;
        this.id = id;
    }

    public PresidentCorner() {
    }

    public PresidentCorner(PresidentCornerEntity presidentCornerEntity) {
        this.id = presidentCornerEntity.getId();
        this.content = presidentCornerEntity.getContent();
    }

    @Override
    public String toString() {
        return "PresidentCorner{" +
                "content='" + content + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
