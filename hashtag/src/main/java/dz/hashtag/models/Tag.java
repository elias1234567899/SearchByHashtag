/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.hashtag.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author abbasturki.elias
 */

@Document
public class Tag implements Serializable{
    
    @Id
    private String id;
   //@JsonProperty("text")
    private String tag;

    public Tag() {
       super();
    }
    
    public Tag(String id, String tag) {
        this.id = id;
        this.tag = tag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

  
    @Override
    public String toString() {
        return "Tag{" + "id=" + id + ", tag=" + tag + '}';
    }
    
}
