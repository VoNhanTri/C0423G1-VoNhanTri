import {Link} from "react-router-dom";

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
                                        <a href=""><img src={"src/assets/img/logo/logo.png"} alt=""/></a>
                                    </div>
                                </div>
                                <div className="col-xl-8 col-lg-8">
                                    <div className="main-menu f-right d-none d-lg-block">
                                        <nav>
                                            <ul id="navigation">
                                                <li><Link className="nav-link" to="/">Trang Chủ</Link></li>
                                                <li><Link className="nav-link" to="/customer">Khách Hàng</Link></li>
                                                <li><Link className="nav-link" to="/contract">Hợp Đồng</Link></li>
                                                <li><Link className="nav-link" to="/facility">Dịch Vụ</Link></li>
                                                <li><Link className="nav-link" to="/employee">Nhân Viên</Link></li>
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
            </header>

        </>
    )
}
