package com.RestFull.example.RestfullWebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int userCount= 4;

    static {
        users.add(new User(1,"Rodrigo", new Date(), new ArrayList<>(){
            {   add(new Post(1,"Sef"));
                add(new Post(2,"Arduino"));}
        }));
        users.add(new User(2,"Eve", new Date(), new ArrayList<>(){
            {   add(new Post(1,"Contabil"));
                add(new Post(2,"Junior"));}
        }));
        users.add(new User(3,"Alina", new Date(), new ArrayList<>(){
            {   add(new Post(1,"Happy"));
                add(new Post(2,"Masina"));}
        }));
        users.add(new User(4,"Adam", new Date(), new ArrayList<>(){
            {   add(new Post(1,"!DEc"));
                add(new Post(2,"Vacanta"));}
        }));

    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user){
        if (user.getId() == null){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public Post savePost(Post post, int id){
        if(users.size() < id)
            throw new UserNotFoundException("id-" + id );
        users.get(id-1).getPosts().add(new Post(users.get(id-1).getPosts().size()+1,post.getTitle()));
        //users.get(id-1).getPosts().get(users.get(id-1).getPosts().size()-1).setPostId(users.get(id-1).getPosts().size());
        // userul    lista de posturi  adaugat postul
        return users.get(id-1).getPosts().get(users.get(id-1).getPosts().size()-1);
    }

    public User findOne(int id){

        if(users.size() < id)
            throw new UserNotFoundException("id-" + id );
        return users.get(id-1);
    }

    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }

    public List<Post> findAllPost(int id){
        return users.get(id-1).getPosts();
    }

    public Post findOnePost(int id, int post_id ){
        if(users.size() < id)
            throw new UserNotFoundException("id-" + id );
        return users.get(id-1).getPosts().get(post_id-1);
        //         userul       lpost       postul
    }
}
