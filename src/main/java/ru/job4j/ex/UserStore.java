package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                return user;
            }
        }
        throw new UserNotFoundException("Пользователь с логином '" + login + "' не найден.");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user == null) {
            throw new UserInvalidException("Пользователь не может быть null.");
        }
        if (!user.isValid()) {
            throw new UserInvalidException("Пользователь '" + user.getUsername() + "' не валидный.");
        }
        if (user.getUsername().length() < 3) {
            throw new UserInvalidException("Имя пользователя '" + user.getUsername() + "' содержит менее 3 символов.");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };

        try {
            User user = findUser(users, "Petr Arsentev");
            validate(user);
            System.out.println("This user has an access");
        } catch (UserInvalidException e) {
            System.out.println("Пользователь не валидный: " + e.getMessage());
        } catch (UserNotFoundException e) {
            System.out.println("Пользователь не найден: " + e.getMessage());
        }
    }
}