package com.grokonez.jwtauthentication.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "notes")
public class Note extends AuditNotesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    @NotNull
    private String title;

    @Column
    @NotNull
    private String body;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = { CascadeType.PERSIST,
                        CascadeType.MERGE },
            mappedBy = "usefulNotes")
    private Set<User> usefulForUsers = new HashSet<>();

    public Note(@NotNull String title, @NotNull String body) {
        this.title = title;
        this.body = body;
    }

    public Note() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Set<User> getUsefulForUsers() {
        return usefulForUsers;
    }

    public void setUsefulForUsers(Set<User> usefulForUsers) {
        this.usefulForUsers = usefulForUsers;
    }
}
