package com.codegym.music.controller;

import com.codegym.music.dto.MusicDto;
import com.codegym.music.model.Music;
import com.codegym.music.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private IMusicService iMusicService;

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "", required = false) String nameMusic, Model model,
                           @RequestParam(defaultValue = "0", required = false) int page) {
        Pageable pageable = PageRequest.of(page, 2, Sort.by("id").ascending());
        Page<Music> musicPage = iMusicService.findAll(nameMusic, pageable);
        model.addAttribute("musicPage", musicPage);
        model.addAttribute("nameMusic", nameMusic);
        return "/list";
    }

    @GetMapping("/add")
    public String showAdd(Model model) {
        model.addAttribute("musicDto", new MusicDto());
        return "add";
    }

    @PostMapping("/add")
    public String add(@Validated @ModelAttribute MusicDto musicDto,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {
        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "add";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        iMusicService.add(music);
        redirectAttributes.addFlashAttribute("mess", "Them Thành Công");
        return "redirect:/music";
    }

    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model) {
        Music music = iMusicService.findByIdMusic(id);
        model.addAttribute("music", music);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute MusicDto musicDto, int id,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        iMusicService.edit(id, music);
        redirectAttributes.addFlashAttribute("mess", "Sua thanh COng");
        return "redirect:/music";
    }
}
