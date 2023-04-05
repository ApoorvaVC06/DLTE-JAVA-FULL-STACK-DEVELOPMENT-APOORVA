function tax(){
    var fname=document.forms['term'].name.value;
    var Prof=document.forms['term'].prof.value;
    var Income=document.forms['term'].income.value;

    var abc=document.forms['term'].type.value;
}
if(Income<=35000){
    if(abc==="emplyee"){
     var bill=document.forms.income['term'].income.value%10;
    document.forms['term'].show.value=fname+" has to pay "+document.forms.income['term'].income.value+" of 10% slab";
    }
}
    else{
        document.forms['term'].show.value=fname+" has eligible to get 50Lacks of Term insurance from Allianze, Adidta, Tata AIA";
    }
