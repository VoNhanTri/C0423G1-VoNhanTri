import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import '../component/service.css'
function Service() {
    return (

<>
    <div className="d-flex justify-content-between flex-wrap">

            <div className="card shadow">
                <img
                    src="https://decofuni.vn/Upload/images/tin-tuc/noi-that-phong-ngu-resort.jpg"
                    className="card-img-top"
                    alt="..."
                />
                <div className="card-body">
                    <h5 className="card-title">house</h5>
                    <p className="card-text">
                        Diện tích phòng: 9m<sup>2</sup>
                    </p>
                    <button>add</button>

                </div>
            </div>

    </div>
</>

    );
}

export default Service;