/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.hashtag.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.social.twitter.api.HashTagEntity;

/**
 *
 * @author abbasturki.elias
 */

@Document
public class Poste implements Serializable{
    
    @Id
    private String id;
    //@JsonProperty("text")
    private String text;
    //@DBRef
   // @JsonProperty("hashtags")
    private List<Tag> tags;

    public Poste() {
        super();
    }
    public Poste(String idPoste, String text) {
        this.id = idPoste;
        
        this.text = text;
    }

    public Poste(String id, String text, List<Tag> tags) {
        this.id = id;
        this.text = text;
        this.tags = tags;
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String idUser) {
        this.id = idUser;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Poste{" + "id=" + id  + ", text=" + text + '}';
    }
    
    
}
