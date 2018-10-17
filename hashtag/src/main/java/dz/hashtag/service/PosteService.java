/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.hashtag.service;

import dz.hashtag.models.Poste;
import dz.hashtag.models.Tag;
import dz.hashtag.repository.PosteRepository;
import dz.vo.PagesVo;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author abbasturki.elias
 */
@Service
public class PosteService {

    int i = 0;
     
    @Autowired
    private PosteRepository posteRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    
    public Single<Boolean> existsPoste(String id) {
   
        return posteRepository.existsById(id);
    }

    public Flowable<Poste> getPostes() {
        return posteRepository.findAll();
    }

    public Single<Poste> createPoste(Poste poste) {
        return posteRepository.save(poste);
    }
    
    public Maybe<Poste> getPosteByID(String id){
        return posteRepository.findById(id);
    }

    public List<Poste> getPostesBytext(String poste) {

        Query query = new Query();
        query.addCriteria(Criteria.where("text").regex(poste));
        List<Poste> postes = mongoTemplate.find(query, Poste.class);
        return postes;
    }

    public List<Poste> getPostesByTag(String tag) {
        System.out.println("text === " + tag);
        List<Poste> result = new ArrayList<>();
        Flowable<Poste> postes = posteRepository.findAll();
        postes.forEach(p -> {
            List<Tag> tags = p.getTags();
            for (Tag t : tags) {
                System.out.println("tag == " + t);
                if (t.getTag().contains("#" + tag)) {
                    System.out.println("taggggg == " + t);
                    result.add(p);
                    break;
                }
            }
        });
        return result;
    }

    public Flowable<Poste> getPostesByText1(String poste) {
        return posteRepository.findByText(poste);
    }

    public Flowable<Poste> getPostesByTag1(String tag) {
        return posteRepository.findPosteByTag(tag);
    }

    public Flowable<Poste> getPostesByTagPage(String tag,int page,int size) {
        return posteRepository.findPosteByTagPage(tag,PageRequest.of(page, size));
    }


}
