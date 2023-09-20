function Header() {
    return (

        <>
                <div  className="header-area header-sticky">
                    <div className="main-header ">
                        <div className="container">
                            <div className="row align-items-center">
                                <div className="col-xl-2 col-lg-2">
                                    <div className="logo">
                                        {/*<a href={link}><img src="case/src/assets/img/logo/logo.png" alt=""/></a>*/}
                                    </div>
                                </div>
                                <div className="col-xl-8 col-lg-8">
                                    <div className="main-menu f-right d-none d-lg-block">
                                        <nav>
                                            <ul id="navigation">
                                                <li><a >Home</a></li>
                                                <li><a >About</a></li>
                                                <li><a >Service</a></li>
                                                <li><a >Blog</a>
                                                    <ul className="submenu">
                                                        <li><a >Blog</a></li>
                                                        <li><a >Blog Details</a></li>
                                                    </ul>
                                                </li>
                                                <li><a href="#">Pages</a>
                                                    <ul className="submenu">
                                                        <li><a >Rooms</a></li>
                                                            <li><a >Element</a></li>
                                                    </ul>
                                                </li>
                                                <li><a >Contact</a></li>
                                            </ul>
                                        </nav>
                                    </div>
                                </div>
                                <div className="col-xl-2 col-lg-2">
                                    <div className="header-btn">
                                        <a href="#" className="btn btn1 d-none d-lg-block ">Book Online</a>
                                    </div>
                                </div>
                                <div className="col-12">
                                    <div className="mobile_menu d-block d-lg-none"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </>
    )

}
export default Header;
