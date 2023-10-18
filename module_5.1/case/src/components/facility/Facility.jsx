import {useEffect, useState} from "react";
import {Card, ListGroup} from "react-bootstrap";
import {getAllFacility} from "../../service/FacilityService.jsx";
import {Link} from "react-router-dom";

export function Facility() {
    const [facility, setFacility] = useState([]);

    useEffect(() => {
        displayFacility()
    }, []);


    const displayFacility =  async () => {
       const res = await getAllFacility()
        setFacility(res)
    }

    return (

        <>
            <div className="container">
                <div className="navbar navbar-inverse" >
                    <Link  to="/facility/add" ><i className="fa-regular fa-square-plus" style={{color: "#dca73a",fontSize:40}}></i></Link>
                </div>
                <div className="row pb-4 ">
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
                                    </ListGroup>
                                    <Card.Body>
                                        <div className="navbar">
                                        <div >
                                            <Card.Link href="#"><i className="me-5 fa-regular fa-pen-to-square" style={{color: "#dca73a", fontSize:25}}></i></Card.Link>

                                        </div>
                                        <div >
                                            <Card.Link href="#"><i className="me-5 fa-solid fa-trash-can" style={{color: "#fd2008",fontSize:25,}}></i></Card.Link>
                                        </div>
                                        </div>
                                    </Card.Body>
                                </Card>
                            </div>
                        ))}
                </div>
            </div>

        </>
    )


}