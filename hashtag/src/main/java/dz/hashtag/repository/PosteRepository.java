/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.hashtag.repository;

import dz.hashtag.models.Poste;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.RxJava2CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author abbasturki.elias
 */
@Repository
public interface PosteRepository extends RxJava2CrudRepository<Poste, String> {

    //@Query("{ 'text' : { $regex: ?0 } }")
    @Query("{ 'text' : ?0 }")
    public Flowable<Poste> findByText(@Param("0")String poste);
    
    @Query("{ 'tags' : {'tag' : ?0 } }")
    public Flowable<Poste> findPosteByTag(@Param("0")String Tag);
    
    @Query("{ 'id' : ?0 }")
    public Single<Poste> findPosteById(@Param("0")String id);
    
    //@Query("{ 'tags' : {'tag' : { $regex: ?0 } } }")
    @Query("{ 'tags' : {'tag' : ?0 } }")
    public Flowable<Poste> findPosteByTagPage(@Param("0")String Tag,Pageable pageable);
    

}
