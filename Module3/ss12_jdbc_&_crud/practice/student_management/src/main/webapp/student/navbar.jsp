<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Student Management</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/home">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/student/add.jsp">Add Student</a>
                </li>
            </ul>
            <form class="d-flex" action="/home?action=search" method="post">
                <input class="form-control me-2" type="search" placeholder="Search country" aria-label="Search" name="country" >
                <button class="btn btn-outline-success" type="submit" >Search</button>
            </form>
        </div>
    </div>
</nav>