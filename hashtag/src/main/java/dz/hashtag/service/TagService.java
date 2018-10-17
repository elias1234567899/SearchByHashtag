/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.hashtag.service;

import dz.hashtag.models.Poste;
import dz.hashtag.models.Tag;
import dz.hashtag.repository.PosteRepository;
import dz.hashtag.repository.TagRepository;
import io.reactivex.Flowable;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abbasturki.elias
 */
@Service
public class TagService {
    
    @Autowired
    private TagRepository tagRepository;
    
    
    public Flowable<Tag> getTags() {
        return tagRepository.findAll();
    }
    
     public Single<Tag> createTag(Tag tag) {
        return tagRepository.save(tag);
    }
     
    
}
