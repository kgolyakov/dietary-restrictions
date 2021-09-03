package controllers;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {
    @PutMapping(value = "/sendImage")
    public void sendImage(@RequestBody String imageURL){
        System.out.println("imageURL = " + imageURL);
    }

}
