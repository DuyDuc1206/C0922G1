<nav class="navbar navbar-expand-lg bg-light sticky-lg-top">
    <div class="container-fluid" style="background-color: #046056; height: 70px">
        <a class="navbar-brand" href="/customer" style="color: white;margin-left: 100px">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="" style="color: white">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/home?action=list" style="color: white">TComplex</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="" style="color: white">Facility</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="" style="color: white">Contract</a>
                </li>
            </ul>
            <form class="d-flex" role="search" style="margin-right: 100px;" action="/customer?action=search" method="post">
                <input class="form-control me-2" type="search" placeholder="Search address" aria-label="Search" name="address">
                <input class="form-control me-2" type="search" placeholder="Search name" aria-label="Search" name="name">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
