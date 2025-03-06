package com.proj_springAI.springDemo;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private final ChatModel chatModel;
    
    public ChatService(ChatModel chatModel)
    {
        this.chatModel = chatModel;
    }
    
    public String getResponse(String prompt)
    {
        return chatModel.call(prompt);
    }
    
    public String getResponseOptions(String prompt, double temperature)
    {
        ChatResponse response = chatModel.call(
        new Prompt(
        prompt,
        OllamaOptions.builder()
            .model(OllamaModel.LLAMA3_2_1B)
            .temperature(temperature)
            .build()
    ));
    return response.getResult().getOutput().getContent();
    }


}
