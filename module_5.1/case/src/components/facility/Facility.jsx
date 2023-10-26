import {useEffect, useState} from "react";
import { Card, ListGroup} from "react-bootstrap";
import {getAllFacility} from "../../service/FacilityService.jsx";
import {Link} from "react-router-dom";
import {DeleteFacility} from "./DeleteFacility.jsx";

export function Facility() {
    const [facility, setFacility] = useState([]);


    const [modalStatus, setModalStatus] = useState(false);
    const [selectFacility, setSelectFacility] = useState(null);


    useEffect(() => {
        displayFacility()
    }, []);


    const displayFacility =  async () => {
       const res = await getAllFacility()
        setFacility(res)
    }

    const handleModal = (value) => {
        setModalStatus(true);
        setSelectFacility(value);
    }
    const closeModal = () =>{
        displayFacility()
        setModalStatus(false);
        setSelectFacility(null);
    }


    // const handlePageClick = async (event) => {
    //     const page = event.selected + 1
    //     const res = await getPage(page);
    //     setCustomers(res)
    // }


    return (

        <>
            <div className="container">
                <h1 style={{textAlign:"center"}}>List Facility</h1>
                <div className="navbar navbar-inverse" >
                    <Link  to="/facility/add" ><i className="fa-regular fa-square-plus" style={{color: "#e0c2f0",fontSize:40}}></i></Link>
                </div>
                <div className="row px-5 ">
                    {
                        facility.map((fac) => (
                            // eslint-disable-next-line react/jsx-key
                            <div className="col-md-6 col-xl-4 mb-5 ">
                                <Card style={{width: '20rem'}}>
                                    {/* eslint-disable-next-line react/jsx-no-undef */}
                                    <Card.Img variant="top" src={fac.img}/>
                                    {/* eslint-disable-next-line react/jsx-no-undef */}
                                    <Card.Body style={{textAlign:"center"}}>
                                        <Card.Title>{fac.serviceName.name}</Card.Title>
                                        {/* eslint-disable-next-line react/jsx-no-undef */}

                                    </Card.Body>
                                    <ListGroup className="list-group-flush" style={{textAlign:"center"}}>
                                        <ListGroup.Item>Diện Tích {fac.area}m2</ListGroup.Item>
                                        <ListGroup.Item>{fac.maxCapacity} Người/Phòng</ListGroup.Item>
                                        <ListGroup.Item>Giá: {fac.rentalCost}$</ListGroup.Item>
                                        <ListGroup.Item>Loại Thuê: {fac.rentalType}</ListGroup.Item>
                                    </ListGroup>
                                    <Card.Body>
                                        <div className="navbar">
                                        <div >
                                            <Link  to={`/facility/edit/${fac.id}`}><i className="me-5 fa-regular fa-pen-to-square" style={{color: "#6e65e6", fontSize:25}}></i></Link>

                                        </div>
                                        <div >
                                            <Card.Link href="#" type="button" onClick={()=>handleModal(fac)}><i className="me-5 fa-solid fa-trash-can" style={{color: "#fd2008",fontSize:25,}}></i></Card.Link>
                                        </div>
                                        </div>
                                    </Card.Body>
                                </Card>
                            </div>
                        ))}
                </div>
            </div>
                <DeleteFacility
                show={modalStatus}
                handleClose={closeModal}
                select={selectFacility}
                >
                </DeleteFacility>


            {/*<ReactPaginate*/}
            {/*    breakLabel="..."*/}
            {/*    nextLabel="next >"*/}
            {/*    onPageChange={handlePageClick}*/}
            {/*    pageCount={totalPage}*/}
            {/*    previousLabel="< previous"*/}
            {/*    renderOnZeroPageCount={null}*/}
            {/*    marginPagesDisplayed={3}*/}
            {/*    pageRangeDisplayed={1}*/}



            {/*    containerClassName={"pagination justify-content-center"}*/}
            {/*    previousClassName={"page-item"}*/}
            {/*    previousLinkClassName={"page-link"}*/}
            {/*    pageClassName={"page-item"}*/}
            {/*    pageLinkClassName={"page-link"}*/}
            {/*    nextClassName={"page-item"}*/}
            {/*    nextLinkClassName={"page-link"}*/}
            {/*    breakClassName={"page-item"}*/}
            {/*    breakLinkClassName={"page-link"}*/}
            {/*    activeClassName={"active"}*/}
            {/*/>*/}
        </>
    )


}