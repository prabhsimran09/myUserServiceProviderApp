# myUserServiceProviderApp
MySpringBootApp

This is a basic REST Springboot Application developed using Spring Web, Hibernate with H2 database configured o local memory and built with maven.

It is a simplified Billing and Payment System that supports the creation of users, generation of bills, and allows users to pay their bills. 
It enables querying bills by user and service provider, and handles partial and full payments

User Management
   ● Add a user with a unique user ID and name.
   ● List all users.
   
Service Provider Management
   ● Add a service provider.
   ● Each service provider has a unique ID and name.

Bill Management
  ● Create a bill for a user from a specific provider.
  ● A bill has:
    ○ Bill ID (unique)
    ○ User ID
    ○ Provider ID
    ○ Currency
    ○ Amount
    ○ Paid Amount
    ○ Due Amount
    ○ Due Date
    ○ Payment Status: PENDING, PARTIALLY_PAID, PAID
    
Payment Processing
  ● Users can pay bills (partial or full).
  ● Update the bill payment status and amount due accordingly.
  ● Store payment transactions with:
    ○ Payment ID(Unique)
    ○ Bill ID
    ○ Currency
    ○ Amount paid

Validations and rules
  ● Due Date must be a valid future date.
  ● Initial paid amount must be 0.
  ● Due amount = amount initially.
  ● Payment status must be 'PENDING' on creation.
  ● Amount paid must be > 0.
  ● Update bill status:
    ○ If paid_amount == amount → PAID
    ○ If 0 < paid_amount < amount → PARTIALLY_PAID
    
Queries / Operations
  ● Get pending bills for a user.
  ● Get all bills for a user.
  ● Get bills by provider.
  ● Get the total outstanding
