let details=[{
    "ID":"12345",
    "password":"aaaa",
    "customername":"Apoorva",
    "cuspin":"9999",
    "cusstatus":"active",
    "accno":"9087",
    "accbal":"10000",
    "adharno":"1234567890123",
    "cuspan":"EP945P",
    "phno":"6562333454",
    "cusemail":"aaaaaa@gmail.com"
},
{
    "ID":"54321",
    "password":"bbbb",
    "customername":"anika",
    "cuspin":"8888",
    "cusstatus":"active",
    "accno":"1425",
    "accbal":"1500",
    "adharno":"987654321",
    "cuspan":"WER09J",
    "phno":"9440971297",
    "cusemail":"bbbbbb@gmail.com" 
}]
function authentication(){
    let uname = document.forms['login'].ID.value
    let upass = document.forms['login'].password.value

    details.forEach((item)=>{
        if(item.ID == uname && item.password == upass){
            window.location.href = "http://127.0.0.1:5500/home.html"
        }
    })
}