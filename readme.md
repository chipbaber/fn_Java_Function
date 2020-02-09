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
     "tax_rate":.043,
     "tax":.22,
     "total_cost":5.22}
    ---


### Follow Steps below to deploy the function to Fn:

   - Clone the git repo

    ---
    mkdir stateTaxCalc
    cd stateTaxCalc
    git clone https://github.com/chipbaber/fn_Java_Function.git
     ---

   - Start Fn, then open a new terminal window

    ---
    cd ..
    fn start
    ---
    
   -Command to start UI
   
     ---
     docker run --rm -it --link fnserver:api -p 4000:4000 -e "FN_API_URL=http://localhost:8080" fnproject/ui
     ---
     
   - Access via http://localhost:4000/
     
   - Build the project in a new directory

    ---
    cd stateRates
    fn --verbose build
    ---

   - Create a application for the function

    ---
    fn create app rateCard 
    ---
    
   - Deploy Java App, app name is defined in app.yaml, trigger to function in func.yaml

    ---
    fn --verbose deploy --create-app --all --local
    ---

   - View app and trigger
   
    ---
    fn list apps
    fn list triggers ratecard
    --- 

   - To find url for curl or postman issue:

    ---
    fn inspect function ratecard statetaxcalc
    ---
    
   - Example detailed endpoint http://localhost:8080/invoke/01E086P4FGNG8G00GZJ0000004 Test with postman or curl command.
    
    ---
     curl -X POST -d '{"state":"Texas","price": 5.00}' http://localhost:8080/invoke/01E086P4FGNG8G00GZJ0000004
    ---
    
   - You can also access via pretty url as well. 
   
   ---
    curl -X POST -d '{"state":"Texas","price": 5.00}' http://localhost:8080/t/ratecard/ratecard
   ---
    
   - Practice common commands
   
    ---
    fn list functions rateCard
    fn list apps
    ---
    
   - Cleanup env. 
   
    ---
    fn delete function rateCard statetaxcalc
    fn delete app rateCard
    ---