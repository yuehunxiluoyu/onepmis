package com.toc.ai.test;

import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")

public class TestController {

	@Autowired
	OllamaChatClient ollamaChatClient;
	@Autowired
	OllamaApi ollamaApi;
	
	@Autowired
	OpenAiChatClient openAiChatClient;
	
	
	@RequestMapping("/chat0")
	public String chat0( @RequestParam(value = "msg") String msg) {
		System.out.println("msg:"+msg);
		String result = "";
		try {
			result = ollamaChatClient.call(msg);
			System.out.println("result:"+result);
		} catch (Exception e) {
			System.out.println("e:"+e.getMessage());
		}
        return result;
    }
	
	
	@RequestMapping("/chat1")
	public String openai( @RequestParam(value = "msg") String msg) {
		System.out.println("msg:"+msg);
		String result = "";
		try {
			result = openAiChatClient.call(msg);
			System.out.println("result:"+result);
		} catch (Exception e) {
			System.out.println("e:"+e.getMessage());
		}
        return result;
    }

}
