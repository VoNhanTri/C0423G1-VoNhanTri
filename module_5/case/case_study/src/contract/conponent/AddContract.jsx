import React from 'react';

function AddContract() {
    return (
        <div>
            <div className="container px-5 my-5">
                <form id="contactForm" data-sb-form-api-token="API_TOKEN">
                    <div className="mb-3">
                        <label className="form-label" htmlFor="sốHợpDồng">Số Hợp Đồng</label>
                        <input className="form-control" id="sốHợpDồng" type="text" placeholder="Số Hợp Đồng"
                               data-sb-validations=""/>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="ngayBắtDầu">Ngày Bắt Đầu</label>
                        <input className="form-control" id="ngayBắtDầu" type="text" placeholder="Ngày Bắt Đầu"
                               data-sb-validations=""/>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="ngayKếtThuc">Ngày Kết Thúc</label>
                        <input className="form-control" id="ngayKếtThuc" type="text" placeholder="Ngày Kết Thúc"
                               data-sb-validations=""/>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="sốTiềnCọcTrước">Số Tiền Cọc Trước</label>
                        <input className="form-control" id="sốTiềnCọcTrước" type="text" placeholder="Số Tiền Cọc Trước"
                               data-sb-validations=""/>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="tổngTiềnThanhToan">Tổng Tiền Thanh Toán</label>
                        <input className="form-control" id="tổngTiềnThanhToan" type="text"
                               placeholder="Tổng Tiền Thanh Toán" data-sb-validations=""/>
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

export default AddContract;