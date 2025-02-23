import React, { useContext } from "react";
import { useNavigate } from "react-router-dom";
import { UserContext } from "./App";
import IMG from './assets/download.png'
import "./Persona.css";

function Persona() {
  const navigate = useNavigate();
  const { cardData, setCardData } = useContext(UserContext);

  const addCard = () => {
    navigate("/addcard");
  };


  const edit = (index) => {
    const editCard = cardData[index];
    navigate("/addcard", { state: { editCard, index } });
  };

  const deleteCard = (index) => {
    const updatecard = cardData.filter((_, i) => i != index);
    setCardData(updatecard);
  };

  return (
    <div className="persona-parent-con">
      <h1>Persona</h1>
      <div className="persona-con d-flex flex-column" >
        <button onClick={addCard}>+ Add Persona</button>
        <div className="persona-outer-card">
          {cardData.map((data, index) => (
            <div key={index} className="persona-card">
              <img src={data.image} alt="Persona" />
              <p>{data.title}</p>
              <p>{data.quote}</p>
              <div>
                <button className="edit-btn btn " onClick={() => edit(index)}>
                  Edit
                </button>
                <button
                  className="delete-btn btn bg-danger"
                  onClick={() => deleteCard(index)}
                >
                  Delete
                </button>
              </div>
            </div>
          ))}

          <div className="persona-card" onClick={addCard}>
            <img src={IMG} alt="defaultImage" />
            <p>Enter Title</p>
            <p>Enter Quote</p>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Persona;
