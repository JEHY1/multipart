package com.example.multiPart.controller;

import com.example.multiPart.service.MultiPartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MultiPartTestController {

    private final MultiPartService multiPartService;
    @GetMapping("/multiPart")
    public String multiPart(){
        return "multiPart";
    }

//    @PostMapping("/upload")
//    public String fileUpload(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2, RedirectAttributes redirectAttributes) {
//        multiPartService.fileUpload(file1);
//
//        redirectAttributes.addFlashAttribute("message",
//                "You successfully uploaded " + file1.getOriginalFilename() + "!");
//
//        multiPartService.fileUpload(file2);
//
//        redirectAttributes.addFlashAttribute("message",
//                "You successfully uploaded " + file2.getOriginalFilename() + "!");
//
//        return "redirect:/";
//    }

    @PostMapping("/upload")
    public String fileUpload(@RequestParam("files") List<MultipartFile> files, RedirectAttributes redirectAttributes) {

        System.err.println("call upload");
        files.forEach(file -> {
            if(!file.getOriginalFilename().isEmpty()) {
                System.err.println(file.getOriginalFilename());
                multiPartService.fileUpload(file);

                redirectAttributes.addFlashAttribute("message",
                        "You successfully uploaded " + file.getOriginalFilename() + "!");
            }
        });

        System.err.println("end upload");
        return "redirect:/multiPart";
    }
}
