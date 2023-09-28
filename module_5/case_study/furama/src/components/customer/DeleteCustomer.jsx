import {remove} from "../../service/CustomerService.jsx";
import {toast} from "react-toastify";

export function DeleteCustomer(props) {
    // eslint-disable-next-line react/prop-types
    let {show, selectCustomer, handleClose} = props;

    const handleDelete = async (selectedCustomer) => {
        const res = await remove(selectedCustomer.id);
        if (res.status === 200) {
            handleClose()
            toast("Xoá Thành Công");
        } else {
            toast.error("Xoá Thất Bại");
        }
    }
    return (
        <>
            {show && (
                <div className="modal" tabIndex="-1" style={{display: 'block'}}>
                    <div className="modal-dialog">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title">Confirm Deletion</h5>
                                <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"
                                        onClick={handleClose}></button>
                            </div>
                            <div className="modal-body">
                                {/* eslint-disable-next-line react/prop-types */}
                                <p>Do you want to delete <b>{selectCustomer.hoTen}</b></p>
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-secondary" data-bs-dismiss="modal"
                                        onClick={handleClose}>Close
                                </button>
                                <button type="button" className="btn btn-primary"
                                        onClick={() => handleDelete(selectCustomer)}>Delete
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            )}
        </>
    );
}