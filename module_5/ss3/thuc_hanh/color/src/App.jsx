import {Component, useState} from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

class App extends Component{
    constructor(props) {
        super(props);
        this.state = {
            color: 'black'
        };
    }
    componentDidMount() {
        setTimeout(() =>{
            this.setState({color: 'pink'});
            }, 5000);
    }
    render() {{
        return(
            <div>
                <div style={{
                    backgroundColor: this.state.color,
                    paddingTop: 20,
                    width: 400,
                    height: 80,
                    margin: 'auto'
                }}>

                </div>
            </div>
        )
    }
    }
}

export default App
