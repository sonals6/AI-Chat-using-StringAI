package com.proj_springAI.springDemo;

import java.util.Map;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    private final ChatModel chatModel;

    public RecipeService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String createRecipe(String ingredients, 
                               String cuisine, 
                               String diet)
     {
        var template = """
                I want a recipe which uses the following ingredients: {ingredients}.
                The cuisine should be {cuisine} and the dietary restrictions to be considered are: {diet}.
                Please provide me with a recipe with title, list of ingredients and stepwise instructions.
                """;

        PromptTemplate promptTemplate = new PromptTemplate(template);
        Map<String, Object> params = Map.of(
                                            "ingredients", ingredients, 
                                            "cuisine", cuisine, 
                                            "diet", diet);


        Prompt prompt = promptTemplate.create(params);
        return chatModel.call(prompt).getResult().getOutput().getContent();
    }
}
