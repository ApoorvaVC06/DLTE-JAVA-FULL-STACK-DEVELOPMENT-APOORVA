$(document).ready(()=>{
    $("form[name=login]").submit(()=>{
        $("#errid").hide()
        $("#errpassword").hide()

        const id=$("input[name=id]").val()
        const password=$("input[name=passCode]").val()

        try{
            if(id===""){
                throw " ID shouldn't be empty"
            }
            else if(!(/[0-9]/).test(id)){
                throw "Id is not valid!!(must include only the digits[0-9])"
            }
        }
        catch(err){
            $("#errid").text(err)
            $("#errid").show()
            return false
        }

        try{
            if(password===""){
                throw "Password shouldn't be empty"
            }
            else if(!(/(?=.*[0-9])(?=.*[$#@!*])[a-zA-Z0-9$#@!*]{8,}/).test(password)){
                throw "Invalid Password"
            }
        }
        catch(msg){
            $("#errpassword").text(msg)
            $("#errpassword").show()
            return false
        }
    })
})       