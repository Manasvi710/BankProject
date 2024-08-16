package com.example.bank.Controller;

import com.example.bank.Model.Bank;
import com.example.bank.Service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Bank")
public class BankController {
    @Autowired
    BankService bankService;
    @PostMapping("/save")
    public void save(@RequestBody Bank bank){
        bankService.save(bank);
    }

    @PutMapping("/Deposit/{accno}")
    public void deposit(@PathVariable int accno, @RequestBody Bank bank){
        bankService.deposit(accno, bank);
    }

    @PutMapping("/Withdraw/{accno}")
    public void withdraw(@PathVariable int accno, @RequestBody Bank bank){
        bankService.withdraw(accno, bank);
    }

    @GetMapping
    public List<Bank> display(){
        return bankService.display();
    }

    @PutMapping("/transfer/{accno}")
    public void transfer(@PathVariable int accno, @RequestBody Bank bank){
        bankService.transfer(accno, bank);
    }
}

