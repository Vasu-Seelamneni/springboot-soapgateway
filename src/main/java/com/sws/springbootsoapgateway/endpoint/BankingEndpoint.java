package com.sws.springbootsoapgateway.endpoint;


import com.example.banking.CreateAccountRequest;
import com.example.banking.CreateAccountResponse;
import com.example.banking.GetAccountBalanceRequest;
import com.example.banking.GetAccountBalanceResponse;
import com.sws.springbootsoapgateway.entity.Account;
import com.sws.springbootsoapgateway.service.AccountService;
import com.sws.springbootsoapgateway.service.TransactionService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BankingEndpoint {

    private static final String NAMESPACE_URI = "http://www.example.com/banking";

    private final AccountService accountService;

    private final TransactionService transactionService;

    public BankingEndpoint(AccountService accountService, TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateAccountRequest")
    @ResponsePayload
    public CreateAccountResponse createAccount(@RequestPayload CreateAccountRequest request) {
        Account account = new Account();
        account.setAccountNumber(request.getAccountNumber());
        account.setAccountHolderName(request.getAccountHolderName());
        account.setBalance(request.getBalance());
        // Map JAXB enum to business logic enum
        account.setType(mapJaxbEnumToBusinessEnum(request.getType()));

        accountService.createAccount(account);

        CreateAccountResponse response = new CreateAccountResponse();
        response.setStatus("SUCCESS");
        response.setAccountNumber(account.getAccountNumber());

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAccountBalanceRequest")
    @ResponsePayload
    public GetAccountBalanceResponse getAccountDetails(@RequestPayload GetAccountBalanceRequest request) {
        Account account = accountService.getAccount(request.getAccountNumber());

        GetAccountBalanceResponse response = new GetAccountBalanceResponse();
        response.setAccountHolderName(account.getAccountHolderName());
        response.setBalance(account.getBalance());

        return response;
    }

    // Utility method to map JAXB enum to business logic enum
    private com.sws.springbootsoapgateway.constants.AccountType mapJaxbEnumToBusinessEnum(com.example.banking.AccountType jaxbType) {
        switch (jaxbType) {
            case CURRENT:
                return com.sws.springbootsoapgateway.constants.AccountType.CURRENT;
            case SAVINGS:
                return com.sws.springbootsoapgateway.constants.AccountType.SAVINGS;
            default:
                throw new IllegalArgumentException("Unknown AccountType: " + jaxbType);
        }
    }
}
