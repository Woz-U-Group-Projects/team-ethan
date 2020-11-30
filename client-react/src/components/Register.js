import React from 'react';
import axios from "axios";

class Register extends React.Component {
    constructor(props) {
        super(props);
        this.username = React.createRef();
        this.password = React.createRef();
    }
    registerUser = () => {
        let url = "http://localhost:8080/register";
        axios.post(url, { username: this.username.current.value, password: this.password.current.value }).then(response => {
            console.log("Successfully Added User")
        });
    };
    render() {
        return (
            <div align="center">
                <h1>Register</h1>
                <div>
                    <label>User Name: <input type="text" ref={this.username} /></label>
                </div>
                <div>
                    <label> Password: <input type="password" ref={this.password} /></label>
                </div>
                <div>
                    <input type="submit" name="register" onClick={this.registerUser} />
                </div>
            </div>
        )
    }
}
export default Register;