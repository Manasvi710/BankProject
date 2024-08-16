
package com.example.bank.Service;

import com.example.bank.Model.Bank;
import com.example.bank.Repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {
    @Autowired
    BankRepository bankRepository;
    public void save(Bank bank){
        bankRepository.save(bank);
    }

    public void deposit(int accno, Bank bank){
        Bank b=bankRepository.findById(accno).get();
        b.setBalance(b.getBalance()+ bank.getBalance());
        bankRepository.save(b);
    }
    public void withdraw(int accno, Bank bank){
        Bank b=bankRepository.findById(accno).get();
        b.setBalance(b.getBalance()- bank.getBalance());
        bankRepository.save(b);
    }
    public List<Bank> display(){
        return bankRepository.findAll();
    }

    public void transfer(int accno, Bank bank){
        Bank minus=bankRepository.findById(accno).get();
        int accNo1=bank.getAccno();
        Bank plus=bankRepository.findById(accNo1).get();
        minus.setBalance(minus.getBalance()-bank.getBalance());
        plus.setBalance(plus.getBalance()+ bank.getBalance());
        bankRepository.save(minus);
        bankRepository.save(plus);
    }
}
