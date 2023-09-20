import React from 'react';

function EditCustomer(props) {
    return (
        <div>
            <div className="container px-5 my-5">
                <form id="contactForm" data-sb-form-api-token="API_TOKEN">
                    <div className="mb-3">
                        <label className="form-label" htmlFor="họTen">Họ Tên </label>
                        <input className="form-control" id="họTen" type="text" placeholder="Họ Tên "
                               data-sb-validations=""/>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="ngaySinh">Ngày Sinh</label>
                        <input className="form-control" id="ngaySinh" type="text" placeholder="Ngày Sinh"
                               data-sb-validations=""/>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="giớiTinh">Giới Tính</label>
                        <input className="form-control" id="giớiTinh" type="text" placeholder="Giới Tính"
                               data-sb-validations=""/>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="cmnd">CMND</label>
                        <input className="form-control" id="cmnd" type="text" placeholder="CMND"
                               data-sb-validations=""/>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="sdt">SĐT</label>
                        <input className="form-control" id="sdt" type="text" placeholder="SĐT" data-sb-validations=""/>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="email">Email</label>
                        <input className="form-control" id="email" type="text" placeholder="Email"
                               data-sb-validations=""/>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="loạiKhach">Loại Khách</label>
                        <input className="form-control" id="loạiKhach" type="text" placeholder="Loại Khách"
                               data-sb-validations=""/>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="dịaChỉ">Địa Chỉ</label>
                        <input className="form-control" id="dịaChỉ" type="text" placeholder="Địa Chỉ"
                               data-sb-validations=""/>
                    </div>

                    <div className="d-grid">
                        <button className="btn btn-primary " id="submitButton" type="submit">Submit
                        </button>
                    </div>
                </form>
            </div>
            {/*<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>*/}
        </div>
    );
}

export default EditCustomer;