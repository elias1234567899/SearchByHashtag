/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.hashtag.contollers;

import dz.hashtag.models.Tag;
import dz.hashtag.service.TagService;
import io.reactivex.Flowable;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 *
 * @author abbasturki.elias
 */
@RestController
@RequestMapping("/tag")
public class TagController {
    
    @Autowired
    private TagService tagService;

    @GetMapping
    public Flowable<Tag> getAllTags() {
        return tagService.getTags();
    }

    @PostMapping
    public Single<Tag> newTag(@RequestBody Tag tag) {
        return tagService.createTag(tag);
    }

    
}
