import React from "react";
import { useNavigate} from "react-router-dom";
import { Navbar, Container, Nav } from 'react-bootstrap';


const Home = () => {
    const navigate = useNavigate();
    const handleClick = () => {
        navigate('/login');
    };

    return (
        <>
            <Navbar collapseOnSelect expand="lg" bg="success" variant="dark">
                <Container fluid>
                    <Navbar.Brand href="/">CourseSelection <a href="/"></a></Navbar.Brand>
                    <Navbar.Toggle aria-controls="navbarScroll" />
                    <Navbar.Collapse id="navbarScroll">
                        <Nav
                            className="me-auto my-2 my-lg-0"
                            style={{ maxHeight: '100px' }}
                            navbarScroll
                        >
                            <Nav.Link href="/">Home</Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
            <div className="background">
                <div className="content">
                    <br /><br /><table> <br /> <br /> <br /> <br /> <br /> <br />
                    <h1 className="title">Welcome to Our University Course Selection Application</h1>
                    <h6>Please Login to Use Our Application</h6>
                    <br />
                    <button className="btn btn-success h-75 pr-3" onClick={handleClick}>LOGIN</button>
                    </table>
                </div>
            </div>
        </>
    );
};

export default Home;
