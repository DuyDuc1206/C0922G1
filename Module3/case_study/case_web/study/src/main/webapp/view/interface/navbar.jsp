<nav class="navbar navbar-expand-lg bg-light sticky-lg-top">
    <div class="container-fluid" style="background-color: #046056; height: 70px">
        <a class="navbar-brand" href="/view/home.jsp" style="color: white;margin-left: 100px">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/view/employee/list.jsp" style="color: white">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/furama?action=list" style="color: white">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/view/service/list.jsp" style="color: white">Service</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/view/contract/list.jsp" style="color: white">Contract</a>
                </li>
            </ul>
            <form class="d-flex" role="search" style="margin-right: 100px">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
