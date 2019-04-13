package pl.tujdowski.czat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatApi {
    public static List<ChatMessage> chatMessage = new ArrayList<>();

    @PostMapping("/handleChatMessage")
    @ResponseBody
    public void handleChatMessage(@RequestBody ChatMessage chatMessage) {
        this.chatMessage.add(chatMessage);
        System.out.println(chatMessage);
    }

    @GetMapping("/chat")
    public String getWindow(Model model) {
        model.addAttribute("chatMessage", chatMessage);
        return "chat";
    }

    @GetMapping("/sendMessage")
    public String send(Model model) {
        model.addAttribute("chatMessage", new ChatMessage());
        return "sendMessage";
    }

    @GetMapping("/iframe")
    public String iframe() {
        return "iframe";
    }


}
