package com.example.demo.controllers;
import com.example.demo.models.*;
import com.example.demo.services.BillService;
import com.example.demo.services.PaymentService;
import com.example.demo.services.ProviderService;
import com.example.demo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/myService")
public class MyController {

    UserService userService;
    BillService billService;
    ProviderService providerService;
    PaymentService paymentService;


    public MyController(UserService userService, BillService billService, ProviderService providerService, PaymentService paymentService) {
        this.userService = userService;
        this.billService = billService;
        this.providerService = providerService;
        this.paymentService = paymentService;
    }


    @PostMapping("/createUserAnDServiceProvider")
    public String createUserAndServiceProvider(@Valid @RequestBody CreateUserAndServiceProviderRequest request){

        String requestType = request.getType();
        Long id = switch (requestType) {
            case "USER" -> userService.addUser(request.getName());
            case "SERVICE_PROVIDER" -> providerService.addProvider(request.getName());
            default -> null;
        };

        if( id ==  null ) return "Invalid input";
        else {
            UserAndServiceProviderResponse createdUser = new UserAndServiceProviderResponse(String.valueOf(id), request.getName(), requestType);
            return createdUser.toString();
        }
    }


    @PostMapping("/createBill")
    public String createBill(@Valid @RequestBody CreateBillRequest request){
        boolean userExists = userService.checkIfCustomerExists(request.getUserId());
        boolean providerExists = providerService.checkIfProviderExists(request.getProviderId());
        if( userExists && providerExists) {
            Long billId = billService.createBill(request);
            if (billId == null)
                return "Invalid Input";
            else {
                BillResponse response = new BillResponse();
                response.setBillId(String.valueOf(billId));
                return response.toString();
            }
        }else{
            if(!userExists) return "Customer "+request.getUserId()+" not found";
            else return "Provider "+request.getProviderId()+" not found";
        }
    }

    @PostMapping("/payBill")
    public String payBill(@Valid @RequestBody PaymentRequest request){
        PaymentResponse response = new PaymentResponse();
        Long billId = billService.updateBill(request);
        Payment payment = paymentService.updatePayment(request);

        if(payment != null ) {
            if(billId == null)
                return "Payment successful with id " + payment.getPaymentId() + " but bill not updated";
            else {
                response.setPaymentId(String.valueOf(payment.getPaymentId()));
                return response.getPaymentId();
            }
        }else {
            return "Payment unsuccessful for bill" + billId;
        }

    }


    @GetMapping("/getPendingBillByUserId")
    public String getPendingBillByUserId(@Valid @RequestParam Long userId){
        return billService.getPendingBillsForUserId(String.valueOf(userId)) !=null ?
                billService.getPendingBillsForUserId(String.valueOf(userId)).toString() :
                "Error occurred while processing request as user ID "+userId+" might not exist ";
    }


    @GetMapping("/getBill")
    public String getPaymentByBillId(@Valid @RequestParam Long billId){
        return billService.getBill(billId) != null ? billService.getBill(billId).toString() : "No such bill found with ID "+billId;
    }


    @GetMapping("/getBillByProviderId")
    public String getBillByProviderId(@Valid @RequestParam Long providerId){
        return billService.getAllBillsForProviderId(String.valueOf(providerId)) != null ?
                billService.getAllBillsForProviderId(String.valueOf(providerId)).toString() :
                "Error occurred while processing request as provider ID "+providerId+" might not exist" ;
    }


    @GetMapping("/getAllBillByUserId")
    public String getBillAllBills(@Valid @RequestParam Long userId){
        return billService.listAllBillsForUser(String.valueOf(userId)) != null ?
        billService.listAllBillsForUser(String.valueOf(userId)).toString() :
                "Error occurred while processing request as user ID "+userId+" might not exist" ;
    }

    @GetMapping("/getPaymentsByBillId")
    public String getPaymentsByBillId(@Valid @RequestParam Long billId){
        return paymentService.getPaymentsByBillId(billId).isPresent() ?
                paymentService.getPaymentsByBillId(billId).get().toString() : null;
    }


    @GetMapping("/getUser")
    public String getUser(@Valid @RequestParam Long userId){
        return userService.getUser(String.valueOf(userId)) != null ?
                userService.getUser(String.valueOf(userId)).toString() : "No user found with ID "+userId;
    }


    @GetMapping("/getAllUsers")
    public String getAllUsers(){
        return userService.listAllUsers().toString();
    }


    @GetMapping("/getProvider")
    public String getProvider(Long providerId){
        return providerService.getServiceProvider(providerId) != null ?
                providerService.getServiceProvider(providerId).toString() : "No provider found with ID "+providerId;
    }
}
