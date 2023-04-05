let details=[{
    "ID":"190001",
    "password":"1000",
    "customername":"Apoorva",
    "customerstatus":"active",
    "accno":"908734567",
    "accbal":"2345678",
   
    
},
{
    "ID":"190002",
    "password":"0001",
    "customername":"karthik",
    "customerstatus":"active",
    "accno":"14256775",
    "accbal":"150",
    
},
{
    "ID":"190003",
    "password":"9999",
    "customername":"Ishika",
    "customerstatus":"active",
    "accno":"10987658",
    "accbal":"19000",
    
}]
function authentication(){
    let uname = document.forms['login'].ID.value
    let upass = document.forms['login'].password.value

    details.forEach((item)=>{
        if(item.ID == uname && item.password == upass){
            window.location.href = "http://127.0.0.1:5501/home.html"
        }
    })
}