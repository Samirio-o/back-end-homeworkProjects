package fi.haagahelia.course.web;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fi.haagahelia.course.domain.Friend;

@Controller
public class FriendSinglePageController {
    //list to store Friend objects
    private List<Friend> friends = new ArrayList<>();

    //constructor
    public FriendSinglePageController() {
        //creates a new friend and adds it to the list
        friends.add(new Friend("Kate", "Cole"));
        friends.add(new Friend("Dan", "Brown"));
    }

    @GetMapping ("/friendSinglePage")
    public String friendSinglePage(Model model) {
        model.addAttribute("friends", friends);
        model.addAttribute("friend", new Friend());
        return "friendSinglePage";
    }

    @PostMapping("/friendSinglePage")
    public String addFriend(@ModelAttribute Friend friend) {
        friends.add(friend);
        //redirects to the same friend list page after adding the new friend
        return "redirect:/friendSinglePage";
    }
}
