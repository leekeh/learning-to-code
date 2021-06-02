import "./UserForm.css";
import React, { useState } from "react";

const UserForm = (props) => {
  const [inputUser, setInputUser] = useState({ username: "", age: "" });
  console.log(inputUser);

  const enteredUNhandler = (event) => {
    setInputUser({ ...inputUser, username: event.target.value });
  };

  const enteredAgeHandler = (event) => {
    setInputUser({ ...inputUser, age: event.target.value });
  };

  const submitHandler = (event) => {
    event.preventDefault();
    props.onSubmit(inputUser);
  };

  return (
    <form className="UserInput" onSubmit={submitHandler}>
      <label htmlFor="tfUserName" style={{ paddingBottom: "15px" }}>
        Username
      </label>
      <input
        type="text"
        id="tfUserName"
        onChange={enteredUNhandler}
        value={inputUser.username}
      ></input>
      <label
        htmlFor="tfAge"
        style={{ paddingBottom: "15px", paddingTop: "22px" }}
      >
        Age (Years)
      </label>
      <input
        type="text"
        id="tfAge"
        onChange={enteredAgeHandler}
        value={inputUser.age}
      ></input>
      <input type="submit" value="Add User" className="Button"></input>
    </form>
  );
};

export default UserForm;
