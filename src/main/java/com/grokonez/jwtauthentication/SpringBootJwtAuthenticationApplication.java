package com.grokonez.jwtauthentication;

import com.grokonez.jwtauthentication.model.Note;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.NoteRepository;
import com.grokonez.jwtauthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootJwtAuthenticationApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private NoteRepository noteRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtAuthenticationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		User user = new User("User", "UserName", "mail@gmil.com", "password");
//
//		Note note1 = new Note("This is a title of the note1", "This is a body of this note1");
//		Note note2 = new Note("This is a title of the note2", "This is a body of this note2");
//
//		user.getUsefulNotes().add(note1);
//		user.getUsefulNotes().add(note2);
//
//		note1.getUsefulForUsers().add(user);
//		note2.getUsefulForUsers().add(user);
//
//		userRepository.save(user);
//		noteRepository.save(note1);
//		noteRepository.save(note2);
//
//		userRepository.findByUsername("UserName").get().getUsefulNotes().forEach(System.out::println);
	}
}
