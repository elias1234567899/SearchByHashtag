/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.hashtag.repository;

import dz.hashtag.models.Tag;
import org.springframework.data.repository.reactive.RxJava2CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author abbasturki.elias
 */

@Repository
public interface TagRepository extends RxJava2CrudRepository<Tag, String>{
    
    //Observable<Tag> findAllById(String id);

    //Single<User> findByIdUser(Single<String> id);
   
    //public Maybe<Tag> findById(String id) ;
    
    //public Flowable<User> findAllById(Flowable<String> flwbl);
    
    //public Flowable<Tag> findAll();
    
}
