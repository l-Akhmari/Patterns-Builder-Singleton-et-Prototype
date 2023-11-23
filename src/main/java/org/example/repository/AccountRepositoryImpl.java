package org.example.repository;

import org.example.model.AccountStatus;
import org.example.model.AccountType;
import org.example.model.BankAccount;
import org.example.model.BankDirector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AccountRepositoryImpl implements AccountRepository {
    private Map<Long, BankAccount> bankAccountMap = new HashMap<>();
    private long accountcount=0;
    @Override
    public BankAccount save(BankAccount bankAccount) {
        Long accountId = ++accountcount;
        bankAccount.setAccountId(accountId);
        bankAccountMap.put(accountId,bankAccount);
        return bankAccount;
    }

    @Override
    public List<BankAccount> findAll() {

        return bankAccountMap.values().stream().toList();
    }

    @Override
    public Optional<BankAccount> findById(Long id) {
        BankAccount account= bankAccountMap.get(id);
        return account==null?Optional.empty():Optional.of(account);
    }

    @Override
    public List<BankAccount> searchAccounts(Predicate<BankAccount> predicate) {

        return bankAccountMap.values().stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public BankAccount update(BankAccount account) {
        bankAccountMap.put(account.getAccountId(), account);
        return account;
    }

    @Override
    public void deleteById(Long id) {
        bankAccountMap.remove(id);
    }

    public void populateData(){
        for (int i = 0; i < 7; i++) {
            BankAccount bankAccount= BankDirector.accountBuilder()
                    .balance(10000*Math.random()*900000)
                    .currency(Math.random()>0.7? " MAd":"USD")
                    .type(Math.random()<0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                    .status(Math.random()>0.5? AccountStatus.CREATED:AccountStatus.ACTIVATED)
                    .Build();
            save(bankAccount);
        }
    }
}
