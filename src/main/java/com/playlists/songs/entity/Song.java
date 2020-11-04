package com.playlists.songs.entity;

import javax.persistence.*;

@Entity
@Table(name="playlist")
public class Song {
    private Long id;
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "nameOfSong")
    private String nameOfSong;

    @Column(name = "singer")
    private String singer;

    public String getNameOfSong() {
        return nameOfSong;
    }

    public void setNameOfSong(String name) {
        this.nameOfSong = nameOfSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
