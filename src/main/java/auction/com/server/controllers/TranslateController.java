package auction.com.server.controllers;


import auction.com.server.services.TranslateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/translate")
public class TranslateController {
    private final TranslateService translateService;

    public TranslateController (TranslateService translateService) {
        this.translateService = translateService;
    }
}
