package org.example;

import org.example.model.BankAccount;
import org.example.repository.AccountRepository;
import org.example.repository.AccountRepositoryImpl;
import org.example.util.JsonSerializer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        JsonSerializer<BankAccount> bankAccountJsonSerializer=new JsonSerializer<>();
        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
        accountRepository.populateData();
        List<BankAccount> bankAccounts = accountRepository.findAll();
        bankAccounts.stream().map(acc->bankAccountJsonSerializer.toJson(acc)).forEach(System.out::println);
    }
}