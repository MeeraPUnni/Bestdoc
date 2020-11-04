package com.playlists.songs.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @Column(name = "nameOfSong")
    private String nameOfSong;

    public String getNameOfSong() {
        return nameOfSong;
    }

    public void setNameOfSong(String nameOfSong) {
        this.nameOfSong = nameOfSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Column(name = "singer")
    private String singer;

    /* @NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;

    @Column(name = "phone_no")
    private long phoneNo;*/

    public Playlist() {}

   /* public Playlist(String name, String email) {
        this.name = name;
        this.email = email;
    }*/

    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
   /* public void setEmail(String email) {
        this.email = email;
    }*/

    public String getName() {
        return name;
    }

    /*public String getEmail() {
        return email;
    }

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}*/
}