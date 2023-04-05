<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<%--<script>--%>
<%--    let details=[{--%>
<%--        "ID":"12345",--%>
<%--        "password":"apoorva"}]--%>
<%--    function authentication(){--%>
<%--        let uname = document.forms['login'].ID.value--%>
<%--        let upass = document.forms['login'].password.value--%>

<%--        details.forEach((item)=>{--%>
<%--            if(item.ID == uname && item.password == upass){--%>
<%--                window.location.href = "display.jsp"--%>
<%--            }--%>
<%--            else{document.write("Invalid credentials")}--%>
<%--        })}--%>

<%--</script>--%>
<style>
    body{
        background: linear-gradient(45deg,lightpink,lavender);
    }

</style>
<body>

<%--<a href="stud">show student details</a>--%>
<%--<a href="insertDetails.jsp">Add details</a>--%>
<%--<a href="viewAddress.jsp">view adress</a>--%>

<div class="container-fluid ">
    <div class="row p-4 justify-content-center">

        <form action="login" method="post" class="justify-content-center card col-lg-4 p-4 rounded-5">
            <h4 class="text-dark text-center">Admin login</h4>
            <div class="form-group">
                <label>Admin ID:</label>
                <input name="adminId" class="form-control" type="text" placeholder="Enter Customer ID">
            </div>
            <div  class="form-group">
                <label>Password:</label>
                <input name="passCode" class="form-control" type="password" placeholder="Enter password">
            </div>
            <div class="d-flex justify-content-end mt-2">
                <a href="#">Forgot password?</a>
            </div>
            <div class="d-flex justify-content-center">
                <button class="btn btn-outline-success m-3" type="submit" value="submit">submit</button>
                <button type="reset" class="btn btn-outline-danger m-3">reset</button>

            </div>
        </form>

    </div>
</div>
</div>
</body>
</html>
