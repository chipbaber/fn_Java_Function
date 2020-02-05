##Fn Sample Function in Java
This program tax a json input payload with both a State name and the price of a item. Then looks up the tax rate for the state, and calculates total cost with Tax.

Ex. Input Payload

    ---
    {"state":"Virginia",
     "price": 5.00}
    ---
    
Ex. Output Payload

    ---
    {"state":"Virginia",
     "price":5.0,
     "tax_rate":.05,
     "tax":.25,
     "total_cost":5.25}
    ---
    
To find url for curl or postman issue:

---
fn inspect function java-app statetaxcalc
---