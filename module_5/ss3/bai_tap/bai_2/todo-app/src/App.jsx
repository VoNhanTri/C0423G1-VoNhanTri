import './App.css'
// eslint-disable-next-line no-unused-vars
import React, {Component} from "react";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            list: [],
            item: ''
        };
    }

    handleChange = (event) => {
        this.setState({item: event.target.value})
    };
    handleAddItem = () => {
        console.log(this.state.item)
        if (this.state.item !== "") {
            this.setState((prev) => {
                return {
                    list: [...prev.list, prev.item],
                    item: ""
                }
            })
        }
    }

    render() {
        return (
            <>
                <h1>Todo List</h1>
                <input type="text" value={this.state.item} onChange={this.handleChange}/>
                <button onClick={this.handleAddItem}>Add</button>
                <ul>
                    {this.state.list.map((e,index) =>(
                        <li key={index}>{e}</li>
                    ))}
                </ul>
            </>
        )
    }
}

export default App
