package edu.mum.SystemDesignAndMemoryLimits.chatroom;

/**
 * Created by hungduong on 7/9/17.
 */
public class UserImpl extends User {

    public UserImpl(ChatroomMediator med, String name) {
        super(med, name);
    }

    @Override
    public void send(String msg) {
        System.out.println(this.name + ": Sending Message = " + msg);
        mediator.sendMessageAll(msg, this);
    }

    @Override
    public void send(String msg, User user) {
        System.out.println(this.name + ": Sending Message = " + msg);
        boolean isSent = mediator.sendMessage(msg, user);

        if (!isSent) {
            System.out.println(user.name + " does not exist in room");
        }
    }

    @Override
    public void receive(String msg) {
        System.out.println(this.name + ": Received Message: " + msg);
    }
}
