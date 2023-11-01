import {remove} from "../service/GoodsService.jsx";
import {toast} from "react-toastify";

export function DeleteGoods(props) {
    // eslint-disable-next-line react/prop-types
    let {show, handle, select} = props;

    const remo = async (data) => {
        const res = await remove(data.id);
        if (res.status === 200) {
            handle();
            toast("Xoá Thành Công");
        } else {
            toast.error("Xoá Thất Bại");
        }
    }

    return (
        <>   {
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
                                        onClick={() =>{remo(select)}}>Delete
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