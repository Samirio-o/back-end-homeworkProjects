package fi.haagahelia.course.web;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fi.haagahelia.course.domain.Friend;

// Marks this class as a Spring controller that handles HTTP requests and returns HTML views
@Controller
public class FriendController {
    
    //
    private List<Friend> friends = new ArrayList<>();

    public FriendController() {
        //creates a new friend and adds it to the list
        friends.add(new Friend("Kate", "Cole"));
        friends.add(new Friend("Dan", "Brown"));
    }

    @GetMapping("/friendList")
    public String friendList(Model model) {
        model.addAttribute("friends", friends);
        return "friendList";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("friend", new Friend());
        return "addFriend";
    }

    //recieves the submitted form data and saves the new friend
    @PostMapping("/add")
    public String addFriend(@ModelAttribute Friend friend) {
        friends.add(friend);
        return "redirect:/friendList"; //redirects to the friend list page after adding a new friend
    }
}
