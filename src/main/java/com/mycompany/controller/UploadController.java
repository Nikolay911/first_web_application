package com.mycompany.controller;

import com.mycompany.model.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

import static com.mycompany.secondaryfunction.Secondary.writeFromF2inF1;

@Controller
public class UploadController {

    @Autowired
    ServletContext context;

    @RequestMapping(value = "/uploadForm", method = RequestMethod.GET)
    public ModelAndView fileUploadPage() {
        UploadFile file = new UploadFile();
        ModelAndView modelAndView = new ModelAndView("uploadForm", "command", file);
        return modelAndView;
    }

    @RequestMapping(value="/uploadForm", method = RequestMethod.POST)
    public String fileUpload(@Validated UploadFile file, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            return "uploadForm";
        }
        else {
            MultipartFile multipartFile = file.getFile();
            FileCopyUtils.copy(file.getFile().getBytes(), new File("f2.txt"));
            writeFromF2inF1();
            return "resultUpload";
        }
    }
}
