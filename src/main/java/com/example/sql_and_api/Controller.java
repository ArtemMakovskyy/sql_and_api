package com.example.sql_and_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
public class Controller {
    @Autowired
    private TextRepository textRepository;

    @GetMapping
    public String controller() {
        return "Controller";
    }

    @GetMapping("/text")
    public Text controllerSave() {
        final long count = textRepository.count();
        Text text = new Text();
        text.setText("text" + count);
        final Text save = textRepository.save(text);
        final Text text1 = textRepository.findById(save.getId()).get();
        return text1;
    }
}
