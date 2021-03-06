import React from "react";
import axios from "axios";
import '../task.min.css';


class Task extends React.Component {
  constructor(props) {
    super(props);
    this.state = { tasks: [] };
    this.taskName = React.createRef();
    this.user = React.createRef();
    this.user = null;
  }

  componentDidMount() {
    if(document.getElementById("user").innerHTML != null){
      this.user = document.getElementById("user").innerHTML.split(":").pop();
    }
    this.getData();
  }

  getData = () => {

    // Spring uses port 8080 (react uses 3000)
    let url = "http://localhost:8080/tasks/user/" + this.user;
    axios.get(url).then(response => this.setState({ tasks: response.data }));
  };

  addTask = () => {
    let url = "http://localhost:8080/tasks";
    axios.post(url, { name: this.taskName.current.value, createdBy: this.user}).then(response => {
      // refresh the data
      this.getData();
      // empty the input
      this.taskName.current.value = "";
    });
  };

  completeTask = (taskToComplete) => {
    let url = `http://localhost:8080/tasks/${taskToComplete}`;
    axios.get(url).then(response => {
        axios.put(url, {name: response.data.name, complete: true, id: response.data.id}).then(response => {
          this.getData();
    });
    });
  };
  

  deleteTask = (taskToDelete) => {
    let url = `http://localhost:8080/tasks/${taskToDelete}`;
      axios.delete(url).then(response => {
      this.getData();
    });
  };
  

  render() {
    return (
      <div align="center">
        <h3>Your Tasks</h3>
        <input ref={this.taskName}/>
        <button type="button" className="btn btn-primary" onClick={this.addTask}>add</button>
        <ul>
          {this.state.tasks.map(p => (
            <li key={p.taskid}>
              {p.name} : { p.complete ? "complete" : "not complete" } <button type="button" className="btn btn-success" onClick= {() => {this.completeTask(p.id)}}>Complete</button><button type="button" className="btn btn-danger" onClick={() => {this.deleteTask(p.id)}}>Delete</button>
            </li>
          ))}
        </ul>
      </div>
    );
  }
}

export default Task;