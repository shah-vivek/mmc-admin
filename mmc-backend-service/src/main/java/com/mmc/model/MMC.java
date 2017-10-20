package com.mmc.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mmc.entity.MMCEntity;

/**
 * Created by SGaurav on 20/10/2017.
 */
@JsonSerialize
public class MMC {

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

    public MMC(String content, String id) {
        this.content = content;
        this.id = id;
    }

    public MMC() {
    }

    public MMC(MMCEntity mmcEntity) {
        this.id = mmcEntity.getId();
        this.content = mmcEntity.getContent();
    }

    @Override
    public String toString() {
        return "MMC{" +
                "content='" + content + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
