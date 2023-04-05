<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<script>
    let details=[{
        "ID":"12345",
        "password":"apoorva"}]
    function authentication(){
        let uname = document.forms['login'].ID.value
        let upass = document.forms['login'].password.value

        details.forEach((item)=>{
            if(item.ID == uname && item.password == upass){
                window.location.href = "studentweb.jsp"
            }
            else{document.write("Invalid credentials")}
        })}

</script>
<body>

<a href="stud">show student details</a>
<a href="insertweb.jsp">Add details</a>
<a href="adress.jsp">view adress</a>


<!--Navbar-->
<nav class="navbar navbar-expand-lg bg-primary">
    <div class="container-fluid">
        <h2 class="text-center text-dark"> WELCOME USER </h2>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav m-3">
                <li class="nav-item">
                    <a class="nav-link" href="#" >Help</a>
                </li>
            </ul>
            <ul class="navbar-nav m-3">
                <li class="nav-item">
                    <a class="nav-link" href="#" >Sign up</a>
                </li>
            </ul>

            <form class="d-flex">
                <input type="text" class="form-control m-3" placeholder="What are you looking for?">
                <button type="search" class="btn btn-outline-success m-3">search</button>
            </form>
        </div>

    </div>
</nav>
<!--marquee moving left below navbar-->
<div class="text-dark text-bg-warning">
    <marquee direction="left" scrollamount="3">
        Please remember that Bank do not ask for upi change through email and contact number
    </marquee>
</div>
<div class="container-fluid bg-info">
    <div class="row p-4">
        <!--form to fill the customer details-->
        <form name="login" class="justify-content-center card col-lg-4 p-4 rounded-5">
            <h4 class="text-dark text-center">Customer login</h4>
            <div class="form-group">
                <label>Username:</label>
                <input name="ID" class="form-control" type="text" placeholder="Enter Customer ID">
            </div>
            <div class="form-group">
                <label>Password:</label>
                <input name="password" class="form-control" type="text" placeholder="Enter password">
            </div>
            <div class="d-flex justify-content-end mt-2">
                <a href="#">Forgot password?</a>
            </div>
            <div class="d-flex justify-content-center">
                <a class="btn btn-outline-success m-3" type="submit" onclick="authentication()">submit</a>
                <button type="reset" class="btn btn-outline-danger m-3">reset</button>

            </div>
        </form>

    </div>
</div>
</div>
</body>
</html>
