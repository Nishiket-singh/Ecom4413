import React, { useState, useEffect } from "react";
import axios from "axios";
import "./SignIn.css";
import { Link, useHistory } from "react-router-dom";

function SignIn() {
  // const [form,setForm]= useState({
  //     name:'',
  //     password:'',
  // });

  const [name, setName] = useState("");
  const [password, setPassword] = useState("");
  const history = useHistory();

  function handleNameChange(e) {
    const k = e.target.value;
    console.log(k);
    setName(k);
  }

  function handlePassChange(e) {
    const k = e.target.value;
    console.log(k);
    setPassword(k);
  }

  // useEffect(() => {
  //     const verify = async () => {
  //       try {

  //         const response = await axios.post("http://localhost:8080/user/signin", {email:name, password:password });
  //         console.log(response.data);
  //         // setItems(response.data);
  //       } catch (error) {
  //         console.error("Error fetching data:", error);
  //       }
  //     };

  //     // Call the async function
  //     verify();
  //   }, []); // The empty dependency array ensures that the effect runs only once when the component mounts

  const verify = async () => {
    try {
      const response = await axios.post("http://localhost:8080/user/signin", {
        email: name,
        password: password,
      });
      console.log(response.data);
      redirect(response.data)
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  function handleSignIn(e) {
    e.preventDefault();
    console.log(e.target);
    console.log("I got clicked");
    verify();
  }


  function redirect(e){
    console.log(e)
    e.status === "sucess"
      ? history.push({
          pathname: "/Catalogue",
        
          authKey: "b5eccb4c-2982-4d6d-807b-2270ecff6d25",
          //'ada7dbd4-18f0-4167-af7b-751f3bc5e706'
        })
        : alert("Wrong Password!! Try Again")
  }
  

  return (
    <div className="container">
      <h1>Sign In</h1>
      <form onSubmit={handleSignIn}>
        <input
          name="name"
          type="text"
          placeholder="Enter Name"
          value={name}
          onChange={handleNameChange}
        ></input>

        <input
          name="password"
          type="password"
          placeholder="Enter Password"
          value={password}
          onChange={handlePassChange}
        ></input>
        <button type="submit" onClick={handleSignIn}> Sign In</button>
      </form>
    </div>
  );
}

export default SignIn;

//<Link  exact to="/Catalogue">  </Link>
