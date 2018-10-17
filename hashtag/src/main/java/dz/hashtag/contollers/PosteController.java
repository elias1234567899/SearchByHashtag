/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.hashtag.contollers;

import dz.hashtag.models.Poste;
import dz.hashtag.models.Tag;
import dz.hashtag.repository.PosteRepository;
import dz.hashtag.service.PosteService;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.social.twitter.api.HashTagEntity;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abbasturki.elias
 */
@RestController
@CrossOrigin("*")
public class PosteController {

    boolean isConnected = true;
    int x = 0;

    @Autowired
    private Twitter twitter;
    @Autowired
    private PosteService posteService;
    @Autowired
    private PosteRepository posteRepository;

    List<Tag> tags = new ArrayList<>();

    @GetMapping
    public Flowable<Poste> getAllPostes() {
        return posteService.getPostes();
    }

    @RequestMapping(value = "/postes/{id}", method = RequestMethod.GET)
    public Maybe<Poste> getContacte(@PathVariable String id) {
        return posteService.getPosteByID(id);
    }

    @PostMapping
    public Single<Poste> newPoste(@RequestBody Poste poste) {
        return posteService.createPoste(poste);
    }

    @GetMapping("/find")
    public Flowable<Poste> findByText(@RequestParam(name = "text", defaultValue = "") String text) {
        return posteService.getPostesByText1(text);
    }

    @GetMapping("/findTag")
    public Flowable<Poste> findByTag(@RequestParam(name = "tag", defaultValue = "") String text) {
        return posteService.getPostesByTag1(text);
    }

//    @GetMapping("/findPage")
//    public Flowable<Poste> search(@RequestParam(name = "tag", defaultValue = "") String tag) {
//        return posteService.getPostesByTag1(tag);
//    }
    @GetMapping("/findPage")
    public Flowable<Poste> search(@RequestParam(name = "tag", defaultValue = "") String tag,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        return posteService.getPostesByTagPage(tag, page, size);
    }

    @GetMapping(value = "/twitter", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Flowable<Poste> getAllandSaveTest(@RequestParam(name = "hashtag", defaultValue = "") final String hashtag) {

//        Flowable<Poste> postes = null;
        if (twitter.isAuthorized() && isConnected) {
            try {
                Flowable<Tweet> tweets = Flowable.fromIterable(twitter.searchOperations()
                        .search(hashtag)
                        .getTweets());
                tweets.map((tweet) -> {
                    List<HashTagEntity> hashTags = tweet.getEntities().getHashTags();
                    hashTags.forEach((hash) -> {
                        String ss = "#" + hash.getText();
                        Tag tag = new Tag(null, ss);
                        tags.add(tag);
                    });
                    return tweet;
                }).subscribe((tweet) -> {
                    posteRepository.save(new Poste(tweet.getIdStr(), tweet.getText(), tags)).subscribe();
                });
            } catch (Exception e) {
                isConnected = false;
                System.out.println("---------------------erreur------------------");
                e.getMessage();
            }
        } else {
            x++;
            if (x > 10) {
                x = 0;
                isConnected = true;
            }
        }

        return posteService.getPostesByTag1(hashtag);

//        .filter((tweet) -> {
//
////            
////            if (posteService.existsPosteById(tweet.getIdStr())) {
////                return false;
////            }
//
//            return posteService.existsPosteById(tweet.getIdStr());
//
//        })
    }

    @GetMapping(value = "/twitter/test/{hashtag}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Flowable<Tweet> get(@PathVariable final String hashtag) {
        Flowable<Tweet> tweets = Flowable.fromIterable(twitter.searchOperations()
                .search(hashtag)
                .getTweets());
        System.out.println("////////////////////////");
        tweets.forEach((t) -> {
            System.out.println(t);
        });
        return tweets;
    }

}
