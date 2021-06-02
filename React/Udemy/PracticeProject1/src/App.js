import UserForm from "./components/UserForm";
import Person from "./components/Person";
import Modal from "./components/Modal";
import "./App.css";
import React, { useState } from "react";

function App() {
  const [errormsg, setErrorMsg] = useState("");

  const [users, setusers] = useState([]);
  const submitHandlerMain = (content) => {
    if (
      content.username == null ||
      content.age == null ||
      content.username.trim() === "" ||
      content.age.trim() === ""
    ) {
      setErrorMsg("Please fill out both fields, they should not be empty.");
    } else if (isNaN(content.age.trim() || content.age.trim() < 1)) {
      setErrorMsg("Please enter a valid age (>0)");
    } else {
      setusers([...users, content]);
    }
  };

  const removeModal = () => {
    if (errormsg !== "") {
      setErrorMsg("");
    }
  };

  return (
    <div>
      <div className="Background" onClick={removeModal}>
        <Modal content={errormsg} onClick={removeModal} />
        <div className="Wrapper">
          <UserForm onSubmit={submitHandlerMain} />
        </div>
        <div className={users.length > 0 ? "Wrapper" : ""}>
          <ul className="ListBox">
            {users.map((user, index) => (
              <Person person={user} key={index} />
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
}

export default App;
