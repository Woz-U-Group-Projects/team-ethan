import React from 'react';
import axios from "axios";

class Signin extends React.Component {
    constructor(props) {
        super(props);
        this.username = React.createRef();
        this.password = React.createRef();
    }
    signInUser = () => {
        let url = "http://localhost:8080/login/" + this.username.current.value;
        axios.get(url).then(response => {
           if(response.data.username === this.username.current.value && response.data.password === this.password.current.value){
            alert("Successfully Logged In");
            console.log(response);
            document.getElementById("user").innerHTML = "User: " + response.data.id;
          } else {
            alert("Unsuccessful Login");
            console.log(response);
            console.log(this.password);
          }
        });
    };
    render() {
        return (
            <div>
                <h1>Sign In</h1>
                <div>
                    <label>User Name: <input type="text" ref={this.username} /></label>
                </div>
                <div>
                    <label> Password: <input type="password" ref={this.password} /></label>
                </div>
                <div>
                    <input type="submit" name="sign in" onClick={this.signInUser} />
                </div>
            </div>
        )
    }
}
export default Signin;