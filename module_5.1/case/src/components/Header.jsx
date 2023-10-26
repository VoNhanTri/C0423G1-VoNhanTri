import {Link} from "react-router-dom";
import {NavLink} from "react-bootstrap";

export function Header() {

    return (
        <>
            <header>
                <div className="container-fluid">
                    <div className="header-area header-sticky">
                        <div className="main-header ">
                            <div className="row align-items-center">
                                <div className="col-xl-2 col-lg-2">
                                    <div className="logo">
                                        <NavLink href="/"><img src={"src/assets/img/logo/logo.png"} alt=""/></NavLink>
                                    </div>
                                </div>
                                <div className="col-xl-8 col-lg-8">
                                    <div className="main-menu f-right d-none d-lg-block">
                                        <nav>
                                            <ul id="navigation">
                                                <li><Link className="nav-link" to="/" ><button>Home</button></Link></li>
                                                <li><Link className="nav-link" to="/customer" ><button>Customer</button></Link></li>
                                                <li><Link className="nav-link" to="/contract" ><button>Contract</button></Link></li>
                                                <li><Link className="nav-link" to="/facility" ><button>Facility</button></Link></li>
                                                {/*<li><Link className="nav-link" to="/employee">Nhân Viên</Link></li>*/}
                                            </ul>
                                        </nav>
                                    </div>
                                </div>
                                <div className="col-xl-2 col-lg-2">
                                        <button >Book Online</button>
                                </div>
                                <div className="col-12">
                                    <div className="mobile_menu d-block d-lg-none"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>

        </>
    )
}
