package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Класс описывает работу банковского сервиса.
 * Сервис позволяет регистрировать пользователей, открывать им счета
 * и выполнять переводы денежных средств между счетами.
 * @author Aksenov Aleksey
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей и их счетов осуществляется в коллекции типа HashMap.
     * Ключом выступает объект пользователя, значением - список его счетов.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя в систему.
     * Если пользователь с таким паспортом уже существует, ничего не делается.
     * @param user пользователь которого нужно добавить
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя из системы по номеру паспорта.
     * Для удаления создается временный объект User, так как equals/hashCode
     * реализованы через поле паспорта.
     * @param passport номер паспорта пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод добавляет новый счёт пользователю.
     * Счёт добавляется только если у пользователя ещё нет счёта с такими реквизитами.
     * @param passport номер паспорта пользователя
     * @param account объект счёта который нужно добавить
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта.
     * @param passport номер паспорта для поиска
     * @return объект User или null, если пользователь не найден
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет счёт пользователя по реквизитам.
     * @param passport номер паспорта владельца счёта
     * @param requisite реквизиты счёта для поиска
     * @return объект Account или null, если счёт не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод переводит деньги с одного счёта на другой.
     * Перевод возможен только если счета существуют и на исходном счёте
     * достаточно средств.
     * @param sourcePassport паспорт владельца исходного счёта
     * @param sourceRequisite реквизиты исходного счёта
     * @param destinationPassport паспорт владельца целевого счёта
     * @param destinationRequisite реквизиты целевого счёта
     * @param amount сумма перевода
     * @return true, если перевод успешен, иначе false
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account source = findByRequisite(sourcePassport, sourceRequisite);
        Account destination = findByRequisite(destinationPassport, destinationRequisite);

        if (source != null && destination != null && source.getBalance() >= amount) {
            source.setBalance(source.getBalance() - amount);
            destination.setBalance(destination.getBalance() + amount);
            result = true;
        }
        return result;
    }

    /**
     * Метод возвращает список счетов пользователя.
     * @param user объект пользователя
     * @return список счетов пользователя или null, если пользователь не найден
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}