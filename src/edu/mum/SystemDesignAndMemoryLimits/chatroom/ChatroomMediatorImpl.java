package edu.mum.SystemDesignAndMemoryLimits.chatroom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 7/9/17.
 */
public class ChatroomMediatorImpl implements ChatroomMediator {

    private List<User> users;

    public ChatroomMediatorImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public boolean sendMessage(String msg, User user) {
        for (User u : users) {
            if (u == user) {
                u.receive(msg);
                return true;
            }
        }

        return false;
    }

    @Override
    public void sendMessageAll(String msg, User user) {
        for (User u : users) {
            if (u != user) {
                u.receive(msg);
            }
        }
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }
}
