package com.example.challenge_9.services;

import com.example.challenge_9.entities.User;
import com.example.challenge_9.exceptions.ResourceNotFoundException;
import com.example.challenge_9.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public User saveNewUser(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

    public List<User> getAllUsers()
    {
        return this.userRepository.findAll();
    }

    public User findUserByID(long id)
    {
        Optional<User> userData = this.userRepository.findById(id);
        // Return statement if user exist or throw exception
        return userData.orElseThrow(() -> new ResourceNotFoundException("User not found"));

    }

    public String updateUserByID(long id, User user)
    {
        Optional<User> userData = this.userRepository.findById(id);
        if (userData.isPresent()) {
            User existingUser = userData.orElseThrow(() -> new ResourceNotFoundException("User not found"));
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            // Change password if exist
            if(!user.getPassword().isEmpty())
            {
                existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            // save existingUser in the database
            this.userRepository.save(existingUser);
            // return statement
            return "User updated successfully!";
        } else {
            throw new ResourceNotFoundException("User not found");
        }
    }

    public String deleteUserById(long id)
    {
        Optional<User> userData = this.userRepository.findById(id);
        if (userData.isPresent()) {
            this.userRepository.deleteById(id);
            return "User deleted successfully!";
        } else {
            throw new ResourceNotFoundException("User not found");
        }
    }

 /*   // Affecter Role to user
    public String affectUserToRole(long idUser, long idRole) {
        Optional<User> userData = this.userRepository.findById(idUser);
        if (userData.isPresent()) {
            User existingUser = userData.orElseThrow(() -> new ResourceNotFoundException("User not found"));
            Optional<Role> roleData = this.roleRepository.findById(idRole);
            if (roleData.isPresent()) {
                Role existingRole = roleData.orElseThrow(() -> new ResourceNotFoundException("Role not found"));
                Set<Role> roles = existingUser.getRoles();
                roles.add(existingRole);
                existingUser.setRoles(roles);
                this.userRepository.save(existingUser);
            }
        }
        return "User affected to role successfully!";
    }

    // affect user to details
    public  String affectUserToDetails(long idUser, long idDetails) {
        Optional<User> userData = this.userRepository.findById(idUser);
        if (userData.isPresent()) {
            User existingUser = userData.orElseThrow(() -> new ResourceNotFoundException("User not found"));
            Optional<UserDetails> detailsData = this.userDetailsRepository.findById(idDetails);
            if (detailsData.isPresent()) {
                UserDetails existingDetails = detailsData.orElseThrow(() -> new ResourceNotFoundException("Details not found"));
                existingDetails.setUser(existingUser);
                existingUser.setDetails(existingDetails);
                this.userRepository.save(existingUser);
                this.userDetailsRepository.save(existingDetails);
            }
        }
        return "User affected to details successfully!";
    }

    public String affectUserToPost(long idUser,long idPost)
    {
        Optional<User> userData = this.userRepository.findById(idUser);
        if (userData.isPresent()) {
            User existingUser = userData.orElseThrow(() -> new ResourceNotFoundException("User not found"));
            Optional<Post> postData = this.postRepository.findById(idPost);
            if (postData.isPresent()) {
                Post existingPost = postData.orElseThrow(() -> new ResourceNotFoundException("Post not found"));
                existingPost.setUser(existingUser);
                List<Post> posts = existingUser.getPosts();
                posts.add(existingPost);
                existingUser.setPosts(posts);
                this.userRepository.save(existingUser);
                this.postRepository.save(existingPost);
            }
        }
        return "User affected to post successfully!";
    }*/

    @Transactional(readOnly = true)
    public User findByEmail(String email) {
        User user = null;
        try {
            user = userRepository.findByEmail(email);
        } catch (Exception e) {
            throw e;
        }
        return user;
    }

}
