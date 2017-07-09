package edu.mum.SystemDesignAndMemoryLimits.chatroom;

/**
 * Created by hungduong on 7/9/17.
 */
public interface ChatroomMediator {
    boolean sendMessage(String msg, User user);
    void sendMessageAll(String msg, User user);
    void addUser(User user);
}
