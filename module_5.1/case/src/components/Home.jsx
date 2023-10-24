import Carousel from 'react-bootstrap/Carousel';
import {Image} from "react-bootstrap";
import {FacilityDisplay} from "./facility/FacilityDisplay.jsx";

function IndividualIntervalsExample() {
    return (
        <>
            <div className='container-fluid'>
                <Carousel>
                    <Carousel.Item interval={500}>
                        <Image src='src/assets/img/hero/contact_hero.jpg'
                               style={{width: "100%", marginBottom: "50px"}}/>
                    </Carousel.Item>
                    <Carousel.Item interval={500}>
                        <Image src='src/assets/img/hero/roomspage_hero.jpg'
                               style={{width: "100%", marginBottom: "50px"}}/>
                    </Carousel.Item>
                    <Carousel.Item>
                        <Image src='src/assets/img/hero/servicespage_hero.jpg'
                               style={{width: "100%", marginBottom: "50px"}}/>
                    </Carousel.Item>
                </Carousel>
                <FacilityDisplay/>
            </div>
        </>
    );
}

export default IndividualIntervalsExample;