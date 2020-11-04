package com.playlists.songs.controller;

import javax.validation.Valid;

import com.playlists.songs.entity.Song;
import com.playlists.songs.repository.PlaylistRepository;
import com.playlists.songs.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playlists.songs.entity.Playlist;


@Controller
@RequestMapping("/playlists/")
public class SongPlaylistController {

	private final PlaylistRepository playlistRepository;
	private final SongRepository songRepository;

	@Autowired
	public SongPlaylistController(PlaylistRepository playlistRepository, SongRepository songRepository) {
		this.playlistRepository = playlistRepository;
		this.songRepository = songRepository;
	}

	@GetMapping("signup")
	public String showSignUpForm(Playlist playlist) {
		return "add-playlist";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("playlists", playlistRepository.findAll());
		return "index";
	}

	@PostMapping("add")
	public String addPlaylist(@Valid Playlist playlist, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-playlist";
		}
		playlistRepository.save(playlist);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Playlist playlist = playlistRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid playlist Id:" + id));
		model.addAttribute("playlist", playlist);
		return "update-playlist";
	}

	@PostMapping("update/{id}")
	public String updatePlaylist(@PathVariable("id") long id, @Valid Playlist playlist, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			playlist.setId(id);
			return "update-playlist";
		}

		playlistRepository.save(playlist);
		model.addAttribute("playlists", playlistRepository.findAll());
		return "index";
	}

	@GetMapping("delete/{id}")
	public String deletePlaylist(@PathVariable("id") long id, Model model) {
		Playlist playlist = playlistRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid playlist Id:" + id));
		playlistRepository.delete(playlist);
		model.addAttribute("playlists", playlistRepository.findAll());
		return "index";
	}

}
