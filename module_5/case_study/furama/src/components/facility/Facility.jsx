import React, {useEffect, useState} from "react";
import {getAll} from "../../service/FacilityService.jsx";

import Card from 'react-bootstrap/Card';
import ListGroup from 'react-bootstrap/ListGroup';


export function Facility() {
    const [dichVu, setdichVu] = useState([]);

    useEffect(() => {
        getFacility();
    }, []);

    const getFacility = async () => {
        const res = await getAll();
        setdichVu(res)
    }


    return (
        <>
            <div className="container-fluid">
                <div className="row pb-4 ">
                    {
                        dichVu.map((dichVu) => (
                            // eslint-disable-next-line react/jsx-key
                            <div className="col-md-6 col-xl-4 mb-5 ">
                                <Card style={{width: '20rem'}}>
                                    {/* eslint-disable-next-line react/jsx-no-undef */}
                                    <Card.Img variant="top" src={dichVu.img}/>
                                    {/* eslint-disable-next-line react/jsx-no-undef */}
                                    <Card.Body>
                                        <Card.Title>{dichVu.serviceName}</Card.Title>
                                        {/* eslint-disable-next-line react/jsx-no-undef */}

                                    </Card.Body>
                                    <ListGroup className="list-group-flush">
                                        <ListGroup.Item>Diện Tích {dichVu.area}m2</ListGroup.Item>
                                        <ListGroup.Item>{dichVu.maxCapacity} Người/Phòng</ListGroup.Item>
                                        <ListGroup.Item>Giá: {dichVu.rentalCost}$</ListGroup.Item>
                                    </ListGroup>
                                    <Card.Body>
                                        <Card.Link href="#">Card Link</Card.Link>
                                        <Card.Link href="#">Another Link</Card.Link>
                                    </Card.Body>
                                </Card>
                            </div>
                        ))}
                </div>
            </div>
        </>
    );


    // return (
    //     <>
    //         <section className="section-margin section-margin--small">
    //
    //             <div className="container">
    //                 <div className="section-intro text-center pb-80px">
    //
    //                     <div className="section-intro__style">
    //                         <img src="https://themewagon.github.io/seapalace/img/home/bed-icon.png" alt />
    //                     </div>
    //                     <h2>Explore Our Rooms</h2>
    //                 </div>
    //                 <div className="row pb-4 flex-wrap">
    //                     {
    //                         dichVu.map((faci) => (
    //                             // eslint-disable-next-line react/jsx-key
    //                             <div className="col-md-6 col-xl-4 mb-5">
    //                                 <div className="card card-explore">
    //                                     <div className="card-explore__img">
    //                                         <img className="card-img" src={faci.img} alt />
    //                                     </div>
    //                                     <div className="card-body">
    //                                         <h3 className="card-explore__price">${faci.rentalCost} <sub>/ Per Night</sub></h3>
    //                                         <h4 className="card-explore__title"><a href="#">{faci.serviceName}</a></h4>
    //                                         <p>{faci.rentalType}----Beginning fourth dominion creeping god was. Beginning, which fly yieldi dry beast moved blessed </p>
    //                                     </div>
    //                                 </div>
    //                             </div>
    //                         ))}
    //                 </div>
    //             </div>
    //
    //         </section>
    //     </>
    //
    // );
}