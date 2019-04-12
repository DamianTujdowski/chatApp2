package pl.tujdowski.czat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ChatApi {
    private static ChatMessage chatMessage;

    @PostMapping("/handleChatMessage")
    public void handleChatMessage(@RequestBody ChatMessage chatMessage) {
        this.chatMessage = chatMessage;
        System.out.println(chatMessage);
    }

    @GetMapping("/window")
    public String getWindow(Model model) {
        model.addAttribute("chatMessage", chatMessage);
        return "chat";
    }

}
