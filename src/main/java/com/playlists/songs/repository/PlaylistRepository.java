package com.playlists.songs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.playlists.songs.entity.Playlist;

@Repository
public interface PlaylistRepository extends CrudRepository<Playlist, Long> {

    List<Playlist> findByName(String name);

}
