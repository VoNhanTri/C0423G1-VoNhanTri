import data from "bootstrap/js/src/dom/data.js";
import { xoa} from "../service/HangHoaService.jsx";
import {toast} from "react-toastify";

export function XoaHangHoa(props) {
    // eslint-disable-next-line react/prop-types
    let {show,handle,select} = props;

    const xoaXoa = async (data) =>{
        const res = await xoa(data.id)
        if (res.status===200){
            handle()
            toast("Xoá Thành ooong")
        }else {
            toast.error("XOá Thất Bại")
        }

    }


    return (
        <>
            {
                show&& (
                    <div className="modal" tabIndex="-1" style={{display: 'block'}}>
                        <div className="modal-dialog">
                            <div className="modal-content">
                                <div className="modal-header">
                                    <h5 className="modal-title">Confirm Deletion</h5>
                                    <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"
                                            onClick={handle}></button>
                                </div>
                                <div className="modal-body">
                                    {/* eslint-disable-next-line react/prop-types */}
                                    <p>Bạn Có Muốn xoá tên <b>{select.tenHangHoa}</b></p>
                                </div>
                                <div className="modal-footer">
                                    <button type="button" className="btn btn-secondary" data-bs-dismiss="modal"
                                            onClick={handle}>Close
                                    </button>
                                    <button type="button" className="btn btn-primary"
                                            onClick={() =>{xoaXoa(select)}}>Delete
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                )
            }

        </>
    )
}