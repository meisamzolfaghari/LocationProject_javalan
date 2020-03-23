package ir.javaland.projects.location.service;

public class OnlineUserHandler {
    private static Integer OnlineUser = 0;


    public OnlineUserHandler() {
    }

    public synchronized static void plusOnlineUser(){
        OnlineUser++;
    }
    public synchronized static void minusOnlineUser(){
        OnlineUser--;
    }

    public static Integer getOnlineUser() {
        return OnlineUser;
    }
}
