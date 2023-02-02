package com.RestFull.example.RestfullWebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController extends EntityModel {

    @Autowired
    private UserDaoService service;
    //GET users
    //retrieveAllUsers
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    //retrieveUser(int id)
    @GetMapping("/users/{id}")
    public EntityModel<User> retireveUser(@PathVariable int id){
        User user = service.findOne(id);

        //protected EntityModel() { this.content = null;}
        //protected EntityModel(T content) { this(content, Links.NONE);
        //protected EntityModel(T content, Iterable< Link > links)
        EntityModel<User> model = EntityModel.of(user);
        WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        model.add(linkToUsers.withRel("toti_userii"));

        return model;

        //"all-users", SERVER_PATH + "/users"


    }

    //HATEOAS -> Hypermediea As The Engine Of Aplication State

    // input - details of user
    // output - CREATED & RETURN the created URI
    @PostMapping("/users")
    public ResponseEntity<Object > createUser(@Valid @RequestBody User user){
        User savedUser = service.save(user);
        //CREATED
         ///user/4
         //How to set the URI of the created resource in first response

         // users/{id}      savedUser.getId()
         ServletUriComponentsBuilder ServletUriComponentBuilder = null;
         URI  location = ServletUriComponentBuilder
                 .fromCurrentRequest().
                 path("/{id}").
                 buildAndExpand(savedUser.getId())
                 .toUri();

         return  ResponseEntity.created(location).build();
     }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object > createUser(@RequestBody Post post, @PathVariable int id){
        Post savedPost = service.savePost(post, id);
        //CREATED
        ///user/4
        //How to set the URI of the created resource in first response

        // users/{id}      savedUser.getId()
        ServletUriComponentsBuilder ServletUriComponentBuilder = null;
        URI  location = ServletUriComponentBuilder
                .fromCurrentRequest().
                path("/{id_posts}").
                buildAndExpand(savedPost.getPostId())
                .toUri();

        return  ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = service.deleteById(id);

        if (user == null)
            throw new UserNotFoundException("id-" + id);
    }

    //retrieveUser(int id)
    @GetMapping("/users/{id}/posts")
    public List<Post> retireveAllPosts(@PathVariable int id){
        return service.findAllPost(id);
    }

    @GetMapping("/users/{id}/posts/{id_post}")
    public Post retireveAllPosts(@PathVariable int id,@PathVariable int id_post){
        return service.findOnePost( id, id_post);
    }

}
