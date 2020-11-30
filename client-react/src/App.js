import React from "react";
import MyTasks from "./components/MyTasks";
import SignIn from "./components/Signin";
import Register from "./components/Register";
import "./App.css";
import { BrowserRouter as Router, Route, Link } from 'react-router-dom';

const App = () => (
  <Router>
    <div>
    <ul>
        <li>
          <Link to="/">Sign In</Link>
        </li>
        <li>
          <Link to="/tasks">Tasks</Link>
        </li>
        <li>
          <Link to= "/register">Register </Link>
        </li>
        <h4 id="user" align="right"></h4>
      </ul>

      <hr />
      <Route exact path="/" component={SignIn} />
      <Route path="/tasks" component={MyTasks} />
      <Route path = "/register" component={Register} />
    </div>
  </Router>
);

export default App;
