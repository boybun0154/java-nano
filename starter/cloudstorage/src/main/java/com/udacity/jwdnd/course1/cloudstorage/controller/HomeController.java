package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.dto.CredentialForm;
import com.udacity.jwdnd.course1.cloudstorage.dto.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.service.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.service.FileService;
import com.udacity.jwdnd.course1.cloudstorage.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Controller
public class HomeController {
    private FileService fileService;
    private NoteService noteService;
    private CredentialService credentialService;

    public HomeController(FileService fileService, NoteService noteService, CredentialService credentialService) {
        this.fileService = fileService;
        this.noteService = noteService;
        this.credentialService = credentialService;
    }

    @GetMapping("/home")
    public String getHome(@ModelAttribute("noteForm") NoteForm noteForm,
                          @ModelAttribute("credentialForm") CredentialForm credentialForm, Model model) {
//        model.addAttribute("credentials", credentialService.getCredentials());
        return "home";
    }

    @PostMapping("/note")
    public String postNote(@ModelAttribute("noteForm") NoteForm noteForm, Model model) {
//        if (noteForm.getNoteId() == null) {
//            noteService.create(noteForm);
//        } else {
//            noteService.update(noteForm);
//        }
//        model.addAttribute("notes", noteService.getAll());
        model.addAttribute("success", true);
        return "result";
    }

    @PostMapping("/credential")
    public String postCredential(@ModelAttribute("credentialForm") CredentialForm credentialForm, Model model) {
//        if (credentialForm.getCredentialId() == null) {
//            credentialService.create(credentialForm);
//        } else {
//            credentialService.update(credentialForm);
//        }
//        model.addAttribute("credentials", credentialService.getAll());
        model.addAttribute("success", true);
        return "result";
    }

    @PostMapping("/file-upload")
    public String handleFileUpload(@RequestParam("fileUpload") MultipartFile fileUpload, Model model) {
        try {
            InputStream fis = fileUpload.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("success", true);
        return "result";
    }
}
