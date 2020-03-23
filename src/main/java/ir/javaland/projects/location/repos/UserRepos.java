package ir.javaland.projects.location.repos;


import ir.javaland.projects.location.model.User;

public class UserRepos extends CrudRepos<User, Long> {
    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    private static UserRepos userRepos = null;

    private UserRepos() {
    }

    public static UserRepos getInstance() {
        if (userRepos == null)
            userRepos = new UserRepos();
        return userRepos;
    }

}
