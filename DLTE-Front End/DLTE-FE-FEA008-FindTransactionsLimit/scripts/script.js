var transac = []    //Array storing transaction amount details
var cnt = 0;    // variable to Keep a count on transactions (Can also be used for indexing)
var debCnt = 0; //Count the number of debit transactions
let history;    //Variable to store innerHTML data
function limit(){
    let amt = document.forms['lim'].amount.value;
    document.forms['lim'].amount.value = "";
    transac[cnt] = +amt;    //Pushing the amount to the array
    //First transaction
    if(cnt==0){ 
        alert(amt +" credited.");
        history = "<tr class='bg-success-subtle'><td>"+amt+"</td><td>Credit</td></tr>";
    }
    //OTher transactions
    if(cnt>0){
        //Checking if the current transaction amount is less than the previous one
        if(transac[cnt]<=transac[cnt-1]){
            //Checking if the number of debit transactions have crossed 3
            if(debCnt>2){
                if(confirm("You have reached your debit limit!!\nThis trasaction will cost you Rs.20 extra\n\nDo you wish to proceed?")==true){
                    alert(amt+" debited.")
                    history = "<tr class='bg-danger-subtle'><td>"+amt+"</td><td>Debit</td></tr>";
                    debCnt += 1;
                }
                else{
                    alert("Transaction cancelled.")
                    history = "";
                    transac.pop();  //Removing the last transaction, since its cancelled
                }
            }
            else{
                alert(amt+" debited.")
                history = "<tr class='bg-danger-subtle'><td>"+amt+"</td><td>Debit</td></tr>";
                debCnt += 1;
            }
        }
        else{
            alert(amt +" credited.")
            history = "<tr class='bg-success-subtle'><td>"+amt+"</td><td>Credit</td></tr>";
        }
    }
    //Writing the history to the html
    document.getElementById("hist").innerHTML += history;
    cnt += 1;
}