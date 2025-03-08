package com.proj_springAI.springDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatService chatService;
    private final RecipeService recipeService;
    
    public ChatController(ChatService chatService, RecipeService recipeService)
        {
            this.chatService = chatService;
            this.recipeService = recipeService;
    }

    
    @GetMapping("ask-ai")
    public String getResponse(@RequestParam String prompt)
    {
        return chatService.getResponse(prompt);
    }
    

    @GetMapping("ask-ai-options")
    public String getResponseOptions(@RequestParam String prompt,
                                     @RequestParam(defaultValue = "0.4") double temperature)
    {
        return chatService.getResponseOptions(prompt, temperature);
    }

    @GetMapping("ask-ai-recipe")
    public String getRecipe(@RequestParam String ingredients, 
                                  @RequestParam String cuisine, 
                                  @RequestParam String diet)
    {
        return recipeService.createRecipe(ingredients, cuisine, diet);
    }



}

