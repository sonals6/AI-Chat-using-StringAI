package com.proj_springAI.springDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    ChatService chatService;
    
    public ChatController(ChatService chatService)
    {
        this.chatService = chatService;
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


/* 
    //@Autowired
    public ChatController(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/ai/generate")
    public Map<String,String> generate(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        return Map.of("generation", this.chatModel.call(message));
    }

    @GetMapping("/ai/generateStream")
	public Flux<ChatResponse> generateStream(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        Prompt prompt = new Prompt(new UserMessage(message));
        return this.chatModel.stream(prompt);
    }
*/
}

