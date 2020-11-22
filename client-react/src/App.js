import React from "react";
import ReactDOM from 'react-dom';
import MyTasks from "./components/MyTasks";
import SignIn from "./components/Signin";
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
          <Link to="/tasks">About</Link>
        </li>
      </ul>

      <hr />
      <Route exact path="/" component={SignIn} />
      <Route path="/tasks" component={MyTasks} />
    </div>
  </Router>
);

export default App;
